./mvnw clean package -DskipTests
docker build -t databaseservice:latest .
docker tag databaseservice:latest danielugulino/databaseservice:latest
docker push danielugulino/databaseservice:latest