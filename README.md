# teste-go2win-backend

## Descrição

Projeto de teste go2win sistema de transação.

## Tecnologias Utilizadas

- **Java 11**
- **Spring Boot 2.7.2**
- **Maven**

## Dependências Principais

### Spring Boot Starters

- **spring-boot-starter-data-jpa**: Fornece suporte ao JPA (Java Persistence API), facilitando a implementação de
  repositórios e entidades.
- **spring-boot-starter-web**: Fornece suporte para desenvolvimento de aplicações web, incluindo RESTful services.
- **spring-boot-starter-test**: Inclui bibliotecas para testes unitários e de integração, como JUnit, Hamcrest e
  Mockito.

### Banco de Dados

- **H2 Database**: Banco de dados em memória usado para desenvolvimento e testes.

### Utilitários

- **spring-boot-devtools**: Fornece funcionalidades para melhorar a experiência de desenvolvimento, como recarregamento
  automático.
- **Lombok**: Biblioteca que simplifica a escrita de código Java, gerando automaticamente métodos getter, setter,
  equals, hashCode e toString.
- **jackson-datatype-jsr310**: Suporte para tipos Java 8 Date and Time API no Jackson.

## Como Executar o Projeto

### Pré-requisitos

- Java 11
- Maven 3.6.3

### Passos para Execução

1. Clone o repositório:
    ```bash
    git clone https://github.com/PedroGomes15/teste-go2win-fronted.git
    ```
2. Navegue até o diretório do projeto:
    ```bash
    cd teste-go2win-backend
    ```
3. Execute o comando Maven para compilar o projeto e baixar as dependências:
    ```bash
    mvn clean install
    ```
4. Inicie a aplicação:
    ```bash
    mvn spring-boot:run
    ```

A aplicação estará disponível em `http://localhost:8080`.

## Serviços

- [Transaction](###transaction)
- [Tax](###tax)

## Rotas

### Tax

- #### Retorna a lista de Taxas

```http
  GET /tax
```

**Resposta:**

```bash
[
	{
		"data_from": 0,
		"data_to": 0,
		"tax": 2.5,
		"money": 3.0
	},...
]

```

-----

- #### Retorna a taxa referente a data

```http
GET /tax/fromdate
```

**Descrição**: Retorna a taxa relacionada à data fornecida em relação ao dia de hoje. Se a data for anterior ao dia de
hoje, retorna um erro. Se a data for maior que 50 dias a partir do dia de hoje, retorna outro erro.

**Exemplo de Requisição**:

```bash
curl -X GET "http://localhost:8080/tax/fromdate?date=2024-07-22"
```

**Resposta:**

```bash
{
	"data_from": 21,
	"data_to": 30,
	"tax": 6.9,
	"money": 0.0
}

```

-----

- #### Calcula a taxa referente ao valor que foi passado

```http
POST /tax/calculate
```

**Descrição**: Envia os dados de uma transação para simular a taxa.

**Body**:

| Parâmetro      | Tipo     | Descrição                                |
|:---------------|:---------|:-----------------------------------------|
| `amount`       | `number` | **Obrigatório**. Valor a ser transferido |
| `transferDate` | `Date`   | **Obrigatório**. Data do agendamento     |

**Exemplo de Requisição**:

```bash
curl --request POST \
  --url http://localhost:8080/tax/calculate \
  --header 'Content-Type: application/json' \
  --data '{
	"amount": 100,
	"transferDate": "2024-07-15"
}'
```

**Resposta:**

```bash
{
	"totalAmount": 106.9,
	"totalTaxAmount": 6.8999996,
	"tax": {
		"data_from": 21,
		"data_to": 30,
		"tax": 6.9,
		"money": 0.0
	}
}

```

### Transaction

- #### Retorna a lista de Transferencias

```http
  GET /transaction
```

**Resposta:**

```bash
[
	{
		"id": "22b57695-e855-4320-bbfe-895efc806fd0",
		"createdAt": "2024-06-24T00:41:19.914349",
		"fromAccount": "123123123",
		"destinyAccount": "123123123",
		"amount": 120.0,
		"taxAmount": 8.28,
		"transferDate": "2024-07-15"
	},
    ...
]

```

-----

- #### Nova Transferencia

```http
POST /transaction
```

**Descrição**: Cria o agendamento de um nova transferencia

**Body**:

| Parâmetro        | Tipo     | Descrição                                |
|:-----------------|:---------|:-----------------------------------------|
| `fromAccount`    | `string` | **Obrigatório**. Conta do cliente        |
| `destinyAccount` | `string` | **Obrigatório**. Conta do destinatario   |
| `amount`         | `number` | **Obrigatório**. Valor a ser transferido |
| `transferDate`   | `Date`   | **Obrigatório**. Data do agendamento     |

**Exemplo de Requisição**:

```bash
curl --request POST \
  --url http://localhost:8080/transaction \
  --header 'Content-Type: application/json' \
  --cookie JSESSIONID=C69115C99A9CF129543A881E99740C4E \
  --data '{
	"fromAccount": "123123123",
	"destinyAccount": "123123123",
	"amount": 120,
	"transferDate": "2024-07-15"
}'
```

**Resposta:**

```bash
{
	"id": "22b57695-e855-4320-bbfe-895efc806fd0",
	"createdAt": "2024-06-24T00:41:19.9143491",
	"fromAccount": "123123123",
	"destinyAccount": "123123123",
	"amount": 120.0,
	"taxAmount": 8.28,
	"transferDate": "2024-07-15"
}

```

## Roadmap

- Adicionar um banco de dados relacional como Postgress

- Migrar as taxas para um tabela no banco de dados para facilitar a atualização dos valores.

- Adicionar uma biblioteca de migrations para criar as tabelas no banco de dados relacional e manter o historico.

- Adicionar testes unitarios com o Spring Test

## Detalhes

- As taxas estão em um json estatico na pasta ./src/main/resources/data/transferTable.json

## Autores

- [@PedroGomes15](https://github.com/PedroGomes15)

