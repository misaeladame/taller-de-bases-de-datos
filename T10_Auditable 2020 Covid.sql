/*
Script para crear la base de datos auditable2020covid
Materia: Taller de Base de Datos 
Fecha de creacion: 09/07/20
Autor: José Misael Adame Sandoval 18131209
Fecha de ultima actualizacion 09/07/20
Lugar: Torreon, Coahuila 
*/

--Crear la base de datos
CREATE DATABASE auditable2020covid;

--Poner en uso la base de datos
USE auditable2020covid;

--Crear la tabla sesiones
CREATE TABLE sesiones 
(
    ses_id BIGINT IDENTITY NOT NULL,
    ses_token CHAR(32) NOT NULL,
    ses_ip CHAR(8) NOT NULL,
    ses_os VARCHAR(64) NULL,
    ses_inicio DATETIME NOT NULL,
    ses_fin DATETIME NULL,
    ses_ultima_accion DATETIME NOT NULL,
    usr_id INT NOT NULL, 
    PRIMARY KEY (ses_id),
    UNIQUE (ses_token)
);

--Crear la tabla usuarios
CREATE TABLE usuarios 
(
    usr_id INT IDENTITY NOT NULL,
    usr_login VARCHAR(32) NOT NULL,
    usr_pwd CHAR(32) NOT NULL,
    usr_fcreacion DATETIME NULL,
    ses_id BIGINT NOT NULL,
    PRIMARY KEY (usr_id), 
    UNIQUE (usr_login)
);

--Crear la tabla roles
CREATE TABLE roles 
(
    rol_id INT IDENTITY NOT NULL,
    rol_nombre VARCHAR(255) NOT NULL,
    rol_fcreacion DATETIME NULL,
    ses_id BIGINT NOT NULL,
    PRIMARY KEY (rol_id),
    UNIQUE (rol_nombre)
);

--Crear la tabla usuarios_roles
CREATE TABLE usuarios_roles
(
    usr_id INT NOT NULL,
    rol_id INT NOT NULL,
    ur_fasignacion DATETIME NULL,
    ses_id BIGINT NOT NULL
);

--Crear la tabla permisos
CREATE TABLE permisos 
(
    perm_id INT IDENTITY NOT NULL,
    perm_permisos CHAR(32) NOT NULL,
    perm_fecha DATETIME NOT NULL,
    ses_id BIGINT NOT NULL,
    rol_id INT NOT NULL,
    PRIMARY KEY (perm_id),
    UNIQUE (perm_permisos)
);

--Crear la tabla ventas
CREATE TABLE ventas
(
    vta_id INT IDENTITY NOT NULL,
    vta_fventa DATETIME NULL,
    ses_id BIGINT NOT NULL,
    PRIMARY KEY (vta_id)
);

--Crear la tabla articulos
CREATE TABLE articulos
(
    art_id INT IDENTITY NOT NULL, 
    art_fcreacion DATETIME NULL,
    ses_id BIGINT NOT NULL,
    vta_id INT NOT NULL, 
    PRIMARY KEY (vta_id)
);

--Crear constraint para referenciar el usr_id de la tabla usuarios en la tabla sesiones
--El usuario inicia sesión
ALTER TABLE sesiones
ADD CONSTRAINT UsuarioIniciaSesion
FOREIGN KEY (usr_id)
REFERENCES usuarios (usr_id);

--Crear constraint para referenciar el ses_id de la tabla sesiones en la tabla usuarios
--En la sesión se crea a un usuario nuevo
ALTER TABLE usuarios
ADD CONSTRAINT SesionCreaUsuario
FOREIGN KEY (ses_id)
REFERENCES sesiones (ses_id);

--Crear constraint para referenciar el ses_id de la tabla sesiones en la tabla ventas
ALTER TABLE ventas
ADD CONSTRAINT sesfk_id_vta
FOREIGN KEY (ses_id)
REFERENCES sesiones (ses_id);

--Crear constraint para referenciar el ses_id de la tabla sesiones en la tabla articulos
ALTER TABLE articulos 
ADD CONSTRAINT sesfk_id_art
FOREIGN KEY (ses_id)
REFERENCES sesiones (ses_id);

--Crear constraint para referenciar el vta_id de la tabla ventas en la tabla articulos
ALTER TABLE articulos 
ADD CONSTRAINT vtafk_id_art
FOREIGN KEY (vta_id)
REFERENCES ventas (vta_id);

--Crear constraint para referenciar el usr_id de la tabla usuarios en la tabla usuarios_roles
ALTER TABLE usuarios_roles 
ADD CONSTRAINT usrfk_id_ur
FOREIGN KEY (usr_id)
REFERENCES usuarios (usr_id);

--Crear constraint para referenciar el rol_id de la tabla roles en la tabla usuarios_roles
ALTER TABLE usuarios_roles 
ADD CONSTRAINT rolfk_id_ur
FOREIGN KEY (rol_id)
REFERENCES roles (rol_id);

--Crear constraint para referenciar el ses_id de la tabla sesiones en la tabla usuarios_roles
ALTER TABLE usuarios_roles 
ADD CONSTRAINT sesfk_id_ur
FOREIGN KEY (ses_id)
REFERENCES sesiones (ses_id);

--Crear constraint para referenciar el ses_id de la tabla sesiones en la tabla roles
ALTER TABLE roles 
ADD CONSTRAINT sesfk_id_rol
FOREIGN KEY (ses_id)
REFERENCES sesiones (ses_id);

--Crear constraint para referenciar el ses_id de la tabla sesiones en la tabla permisos
ALTER TABLE permisos
ADD CONSTRAINT sesfk_id_perm
FOREIGN KEY (ses_id)
REFERENCES sesiones (ses_id);

--Crear constraint para referenciar el rol_id de la tabla roles en la tabla permisos
ALTER TABLE permisos
ADD CONSTRAINT rolfk_id_perm
FOREIGN KEY (rol_id)
REFERENCES roles (rol_id);

--Obtener los usuarios creados por un usuario dado, y los permisos que tenía al momento de crear cada uno de los usuarios
SELECT creador.usr_login AS Creador, creados.usr_login AS 'Usuario Creado', rol.rol_nombre AS Rol,
        perm.perm_permisos AS permisos
FROM usuarios AS creador 
INNER JOIN sesiones AS ses ON (creador.usr_id = ses.usr_id)
INNER JOIN usuarios AS creados ON (ses.ses_id = creados.ses_id)
INNER JOIN usuarios_roles AS ur ON (creador.usr_id = ur.usr_id)
INNER JOIN roles AS rol ON (ur.rol_id = rol.rol_id)
INNER JOIN permisos AS perm ON (rol.rol_id = perm.rol_id)
WHERE (creador.usr_login = 'usuarioC')
AND (ur.ur_fasignacion IN (SELECT MAX(ur_fasignacion)
                           FROM usuarios_roles
                           WHERE (ur_fasignacion < creados.usr_fcreacion)))
AND (perm.perm_fecha IN (SELECT MAX(perm_fecha)
                         FROM permisos 
                         WHERE (perm_fecha < creados.usr_fcreacion)));


--Obtener el último rol asignado a un usuario dado
SELECT rol_nombre
FROM usuarios AS usr 
INNER JOIN usuarios_roles AS ur ON (usr.usr_id = ur.usr_id)
INNER JOIN roles AS rol ON (ur.rol_id = rol.rol_id)
WHERE (usr_login = 'usuarioD')
AND (ur_fasignacion IN (SELECT MAX(ur_fasignacion)
                        FROM usuarios_roles
                        WHERE (usr_id = usr.usr_id)));

--Agregar un usuario con todos los permisos, y otro sin el primer permiso
ALTER TABLE usuarios
DROP CONSTRAINT SesionCreaUsuario 
GO
ALTER TABLE sesiones 
DROP CONSTRAINT FKSesiones519836 
GO 

/*
SET IDENTITY_INSERT usuarios ON
GO
SET IDENTITY_INSERT sesiones ON
*/

INSERT INTO usuarios 
(usr_id, usr_login, usr_pwd, usr_fcreacion, ses_id)
VALUES (1, 'admin', 'password', GETDATE(), 1);

INSERT INTO sesiones 
(ses_id, ses_token, ses_ip, ses_inicio, ses_ultima_accion, usr_id)
VALUES (1, 'ljkldksljklgklds', '0F000001', GETDATE(), GETDATE(), 1);

INSERT INTO roles 
(rol_nombre, rol_fcreacion, ses_id)
VALUES ('Super Administradores', GETDATE(), 1);

INSERT INTO permisos 
(perm_permisos, perm_fecha, ses_id, rol_id)
--32 F's
VALUES ('FFFFFFFFFFFFFFFFFFFFFFFFF', GETDATE(), 1, 2);

INSERT INTO usuarios_roles 
(usr_id, rol_id, ur_fasignacion, ses_id)
VALUES (1, 2, GETDATE(), 1);

UPDATE sesiones 
SET ses_ultima_accion = GETDATE(), ses_fin = GETDATE()
WHERE (ses_id = 1);

SELECT * 
FROM usuarios;

SELECT * 
FROM sesiones;

SELECT * 
FROM roles;

SELECT * 
FROM permisos;

INSERT INTO sesiones 
(ses_inicio, ses_ip, ses_token, ses_ultima_accion, usr_id)
VALUES (GETDATE(), '0F000001', 'jfkdshfkjdshjds', GETDATE(), 1)

INSERT INTO roles 
(rol_nombre, rol_fcreacion, ses_id)
VALUES ('Administradores', GETDATE(), 2);

INSERT INTO permisos 
(perm_permisos, perm_fecha, rol_id, ses_id)
-- 31 F's
VALUES ('FFFFFFFFFFFFFFFFFFFFFFFFFFFF', GETDATE(), 3, 2);

INSERT INTO usuarios 
(usr_login, usr_pwd, usr_fcracion, ses_id)
VALUES ('manolito', 'strongPassword', GETDATE(), 2);

INSERT INTO usuarios_roles 
(usr_id, rol_id, ur_fasignacion, ses_id)
VALUES (2, 3, GETDATE(), 2);

SELECT * 
FROM usuarios AS usr 
INNER JOIN usuarios_roles AS ur ON (usr.usr_id = ur.usr_id)
INNER JOIN roles AS rol ON (ur.rol_id = rol.rol_id)
INNER JOIN permisos AS perm ON (rol.rol_id = perm.rol_id);

SELECT usr.usr_login, rol_nombre, perm_permisos, creador.usr_login
FROM usuarios AS usr 
INNER JOIN usuarios_roles AS ur ON (usr.usr_id = ur.usr_id)
INNER JOIN roles AS rol ON (ur.rol_id = rol.rol_id)
INNER JOIN permisos AS perm ON (rol.rol_id = perm.rol_id)
INNER JOIN sesiones AS ses ON (usr.ses_id = ses.ses_id)
INNER JOIN usuarios AS creador ON (ses.usr_id = usr.usr_id);

--Transacciones de ejemplo
SELECT *
FROM usuarios 
BEGIN TRANSACTION 
INSERT INTO usuarios 
(usr_login, usr_pwd, usr_fcreacion, ses_id)
VALUES ('nuevo', '123456', GETDATE(), 2)
SELECT * 
FROM usuarios
BEGIN TRANSACTION
ROLLBACK TRANSACTION
SELECT *
FROM usuarios 


BEGIN TRANSACTION 


SELECT *
FROM usuarios 
BEGIN TRANSACTION 
INSERT INTO usuarios 
(usr_login, usr_pwd, usr_fcreacion, ses_id)
VALUES ('nuevo', '123456', GETDATE(), 2)
SELECT * 
FROM usuarios
BEGIN TRANSACTION
COMMIT TRANSACTION
SELECT *
FROM usuarios 
BEGIN TRANSACTION 

/*
Transacciones automáticas
*/
SELECT *
FROM usuarios;
BEGIN TRY 
    BEGIN TRANSACTION;
    INSERT INTO usuarios 
    (usr_login, usr_pwd, ses_id, usr_fcreacion)
    VALUES ('otro usuario', 'iibwdsafdsg', 2, GETDATE());
    SELECT * 
    FROM usuarios;
    INSERT INTO usuarios 
    (usr_login, usr_pwd, ses_id, usr_fcreacion)
                                            --2
    VALUES ('otro nuevo usuario', 'dfhdsogd', 3, GETDATE());
    SELECT * 
    FROM usuarios;
    COMMIT TRANSACTION; 
END TRY 
BEGIN CATCH
    ROLLBACK TRANSACTION;
    RAISERROR('Ocurrió un error', 16, 1);
END CATCH
SELECT *
FROM usuarios;

-- Practica de ejemplo
SELECT *
FROM usuarios;
BEGIN TRY 
    BEGIN TRANSACTION;
    INSERT INTO sesiones 
    (ses_inicio, ses_ip, ses_token, ses_ultima_accion, usr_id)
    VALUES (GETDATE(), '0F000001', 'htjidshgjkhdsj', GETDATE(), 3);
    SELECT * 
    FROM sesiones;
    INSERT INTO usuarios 
    (usr_login, usr_pwd, ses_id, usr_fcreacion)                       --2
    VALUES ('otro lindo usuario', 'dfhdsogd', 3, GETDATE());
    SELECT * 
    FROM usuarios;
    INSERT INTO usuarios_roles 
    (usr_id, rol_id, ur_fasignacion, ses_id )
    VALUES (2, 3, 'Fecha no disponible', 4);
    SELECT *
    FROM usuarios_roles; 
    COMMIT TRANSACTION; 
END TRY 
BEGIN CATCH
    ROLLBACK TRANSACTION;
    RAISERROR('Ocurrió un error', 16, 1);
END CATCH
SELECT *
FROM sesiones;
SELECT *
FROM usuarios;
SELECT *
FROM usuarios_roles;

/*
Transacciones anidadas
*/
PRINT @@TRANCOUNT -- 0
BEGIN TRANSACTION
PRINT @@TRANCOUNT -- 1
BEGIN TRANSACTION
PRINT @@TRANCOUNT -- 2
BEGIN TRANSACTION
PRINT @@TRANCOUNT -- 3
COMMIT TRANSACTION
PRINT @@TRANCOUNT -- 2
BEGIN TRANSACTION
PRINT @@TRANCOUNT -- 3
COMMIT TRANSACTION
PRINT @@TRANCOUNT -- 2
ROLLBACK TRANSACTION
PRINT @@TRANCOUNT -- 0 
COMMIT TRANSACTION -- Marca ERROR
PRINT @@TRANCOUNT -- 0

/*
Transacciones almacenadas
*/
BEGIN TRANSACTION
BEGIN TRY 
-- 
--
-- 
-- 
SAVE TRANSACTION punto1
BEGIN TRY 
-- 
-- 
-- 
-- 
PRINT 'No hay instrucciones'
END TRY 
BEGIN CATCH 
    ROLLBACK TRANSACTION punto1
END CATCH
-- 
-- 
-- 
-- 
--
COMMIT TRANSACTION 
END TRY 
BEGIN CATCH 
    ROLLBACK TRANSACTION 
    RAISERROR('Ocurió un Error', 16, 1)
END CATCH


--Ejemplo del Diagrama 
BEGIN TRANSACTION
BEGIN TRY 
    -- 
    SAVE TRANSACTION punto1
    BEGIN TRY 
        -- 
        -- 
        -- 
        SAVE TRANSACTION punto2 
        BEGIN TRY 
            -- 
            -- 
            -- 
            -- 
        END TRY
        BEGIN CATCH 
            ROLLBACK TRANSACTION punto2
        END CATCH  
        -- 
    END TRY 
    BEGIN CATCH 
        ROLLBACK TRANSACTION punto1 
    END CATCH 
    -- 
    -- 
    SAVE TRANSACTION punto3 
    BEGIN TRY 
        -- 
        -- 
        SAVE TRANSACTION d 
        BEGIN TRY 
            -- 
            -- 
            -- 
        END TRY 
        BEGIN CATCH 
            ROLLBACK TRANSASCTION d 
        END CATCH 
        -- 
    END TRY 
    BEGIN CATCH 
        ROLLBACK TRANSACTION punto3 
    END CATCH 
    -- 
    --
    SAVE TRANSACTION e 
    BEGIN TRY 
        -- 
        -- 
    END TRY 
    BEGIN CATCH 
        ROLLBACK TRANSACTION e 
    END CATCH 
    -- 
    COMMIT TRANSACTION
END TRY 
BEGIN CATCH 
    ROLLBACK TRANSACTION 
END CATCH 

/*
Transacciones distribuidas
*/
BEGIN TRY
    BEGIN DISTRIBUTED TRANSACTION 
    -- 
    -- 
    -- 
    -- 
    -- 
    -- 
    -- 
    -- 
    COMMIT TRANSACTION
END TRY 
BEGIN CATCH 
    ROLLBACK TRANSACTION 
END CATCH 

--Poner en uso la base de datos master
USE master;

--Eliminar la base de datos auditable2020covid
DROP DATABASE auditable2020covid;

