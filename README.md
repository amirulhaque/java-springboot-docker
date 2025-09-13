# 🚀 Java Spring Boot Docker Project

This project is a simple **Spring Boot REST API** containerized using **Docker** and deployable on **AWS EC2**.

The app provides:
- `GET /api/hello` → Returns a greeting message
- `POST /api/echo` → Echoes back JSON payload

---

## 📖Features
- REST API built with **Spring Boot**
- **Dockerized** → no need to install Java or Maven on EC2
- Deployable on **AWS EC2**
- Logs and validation handled with Spring Boot features


---

## 🛠️Prerequisites
- AWS EC2 instance (Amazon Linux 2023 recommended)
- Docker installed on EC2

👉 Java and Maven are **not required** on EC2. They run inside Docker.

---

## Clone the Repository
```bash
git clone https://github.com/amirulhaque/java-springboot-docker.git
cd java-springboot-docker-project
```

## Install Docker on EC2
```bash
sudo yum update -y
sudo yum install -y docker
sudo systemctl service enable docker
sudo systemctl docker start
sudo usermod -aG docker ec2-user
docker --version
```

## 📜 Dockerfile Explained
Here is the Dockerfile used in this project:
```bash
FROM maven:3.9.4-eclipse-temurin-17 AS builder
WORKDIR /home/app
COPY pom.xml .
COPY src ./src
RUN mvn -B -DskipTests package
FROM openjdk:17-jdk-slim
WORKDIR /app
COPY --from=builder /home/app/target/demo-0.0.1-SNAPSHOT.jar /app/app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/app/app.jar"]
```

## 🔎 Step-by-step explanation:

**1. FROM maven:3.9.4-eclipse-temurin-17 AS build**

Starts with an official Maven + JDK 17 image.

This image contains both Maven & Java, used for compiling the app.

**2. WORKDIR /app**

Sets the working directory inside the container to /app.

**3. COPY pom.xml . & COPY src ./src**

Copies project files (POM + source code) into the container.

**4. RUN mvn clean package -DskipTests**

Runs Maven inside the container to build the Spring Boot JAR file.

-DskipTests skips running unit tests to speed up builds.

**5. FROM openjdk:17-jdk-slim**

Starts a fresh, lightweight JDK 17 image.

This ensures the final image is smaller (doesn’t include Maven).

**6. COPY --from=build /app/target/demo-0.0.1-SNAPSHOT.jar app.jar**

Copies only the built JAR file from the build stage into the runtime stage.

**7. ENTRYPOINT ["java", "-jar", "app.jar"]**

Defines the command to run the application when the container starts.

**👉 This is called a multi-stage Docker build:**

 - Stage 1 = Build with Maven

 - Stage 2 = Run with JDK only

This makes the final Docker image much smaller and more efficient.



## 🌐 Testing the APIs
Once the container is running, use your EC2 Public IP:

✅ Hello API
```bash
curl http://<EC2_PUBLIC_IP>:8080/api/hello
```
# Response: Hello, world!

```bash
curl http://<EC2_PUBLIC_IP>:8080/api/hello?name=Zeyaul
```
# Response: Hello, Zeyaul!

✅ Echo API
```bash
curl -X POST "http://<EC2_PUBLIC_IP>:8080/api/echo" \
     -H "Content-Type: application/json" \
     -d '{"message":"Hi from EC2"}'
```


# Response:
{
  "message": "Hi from EC2"
}
