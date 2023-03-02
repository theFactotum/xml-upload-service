FROM adoptopenjdk/openjdk11:latest
RUN mkdir /opt/app

COPY target/xml-upload-service-0.0.1-SNAPSHOT.jar /opt/app/xml-upload-service-0.0.1.jar

CMD ["java", "-jar", "/opt/app/xml-upload-service-0.0.1.jar"]



ENTRYPOINT ["java","-jar","/opt/app/xml-upload-service-0.0.1.jar"]
