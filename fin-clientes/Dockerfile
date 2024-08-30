FROM maven:3.9.9-amazoncorretto-17-al2023 as build
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

FROM openjdk:23-ea-17-slim
WORKDIR /app
COPY --from=build ./app/target/*.jar ./app.jar
ARG EUREKA_SERVER=localhost
ENTRYPOINT java -jar app.jar