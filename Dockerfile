FROM eclipse-temurin:17-jdk-slim

# Adiciona suporte a certificados SSL confiáveis
RUN apt-get update && apt-get install -y ca-certificates && apt-get clean

WORKDIR /app

COPY . .

RUN chmod +x mvnw
RUN ./mvnw clean package -DskipTests

CMD ["java", "-jar", "target/Global_Java-0.0.1-SNAPSHOT.jar"]
