CREATE DATABASE Escuela_v2;

USE Escuela_v2;

CREATE TABLE alumnos 
(
    alu_nombre VARCHAR(255),
    alu_fnac DATE,
    alu_nctrl CHAR(10),
    alu_email VARCHAR(255)
);

CREATE TABLE maestros
(
    mtro_nombre VARCHAR(255),
    mtro_fnac DATE,
    mtro_nemp CHAR(10),
    mtro_email VARCHAR(255),
    mtro_rfc CHAR(13)
);

CREATE TABLE administrativos 
(
    adm_nombre VARCHAR(255),
    adm_fnac DATE,
    adm_nemp CHAR(10),
    adm_email VARCHAR(255),
    adm_rfc CHAR(13)
);

--Consulta de UNION
SELECT alu_nombre AS Nombre, alu_fnac AS FNac, alu_nctrl AS Num, alu_email AS Email, '' AS RFC 
FROM alumnos
UNION 
SELECT mtro_nombre AS Nombre, mtro_fnac AS FNac, mtro_nemp AS Num, mtro_email AS Email, mtro_rfc AS RFC
FROM maestros 
UNION 
SELECT adm_nombre AS Nombre, adm_fnac AS FNac, adm_nemp AS Num, adm_email AS Email, adm_rfc AS RFC
FROM administrativos;


USE master;

DROP DATABASE Escuela_v2;