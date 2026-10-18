REST API for a tool company, where you can create users and tools, and link users to tools

Competencies:
* Java
* Spring Boot 4
* JPA
* PostgreSQL
* Maven
* Swagger
* Postman

To start project:

Start Spring boot Application and Docker, make sure your on localhost 5500 and create a user and tools
with either Postman or Swagger

Structure:

Project has two entities, Person and Tools. They are linked to a ManyToMany relation over a linked table "persons_tools",
meaning a user can be linked to many tools

Project contains different packages structuring the project with controller, model, repository and service:

Controller:

Controllers handles HTTP-requests and returns result to client, it handles users and tools, also has the CRUD operations for:

GET - to get data
POST - to post data
PUT - to update data
DELETE - to remove data

Models:

In Model package we have two models that represent two different entities: Person and Tool.

Person model represents a user that can borrow tools.

Tool model represents tools that can be borrowed.

Repository:

Repository is a interface that allows communication with database over JPA, it provides methods to get, save, update and deleting data.

Service:

Services "creates" the structure for the project with creating and updating user, GET for users and tools, availability for tools.

Validation:

@NotBlank is used to describe with filed cannot be empty while @Valid checks when program starts

There is also status codes for when some "rules" are not followed as:
400 Bad request - when data is not valid
404 Not Found - when data is not found
409 Conflict - when data cannot be removed, because is already borrowed/linked

and 200 OK for when data is ok

Swagger:

Swagger is used to test the API endpoints directly in web, can be done by following link:
http://localhost:5500/swagger-ui/index.html
