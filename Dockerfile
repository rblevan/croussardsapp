FROM eclipse-temurin:25-jdk-alpine
WORKDIR /app
COPY croussards_back/target/*.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]
