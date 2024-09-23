FROM openjdk:17-jdk-slim

WORKDIR /app

COPY target/irrfService-0.0.1-SNAPSHOT.jar /app/irrfService.jar

EXPOSE 8082

ENTRYPOINT ["java", "-jar", "irrfService.jar"]