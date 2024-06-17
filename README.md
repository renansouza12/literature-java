# Project Name: Book Search API

## Description:

This project implements a Java Spring Boot application that functions as a book search API. It leverages the Gutenberg API to retrieve book information and stores the retrieved data in a PostgreSQL database. Additionally, the API allows searching for saved books, filtering them by language and author.

### Features:

- Search for books by title using the Gutenberg API.
- Save retrieved book details to a PostgreSQL database.
- List all saved books.
- Filter saved books by language.
- Filter saved books by author (implementation details not provided in the given code).
  
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

``` Bash 
git clone https://github.com/your-username/book-search-api.git

cd

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

