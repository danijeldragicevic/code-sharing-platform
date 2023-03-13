# Code sharing platform
Web application that is able to share code between collaborators via API and Web interface. <br>
Application is able to:
- create new code snippets,
- set view and time restrictions on created snippets,
- show snippet by its ID and
- show all unrestricted code snippets.

Application use embedded H2 database and no authentication.

# Technology
- Java 11
- Spring Boot 2.7.1 (Spring Web MVC, Spring Data Jpa, Spring Validation, Project Lombok, H2 database, Thymeleaf template engine)
- Gradle 7.4

# To run application:
Navigate to the project root directory and run **./gradlew bootRun**

# Exposed endpoints:
By default, service will run on **http://localhost:8889** <br/>
Following endpoints will be exposed:

| Methods   | Urls             | Action                                                   |
|-----------|------------------|----------------------------------------------------------|
| GET       | /h2              | Access to the local database (username: sa, no password) |
| POST      | /api/code/new    | Create new code snippet                                  |
| GET       | /api/code/:id    | Get code snippet by it's :id                             |
| GET       | /api/code/latest | List 10 latest unrestricted code snippets                |
| GET       | /code/new        | Create new code snippet                                  |
| GET       | /code/:id        | Get code snippet by it's :id                             |
| GET       | /code/latest     | List 10 latest unrestricted code snippets                |

# Examples
### API calls
**Example 1:** POST /api/code/new <br/>
Creates new code snippet and store it in the local database under the unique UUID. <br>
If time and views are set to zero, or negative value, code snippet don't have any limitations and can be displayed as much as desired. <br>
First snippet:
```
{
    "code": "public static void main(String[] args) { }",
    "time": 0,
    "views": 0
}
```
Response: 200 OK. <br>
Response body:
```
{
    "id": "e9229957-a76a-4c8f-b331-16fae7874044"
}
```
Second snippet:
```
{
    "code": "public class CodeSnippet { }",
    "time": 0,
    "views": 0
}
```
Response: 200 OK. <br>
Response body:
```
{
    "id": "48bf00d3-c245-47d8-a081-0dc5d2bf44ac"
}
```
Third snippet:
```
{
    "code": "public class SecretCode { }",
    "time": 5000,
    "views": 5
}
```
Response: 200 OK. <br>
Response body:
```
{
    "id": "360f2c38-5d78-4a6d-848f-621c83f24a9b"
}
```
**Example 2:** GET /api/code/360f2c38-5d78-4a6d-848f-621c83f24a9b <br>
Shows code snippet by its ID number. <br>
Response: 200 OK. <br>
Response body:
```
{
    "code": "public class SecretCode { }",
    "date": "2023-03-13 14:48:39",
    "time": 4879,
    "views": 4
}
```
In case that some of snippet's limitation is reached (time to view or number of views), snippet will be deleted. <br>
If same code snippet is requested after it is deleted, an error will be thrown. <br>
Response: 404 Not Found. <br>
Response body:
```
{
    "time": "2023-03-13 14:52:56",
    "status": 404,
    "error": "Not Found",
    "message": "Code snippet with requested id does not exists!",
    "path": "/api/code/360f2c38-5d78-4a6d-848f-621c83f24a9b"
}
```
**Example 3:** GET /api/code/latest <br>
Displays ten latest code snippets, ordered by date created. <br>
Only unrestricted snippets will be shown, so only snippets whose time/views properties are set to zero (or negative value). <br>
Response 200 OK. <br>
Response body:
```
[
    {
        "code": "public class CodeSnippet { }",
        "date": "2023-03-13 14:57:56",
        "time": 0,
        "views": 0
    },
    {
        "code": "public static void main(String[] args) { }",
        "date": "2023-03-13 14:57:38",
        "time": 0,
        "views": 0
    }
]
```
### Web calls
**Example 1:** POST /code/new <br>
![sc1](https://user-images.githubusercontent.com/82412662/224753754-75b635a9-1553-469e-a7e1-06e35d93b5d1.png)

**Example 2:** GET /code/ce22b058-2473-4b34-8135-f6201d25005d <br>
![sc2](https://user-images.githubusercontent.com/82412662/224753853-10289d04-d1ae-41cb-ab45-f20653952a15.png)

**Example 3:** GET /code/ce22b058-2473-4b34-8135-f6201d25005d (expired) <br>
![sc3](https://user-images.githubusercontent.com/82412662/224753956-57bef0cb-98e0-407f-80e4-95e43580f72b.png)

**Example 4:** GET /code/latest <br>
![sc4](https://user-images.githubusercontent.com/82412662/224754030-a672d9a0-0bdc-47d8-88e1-66e5deb33292.png)

# Licence
[![License](https://img.shields.io/badge/License-Apache_2.0-blue.svg)](https://opensource.org/licenses/Apache-2.0)
