FROM openjdk:11
EXPOSE 8080
COPY target/user-service-docker.jar user-service-docker.jar
ENTRYPOINT ["java", "-jar", "/user-service-docker.jar"]
