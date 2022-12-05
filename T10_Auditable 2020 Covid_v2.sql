/*************************************

                UNIDAD 5
             SQL PROCEDURAL

**************************************/

DECLARE @variable INT 
SET @variable = 2
DECLARE @variable2 INT 
SET @variable2 = 3
DECLARE @suma INT 
SET @suma = @variable + @variable2 
SELECT @suma AS 'Suma'
PRINT @suma


DECLARE @variable INT 
SET @variable = 2
DECLARE @variable2 INT 
SET @variable2 = 3
DECLARE @suma INT 
SET @suma = @variable + @variable2 
SELECT @suma AS 'Suma'
PRINT 'Suma'
PRINT @suma


DECLARE @id INT; 
DECLARE @login VARCHAR(32); 
SELECT @id = usr_id, @login = usr_login
FROM usuarios 
WHERE (usr_login = 'admin');

SELECT ses_id, ses_token, ses_ip, ses_os, ses_inicio, ses_fin, ses_ultima_accion, usr_id, @login AS 'usr_login'
FROM sesiones 
WHERE (usr_id = @id);


DECLARE @id INT; 
SET @id = (SELECT usr_id 
           FROM usuarios 
           WHERE (usr_login = 'admin'));

SELECT *
FROM sesiones 
WHERE (usr_id = @id);

/********************
CREATE PROCEDURE [<nombre esquema>,]<nombre procedimiento>
[@param1 <tipo de dato> [OUTPUT | READONLY][, ...]]
AS
BEGIN 
    <cuerpo>
END
**********************/
ALTER 
CREATE PROCEDURE procedimiento1 @login VARCHAR(32)
AS 
BEGIN 
    DECLARE @id INT;
    DECLARE @login VARCHAR(32);
    SELECT @id = usr_id, @login = usr_login 
    FROM usuarios 
    WHERE (usr_login = @login);

    SELECT ses_id, ses_token, ses_ip, ses_os, ses_inicio, ses_fin, ses_ultima_accion, usr_id, @login AS 'usr_login'
    FROM sesiones 
    WHERE (usr_id = @id);

END;

EXEC procedimiento1 'admin';



CREATE PROCEDURE procedimiento2 @resultado INT OUTPUT, @multiplicador INT 
AS 
BEGIN 
    SET @resultado = @resultado * @multiplicador 
END 

DECLARE @var INT;
SET @var = 30;
EXEC procedimiento @var OUTPUT, 2;
SELECT @var AS resultado;

/*************************************
UDF
Funciones Definidas por el Usuario
(USER DEFINED FUNCTIONS)

Procedimientos  PROCEDURE  FUNCTION  VOID
Funciones       FUNCTION   FUNCTION  RETURN

CREATE FUNCTION [<nombre función>,]<nombre funcion>(@param <tipo de dato>[, ...])
RETURNS <tipo de dato>
AS
BEGIN
    <cuerpo>
    RETURN <expresion escalar>
END
*************************************/

CREATE FUNCTION suma(@a INT, @b INT)
RETURNS INT 
AS 
BEGIN 
    DECLARE @c INT;
    SET @c = @a + @b;
    RETURN @c; 
END;

SELECT dbo.suma(2, 3);

SELECT 5;


DECLARE @valor INT 
SET @valor = dbo.suma(2, 17);

SELECT @valor

--Poner en uso la base de datos master
USE master;

--Eliminar la base de datos auditable2020covid
DROP DATABASE auditable2020covid;

