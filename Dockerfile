FROM openjdk:17
RUN mkdir /home/app
COPY ./target/college.app.jar /home/app
CMD ["java", "-jar", "home/app/college.app.jar"]

