FROM openjdk:17-jdk-slim

WORKDIR /app

COPY target/auth-0.0.1-SNAPSHOT.jar /app/auth.jar

EXPOSE 9898

ENTRYPOINT ["java", "-jar", "/app/auth.jar"]
