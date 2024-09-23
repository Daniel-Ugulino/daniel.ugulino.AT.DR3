./mvnw clean package -DskipTests
docker build -t taxservice:latest .
docker tag taxservice:latest danielugulino/taxservice:latest
docker push danielugulino/taxservice:latest