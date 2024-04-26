FROM openjdk:17.0.2-jdk-slim-buster
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} lesson5-0.0.1-SNAPSHOT.jar
EXPOSE 5432
EXPOSE 8080
ENTRYPOINT ["java","-jar","/lesson5-0.0.1-SNAPSHOT.jar"]