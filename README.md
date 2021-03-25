# beerapplication (work in progress)


## General Info ====

The application presents a Springboot micro-service component. A user assigns one or more products. The list of products, at this specific application, is a list of German Beer Companies. Each of the Beer Companies contains a list of different beers. The user may consult the different beers of each company and place an order (a purchase). He or she may add beers to that order-list and finally purchase the order. The beer-application table ProductPurchasEntity presents a classical Shopping Cart devise, which forms the hearth of this small project.

## How to get started ====

Clone the application first. Build it with the Maven 'mvn clean install' command-line command. And finally run it with the Springboot Maven command: 'mvn spring-boot:run'. The application, which has three different Spring-Profiles, will start default into the test (demo) profile. To change the profiles go to the application properties file and change spring.profiles.active=test into 'dev' of 'prod', to reach the other profiles through start-up.

  https://github.com/artsgard/retailapplication/blob/master/src/main/resources/application.properties

You will notice that each profile has its own DB and of course when using the other two profiles of dev or prod you should intall and configurate respectively a Mysql or Postgres DB. You'll find the configuration-details of user password etc. at the DBConfig at the root of the project:

  https://github.com/artsgard/retailapplication/blob/master/src/main/java/com/artsgard/retailapplication/DBConfig.java

I case you have a Mysql DB installed at your local machine (after adjusting credentials like user pw), the application will automatically envoke a DB script and install some previous data into your local DB (a nice fact of Mysql but unfortunately Postrgres does not work like that).

Important, when running the application in the test-profile mode as a demo (the clone default), the application will run "out of the box". The internal h2 database has already some initial data uploaded to try out the swagger petitions!

The Swagger url is: http://localhost:8085/retailApplication/swagger-ui.html#!/


## Technical Features ====

There are three classical layers present at the application: Controller - Service - JPA Repository. The Data Objects are called Entities when comming and going to the DataBase and DTOs when communicating with the front-end part. The mapping of the POJO properties is done by the Mapstruct library (org.mapstruct). Next find a list of the implemented features of the application:

  -Sprimg Server Validation (javax.validation)
  
  -Spring Rest Exception Handeling (@ControllerAdvice)
  
  -Bassic Info and Error Loggin (org.slf4j.Logger and logback-spring.xml)
  
  -Spring-Data JPA (using Pageable, Sort-implementation, ExampleMatcher etc.)
  
  -Spring-Profiles (test, dev, prod with different data sources)
  
  -Spring DB Initialization
  
  -Swagger2 Documentation
  
  -Testing
  
