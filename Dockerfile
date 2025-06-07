# Use imagem base com Java 17 (ou 21 se quiser)
FROM eclipse-temurin:17-jdk

# Crie diretório da aplicação
WORKDIR /app

# Copie tudo para a imagem
COPY . .

# Permissão para o mvnw
RUN chmod +x mvnw

# Execute o build
RUN ./mvnw clean package -DskipTests

# Comando para rodar o app
CMD ["java", "-jar", "target/Global_Java-0.0.1-SNAPSHOT.jar"]
