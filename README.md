# clean-architecture-picpay-challange (Em construção)

Desafio do Picpay sendo resolvido utilizando Clean Architecture.

## Endpoints

### http://localhost:8081/api/v1/user/createUser]

Cadastrar um novo uusário

**Validações:** O email é único, o taxNumber é único podendo ser CNPJ ou CPF, o type pode ser USER ou SHOPKEEPER.

```json
  {
    "email": "gabrgfl@htmail.com",
    "password": "camilo123",
    "taxNumber": "17364509720",
    "fullName": "Gabriel Cardoso Girarde",
    "type": "USER",
    "pin": "12345678"
}
```

### http://localhost:8081/api/v1/wallet/transfer

Realizar transferência

**Validações:** Para realizar um transferência é necessário informar o PIN criado na hora do cadastro, o usuário terá 3 tentivas de acertos e quando chegar a zero a carteira será bloqueada, caso ele acerte o contador retorna para 3 tentivas. 

```json
  {
    "fromTaxNumber": "17364509720",
    "toTaxNumber": "95018069791",
    "value": 123.45,
    "pin": "1234568"
  }
```

### http://localhost:8081/api/v1/wallet/consultBalance/{taxNumber}

Consultar saldo

**Resposta**

```json
  {
    "success": true,
    "result": {
        "balance": 376.55
    }
}
```

# Tecnologias

### Spring Web 

### Spring Cloud

### Flyway

### H2 
