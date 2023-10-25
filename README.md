# DSWN1
Trabalho para Desenvolvimento de Software para Web.
Esse repositório contem o Micro Serviço responsavel por fazer as operações simples de um CRUD para um site de adoção de pets

## Conteúdo

- [Installation](#instalação)
- [Configuration](#configuração)
- [API Endpoints](#api-endpoints)
- [Database](#database)

## Installation

1. Clone the repository:

```bash
git clone git@github.com:UAMCGMP/DSWN1.git
```

2. Instale as dependências com Maven
```bash
  mvn clean install
 ```

## Uso

1. Inicie a aplicação com Maven
2. A API estará disponível em http://localhost:8080 ou em ambiente produtivo https://dswn1-pawsome-app.onrender.com


## API Endpoints
A API entrega os seguintes endpoints:

```markdown
GET / - Retorna a lista com todos os pets cadastrados.

POST / - Registra novos pets.

PUT / - Atualiza os dados dos pets.

DELETE / - Deleta um pet do banco.
```

## Database
O projeto utiliza PostgresSQL como banco de dados. As migrations utilizadas estão sendo gerenciadas com Flyway.

Para [instalar PostgresSQL](https://www.postgresql.org/download/).