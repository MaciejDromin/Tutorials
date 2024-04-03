FROM gradle:8.6.0-jdk21-alpine as builder
WORKDIR /app
ARG SKIP_TESTS="-x test"
COPY ./ ./
RUN ./gradlew clean build ${SKIP_TESTS}

FROM openjdk:21-slim as runner
WORKDIR /app
COPY --from=builder /app/build/libs/*SNAPSHOT.jar app.jar
ENTRYPOINT ["java", "-Dspring.profiles.active=docker", "-jar", "/app/app.jar"]
