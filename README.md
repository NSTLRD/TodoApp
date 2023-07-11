# TodoApp

This is a TodoApp application for managing tasks and daily routines. It provides functionality to create, update, and delete tasks, as well as mark them as complete or incomplete. The application is built with Spring Boot and utilizes Spring Data JPA for data persistence.

## Features

- User Registration: Users can register for an account by providing their name, username, email, and password.
- User Login: Registered users can log in to the application using their credentials.
- Task Management: Users can create, update, and delete tasks. They can also mark tasks as complete or incomplete.
- Role-based Authorization: The application supports role-based authorization. Administrators have access to all functionality, while regular users have limited access.

## Technologies

- Java 17
- Spring Boot
- Spring Data JPA
- MySQL
- Maven
- Spring Security
- Springdoc OpenAPI

## Getting Started

### Prerequisites

- Java Development Kit (JDK) 17 or later
- MySQL database server
- Maven

### Configuration

1. Clone the repository:

```bash
git clone https://github.com/your-username/TodoApp.git
```

2. Configure the database connection in the `application.properties` file located in the `src/main/resources` directory:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/todo_app?useSSL=false&serverTimezone=UTC
spring.datasource.username=root
spring.datasource.password=root
```

3. Run the application:

```bash
cd TodoApp
mvn spring-boot:run
```

The application will start running on `http://localhost:8008`.

## API Documentation

The API documentation is generated using Springdoc OpenAPI and can be accessed at `http://localhost:8008/swagger-ui.html`.

## License

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.

## Acknowledgements

This project was developed as a part of the TodoApp application.
