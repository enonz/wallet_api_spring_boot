FROM openjdk:latest
VOLUME /tmp
EXPOSE 9090
ARG JAR_FILE=target/wallet-api-0.0.1-SNAPSHOT.jar
ADD ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]