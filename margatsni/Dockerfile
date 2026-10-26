FROM maven:3.10.0-eclipse-temurin-25-alpine as build

WORKDIR /app
COPY pom.xml .
RUN mvn dependency:go-offline
COPY . .
RUN mvn clean package -DskipTests=true

#============================================
from eclipse-temurin:25-jre-alpine as run

COPY --from=build /app/target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]