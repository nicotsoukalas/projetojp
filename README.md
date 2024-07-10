# AppPessoaContatos

## Descrição
Aplicação API Rest para gerenciar um sistema de cadastro de Pessoas e seus respectivos Contatos, onde cada Pessoa pode ter vários Contatos. O principal objetivo é permitir que operações CRUD (Criar, Ler, Atualizar, Deletar) sejam realizadas na estrutura de Pessoas e Contatos.

## Requisitos Técnicos
- Java com Spring Boot (Versão 3.2.7)
- JPA/Hibernate com H2
- Tratamento de dados de entrada e validações necessárias
- Documentação da API utilizando OpenAPI (Swagger)

## Funcionalidades
### CRUD de Pessoas
1. Criar Pessoa
2. Obter Pessoa por ID
3. Obter Pessoa por ID para mala direta
4. Listar todas as Pessoas
5. Atualizar Pessoa por ID
6. Deletar Pessoa por ID

### CRUD de Contatos
1. Adicionar um novo Contato a uma Pessoa
2. Obter Contato por ID
3. Listar todos os Contatos de uma Pessoa
4. Atualizar Contato por ID
5. Deletar Contato por ID

## Modelagem
### Pessoa
- ID (único, não pode ser nulo)
- Nome (não pode ser nulo)
- Endereço (pode ser nulo)
- CEP (pode ser nulo)
- Cidade (pode ser nulo)
- UF (pode ser nulo)

### Contato
- ID (único, não pode ser nulo)
- Tipo contato (não pode ser nulo) [inteiro: 0 - Telefone, 1 - Celular]
- Contato (não pode ser nulo)
- Relacionamento com a entidade Pessoa (OneToMany e ManyToOne)

## Endpoints
### Pessoa
- POST `/api/pessoas` (cria uma nova Pessoa)
- GET `/api/pessoas/{id}` (retorna os dados de uma Pessoa por ID)
- GET `/api/pessoas` (lista todas as Pessoas)
- PUT `/api/pessoas/{id}` (atualiza uma Pessoa existente)
- DELETE `/api/pessoas/{id}` (remove uma Pessoa por ID)
- GET `/api/pessoas/maladireta/{id}` (retorna os dados de uma Pessoa por ID para mala direta)
    - Exemplo de resposta:
    ```json
    {
      "ID": 1,
      "Nome": "Fulano",
      "MalaDireta": "Rua A, 1 – CEP: 11111-000 – Cidade/UF"
    }
    ```

### Contato
- POST `/api/contatos/` (adiciona um novo Contato a uma Pessoa)
- GET `/api/contatos/{id}` (retorna os dados de um Contato por ID)
- GET `/api/contatos/pessoa/{idPessoa}` (lista todos os Contatos de uma Pessoa)
- PUT `/api/contatos/{id}` (atualiza um Contato existente)
- DELETE `/api/contatos/{id}` (remove um Contato por ID)

## Documentação do OpenAPI (Swagger)

1. Acesse a aplicação:
    - A aplicação estará disponível em `http://localhost:8080`
    
2. Acesse a documentação do OpenAPI (Swagger):
    - A documentação da API estará disponível em `http://localhost:8080/swagger-ui.html`

## Banco de Dados
- A aplicação utiliza o banco de dados em memória H2.
- O console do H2 pode ser acessado em `http://localhost:8080/h2-console`.
