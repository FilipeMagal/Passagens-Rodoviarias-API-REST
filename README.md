# API de Cadastro de Veículos
---
Este projeto é uma API RESTful desenvolvida com Spring Boot que permite o cadastro, atualização, exclusão e consulta de passagens rodoviária. proposto pela faculdade visconde de cairu.
---
## Endpoints da API
---
1. ## Endpoint padrão para cidade = /doisv/cidade
---
2. ### Listar todos os dados da cidade(GET) = /cidades
Exemplo:
```bash
http://localhost:8080/doisv/cidade/cidades
```
3. ### Listar apenas os dados de uma cidade em específico(GET) = /{id}
Exemplo:
```bash
http://localhost:8080/doisv/cidade/1
```
4. ### Usuário criar os dados para essa cidade(POST) = /create
Exemplo:
```bash
http://localhost:8080/doisv/cidade/create
```
5. ### Usuário alterar os dados para uma cidade já criada(PUT) = /create/{id}
Exemplo:
```bash
http://localhost:8080/doisv/cidade/create/1
```
6. ### Deletar uma cidade já criada(DELETE) = /delete/{id}
Exemplo:
```bash
http://localhost:8080/doisv/cidade/delete/1
```
    
