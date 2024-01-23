FROM openjdk:17
VOLUME /tmp
EXPOSE 8086
ARG JAR_FILE=target/sprint-rabbitmq-0.0.1-SNAPSHOT.jar
ADD ${JAR_FILE} sprint-rabbitmq.jar
ENTRYPOINT ["java","-jar","/sprint-rabbitmq.jar"]
