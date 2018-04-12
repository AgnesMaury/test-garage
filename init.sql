CREATE DATABASE garage_db;

CREATE TABLE garages (
    id VARCHAR(255) PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    address VARCHAR(255) NOT NULL,
    creation_date TIMESTAMP NOT NULL,
    maximum_capacity INTEGER NOT NULL
);

CREATE TABLE cars (
    id VARCHAR(255) PRIMARY KEY,
    matriculation VARCHAR(255) NOT NULL,
    brand VARCHAR(255) NOT NULL,
    model VARCHAR(255) NOT NULL,
    color VARCHAR(255) NOT NULL,
    commissioning_date TIMESTAMP NOT NULL,
    price REAL NOT NULL,
    garage_id VARCHAR(255) NOT NULL
);