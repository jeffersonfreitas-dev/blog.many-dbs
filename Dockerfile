FROM maven:3.8.4-openjdk-17 as build
WORKDIR /app
COPY . .
RUN mvn clean package

FROM eclipse-temurin:17.0.9_9-jdk
RUN groupadd -r appuser && useradd -r -g appuser appuser
COPY --from=build /app/target/manydbs-0.0.1-SNAPSHOT.jar /app/manydbs-api.jar
RUN chown appuser:appuser /app/manydbs-api.jar
USER appuser
WORKDIR /app
EXPOSE 8080
CMD ["java", "-Duser.timezone=America/Fortaleza", "-jar", "manydbs-api.jar"]