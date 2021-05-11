FROM openjdk:16-jdk-alpine
VOLUME /tmp
EXPOSE 3000
ARG JAR_FILE=target/Porject221-0.0.1-SNAPSHOT.jar
ADD ${JAR_FILE} app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]