package com.college.app.filter;

import java.io.IOException;
import java.time.LocalDateTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.college.app.service.JwtService;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.MalformedJwtException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JwtAuthenticationFilter extends  OncePerRequestFilter {

	private Logger logger = LoggerFactory.getLogger(OncePerRequestFilter.class);
    @Autowired
    private JwtService jwtHelper;

    @Autowired
    private UserDetailsService userDetailsService;
    
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {


        String requestHeader = request.getHeader("Authorization");
        logger.info(" Header : {}", requestHeader);
        String username = null;
        String token = null;
        if (requestHeader != null && requestHeader.startsWith("Bearer")) {
            token = requestHeader.substring(7);
            try {
                username = this.jwtHelper.getUsernameFromToken(token);
            } catch (IllegalArgumentException e) {
                logger.info("Illegal Argument while fetching the username !!");
                sendErrorResponse(response, "Invalid Token Format", HttpServletResponse.SC_BAD_REQUEST);
                return;
            } catch (ExpiredJwtException e) {
                logger.info("Given JWT token is expired !!");
                sendErrorResponse(response, "JWT Token Expired", HttpServletResponse.SC_UNAUTHORIZED);
                return;
            } catch (MalformedJwtException e) {
                logger.info("Token is malformed or tampered with! Invalid Token");
                sendErrorResponse(response, "Invalid JWT Token", HttpServletResponse.SC_BAD_REQUEST);
                return;
            } catch (Exception e) {
                logger.info("Unexpected error while processing JWT token");
                sendErrorResponse(response, "Internal Server Error", HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
                return;
            }
        } else {
//            logger.info("Invalid Header Value !! ");
            filterChain.doFilter(request, response);
        }


        if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
            //fetch user detail from username
            UserDetails userDetails = this.userDetailsService.loadUserByUsername(username);
            Boolean validateToken = this.jwtHelper.validateToken(token, userDetails);
            if (validateToken) {
                //set the authentication
                UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
//                authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                authentication.setDetails(token);
                SecurityContextHolder.getContext().setAuthentication(authentication);
                filterChain.doFilter(request, response);
            } else {
                logger.info("Validation fails !!");
            }

        }
//        filterChain.doFilter(request, response);
    }
    
    private void sendErrorResponse(HttpServletResponse response, String message, int statusCode) throws IOException {
        response.setStatus(statusCode);
        response.setContentType("application/json");
        response.getWriter().write("{\"message\": \"" + message + "\", \"timestamp\": \"" + LocalDateTime.now() + "\"}");
    }
    
}
