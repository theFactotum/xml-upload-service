## Getting Started

### Dependencies

* Spring Web
* Spring Boot
* Spring Data JPA
* H2 Database (in memory storage)
* JAXB Marshalling & Unmarshalling

### Installing

* Run the following command in the project root for creating Docker build

```
docker build --tag=xml-upload-service-0.0.1:latest .
```
<br/>

To set container name 
```
docker run -p8080:8080 xml-upload-service-0.0.1:latest
```
<br/>

Few Docker commands,
$> docker inspect xml-upload-service <br>
$> docker stop xml-upload-service <br>
$> docker rm xml-upload-service <br>

* Database connection url:

```
http://localhost:8080/h2-store
```

Docker-compose commands: <br> <br>
docker-compose config <br>
docker-compose up -d xml-upload-service <br>
docker-compose down 

### API Endpoints

All URIs are relative to *http://localhost:8080/api/*

Class | Method                                           | HTTP request      | Description
------------ |--------------------------------------------------|-------------------| -------------
*XmlDataUploadController* | [**getAll**](http://localhost:8080/api/getAll)   | **GET** /getAll   | Get all the records from in-memory h2 Store
*XmlDataUploadController* | [**save**](http://localhost:8080/api/save)       | **POST** /save    | save the DecideInfo record into database  without XSD validation (JSON Request)
*XmlDataUploadController* | [**saveXML**](http://localhost:8080/api/saveXML) | **POST** /saveXML | Save the DeviceInfo Record into database post XSD schema validation (XML Request)
