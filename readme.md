# Projeto Spring Boot Api REST com CRUD

### CRUD de Clientes
Este projeto contem crud de clientes completo com tratamento de exceções.
O projeto está configurado em ambiente de testes e possui banco de dados H2 e um seed para inserção inicial de dados para fins de testes. As seguintes operações são suportadas:


* Busca paginada de clientes
* Busca de cliente por id
* Inserir novo cliente
* Atualizar cliente
* Deletar cliente

Os seguintes testes podem ser aplicados ao projeto, com tratamento de exceção para testes negativos:
* Busca por id retorna cliente existente;
* Busca por id retorna 404 para cliente inexistente;
* Busca paginada retorna listagem paginada corretamente;
* Inserção de cliente insere cliente com dados válidos;
* Inserção de cliente retorna 422 e mensagens customizadas com dados inválidos, caso o campo "name" esteja vazio, menor que 10 posições e maior que 50 posições. Se o campo "birthDate" for preenchido com data no futuro a Api emite uma mensagem informando que datas no futuro não podem ser utilizadas;
* Atualização de cliente atualiza cliente com dados válidos
* Atualização de cliente retorna 404 para cliente inexistente
* Atualização de cliente retorna 422 e mensagens customizadas com dados inválidos, caso o campo "name" esteja vazio, menor que 10 posições e maior que 50 posições. Se o campo "birthDate" for preenchido com data no futuro a Api emite uma mensagem informando que datas no futuro não podem ser utilizadas;
* Deleção de cliente deleta cliente existente;
* Deleção de cliente retorna 404 para cliente inexistente.

### Exemplos de payloads para testes

#### Host da Api REST
http://localhost:8080

#### Busca por todos os clientes
GET /clients

#### Busca de cliente por Id
GET /clients/1

#### Busca paginada de clientes
GET /clients?page=0&size=5&sort=name

#### Inserção de novo cliente
POST /clients
```json
{
  "name": "Pedro Paulo de Oliveira",
  "cpf": "27810240580",
  "income": 5000.0,
  "birthDate": "1980-07-20",
  "children": 2
}
```

#### Atualização de cliente
PUT /clients/1
```json
{
  "name": "Pedro Paulo de Oliveira Santos",
  "cpf": "27810240580",
  "income": 5000.0,
  "birthDate": "1980-07-20",
  "children": 2
}
```

#### Deleção de cliente
DELETE /clients/1