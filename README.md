# Back-End Challenge - Contas Correntes
### Desafio: Run The Bank!

![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)
![Spring](https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white)
[![Licence](https://img.shields.io/github/license/Ileriayo/markdown-badges?style=for-the-badge)](./LICENSE)

API RestFull usando **Java, Java Spring, H2 as the database.**


## Installation

1. Clone the repository:

```bash
git clone https://github.com/
```
2. Install dependencies with Maven
```bash
git clone https://github.com/
```

4. Run on port `8080`


## Usage

1. Start the application with Maven
2. The API will be accessible at http://localhost:8080

## Swagger
1. The Swagger will be accessible at http://localhost:8080/swagger-ui/index.html

## Tests
1. Founder - src\test\java\com\bank\accounts\bankaccounts\data

## Database and application.properties
The project utilizes [H2 Database](https://www.h2database.com/html/tutorial.html) as the database. 
```json
   spring.jpa.hibernate.ddl-auto=create-drop
   spring.h2.console.enabled=true
   spring.datasource.url=jdbc:h2:mem:santanderdb
   spring.datasource.driverClassName=org.h2.Driver
   spring.datasource.username=admin
   spring.datasource.password=
   spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
   springdoc.api-docs.path=/api-docs
   url.notify.mock=https://run.mocky.io/v3/9769bf3a-b0b6-477a-9ff5-91f63010c9d3
```
## API Endpoints
The API provides the following endpoints:

**GET - Customer**
```markdown
GET /customer - List of all customer.
```
```json
[
  {
    "id": "04bf4d45-8cad-47bb-91c5-a379c56c84e2",
    "name": "Name Customer",
    "typeAccount": "PF",
    "cpfCnpj": "45154121451",
    "address": "Barueri",
    "password": "123456789"
  }
]
```
**GET - Customer By Id**
```markdown
GET /customer/{id} - List customer by id.
```

```json
[
  {
    "id": "04bf4d45-8cad-47bb-91c5-a379c56c84e2",
    "name": "Name Customer",
    "typeAccount": "PF",
    "cpfCnpj": "45154121451",
    "address": "Barueri",
    "password": "123456789"
  }
]
```

**POST - Customer**
```markdown
POST /customer - New customer into the App
```
```json
{
  "name": "Customer Name",
  "typeAccount": "PF",
  "cpfCnpj": "45154121451",
  "address": "Barueri",
  "password": "123456789"
}
```

**PUT Customer**
```markdown
PUT /customer/{id} - Updated all fields Customer
```

```json
{
  "name": "Customer Name",
  "typeAccount": "PF",
  "cpfCnpj": "45154121451",
  "address": "Barueri",
  "password": "123456789"
}
```

**PATCH Customer**
```markdown
PATCH /customer/{id} - Updated some fields Customer
```

```json
{
  "name": "Customer Name",
  "typeAccount": "PJ"
}
```

**DELETE Customer**
```markdown
DELETE /customer/{id} - Delete Customer
```

**POST Account**
```markdown
POST /account - Post Account
```

```json
{
  "customerId": "d7caee7e-ed60-4f97-a146-c465061a24da",
  "agency": "103",
  "balance": 100,
  "state": "Active"
}
```

**GET Account**
```markdown
GET /account/{id} - GET Account
```

**PATCH Account**
```markdown
PATCH /account/{id} - PATCH Account
```
```json
{
  "agency": "103",
  "balance": 150,
  "state": "Active"
}
```

**GET ALL Account**
```markdown
GET /account - GET All Account
```

**POST - Payment**
```markdown
POST /payment - Create one Payment
```
```json
{
  "senderAccountId": "626c770b-7d82-4182-ba78-11527c235d66",
  "destinationAccountId": "fdde43a7-b674-4c5c-8d9a-32a93b927252",
  "paymentValue": 20
}
```






