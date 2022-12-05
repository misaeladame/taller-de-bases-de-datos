--crear la base de datos
CREATE DATABASE discografia

--Poner en uso la base de datos
USE discografia

--Crear la tabla compañia
CREATE TABLE compañia 
(
comp_id int IDENTITY NOT NULL, 
comp_nombre varchar(255) NULL, 
comp_dirección varchar(255) NULL, 
PRIMARY KEY (comp_id)
);

--Crear  la tabla grabaciones
CREATE TABLE grabaciones 
(
grab_id int IDENTITY NOT NULL, 
grab_titulo varchar(255) NULL, 
grab_temas int NULL, 
grab_descripcion varchar(255) NULL, 
comp_id int NOT NULL, 
cat_id int NOT NULL, 
form_id int NOT NULL, 
edo_id int NOT NULL, 
PRIMARY KEY (grab_id)
);

--Crear la tabla interprete
CREATE TABLE interprete 
(
int_id int IDENTITY NOT NULL, 
int_nombre varchar(255) NOT NULL, 
PRIMARY KEY (int_id)
);

--Crear la tabla formato
CREATE TABLE formato 
(
form_id int IDENTITY NOT NULL, 
form_nombre varchar(255) NOT NULL, 
PRIMARY KEY (form_id)
);

--Crear la tabla participaciones
CREATE TABLE participaciones 
(
part_id int IDENTITY NOT NULL, 
part_fecha datetime NULL, 
grab_id int NOT NULL, 
int_id int NOT NULL, 
tpart_id int NOT NULL, 
PRIMARY KEY (part_id)
);

--Crear la tabla categoria
CREATE TABLE categoria 
(
cat_id int IDENTITY NOT NULL, 
cat_nombre varchar(255) NULL,
PRIMARY KEY (cat_id)
);

--Crear la tabla tparticipaciones
CREATE TABLE tparticipaciones 
(
tpart_id int IDENTITY NOT NULL, 
tpart_nombre varchar(255) NULL,
PRIMARY KEY (tpart_id)
);

--Crear la tabla estado_conservacion
CREATE TABLE estado_conservacion 
(
edo_id int IDENTITY NOT NULL,
edo_nombre varchar(255) NULL, 
PRIMARY KEY (edo_id)
);

--Crear la tabla sueldos
CREATE TABLE sueldos 
(
sdo_monto money NOT NULL, 
part_id int NOT NULL
);

