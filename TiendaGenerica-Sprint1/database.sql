CREATE DATABASE IF NOT EXISTS tienda_generica CHARACTER SET utf8mb4;
USE tienda_generica;
CREATE TABLE IF NOT EXISTS usuarios (
 cedula VARCHAR(20) PRIMARY KEY,
 nombre_completo VARCHAR(255) NOT NULL,
 correo VARCHAR(255) NOT NULL,
 nombre_usuario VARCHAR(100) NOT NULL UNIQUE,
 contrasena VARCHAR(255) NOT NULL
);
