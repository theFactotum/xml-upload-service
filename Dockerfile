FROM openjdk:11-jdk-alpine

COPY target/xml-upload-service-0.0.1-SNAPSHOT.jar xml-upload-service-0.0.1.jar

ENTRYPOINT ["java","-jar","/xml-upload-service-0.0.1.jar"]