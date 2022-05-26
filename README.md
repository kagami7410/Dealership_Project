# Manual Trader
Find the car of your dreams!
---
//logo
# Table of Contents

## Contents

* [Introduction – project overview and Tech Stack](#project-overview)
* [Instructions for initial set-up](#instructions)
* [Project Structure](#project-structure)
* [Methods](#methods)
   * [Word Service](#_word-service_-wordservice)
   * [Answer Service](#_answerservice_-answerservice)
* [Using the API – HTTP Requests](#using-the-api--http-requests)
   * [Helper mode](#_primary-helper-mode-requests_)
   * [Competitive mode](#_primary-competitive-mode-requests_)


# Project Overview
- This API was created using Java, Spring boot & PostgreSQL
- API contains a one to many relationship between models:






- These include; Car, Customer, Dealer, Purchase, Dealership
- Each controller has derived queries allowing user to search for each model using specific attributes
- For example: Search for a car by specifying a colour and/or brand
---
UML & ERD Diagram pictures
![ERD Diagram](https://github.com/kagami7410/Dealership_Project/blob/main/ERD_CARSPROJECT.pdf)

![UML Diagram](
https://github.com/kagami7410/Dealership_Project/blob/main/Dealership_UML_Diagram.png)

---
# Instructions:
 - Please make sure you have the following installed: Java 18, a Java IDE, Postgres(Database manager), Postman(API platform, for testing purposes)
### Application properties: Include the following if not present in application.properties

```
spring.h2.console.enabled=true
spring.h2.console.path=/h2
hibernate.dialect=org.hibernate.dialect.H2Dialect
spring.datasource.url=jdbc:h2:file:./db/manual_trader
spring.datasource.username=sa
spring.datasource.password=
spring.datasource.driver-class-name=org.h2.Driver
spring.jpa.hibernate.ddl-auto=create-drop
spring.jpa.properties.hibernate.enable_lazy_load_no_trans=true
```
---
## Restful Routes
### You can use the following endpoints at localhost:8080/cars or any other ports

- **GET:** The GET route has several different queries for each model
    - CARS - For example, brand: *localhost:8080/cars?brand=BMW* - Results in a list of all BMW cars
    - DEALERS - For example, name: *localhost:8080/dealers?name=Sam* - Results in a list of all dealers with the name Sam
    - DEALERSHIPS - For example, location: *localhost:8080/dealerships?location=LONDON* - Results in a list of all Dealerships located in London
    - CUSTOMERS - For example, name: *localhost:8080/customers?name=Xavier* - Results in a list of customers with the name Xavier
    - PURCHASE - For example, date: *localhost:8080/purchase?date=2020-10-09* - Results in a list of all purchases made on the specified date  

- **SHOW:**
    - *localhost:8080/cars/{id}* Results in a car with the associated id being displayed
    - The same logic can be applied to DEALERS, DEALERSHIPS, CUSTOMER & PURCHASE.

- **POST**
    - *localhost:8080/cars/new/* : Allows you to input each of the attributes to create a new CAR. 
    - The same logic can be applied to DEALERS, DEALERSHIPS, CUSTOMER & PURCHASE.

- **PUT:**
    - *localhost:8080/cars/update/{id}* - Results in changes being made to an already existing car
    - The same logic can be applied to DEALERS, DEALERSHIPS, CUSTOMER & PURCHASE.

- **DELETE**
    - *localhost:8080/dealers/remove/{id}* - Will result in removing a dealer with a given id
    - The same logic can be applied to DEALERS, DEALERSHIPS, CUSTOMER & PURCHASE.


# Testing


#  Dependencies

- Junit Test
- Spring Web
- SpringBoot DevTools
- Spring dataJpa
- H2 Database
