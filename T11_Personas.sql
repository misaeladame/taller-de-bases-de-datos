--C 
CREATE DATABASE personas;

--DATA
CREATE TABLE personas 
(
    pers_id INT IDENTITY NOT NULL, 
    pers_nombre VARCHAR(255) NOT NULL, 
    pers_sexo BIT NOT NULL, 
    pers_fnac DATETIME NULL,
    pers_padre INT NULL, 
    pers_madre INT NULL, 
    PRIMARY KEY (pers_id) 
);

-- 
ALTER TABLE personas 
ADD CONSTRAINT persfk_id_pers_padre
FOREIGN KEY (pers_padre)
REFERENCES personas (pers_id)

--
ALTER TABLE personas 
ADD CONSTRAINT persfk_id_pers_madre
FOREIGN KEY (pers_madre)
REFERENCES personas (pers_id)

-- 
INSERT INTO personas 
(pers_nombre, pers_sexo, pers_fnac, pers_padre, pers_madre)
VALUES ('Adán', 1, '1900-01-01', NULL, NULL),
('Eva', 0, '1900-01-08', NULL, NULL);

SELECT * 
FROM personas;

INSERT INTO personas 
(pers_nombre, pers_sexo, pers_fnac, pers_padre, pers_madre)
VALUES ('Cain', 1, '1950-01-01', 1, 2),
('Abel', 0, '1900-01-08', 1, 2);



CREATE FUNCTION idDesdeNombre(@nombre VARCHAR(255))
RETURNS INT 
AS 
BEGIN
    DECLARE @id INT; 
    SELECT @id = pers_id 
    FROM personas
    WHERE (pers_nombre = @nombre); 
    IF @id IS NULL 
        INSERT INTO personas 
        (pers_nombre, pers_sexo, pers_fnac, pers_padre, pers_madre)
        VALUES (@nombre, 1, GETDATE(), NULL, NULL);
        SELECT @id = pers_id 
        FROM personas 
        WHERE (pers_nombre = @nombre)
    END IF
    RETURN @id;
END


INSERT INTO personas 
(pers_nombre, pers_sexo, pers_fnac, pers_padre, pers_madre)
VALUES ('Set', 1, '1960-01-01', dbo.idDesdeNombre('Adan'), dbo.idDesdeNombre('Eva'))


DROP FUNCTION idDesdeNombre 


/*****************************************

Funciones Definidas por el Usuario que retornan tablas


CREATE FUNCTION [<esquema>,]<nombre function>(@param <tipo dato> [, ...])
RETURNS TABLE
AS 
    RETURN SELECT *
           FROM <table>
           <WHERE>

*****************************************/

CREATE FUNCTION registroPersonal(@id INT)
RETURNS TABLE 
AS
    RETURN SELECT *
        FROM personas 
        WHERE (pers_id = @id)


/*mi consulta
CREATE FUNCTION hijosDe(@nombre VARCHAR(255))
RETURNS TABLE 
AS
RETURN SELECT pers_nombre AS Hijos 
       FROM personas 
       WHERE (SELECT pers_id
              FROM personas
              WHERE(pers_padre = SELECT pers_id
                                 FROM personas 
                                 WHERE(pers_nombre = @nombre)));
*/

--Inge Ulloa
CREATE FUNCTION hijosDe(@nombre VARCHAR(255))
RETURNS TABLE 
AS
RETURN SELECT hijos.pers_nombre 
       FROM personas AS pers 
       INNER JOIN personas AS hijos ON (per.pers_id IN (hijos.pers_padre, hijos.pers_madre))
       WHERE (pers.pers_nombre = @nombre)


/*****************************************************
                        TRIGGERS


        DDL                             DML

CREATE ALTER DROP               INSERT UPDATE DELETE


CREATE TRIGGER <nombre trigger>
ON {<nombre tabla> | <nombre vista>}
{FOR | AFTER | INSTEAD OF}
{[INSERT] [,] [UPDATE] [,] [DELETE]}
AS
BEGIN
    <cuerpo trigger>
END

***************************************************/

CREATE TRIGGER impedirHuerfanos
ON personas 
INSTEAD OF INSERT 
AS 
BEGIN 
    PRINT 'Se ejecutó un insert'
END


INSERT INTO personas 
(pers_nombre, pers_sexo)
VALUES ('Fulanito', 1);

SELECT * 
FROM personas;
GO 

CREATE TRIGGER Trigger2 
ON personas 
INSTEAD OF UPDATE 
AS 
BEGIN 
    PRINT 'No se hizo el update'
END 


UPDATE personas 
SET pers_nombre = 'Abel (x)'
WHERE (pers_nombre = 'Abel')

DROP TRIGGER Trigger2

/****************************************

                MAGIC TABLES
               TABLAS MAGICAS

                INSERT            UPDATE         DELETE     MySQL
INSERTED          X                 X                       NEW
DELETED                             X               X       OLD

*****************************************/
GO
CREATE OR ALTER TRIGGER identificarEvento
ON personas 
INSTEAD OF INSERT, UPDATE, DELETE 
AS 
BEGIN 
    DECLARE @nombre VARCHAR(255);
    DECLARE @sexo BIT; 
    DECLARE @fnac DATETIME; 
    DECLARE @idp INT; 
    DECLARE @idm INT; 
    DECLARE @id INT;
    IF EXISTS(SELECT *
              FROM INSERTED) AND EXISTS(SELECT *
                                        FROM DELETED)  
    BEGIN
        PRINT 'No se realizó el update';
        
        SELECT @nombre = pers_nombre, @sexo = pers_sexo, @fnac = pers_fnac,
               @idp = pers_padre, @idm = pers_madre
        FROM INSERTED;
        SELECT @id = pers_id 
        FROM DELETED
        UPDATE personas
        SET pers_nombre = @nombre, pers_sexo = @sexo, pers_fnac = @fnac, pers_padre = @idp,
            pers_madre = @idm
        WHERE (pers_id = (SELECT TOP 1 pers_id
                          FROM DELETED)) 
        PRINT 'Ahora si';
    END
    ELSE IF EXISTS(SELECT *
                   FROM INSERTED)
        PRINT 'No se realizó el insert';
        SELECT @nombre = pers_nombre, @sexo = pers_sexo, @fnac = pers_fnac,
               @idp = pers_padre, @idm = pers_madre 
        FROM INSERTED;
        INSERT INTO personas 
        (pers_nombre, pers_sexo, pers_fnac, pers_padre, pers_madre)
        VALUES(@nombre, @sexo, @fnac, @idp, @idm);
        PRINT 'Ahora si'
    ELSE 
    BEGIN
        PRINT 'No se realizó el delete';
        SELECT @id = pers_id,
        FROM DELETED;
        DELETE 
        FROM personas
        WHERE (pers_id = @id)
        PRINT 'Ahora si';
    END;
END;

DELETE 
FROM personas 
WHERE (pers_nombre = 'Abel')

DELETE 
FROM personas 
WHERE (pers_nombre LIKE = 'Abel%')

/***********************************************

Crear un trigger para evitar que una persona 
de sexo masculino sea madre de otra, al igual 
que una de sexo femenino sea padre de otra, este 
sea hará al nacer o adoptar un hijo.

*************************************************/
GO
CREATE FUNCTION obtenerSexo(@id INT)
RETURNS BIT 
AS 
BEGIN 
    DECLARE @sexo BIT 
    SET @sexo = (SELECT pers_sexo
                 FROM personas
                 WHERE (pers_id = @id));
    RETURN @sexo;
END;
GO
CREATE OR ALTER TRIGGER padresCorrectos 
ON personas 
AFTER INSERT 
AS 
BEGIN
    DECLARE @id INT; 
    DECLARE @sp BIT;
    DECLARE @sm BIT;
    DECLARE @idp INT; 
    DECLARE @idm INT;
    SELECT @id = pers_id, @idp = pers_padre, @idm = pers_madre 
    FROM INSERTED;
    SET @sp = dbo.obtenerSexo(@idp);
    SET @sm = dbo.obtenerSExo(@idm);
    IF @sp != 1 OR @sm != 0
    BEGIN 
        DELETE 
        FROM personas 
        WHERE (pers_id = @id);
        RAISERROR('Error con el sexo de los padres', 16, 1)
    END;
END;

INSERT INTO personas 
(pers_nombre, pers_sexo, pers_fnac, pers_padre, pers_madre)
VALUES ('Abel', 1, GETDATE(), 3, 2)

SELECT * 
FROM personas;
GO
CREATE TRIGGER adopcionesCorrectas
ON personas 
AFTER UPDATE  
AS 
BEGIN 
    DECLARE @id INT; 
    DECLARE @sp BIT;
    DECLARE @sm BIT;
    DECLARE @idp INT; 
    DECLARE @idm INT;
    DECLARE @idpa INT; 
    DECLARE @idma INT; 
    DECLARE @nombre VARCHAR(255);
    DECLARE @sexo BIT; 
    DECLARE @fnac DATE; 
    SELECT @idp = pers_padre, @idm = pers_madre 
    FROM INSERTED;
    SELECT @id = pers_id, @idpa = pers_padre, @idma = pers_madre, @nombre = pers_nombre,
                 @sexo = pers_sexo  
    FROM DELETED;
    SET @sp = dbo.obtenerSexo(@idp);
    SET @sm = dbo.obtenerSexo(@idm);
    IF @sp != 1 OR @sm != 0
    BEGIN 
        UPDATE personas 
        SET pers_nombre = @nombre, pers_sexo = @sexo, pers_fnac = @fnac, pers_padre = @idpa,
            pers_madre = @idma 
        WHERE (pers_id = @id);
        RAISERROR('Error con el sexo de los nuevos padres, se anula adopción y se restauran valores ', 16, 1);
    END; 
END;
   
UPDATE personas 
SET pers_nombre = pers_nombre + ' De Tal', pers_padre = 2, pers_madre
WHERE (pers_id = dbo.idDesdeNombre('Fulanito')); --ERROR

UPDATE personas 
SET pers_nombre = pers_nombre + ' De Tal', pers_padre = dbo.idDesdeNombre('Adan'),
    pers_madre = dbo.idDesdeNombre('Eva')
WHERE (pers_id = dbo.idDesdeNombre('Fulanito'));
    

--Poner en uso la base de datos master
USE master;

--Eliminar la base de datos peronas
DROP DATABASE personas;