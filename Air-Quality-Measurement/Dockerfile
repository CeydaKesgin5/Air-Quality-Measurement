FROM openjdk:20-jdk-oracle
ARG JAR_FILE=target/*.jar
COPY ./target/intern2-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]

