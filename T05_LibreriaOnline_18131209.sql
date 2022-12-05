--Script para crear la base de datos libreria_online 
--Materia Taller de Base de Datos 
--Fecha de creacion 02/03/20
--Autor: José Misael Adame Sandoval 18131209
--Lugar: Torreon, Coahuila 

--Crear la base de datos
CREATE DATABASE libreria_online

--Poner en uso la base de Datos
USE libreria_online

--Crear la tabla autor
CREATE TABLE autor 
(
    aut_id INT IDENTITY NOT NULL,
    aut_nombre VARCHAR(255) NOT NULL,
    aut_direccion VARCHAR(255) NOT NULL,
    aut_url VARCHAR(255) NOT NULL,
    PRIMARY KEY (aut_id)
);

--Crear la tabla editorial
CREATE TABLE editorial 
(
    edi_id INT IDENTITY NOT NULL,
    edi_nombre VARCHAR(255) NOT NULL,
    edi_direccion VARCHAR(255) NULL,
    edi_telefono VARCHAR(255) NOT NULL,
    edi_url INT NOT NULL,
    PRIMARY KEY (edi_id)
);

--Crear la tabla libro
CREATE TABLE libro 
(
    lib_id INT IDENTITY NOT NULL,
    lib_isbn VARCHAR(255) NOT NULL,
    lib_titulo VARCHAR(255) NOT NULL,
    lib_año VARCHAR(255) NULL,
    lib_precio MONEY NULL,
    aut_id INT NOT NULL,
    edi_id INT NOT NULL,
    PRIMARY KEY (lib_id)
);

--Crear la tabla almacen 
CREATE TABLE almacen 
(
    alm_id INT IDENTITY NOT NULL,
    alm_codigo INT NOT NULL,
    alm_telefono VARCHAR(255),
    alm_direccion VARCHAR(255),
    PRIMARY KEY (alm_id)
);

--Crear la tabla almacen_libro
CREATE TABLE almacen_libro
(
    lib_id INT NOT NULL,
    alm_id INT NOT NULL,
    alm_lib_cantidad INT NOT NULL,
    PRIMARY KEY (lib_id, alm_id)
);

--Crear la tabla cliente
CREATE TABLE cliente 
(
    cli_id INT IDENTITY NOT NULL,
    cli_nombre VARCHAR(255) NOT NULL,
    cli_email VARCHAR(255) NOT NULL,
    cli_telefono VARCHAR(255) NULL,
    cli_direccion VARCHAR(255) NOT NULL,
    PRIMARY KEY (cli_id)
);

--Crear la tabla carrito_compras
CREATE TABLE carrito_compras
(
    car_id INT IDENTITY NOT NULL,
    cli_id INT NOT NULL,
    PRIMARY KEY (car_id)
);

--Crear la tabla carrito_compras_libro
CREATE TABLE carrito_compras_libro
(
    car_id INT NOT NULL,
    lib_id INT NOT NULL,
    car_lib_cantidad INT NOT NULL,
    PRIMARY KEY (car_id, lib_id)
);

--Crear constraint para que sea unico lib_isbn en la tabla libro
ALTER TABLE libro
ADD UNIQUE (id_isbn);

--Crear constraint para que sea unico alm_codigo en la tabla almacen
ALTER TABLE almacen
ADD UNIQUE (alm_codigo);

--Crear constraint para referenciar el aut_id de la tabla autor en la tabla libro
ALTER TABLE libro
ADD CONSTRAINT autfk_id_lib
FOREIGN KEY (aut_id)
REFERENCES autor (aut_id);

--Crear constraint para referenciar el edi_id de la tabla editorial en la tabla libro
ALTER TABLE libro
ADD CONSTRAINT edifk_id_lib
FOREIGN KEY (edi_id)
REFERENCES editorial (edi_id);

--Crear constraint para referenciar el lib_id de la tabla libro en la tabla almacen_libro
ALTER TABLE almacen_libro
ADD CONSTRAINT libfk_id_alm_lib
FOREIGN KEY (lib_id)
REFERENCES libro (lib_id);

--Crear constraint para referenciar el alm_id de la tabla almacen en la tabla almacen_libro
ALTER TABLE almacen_libro
ADD CONSTRAINT almfk_id_alm_lib
FOREIGN KEY (alm_id)
REFERENCES almacen (alm_id);

--Crear constraint para referenciar el cli_id de la tabla cliente en la tabla carrito_compras
ALTER TABLE carrito_compras
ADD CONSTRAINT clifk_id_cli
FOREIGN KEY (cli_id)
REFERENCES cliente (cli_id);

--Crear constraint para referenciar el car_id de la tabla carrito_compras en la tabla carrito_compras_libro
ALTER TABLE carrito_compras_libro
ADD CONSTRAINT carfk_id_car_lib
FOREIGN KEY (car_id)
REFERENCES carrito_compras (car_id);

--Crear constraint para referenciar el lib_id de la tabla libro en la tabla carrito_compras_libro
ALTER TABLE carrito_compras_libro
ADD CONSTRAINT libfk_id_car_lib
FOREIGN KEY (lib_id)
REFERENCES libro (lib_id);

--Crear un indice único de lib_isbn de la tabla libro
CREATE UNIQUE NONCLUSTERED INDEX lib_isbn_idx
ON libro (lib_isbn ASC);

--Crear un indice de lib_titulo de la tabla libro
CREATE NONCLUSTERED INDEX lib_titulo_idx
ON libro (lib_titulo ASC);

--Crear un indice de aut_nombre de la tabla autor 
CREATE NONCLUSTERED INDEX aut_nombre_idx
ON autor (aut_nombre);

--Crear un índice de edi_nombre de la tabla editorial
CREATE NONCLUSTERED INDEX edi_nombre_idx
ON editorial (edi_nombre);

--Crear un índice único alm_codigo de la tabla almacen
CREATE UNIQUE NONCLUSTERED INDEX alm_codigo_idx
ON almacen (alm_codigo);

--Crear un índice de cli_nombre de la tabla cliente
CREATE NONCLUSTERED INDEX cli_nombre_idx
ON cliente (cli_nombre);
