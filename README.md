API de Gerenciamento de Tarefas

API REST para gerenciamento de tarefas com controle de conclusão e vencimento.

Tecnologias

* Java 17
* Spring Boot
* Spring Data JPA
* H2 Database

Estrutura do projeto

* models → entidades JPA
* repositories → acesso ao banco de dados
* services → regras de negócio
* controllers → endpoints REST

Endpoints

* POST /tarefas
* GET /tarefas
* GET /tarefas/{id}
* PUT /tarefas/{id}
* DELETE /tarefas/{id}

Como testar

Os endpoints podem ser testados utilizando:

Postman
ou
Swagger: http://localhost:8080/swagger-ui/index.html
