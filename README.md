# 🧩 API RESTful de Usuários com Spring Boot

API REST construída com **Spring Boot**, documentada com **Swagger** e empacotada com **Docker**, suportando todas as operações CRUD: `GET`, `POST`, `PUT`, `PATCH`, `DELETE`.

---

## 🚀 Tecnologias

- Java 17
- Spring Boot 3.4.5
- Spring Web
- SpringDoc OpenAPI (Swagger)
- Lombok
- Docker
- JUnit e RestAssured

---

## 🐳 Como rodar com Docker

```bash
docker build -t minha-api .
docker run -p 8080:8080 minha-api


| Método | Endpoint         | Descrição                        |
| ------ | ---------------- | -------------------------------- |
| GET    | `/usuarios`      | Lista todos os usuários          |
| GET    | `/usuarios/{id}` | Retorna um usuário por ID        |
| POST   | `/usuarios`      | Cria um novo usuário             |
| PUT    | `/usuarios/{id}` | Atualiza *todos* os dados        |
| PATCH  | `/usuarios/{id}` | Atualiza *parcialmente* os dados |
| DELETE | `/usuarios/{id}` | Remove um usuário                |

Interface Swagger: http://localhost:8080/swagger-ui.html
Especificação OpenAPI (importável no Postman):
http://localhost:8080/v3/api-docs

GET 
[
  {
    "id": 1,
    "nome": "João Silva",
    "email": "joao@email.com"
  },
  {
    "id": 2,
    "nome": "Maria Souza",
    "email": "maria@email.com"
  }
]

POST
{
  "nome": "João Silva",
  "email": "joao@email.com"
}
PUT
{
  "nome": "João Atualizado",
  "email": "joao@email.com"
}
PATCH
{
  "email": "novo@email.com"
}
Especificação OpenAPI (importável no Postman):
http://localhost:8080/v3/api-docs

comandos para subir os codigos pro github
git init
git add .
git commit -m
git push origin main
