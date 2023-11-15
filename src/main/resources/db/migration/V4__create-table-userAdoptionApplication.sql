CREATE TABLE userAdoptionApplication (
    id TEXT PRIMARY KEY UNIQUE NOT NULL,
    nomeUsuario TEXT NOT NULL UNIQUE,
    emailUsuario TEXT NOT NULL,
    telefoneUsuario TEXT NOT NULL,
    idPet TEXT NOT NULL,
    nomeDoPet TEXT NOT NULL
);