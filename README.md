# Passagens Rodoviárias

Projeto desenvolvido como proposta da **Faculdade Visconde de Cairu**, com o objetivo de criar um sistema de gestão de passagens rodoviárias.

---

## Endpoints da API
---

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

**Outro Exemplo**
```bash
{
        "idCidade": "CIDADE2",
        "nomeCidade": "Salvador",
        "uf": "BA",
        "cep": "01100-000"
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

---

### 1. Listar Todas as Passagens
- **Método:** GET  
- **Endpoint:** `/passagens`  
- **Descrição:** Retorna uma lista de todas as passagens cadastradas.  

**Exemplo de URL:**  
```bash
http://localhost:8080/doisv/passagem/passagens
```

---

### 2. Obter Detalhes de uma Passagem por ID
- **Método:** GET  
- **Endpoint:** `/{id}`  
- **Descrição:** Retorna os detalhes de uma passagem específica pelo ID.  

**Exemplo de URL:**  
```bash
http://localhost:8080/doisv/passagem/1
```

---

### 3. Criar uma Nova Passagem
- **Método:** POST  
- **Endpoint:** `/create`  
- **Descrição:** Adiciona uma nova passagem à base de dados.  

**Exemplo de URL:**  
```bash
http://localhost:8080/doisv/passagem/create
```

**Exemplo no Postman**
```bash
{
    {
    "poltrona": 16,
    "dataSaida": "2024-11-18",
    "horaSaida": "07:50",
    "valorPassagem": 250.10,
    "veiculo": {
        "numero": 1 
    },
    "cidadeOrigem": {
        "idCidade": "CIDADE2" 
    },
    "cidadeDestino": {
        "idCidade": "V2933307" 
    }
}
}
```

---

### 4. Atualizar uma Passagem Existente
- **Método:** PUT  
- **Endpoint:** `/create/{id}`  
- **Descrição:** Atualiza as informações de uma passagem específica pelo ID.  

**Exemplo de URL:**  
```bash
http://localhost:8080/doisv/passagem/create/1
```

---

### 5. Excluir uma Passagem
- **Método:** DELETE  
- **Endpoint:** `/delete/{id}`  
- **Descrição:** Remove uma passagem da base de dados pelo ID.  

**Exemplo de URL:**  
```bash
http://localhost:8080/doisv/passagem/delete/1
```

---

## Como Executar a Aplicação

---
1. Antes de tudo, pegue os scripts para o banco de dados:

```bash
CREATE TABLE cidade (
    idCidade VARCHAR(10) PRIMARY KEY,
    nomeCidade VARCHAR(50) NOT NULL,
    uf VARCHAR(2) NOT NULL,
    cep VARCHAR(9) NOT NULL UNIQUE
);
```

```bash
CREATE TABLE veiculo (
    numero BIGINT AUTO_INCREMENT PRIMARY KEY,
    placa VARCHAR(8) NOT NULL,
    motorista VARCHAR(100) NOT NULL,
    modelo VARCHAR(50) NOT NULL,
    dataCompra DATE NOT NULL,
    qtdPoltronas INT NOT NULL
);
```
```bash
CREATE TABLE passagem (
    idPassagem BIGINT AUTO_INCREMENT PRIMARY KEY,
    poltrona INT NOT NULL,
    dataSaida DATE NOT NULL,
    horaSaida VARCHAR(5) NOT NULL,
    valorPassagem DECIMAL(10, 2) NOT NULL,
    veiculo VARCHAR(50) NOT NULL,  -- A chave estrangeira veiculo, com base no número do veículo
    cidade_Origem VARCHAR(10) NOT NULL,  -- A chave estrangeira para a cidade de origem
    cidade_Destino VARCHAR(10) NOT NULL,  -- A chave estrangeira para a cidade de destino
    FOREIGN KEY (veiculo) REFERENCES veiculo(numero),  -- Referência à tabela de veiculos
    FOREIGN KEY (cidade_Origem) REFERENCES cidade(idCidade),  -- Referência à tabela de cidades
    FOREIGN KEY (cidade_Destino) REFERENCES cidade(idCidade)  -- Referência à tabela de cidades
);
```
```bash
-- Cria a função chamada "incrementa_dia"
CREATE OR REPLACE FUNCTION incrementa_dia()
RETURNS trigger AS $$  -- Define que a função retorna um "trigger"
BEGIN  -- Início do bloco da função

-- Incrementa 1 dia na coluna "data_saida" do registro que está sendo inserido
    NEW.data_saida := NEW.data_saida + INTERVAL '1 day'; 

-- Retorna o novo registro com o campo "data_saida" atualizado
    RETURN NEW;

END;  -- Fim do bloco da função
$$ LANGUAGE plpgsql;  -- Define que a função utiliza a linguagem PL/pgSQL
```
```bash
-- Cria uma trigger chamada "trigger_incrementa_dia"
CREATE TRIGGER trigger_incrementa_dia
-- Especifica que a trigger será acionada antes de um INSERT na tabela "passagem"
BEFORE INSERT ON passagem
-- Especifica que a trigger deve ser acionada para cada linha inserida
FOR EACH ROW
-- Define que a trigger vai executar a função "incrementa_dia"
EXECUTE FUNCTION incrementa_dia();
```
2. Clone o repository: git clone https://github.com/FilipeMagal/Passagens-Rodoviarias-API-REST.git
3. Compile e execute 
4. Após compilar, o spring security irá criar um token
5. Use o token no postman para autorização (basic auth)
6. Agora é só utilizar as requisições HTTP com seus respectivos endpoints e desfrutar da API

