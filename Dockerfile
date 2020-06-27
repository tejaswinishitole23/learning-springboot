FROM openjdk:11-jdk-slim

VOLUME /tmp

EXPOSE 8085

RUN mkdir -p /app/
RUN mkdir -p /app/logs/

COPY build/libs/learning-springboot-0.0.1-SNAPSHOT.jar /app/app.jar

ENTRYPOINT ["java","-jar","/app/app.jar"]
