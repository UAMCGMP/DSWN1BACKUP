CREATE TABLE pet(
    id TEXT PRIMARY KEY UNIQUE NOT NULL,
    name TEXT NOT NULL,
    age int,
    breed TEXT,
    size TEXT,
    weight float,
    bio TEXT,
    gender TEXT,
    vaccinated TEXT,
    castration TEXT
);