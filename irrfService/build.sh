./mvnw clean package -DskipTests
docker build -t irrfservice:latest .
docker tag irrfservice:latest danielugulino/irrfservice:latest
docker push danielugulino/irrfservice:latest