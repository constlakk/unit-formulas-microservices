# unit-formulas-microservices


## DESCRIPTION

A back-end, REST API and microservices project for showcasing. Made with Spring Boot.

Unit formulas microservice serves as a repository for storing, adding and deleting formulas for converting measurement units (e.g. metric to imperial). (port: 8000)

Unit conversion microservice calls the unit formulas microservice and performs the actual conversion by adding a quantity parameter in the URL. (port: 8100)

Naming server microservice registers all other microservices and holds relevant information. (port: 8761)

API gateway microservice provides a common interface for calling both formulas and conversions. (port: 8765)

Uses JPA for holding in-memory information.


## TO RUN

In the command line, navigate to the root of the project (where docker-compose.yaml is located) and run the command:

**docker compose up**

You need Docker and Docker Compose to be functional in your machine.

========================================================================================

Sample URLs:

## GET

+ retrieve all formulas

http://localhost:8765/unit-formulas

+ retrieve specific formula

http://localhost:8765/unit-formulas/from/inches/to/centimeters

+ perform conversion

http://localhost:8765/unit-conversion-feign/from/inches/to/centimeters/quantity/20


## POST

+ create new formula

http://localhost:8765/unit-formulas

Sample body:

{
"id": 4,
"from": "tons",
"to": "kilograms",
"multiplyBy": 907.2
}


## DELETE

+ remove formula

http://localhost:8765/unit-formulas/2


## EUREKA NAMING SERVER

http://localhost:8761

========================================================================================

## DOCKER IMAGES

+ kostaslakkas/microservices-api-gateway
+ kostaslakkas/microservices-naming-server
+ kostaslakkas/microservices-unit-formulas
+ kostaslakkas/microservices-unit-conversion
