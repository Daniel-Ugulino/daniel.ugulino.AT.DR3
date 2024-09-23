FROM openjdk:17-jdk-slim

WORKDIR /app

COPY target/databaseService-0.0.1-SNAPSHOT.jar /app/databaseService.jar

EXPOSE 8083

ENTRYPOINT ["java", "-jar", "databaseService.jar"]