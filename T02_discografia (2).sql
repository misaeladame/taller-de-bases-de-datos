--crear la base de datos
CREATE DATABASE miBD18131209

--Poner en uso la base de datos
USE miBD18131209

--Crear la tabla compañia
CREATE TABLE compañia 
(
comp_id INT IDENTITY PRIMARY KEY, 
comp_nombre VARCHAR(255) NOT NULL, 
comp_dirección VARCHAR(255) NOT NULL 
);

--Crear la tabla grabaciones
CREATE TABLE grabaciones 
(
grab_id INT IDENTITY PRIMARY KEY, 
grab_titulo VARCHAR(255) NOT NULL, 
grab_temas INT NOT NULL CONSTRAINT chck_grab_temas CHECK (grab_temas >= 0), 
grab_descripcion VARCHAR(255) NOT NULL, 
comp_id INT NOT NULL CONSTRAINT compfk FOREIGN KEY REFERENCES compañia, 
cat_id INT NOT NULL CONSTRAINT catfk FOREIGN KEY REFERENCES categoria, 
form_id INT NOT NULL CONSTRAINT formfk FOREIGN KEY REFERENCES formato, 
edo_id INT NOT NULL CONSTRAINT edofk FOREIGN KEY REFERENCES estado_conservacion
);

--Crear la tabla interprete
CREATE TABLE interprete 
(
int_id INT IDENTITY PRIMARY KEY, 
int_nombre VARCHAR(255) NOT NULL,
int_descripcion VARCHAR(255) NOT NULL
);

--Crear la tabla formato
CREATE TABLE formato 
(
form_id INT IDENTITY PRIMARY KEY, 
form_nombre VARCHAR(255) NOT NULL
);

--Crear la tabla participaciones 
CREATE TABLE participaciones 
(
part_id IN IDENTITY PRIMARY KEY, 
part_fecha DATETIME NOT NULL , 
grab_id INT NOT NULL CONSTRAINT grabfk FOREIGN KEY REFERENCES grabaciones, 
int_id INT NOT NULL CONSTRAINT intfk FOREIGN KEY REFERENCES interprete, 
tpart_id INT NOT NULL CONSTRAINT tpartfk FOREIGN KEY REFERENCES tparticipaciones
);

--Crear la tabla categoria
CREATE TABLE categoria 
(
cat_id INT IDENTITY PRIMARY KEY, 
cat_nombre VARCHAR(255) NOT NULL
);

--Crear la tabla tparticipaciones
CREATE TABLE tparticipaciones 
(
tpart_id INT IDENTITY PRIMARY KEY, 
tpart_nombre VARCHAR(255) NOT NULL
);

--Crear la tabla estado_conservacion
CREATE TABLE estado_conservacion 
(
edo_id INT IDENTITY PRIMARY KEY,
edo_nombre VARCHAR(255) NOT NULL
);

--Crear la tabla sueldos
CREATE TABLE sueldos 
(
sdo_monto MONEY NOT NULL, 
part_id INT NOT NULL CONSTRAINT partfk FOREIGN KEY REFERENCES participaciones 
);
