# Builder stage: compile with Maven
FROM maven:3.9.4-eclipse-temurin-17 AS builder
WORKDIR /home/app
COPY pom.xml .
COPY src ./src


# Run tests and package (change -DskipTests to skip tests if desired)
RUN mvn -B -DskipTests package


# Runtime stage: lightweight JRE/JDK
FROM openjdk:17-jdk-slim
WORKDIR /app
# Copy the fat jar from the builder stage
COPY --from=builder /home/app/target/demo-0.0.1-SNAPSHOT.jar /app/app.jar


EXPOSE 8080
ENTRYPOINT ["java","-jar","/app/app.jar"]
