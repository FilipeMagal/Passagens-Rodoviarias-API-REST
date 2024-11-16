# Passagens Rodoviárias

Projeto desenvolvido como proposta da **Faculdade Visconde de Cairu**, com o objetivo de criar um sistema de gestão de passagens rodoviárias.

---

## Endpoints da API

O endpoint padrão para gerenciamento de cidades no sistema é:  `/doisv/cidade`
O endpoint padrão para gerenciamento de veiculos no sistema é: `/doisv/veiculo`
O endpoint padrão para gerenciamento de passagens no sistema é: `/doisv/passagem`
---

### 1. Listar Todas as Cidades
- **Método:** GET  
- **Endpoint:** `/cidades`  
- **Descrição:** Retorna uma lista de todas as cidades cadastradas.  

**Exemplo de URL:**  
```bash
http://localhost:8080/doisv/cidade/cidades
```

---

### 2. Obter Detalhes de uma Cidade por ID
- **Método:** GET  
- **Endpoint:** `/{id}`  
- **Descrição:** Retorna os detalhes de uma cidade específica pelo ID.  

**Exemplo de URL:**  
```bash
http://localhost:8080/doisv/cidade/1
```

---

### 3. Criar uma Nova Cidade
- **Método:** POST  
- **Endpoint:** `/create`  
- **Descrição:** Adiciona uma nova cidade à base de dados.  

**Exemplo de URL:**  
```bash
http://localhost:8080/doisv/cidade/create
```

**Exemplo no Postman**
```bash
{
        "idCidade": "V2933307",
        "nomeCidade": "Vitoria da Conquista",
        "uf": "BA",
        "cep": "01110-000"
}
```

---

### 4. Atualizar uma Cidade Existente
- **Método:** PUT  
- **Endpoint:** `/create/{id}`  
- **Descrição:** Atualiza as informações de uma cidade específica pelo ID.  

**Exemplo de URL:**  
```bash
http://localhost:8080/doisv/cidade/create/1
```

---

### 5. Excluir uma Cidade
- **Método:** DELETE  
- **Endpoint:** `/delete/{id}`  
- **Descrição:** Remove uma cidade da base de dados pelo ID.  

**Exemplo de URL:**  
```bash
http://localhost:8080/doisv/cidade/delete/1
```

---

### 1. Listar Todos os Veículos
- **Método:** GET  
- **Endpoint:** `/veiculos`  
- **Descrição:** Retorna uma lista de todos os veículos cadastrados.  

**Exemplo de URL:**  
```bash
http://localhost:8080/doisv/veiculo/veiculos
```

---

### 2. Obter Detalhes de um Veículo por ID
- **Método:** GET  
- **Endpoint:** `/{id}`  
- **Descrição:** Retorna os detalhes de um veículo específico pelo ID.  

**Exemplo de URL:**  
```bash
http://localhost:8080/doisv/veiculo/1
```

--- 

### 3. Criar um Novo Veículo
- **Método:** POST  
- **Endpoint:** `/create`  
- **Descrição:** Adiciona um novo veículo à base de dados.  

**Exemplo de URL:**  
```bash
http://localhost:8080/doisv/veiculo/create
```

**Exemplo no Postman**
```bash
{
    "numero": 1,
    "placa": "ABC1234",
    "motorista": "Filipe Magal",
    "modelo": "Ônibus Modelo Y",
    "dataCompra": "2024-11-03",
    "qtdPoltronas": 40
}
```

---

### 4. Atualizar uma Cidade Existente
- **Método:** PUT  
- **Endpoint:** `/create/{id}`  
- **Descrição:** Atualiza as informações de uma cidade específica pelo ID.  

**Exemplo de URL:**  
```bash
http://localhost:8080/doisv/cidade/create/1
```

---

### 5. Excluir um Veículo
- **Método:** DELETE  
- **Endpoint:** `/delete/{id}`  
- **Descrição:** Remove um veículo da base de dados pelo ID.  

**Exemplo de URL:**  
```bash
http://localhost:8080/doisv/veiculo/delete/1
```
