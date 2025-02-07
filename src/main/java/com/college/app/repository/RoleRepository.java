package com.college.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.college.app.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

	Role findByRolename(String role);

}
