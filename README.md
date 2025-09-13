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
git clone https://github.com/<your-username>/<your-repo>.git
cd java-springboot-docker-project
