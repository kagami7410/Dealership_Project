# Manual Trader
Find the car of your dreams!
---
//logo
## This API was created using Java, Spring boot & PostgreSQL
## API contains a one to many relationship between models:

![ERD Diagram](https://github.com/kagami7410/Dealership_Project/blob/main/Dealership_UML_Diagram.png)

- These include; Car, Customer, Dealer, Purchase, Dealership
- Each controller has derived queries allowing user to search for each model using specific attributes
- For example: Search for a car by specifying a colour and/or brand
---
Diagram pictures UML & ERD
---
## Instructions:
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

- GET: The GET route has several different queries for each model
    - CARS - For example, brand: localhost:8080/cars?brand=BMW - Results in a list of all BMW cars
    - DEALERS - For example, name: localhost:8080/dealers?name=Sam - Results in a list of all dealers with the name Sam
    - DEALERSHIPS - For example, location: localhost:8080/dealerships?location=LONDON - Results in a list of all Dealerships located in London
    - CUSTOMERS - For example, name: localhost:8080/customers?name=Xavier - Results in a list of customers with the name Xavier
    - PURCHASE - For example, date: localhost:8080/purchase?date=2020-10-09 - Results in a list of all purchases made on the specified date  

- SHOW:
    - localhost:8080/cars/{id} Results in a car with the associated id being displayed
    - The same logic can be applied to DEALERS, DEALERSHIPS, CUSTOMER & PURCHASE.

- POST 
    - CARS EXAMPLE - By using the following URL localhost:8080/cars/new/ : It will allow you to input each of the attributes to create a new CAR. 
    - The same logic can be applied to DEALERS, DEALERSHIPS, CUSTOMER & PURCHASE.

- PUT:
    - localhost:8080/cars/update/{id} - Results in changes being made to an already existing car
    - The same logic can be applied to DEALERS, DEALERSHIPS, CUSTOMER & PURCHASE.

- DELETE
    - localhost:8080/cars/remove/{id} - Results in removing a car with the given id
    - localhost:8080/dealers/remove/{id} - Results in removing a dealer with a given id
    - localhost:8080/dealerships/remove/{id} - Results in removing a dealership with a given id
    - localhost:8080/customers/remove/{id} - Results in removing a customer with a given id
    - localhost:8080/purchases/remove/{id} - Results in removing a purchaser with a given id




##  Dependencies

- Junit Test
- Spring Web
- SpringBoot DevTools
- Spring dataJpa
- H2 Database
