# Literature 

## Description:

This project implements a Java Spring Boot application that functions as a book search API. It leverages the Gutenberg API to retrieve book information and stores the retrieved data in a PostgreSQL database. Additionally, the API allows searching for saved books, filtering them by language and author.

### Features:

- List all saved books.
- Filter saved books by language.
- Filter saved books by author .
  
## Technologies:

-  Java
- Spring Boot
- PostgreSQL (database)
- Gutenberg API (external data source)
  
## Prerequisites:

- Java installed (version 11 or later recommended)
- Maven build tool installed
- PostgreSQL database server running

  
## Setup:

Clone this repository:

``` markdown 
git clone https://github.com/renansouza12/literature-java.git

cd literature-java

code .
```

Configure your PostgreSQL database connection details in src/main/resources/application.properties. Update the following properties:
```properties

Properties
spring.datasource.url=jdbc:postgresql://{DB_HOST}/books
spring.datasource.username={DB_USERNAME}
spring.datasource.password={DB_PASSWORD}
spring.datasource.driver-class-name=org.postgresql.Driver
hibernate.dialect=org.hibernate.dialect.HSQLDialect
spring.jpa.hibernate.ddl-auto=update


```

