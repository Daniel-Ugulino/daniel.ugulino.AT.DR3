FROM openjdk:17-jdk-slim

WORKDIR /app

COPY target/taxService-0.0.1-SNAPSHOT.jar /app/taxService.jar

EXPOSE 8084

ENTRYPOINT ["java", "-jar", "taxService.jar"]