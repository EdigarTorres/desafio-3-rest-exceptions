# Desafio 3 - REST e Exceptions

## Especificação

Projeto Spring Boot contendo um CRUD completo de web services REST para 
acessar um recurso de clientes, contendo as cinco operações básicas aprendidas no capítulo: 

- Busca paginada de recursos 
- Busca de recurso por id 
- Inserir novo recurso 
- Atualizar recurso 
- Deletar recurso

## Endpoints

Busca de cliente por id 
GET /clients/1 

Busca paginada de clientes 
GET /clients?page=0&size=6&sort=name 

Inserção de novo cliente 
POST /clients 
{
"name": "Maria Silva", 
"cpf": "12345678901", 
"income": 6500.0, 
"birthDate": "1994-07-20", 
"children": 2 
}

Atualização de cliente 
PUT /clients/1 
{
"name": "Maria Silvaaa", 
"cpf": "12345678901", 
"income": 6500.0, 
"birthDate": "1994-07-20", 
"children": 2 
}

Deleção de cliente 
DELETE /clients/1 

## Checklit

1. Busca por id retorna cliente existente 
2. Busca por id retorna 404 para cliente inexistente 
3. Busca paginada retorna listagem paginada corretamente 
4. Inserção de cliente insere cliente com dados válidos 
5. Inserção de cliente retorna 422 e mensagens customizadas com dados inválidos 
6. Atualização de cliente atualiza cliente com dados válidos 
7. Atualização de cliente retorna 404 para cliente inexistente 
8. Atualização de cliente retorna 422 e mensagens customizadas com dados inválidos 
9. Deleção de cliente deleta cliente existente 
10. Deleção de cliente retorna 404 para cliente inexistente

## Tecnologias Utilizadas

- **Java 21** (Linguagem de programação)
- **Spring** (Framework)
- **Maven** (Gerenciamento de dependências e build)
- **Jackarta** (Gerenciamento de ORM)
- **Hibernate-Validator** (Validação de dados)
- **H2** (Banco de dados leve para desenvolvimento)
- **Git** (Controle de versão)
- **GitHub** (Hospedagem do repositório)
- **Spring Data JPA** (Operações de acesso ao banco de dados)
