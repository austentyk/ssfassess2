FROM maven:3-eclipse-temurin-21 AS builder 

LABEL MAINTAINER="austentyk"
LABEL APPLICATION="ssfassess"

WORKDIR /src

COPY mvnw .
COPY mvnw.cmd .
COPY pom.xml .
COPY .mvn .mvn
COPY src src

RUN mvn package -Dmaven.test.skip=true


ENTRYPOINT [ "java", "-jar", "eventmanagement-0.0.1.snapshot.jar" ]
ENV SERVER_PORT=8080
ENV SPRING_REDIS_HOST=localhost 
ENV SPRING_REDIS_PORT=6379
ENV SPRING_REDIS_DATABASE=0
ENV SPRING_REDIS_USERNAME=admin 
ENV SPRING_REDIS_PASSWORD=password123
EXPOSE 8080