# API de Cadastro de Veículos
---

Este projeto é uma API RESTful desenvolvida com Spring Boot que permite o cadastro, atualização, exclusão e consulta de passagens rodoviária. proposto pela faculdade visconde de cairu.

---
## Endpoints da API
---
1. ## Endpoint padrão para cidade = /doisv/cidade.
---
2. ### Listar todos os dados da cidade.
   
- **Método:** GET

- **Endpoint:** ```/cidades```

- **Descrição:** Retorna uma lista de todas as cidades cadastradas.
  
**Exemplo:**
```bash
http://localhost:8080/doisv/cidade/cidades
```
3. ### Listar apenas os dados de uma cidade em específico.
- **Método:** GET

- **Endpoint:** ```/1```

- **Descrição:** Retorna os detalhes de uma cidade específica pelo ID.
  
**Exemplo:**
```bash
http://localhost:8080/doisv/cidade/1
```
4. ### Usuário criar os dados para essa cidade.
- **Método:** POST

- **Endpoint:** ```/create```

- **Descrição:** Cadastra uma nova cidade na base de dados.
  
**Exemplo:**
```bash
{
    "idCidade": "V2933307",
    "nomeCidade": "Vitoria da Conquista",
    "uf": "BA",
    "cep": "40330-101"
}
```
```bash
http://localhost:8080/doisv/cidade/create
```

5. ### Usuário alterar os dados para uma cidade já criada.
- **Método:** PUT

- **Endpoint:** ```/create/1```

- **Descrição:**  Atualiza as informações de uma cidade específica pelo ID.
**Exemplo:**
```bash
http://localhost:8080/doisv/cidade/create/1
```
6. ### Deletar uma cidade já criada.
- **Método:** DELETE

- **Endpoint:** ```/delete/1```

- **Descrição:**  Exclui um veículo da base de dados pelo ID.
**Exemplo:**
```bash
http://localhost:8080/doisv/cidade/delete/1
```
---
1. ## Endpoint padrão para veiculo = /doisv/veiculo.
--
2. ### Listar todos os dados do veículo.
   
- **Método:** GET

- **Endpoint:** ```/veiculos```

- **Descrição:** Retorna uma lista de todos os veiculos cadastrados.
  
**Exemplo:**
```bash
http://localhost:8080/doisv/veiculo/veiculos
```
3. ### Listar apenas os dados de um veiculo em específico.
- **Método:** GET

- **Endpoint:** ```/1```

- **Descrição:** Retorna os detalhes de um veiculo específico pelo ID.
  
**Exemplo:**
```bash
http://localhost:8080/doisv/veiculo/1
```
4. ### Usuário criar os dados para esse veiculo.
- **Método:** POST

- **Endpoint:** ```/create```

- **Descrição:** Cadastra um novo veiculo na base de dados.
  
**Exemplo:**
```bash
{
    "placa": "ABC12345",
    "motorista": "João Lima",
    "modelo": "Ônibus Modelo W",
    "dataCompra": "2024-12-25",
    "qtdPoltronas": 45
}
```
```bash
http://localhost:8080/doisv/veiculo/create
```

5. ### Usuário alterar os dados para um veiculo já criado.
- **Método:** PUT

- **Endpoint:** ```/create/1```

- **Descrição:**  Atualiza as informações de um veiculo específico pelo ID.
**Exemplo:**
```bash
http://localhost:8080/doisv/veiculo/create/1
```
6. ### Deletar um veiculo já criado.
- **Método:** DELETE

- **Endpoint:** ```/delete/1```

- **Descrição:**  Exclui um veículo da base de dados pelo ID.
**Exemplo:**
```bash
http://localhost:8080/doisv/veiculo/delete/1
```
---
1. ## Endpoint padrão para passagem = /doisv/passagem.
--
2. ### Listar todos os dados das passagens.
   
- **Método:** GET

- **Endpoint:** ```/passagens```

- **Descrição:** Retorna uma lista de todas as passagens cadastradas.
  
**Exemplo:**
```bash
http://localhost:8080/doisv/passagem/passagens
```
3. ### Listar apenas os dados de uma passagem em específico.
- **Método:** GET

- **Endpoint:** ```/1```

- **Descrição:** Retorna os detalhes de uma passagem específica pelo ID.
  
**Exemplo:**
```bash
http://localhost:8080/doisv/passagem/1
```
4. ### Usuário criar os dados para essa passagem.
- **Método:** POST

- **Endpoint:** ```/create```

- **Descrição:** Cadastra uma nova passagem na base de dados.
  
**Exemplo:**
```bash
{
    "poltrona": 12,
    "dataSaida": "2024-11-15",
    "horaSaida": "16:00",
    "valorPassagem": 200.50,
    "veiculo": {
        "numero": 1 // Assumindo que você tem um veículo existente com número 1
    },
    "cidadeOrigem": {
        "idCidade": "V2933307" // Supondo que CIDADE1 é uma cidade já cadastrada
    },
    "cidadeDestino": {
        "idCidade": "Vitoria da Conquista" // Salvador
    }
}
```
```bash
http://localhost:8080/doisv/passagem/create
```

5. ### Usuário alterar os dados para uma passagem já criada.
- **Método:** PUT

- **Endpoint:** ```/create/1```

- **Descrição:**  Atualiza as informações de uma passagem específica pelo ID.
**Exemplo:**
```bash
http://localhost:8080/doisv/passagem/create/1
```
6. ### Deletar uma passagem já criada.
- **Método:** DELETE

- **Endpoint:** ```/delete/1```

- **Descrição:**  Exclui uma passagem da base de dados pelo ID.
**Exemplo:**
```bash
http://localhost:8080/doisv/passagem/delete/1
```
---

## Como executar a aplicação
---
### Clone o repositório: 
```bash
git clone https://github.com/FilipeMagal/Passagens-Rodoviarias-API-REST.git
```
### Compile e execute a aplicação
1. Após compilar
2. Você irá receber uma Basic Authentication (ou Basic Auth) por conta do Spring Security
3. Copie-o
4. Vá para o postman
5. Escolha alguma url e utilize a aplicação do jeito que desejar.




    
