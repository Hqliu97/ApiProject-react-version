# 基础镜像
#FROM maven:3.8.1-jdk-8-slim as builder
FROM  openjdk:8-jre

WORKDIR /app
COPY hanqApi-backend-0.0.1-SNAPSHOT.jar /app/hanqApi-backend-0.0.1-SNAPSHOT.jar
#本地构建jar包
#COPY pom.xml .
#COPY src ./src
# Build a release artifact.
#RUN mvn package -DskipTests
#CMD ["java","-jar","/app/target/hanqApi-backend-0.0.1-SNAPSHOT.jar"]
CMD ["java","-jar","/app/hanqApi-backend-0.0.1-SNAPSHOT.jar"]
