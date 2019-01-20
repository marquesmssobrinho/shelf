FROM openjdk:8-jdk-alpine


RUN mkdir /shelf

WORKDIR /shelf

COPY target/shelf-0.0.1-SNAPSHOT.jar /shelf/shelf-0.0.1-SNAPSHOT.jar

CMD ["sh", "-c", "java -jar shelf-0.0.1-SNAPSHOT.jar"]