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

```
PETS:
   
| Method   | URL                                      | Description                                                      |
| -------- | ---------------------------------------- | ---------------------------------------------------------------- |
| `GET`    | `/pets`                                  | Retorna todos os pets registrados em banco.                      |
| `POST`   | `/pets`                                  | Registra novos pets.                                             |
| `PUT`    | `/pets`                                  | Altera a informação de um pet.                                   |
| `DELETE` | `/pets`                                  |  Apaga um pet do banco.                                          |
```

```
AUTH:

| Method   | URL                                      | Description                              |
| -------- | ---------------------------------------- | ---------------------------------------- |
| `POST`   | `/auth/login`                            | Autentica um usuario.                    |
| `POST`   | `/auth/register/adm`                     | Registra novo ADM.                       |
| `POST`   | `/auth/register/user`                    | Registra novo usuario.                   |  

Payload (para todos os endpoints):
{
    "login": "user",
    "password": "password"
}
```

```
ADOPTION APLICATION:

| Method   | URL                                      | Description                              |
| -------- | ---------------------------------------- | ---------------------------------------- |
| `POST`   | `/adoptionApplication`                   | Registra uma solicitação de adoção       | 

Payload:
{
    "nomeUsuario": "nomeUsuario",
    "emailUsuario": "emaiUsuario",
    "telefoneUsuario": "telefoneUsuario",
    "idPet": "petData.id",
    "nomeDoPet": "petData.name"
}
```

## Database
O projeto utiliza PostgresSQL como banco de dados. As migrations utilizadas estão sendo gerenciadas com Flyway.

Para [instalar PostgresSQL](https://www.postgresql.org/download/).
=======


Integrantes:

- Camila Caetano - 125111344135
- Gabriel Steffen - 125111353992
- Filipe Anestidis - 125111363103
- Mateus Timm - 125111369651
- Paulo Converso - 125111373916

