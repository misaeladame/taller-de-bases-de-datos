/*
PROYECTO FINAL
Script para crear la base de datos inventarios
Materia: Taller de Base de Datos 
Fecha de creacion: 18/07/20
Equipo: F
Autores: 18131209 José Misael Adame Sandoval 
         18131227 Ricardo Raúl Castro Luna
         18131284 Daniel Sotomayor Saldivar 
Fecha de ultima actualizacion 22/07/20
Lugar: Torreon, Coahuila 
*/

--Crear la base de datos inventarios, se crea en caso de que no exista en el sistema alguna con ese nombre
IF NOT EXISTS (SELECT * 
               FROM sys.databases 
               WHERE name = 'inventarios')
BEGIN
    CREATE DATABASE inventarios;
    PRINT 'La base de datos inventarios ha sido creada'
END
ELSE
BEGIN
    PRINT 'Ya existe la base de datos inventarios'
END
    
--Poner en uso la base de datos inventarios
USE [inventarios];
GO

--Crear la tabla productos
IF EXISTS (SELECT * 
           FROM INFORMATION_SCHEMA.TABLES
           WHERE TABLE_NAME = N'productos')
BEGIN
    PRINT 'Ya existe la tabla productos'
END
ELSE
BEGIN 
    CREATE TABLE productos (
        pro_id          INT IDENTITY NOT NULL,
        pro_codigo      CHAR(8) NOT NULL,
        pro_nombre      VARCHAR(255) NOT NULL,
        pro_tipo        VARCHAR(255) NOT NULL,
        pro_cantidad    INT NOT NULL,
        pro_precio      MONEY NOT NULL, 
        PRIMARY KEY (pro_id),
        UNIQUE (pro_codigo)
    );
    PRINT 'Tabla productos creada exitosamente'
END

--Crear la tabla distribuidores
IF EXISTS (SELECT * 
           FROM INFORMATION_SCHEMA.TABLES
           WHERE TABLE_NAME = N'distribuidores')
BEGIN
    PRINT 'Ya existe la tabla distribuidores'
END
ELSE
BEGIN 
    CREATE TABLE distribuidores (
        dis_id          INT IDENTITY NOT NULL,
        dis_nombre      VARCHAR(255) NOT NULL,
        dis_direccion   VARCHAR(255) NOT NULL,
        PRIMARY KEY (dis_id),
        UNIQUE (dis_nombre)
    );
    PRINT 'Tabla distribuidores creada exitosamente'
END

--Crear la tabla vendedores
IF EXISTS (SELECT * 
           FROM INFORMATION_SCHEMA.TABLES
           WHERE TABLE_NAME = N'vendedores')
BEGIN
    PRINT 'Ya existe la tabla vendedores'
END
ELSE
BEGIN 
    CREATE TABLE vendedores (
        ven_id          INT IDENTITY NOT NULL,
        ven_ncontrol    CHAR(8) NOT NULL,
        ven_nombre      VARCHAR(255) NOT NULL,
        ven_direccion   VARCHAR(255) NOT NULL,
        ven_rfc         CHAR(13) NOT NULL,
        ven_curp        CHAR(18) NOT NULL,
        ven_supervisor  INT NOT NULL,
        PRIMARY KEY (ven_id),
        UNIQUE (ven_ncontrol, ven_rfc, ven_curp)
    );
    PRINT 'Tabla vendedores creada exitosamente'
END

--Crear la tabla clientes 
IF EXISTS (SELECT * 
           FROM INFORMATION_SCHEMA.TABLES
           WHERE TABLE_NAME = N'clientes')
BEGIN
    PRINT 'Ya existe la tabla clientes'
END
ELSE
BEGIN 
    CREATE TABLE clientes (
        cli_id          INT IDENTITY NOT NULL,
        cli_nombre      VARCHAR(255) NOT NULL,
        cli_direccion   VARCHAR(255) NOT NULL,
        ven_id          INT NOT NULL,
        PRIMARY KEY (cli_id)
    );
    PRINT 'Tabla clientes creada exitosamente'
END

--Crear la tabla ordenes
IF EXISTS (SELECT * 
           FROM INFORMATION_SCHEMA.TABLES
           WHERE TABLE_NAME = N'ordenes')
BEGIN
    PRINT 'Ya existe la tabla ordenes'
END
ELSE
BEGIN 
    CREATE TABLE ordenes (
        ord_id   INT IDENTITY NOT NULL,
        cli_id   INT NOT NULL,
        PRIMARY KEY (ord_id)
    );
    PRINT 'Tabla ordenes creada exitosamente'
END

--Crear la tabla ordenes_productos
IF EXISTS (SELECT * 
           FROM INFORMATION_SCHEMA.TABLES
           WHERE TABLE_NAME = N'ordenes_productos')
BEGIN
    PRINT 'Ya existe la tabla ordenes_productos'
END
ELSE
BEGIN 
    CREATE TABLE ordenes_productos (
        ord_id               INT NOT NULL,
        pro_id               INT NOT NULL,
        ord_pro_cantidad     INT NOT NULL,
        ord_pro_precio_total MONEY NULL,
        ord_pro_forden       DATETIME NOT NULL
    );
    PRINT 'Tabla ordenes_productos creada exitosamente'
END

--Crear la tabla productos_vendedores 
IF EXISTS (SELECT * 
           FROM INFORMATION_SCHEMA.TABLES
           WHERE TABLE_NAME = N'productos_vendedores')
BEGIN
    PRINT 'Ya existe la tabla productos_vendedores'
END
ELSE
BEGIN 
    CREATE TABLE productos_vendedores (
        pro_id INT NOT NULL, 
        ven_id INT NOT NULL
    );
    PRINT 'Tabla productos_vendedores creada exitosamente'
END

--Crear la tabla productos_distribuidores
IF EXISTS (SELECT * 
           FROM INFORMATION_SCHEMA.TABLES
           WHERE TABLE_NAME = N'productos_distribuidores')
BEGIN
    PRINT 'Ya existe la tabla productos_distribuidores'
END
ELSE
BEGIN 
    CREATE TABLE productos_distribuidores (
        pro_id INT NOT NULL, 
        dis_id INT NOT NULL 
    );
    PRINT 'Tabla productos_distribuidores creada exitosamente'
END
GO

--Crear un trigger para validar pro_cantidad de la tabla producto
CREATE TRIGGER validarCantidadProductos
ON productos 
AFTER INSERT 
AS 
    IF (SELECT pro_cantidad
        FROM inserted) <= 0
    BEGIN 
        ROLLBACK TRANSACTION
        PRINT 'No puedes registrar un producto con cero o menor cantidades'
    END 
    ELSE 
    BEGIN
        PRINT 'Cantidad registrada correctamente'
    END
GO

--Crear un trigger para validar pro_precio de la tabla producto
CREATE TRIGGER validarPrecioProductos
ON productos 
AFTER INSERT 
AS 
    IF (SELECT pro_precio 
        FROM inserted) <= 0
    BEGIN 
        ROLLBACK TRANSACTION
        PRINT 'No puedes registrar un precio con monto Cero o menor'
    END 
    ELSE 
    BEGIN
        PRINT 'Precio registrado correctamente'
    END
GO

--Crear constraint para referenciar el ord_id de la tabla ordenes en la tabla ordenes_productos 
ALTER TABLE ordenes_productos 
ADD CONSTRAINT ordfk_id_ord_pro
FOREIGN KEY (ord_id) 
REFERENCES ordenes(ord_id);

--Crear constraint para referenciar el ord_id de la tabla productos en la tabla ordenes_productos 
ALTER TABLE ordenes_productos 
ADD CONSTRAINT profk_id_ord_pro 
FOREIGN KEY (pro_id) 
REFERENCES productos(pro_id);

--Crear constraint para referenciar el cli_id de la tabla clientes en la tabla ordenes 
ALTER TABLE ordenes 
ADD CONSTRAINT clifk_id_ord 
FOREIGN KEY (cli_id) 
REFERENCES clientes(cli_id);

--Crear constraint para referenciar el ven_id de la tabla vendedores en la tabla clientes
ALTER TABLE clientes 
ADD CONSTRAINT venfk_id_cli 
FOREIGN KEY (ven_id) 
REFERENCES vendedores(ven_id);

/*
Crear constraint para referenciar el ven_id de la tabla vendedores en la misma tabla porque eso indica 
que es el supervisor
*/
ALTER TABLE vendedores 
ADD CONSTRAINT venfk_id_supervisor 
FOREIGN KEY (ven_supervisor) 
REFERENCES vendedores(ven_id);

--Craer constraint para referenciar el ven_id de la tabla vendedores en la tabla productos_vendedores
ALTER TABLE productos_vendedores
ADD CONSTRAINT venfk_id_pro_ven
FOREIGN KEY (ven_id)
REFERENCES vendedores(ven_id);

--Crear constraint para referenciar el pro_id de la tabla productos en la tabla productos_vendedores
ALTER TABLE productos_vendedores 
ADD CONSTRAINT profk_id_pro_ven
FOREIGN KEY (pro_id)
REFERENCES productos(pro_id);

--Crear constraint para referenciar el pro_id de la tabla productos en la tabla productos_distribuidores
ALTER TABLE productos_distribuidores
ADD CONSTRAINT profk_id_pro_dis 
FOREIGN KEY (pro_id)
REFERENCES productos(pro_id);

--Crear constraint para referenciar el dis_id de la tabla distribuidores en la tabla productos_distribuidores
ALTER TABLE productos_distribuidores
ADD CONSTRAINT disfk_id_pro_dis
FOREIGN KEY (dis_id)
REFERENCES distribuidores(dis_id);

--Crear un indice de dis_nombre en la tabla distribuidores
CREATE NONCLUSTERED INDEX dis_nombre_idx 
ON distribuidores (dis_nombre ASC);

--Crer un índice de pro_nombre en la tabla productos
CREATE NONCLUSTERED INDEX pro_nombre_idx 
ON productos (pro_nombre ASC);

--Crear un índice de ven_nombre en la tabla vendedores
CREATE NONCLUSTERED INDEX ven_nombre_idx 
ON vendedores (ven_nombre ASC);

--Crear un índice de cli_nombre en la tabla clientes
CREATE NONCLUSTERED INDEX cli_nombre_idx
ON clientes (cli_nombre ASC);

--Crear un índice en ord_id en la tabla ordenes
CREATE NONCLUSTERED INDEX ord_id_idx 
ON ordenes (ord_id ASC);

--Crear un índice en ord_id en la tabla ordenes_productos
CREATE NONCLUSTERED INDEX ord_pro_id_idx 
ON ordenes_productos (ord_id ASC);

--Insertar en la tabla vendedores por PRIMERA VEZ
BEGIN TRANSACTION
BEGIN TRY 
    ALTER TABLE vendedores
    DROP CONSTRAINT venfk_id_supervisor;
    SAVE TRANSACTION punto1 
    BEGIN TRY 
        INSERT INTO vendedores 
        (ven_ncontrol, ven_nombre, ven_direccion, ven_rfc, ven_curp, ven_supervisor) 
        VALUES (22419865, 'Claudio Segura', '551 Rebecca Shore', 'CSSALSKGJFMDL', 'SGMLKW3456L2P5J123', 1);
        SAVE TRANSACTION punto2
        BEGIN TRY 
            ALTER TABLE vendedores 
            ADD CONSTRAINT venfk_id_supervisor 
            FOREIGN KEY (ven_supervisor) 
            REFERENCES vendedores(ven_id);
        END TRY 
        BEGIN CATCH 
            ROLLBACK TRANSACTION punto2
            RAISERROR('Ocurió un Error', 16, 1)
        END CATCH;
    END TRY 
    BEGIN CATCH 
        ROLLBACK TRANSACTION punto1
        RAISERROR('Ocurió un Error', 16, 1)
    END CATCH;
    INSERT INTO vendedores 
    (ven_ncontrol, ven_nombre, ven_direccion, ven_rfc, ven_curp, ven_supervisor) 
    VALUES (22419866, 'Hector Sanchez', '43146 Bradley Pass', 'CSSA1SKGSFMDP', 'SGMLKW3456L295J138', 1);
    COMMIT TRANSACTION; 
END TRY 
BEGIN CATCH 
    ROLLBACK TRANSACTION;
    RAISERROR('Ocurió un Error', 16, 1)
END CATCH; 
SELECT *
FROM vendedores;
GO 

--Funcion para insertar con el nombre en el campo ven_supervisor
CREATE FUNCTION idDesdeNombreSupervisor(@nombre VARCHAR(255))
RETURNS INT 
AS 
BEGIN 
    DECLARE @id INT; 
    SELECT @id = ven_id
    FROM vendedores
    WHERE (ven_nombre = @nombre); 
    RETURN @id;
END
GO

--Funcion para insertar con el ncontrol en el campo ven_supervisor
CREATE FUNCTION idDesdeNControlSupervisor(@ncontrol CHAR(8))
RETURNS INT 
AS 
BEGIN
    DECLARE @id INT; 
    SELECT @id = ven_id
    FROM vendedores
    WHERE (ven_ncontrol = @ncontrol); 
    RETURN @id;
END;
GO

--Funcion para insertar con el nombre del vendedor en el campo ven_id 
CREATE FUNCTION idDesdeNombreVendedor(@nombre VARCHAR(255))
RETURNS INT 
AS 
BEGIN 
    DECLARE @id INT; 
    SELECT @id = ven_id
    FROM vendedores
    WHERE (ven_nombre = @nombre); 
    RETURN @id;
END;
GO

--Funcion para insertar con el ncontrol del vendedor en el campo ven_id
CREATE FUNCTION idDesdeNControlVendedor(@ncontrol CHAR(8))
RETURNS INT 
AS 
BEGIN
    DECLARE @id INT; 
    SELECT @id = ven_id
    FROM vendedores
    WHERE (ven_ncontrol = @ncontrol); 
    RETURN @id;
END;
GO

--Funcion para insertar con el nombre en el campo cli_nombre
CREATE FUNCTION idDesdeNombreCliente(@nombre VARCHAR(255))
RETURNS INT 
AS 
BEGIN 
    DECLARE @id INT; 
    SELECT @id = cli_id
    FROM clientes
    WHERE (cli_nombre = @nombre); 
    RETURN @id;
END
GO   

--Funcion para insertar con el nombre del producto en el campo pro_id
CREATE FUNCTION idDesdeNombreProducto(@nombre VARCHAR(255))
RETURNS INT 
AS 
BEGIN 
    DECLARE @id INT; 
    SELECT @id = pro_id
    FROM productos
    WHERE (pro_nombre = @nombre); 
    RETURN @id;
END
GO    

--Funcion para insertar con el codigo del producto en el campo pro_id
CREATE FUNCTION idDesdeCodigoProducto(@codigo CHAR(8))
RETURNS INT 
AS 
BEGIN
    DECLARE @id INT; 
    SELECT @id = pro_id
    FROM productos
    WHERE (pro_codigo = @codigo); 
    RETURN @id;
END
GO

--Crear Trigger para la cantidad de productos insertados en la tabla ordenes_productos
CREATE FUNCTION obtenerCantidadProducto (@id INT)
RETURNS INT
AS 
BEGIN 
    DECLARE @cantidad INT
    SET @cantidad = (SELECT pro_cantidad
                     FROM productos
                     WHERE (pro_id = @id));
    RETURN @cantidad;
END;
GO

CREATE FUNCTION obtenerPrecioProducto (@id INT)
RETURNS INT
AS 
BEGIN 
    DECLARE @precioIndividual MONEY
    SET @precioIndividual = (SELECT pro_precio
                             FROM productos
                             WHERE (pro_id = @id));
    RETURN @precioIndividual;
END;
GO

CREATE PROCEDURE obtenerPrecioTotal @id INT, @cantidadop INT, @cantidadp INT, @precioIndividual MONEY 
AS
BEGIN
    DECLARE @precioTotal MONEY;
    DECLARE @cantidadActualizadaProducto INT;
    SET @precioTotal = @cantidadop * @precioIndividual;
    UPDATE ordenes_productos
    SET ord_pro_precio_total = @precioTotal
    WHERE (pro_id = @id)
   
    SET @cantidadActualizadaProducto =  @cantidadp - @cantidadop;
    UPDATE productos
    SET pro_cantidad = @cantidadActualizadaProducto
    WHERE (pro_id = @id);    
END
GO

CREATE TRIGGER validarCantidadOrdenesPrecioProductos
ON ordenes_productos
AFTER INSERT 
AS
BEGIN 
    DECLARE @id INT;
    DECLARE @cantidadop INT; 
    DECLARE @cantidadp INT;
    DECLARE @precioIndividual MONEY;
    SELECT @id = pro_id, @cantidadop = ord_pro_cantidad
    FROM inserted
    SET @cantidadp = dbo.obtenerCantidadProducto(@id);
    SET @precioIndividual = dbo.obtenerPrecioProducto(@id);
    IF (@cantidadop <= @cantidadp)
    BEGIN 
        EXECUTE obtenerPrecioTotal @id, @cantidadop, @cantidadp, @precioIndividual;
    END
    ELSE 
    BEGIN
        DELETE 
        FROM ordenes_productos 
        WHERE (pro_id = @id)
        RAISERROR('Error con la cantidad', 16, 1) 
    END 
END
GO

--Funcion para insertar con el nombre del distribuidor en el campo dis_id 
CREATE FUNCTION idDesdeNombreDistribuidor(@nombre VARCHAR(255))
RETURNS INT 
AS 
BEGIN 
    DECLARE @id INT; 
    SELECT @id = dis_id
    FROM distribuidores
    WHERE (dis_nombre = @nombre); 
    RETURN @id;
END;
GO

--Insertar registros en la tabla productos
BEGIN TRY
    BEGIN TRANSACTION;
    INSERT INTO productos (pro_codigo, pro_nombre, pro_tipo, pro_cantidad, pro_precio) VALUES (12345678, 'Rines', 'Exterior', 12, 100);
    INSERT INTO productos (pro_codigo, pro_nombre, pro_tipo, pro_cantidad, pro_precio) VALUES (87654321, 'Neumaticos', 'Exterior', 12, 4000);
    INSERT INTO productos (pro_codigo, pro_nombre, pro_tipo, pro_cantidad, pro_precio) VALUES (11111111, 'Aleron', 'Extras', 12, 300);
    INSERT INTO productos (pro_codigo, pro_nombre, pro_tipo, pro_cantidad, pro_precio) VALUES (22222222, 'Bujia', 'Motor', 12, 500);
    COMMIT TRANSACTION;
END TRY
BEGIN CATCH
    ROLLBACK TRANSACTION;
    RAISERROR('Ocurrió un error en la inserción de registros', 16, 1);
END CATCH
SELECT *
FROM productos;

--Insertar registros en la tabla distribuidores
BEGIN TRY 
    BEGIN TRANSACTION;
    INSERT INTO distribuidores (dis_nombre, dis_direccion) VALUES ('Atlanta Car Repair', '21392 Hackett Street');
    INSERT INTO distribuidores (dis_nombre, dis_direccion) VALUES ('Wong Motor Sports', '808 Nils Centers');
    INSERT INTO distribuidores (dis_nombre, dis_direccion) VALUES ('Longos Auto Tires', '1923 Rene Mill');
    INSERT INTO distribuidores (dis_nombre, dis_direccion) VALUES ('ProTeam Auto', '03176 Chaz Manors');
    INSERT INTO distribuidores (dis_nombre, dis_direccion) VALUES ('Car 1p', '55966 Keebler Extension');
    COMMIT TRANSACTION;
END TRY
BEGIN CATCH
    ROLLBACK TRANSACTION;
    RAISERROR('Ocurrió un error en la insersión de registros', 16, 1);
END CATCH
SELECT *
FROM distribuidores;

--Ingresar registros a la tabla vendedores
BEGIN TRY 
    BEGIN TRANSACTION 
    INSERT INTO vendedores 
    (ven_ncontrol, ven_nombre, ven_direccion, ven_rfc, ven_curp, ven_supervisor) 
    VALUES (09431342, 'Misael Adame', '#123 Calle Legumbres Col. Arabia Saudí', 'CSSA1SKGSFMDP',
            'SGMLKW3456L295J138', 
            dbo.idDesdeNombreSupervisor('Claudio Segura'));
    INSERT INTO vendedores
    (ven_ncontrol, ven_nombre, ven_direccion, ven_rfc, ven_curp, ven_supervisor) 
    VALUES (19431342, 'Ana Rosa Montenegro', '27266 Kreiger Crossroad', 'ARNA1SKGSFMDP', 'ARMOKW3456L295J134', 
            dbo.idDesdeNControlSupervisor(09431342));
    INSERT INTO vendedores 
    (ven_ncontrol, ven_nombre, ven_direccion, ven_rfc, ven_curp, ven_supervisor) 
    VALUES (12654928, 'Maria Nieves Barrera', '6742 Vandervort Plain', 'MNBA1SKGSFSRQ', 'PXLLKW3456L295J628', 
            dbo.idDesdeNombreSupervisor('Misael Adame'));
    INSERT INTO vendedores 
    (ven_ncontrol, ven_nombre, ven_direccion, ven_rfc, ven_curp, ven_supervisor) 
    VALUES (12654327, 'Victorino Prados', '802 Davis Plains', 'VPRA1SKGSFSRN', 'VYNNKW3456L345J628', 
            dbo.idDesdeNombreSupervisor('Misael Adame'));
    COMMIT TRANSACTION
END TRY
BEGIN CATCH
    ROLLBACK TRANSACTION;
    RAISERROR('Ocurrió un error en la insersión de registros', 16, 1);
END CATCH
SELECT * FROM 
vendedores;
GO 

--Insertar registros a la tabla clientes
BEGIN TRY 
    BEGIN TRANSACTION
    INSERT INTO clientes
    (cli_nombre, cli_direccion, ven_id)
    VALUES ('Jesus Lopez', '#232 Col. Santiago Av. Morelos', dbo.idDesdeNombreVendedor('Misael Adame'))
    INSERT INTO clientes
    (cli_nombre, cli_direccion, ven_id)
    VALUES ('Juan Alfaro', '#23 Col. Buenos Aires Calle 69', dbo.idDesdeNombreVendedor('Claudio Segura'))
    INSERT INTO clientes
    (cli_nombre, cli_direccion, ven_id)
    VALUES ('Jose Rocha', 'Calle Boca Ejido Roman Riquelme', dbo.idDesdeNControlVendedor(22419866))
    INSERT INTO clientes
    (cli_nombre, cli_direccion, ven_id)
    VALUES ('Ivan Gonzalez ', '#1116 Col. Tangamandapio Calle Socrates', dbo.idDesdeNControlVendedor(12654327))
    COMMIT TRANSACTION
END TRY
BEGIN CATCH
    ROLLBACK TRANSACTION;
    RAISERROR('Ocurrió un error en la insersión de registros', 16, 1);
END CATCH
SELECT * 
FROM clientes;
GO  

--Insertar registros a la tabla ordenes
BEGIN TRY 
    BEGIN TRANSACTION
    INSERT INTO ordenes (cli_id) VALUES (dbo.idDesdeNombreCliente('Jesus Lopez'))
    INSERT INTO ordenes (cli_id) VALUES (dbo.idDesdeNombreCliente('Juan Alfaro'))
    INSERT INTO ordenes (cli_id) VALUES (dbo.idDesdeNombreCliente('Ivan Gonzalez'))
    COMMIT TRANSACTION
END TRY
BEGIN CATCH
    ROLLBACK TRANSACTION;
    RAISERROR('Ocurrió un error en la insersión de registros', 16, 1);
END CATCH
SELECT * 
FROM ordenes;
GO 

--Insertar registros a la tabla ordenes_producto
SELECT *
FROM productos
BEGIN TRY 
    BEGIN TRANSACTION
    INSERT INTO ordenes_productos 
    (ord_id, pro_id, ord_pro_cantidad, ord_pro_forden)
    VALUES (1, dbo.idDesdeNombreProducto('Rines'), 5, GETDATE())
    INSERT INTO ordenes_productos 
    (ord_id, pro_id, ord_pro_cantidad, ord_pro_forden)
    VALUES (2, dbo.idDesdeCodigoProducto(22222222), 8, GETDATE())
    INSERT INTO ordenes_productos 
    (ord_id, pro_id, ord_pro_cantidad, ord_pro_forden)
    VALUES (3, dbo.idDesdeNombreProducto('Aleron'), 2, GETDATE())
    COMMIT TRANSACTION
END TRY
BEGIN CATCH
    ROLLBACK TRANSACTION;
    RAISERROR('Ocurrió un error en la insersión de registros', 16, 1);
END CATCH
SELECT * 
FROM ordenes_productos;
SELECT * 
FROM productos
GO 

--Insertar registros a la tabla productos_vendedores
BEGIN TRY 
    BEGIN TRANSACTION 
    INSERT INTO productos_vendedores (pro_id, ven_id)
    VALUES (dbo.idDesdeNombreProducto('Rines'), dbo.idDesdeNombreVendedor('Misael Adame'))
    INSERT INTO productos_vendedores (pro_id, ven_id)
    VALUES (dbo.idDesdeNombreProducto('Neumaticos'), dbo.idDesdeNombreVendedor('Ana Rosa Montenegro'))
    INSERT INTO productos_vendedores (pro_id, ven_id)
    VALUES (dbo.idDesdeCodigoProducto(11111111), dbo.idDesdeNControlVendedor(22419866))
    INSERT INTO productos_vendedores (pro_id, ven_id)
    VALUES (dbo.idDesdeCodigoProducto(22222222), dbo.idDesdeNControlVendedor(12654327))
    COMMIT TRANSACTION
END TRY 
BEGIN CATCH
    ROLLBACK TRANSACTION
    RAISERROR('Ocurrió un error en la insersión de registros', 16, 1);
END CATCH
SELECT *
FROM productos_vendedores;
GO 

--Insertar registros en la tabla productos_distribuidores
BEGIN TRY 
    BEGIN TRANSACTION 
    INSERT INTO productos_distribuidores (pro_id, dis_id)
    VALUES (dbo.idDesdeNombreProducto('Rines'), dbo.idDesdeNombreDistribuidor('Longos Auto Tires'))
    INSERT INTO productos_distribuidores (pro_id, dis_id)
    VALUES (dbo.idDesdeCodigoProducto(87654321), dbo.idDesdeNombreDistribuidor('Wong Motor Sports'))
    INSERT INTO productos_distribuidores (pro_id, dis_id)
    VALUES (dbo.idDesdeCodigoProducto(11111111), dbo.idDesdeNombreDistribuidor('ProTeam Auto'))
    INSERT INTO productos_distribuidores (pro_id, dis_id)
    VALUES (dbo.idDesdeNombreProducto('Bujia'), dbo.idDesdeNombreDistribuidor('Atlanta Car Repair'))
    COMMIT TRANSACTION
END TRY 
BEGIN CATCH
    ROLLBACK TRANSACTION
    RAISERROR('Ocurrió un error en la insersión de registros', 16, 1);
END CATCH
SELECT *
FROM productos_distribuidores;

--CONSULTAS
-- Función para obtener los empleados del supervisor
GO
CREATE FUNCTION supervisorDe(@nombre VARCHAR(255))
RETURNS TABLE
AS
    RETURN SELECT ven_nombre
           FROM vendedores
           WHERE (ven_supervisor = (SELECT ven_id
									FROM vendedores
									WHERE (ven_nombre = @nombre)))
GO

--Para comprobar el uso de la funcipón
SELECT *
FROM dbo.supervisorDe('Misael Adame');

--Mostrar el precio mayor al promedio de los productos
SELECT pro_nombre, pro_precio
FROM productos
WHERE (pro_precio > (SELECT AVG(pro_precio)
					 FROM productos))

--Ordenes por clientes
GO
CREATE FUNCTION ordenesXclientes(@nombre VARCHAR(255))
RETURNS TABLE
AS
    RETURN  SELECT COUNT(*) AS ordenes
			FROM ordenes AS ord
			INNER JOIN clientes AS cli ON (cli.cli_id = ord.cli_id)
			WHERE (ord.cli_id IN (SELECT cli_id
								  FROM clientes
								  WHERE (cli_nombre = @nombre)))
GO

--Funcion para probar la anterior función
SELECT *
FROM dbo.ordenesXclientes('Ivan Gonzalez')

--Vistas
--Vista en donde se muestra el producto con mayor costo
GO
CREATE VIEW productoMasCaro AS
SELECT * 
FROM productos
WHERE (pro_precio IN(SELECT MAX(pro_precio)
                     FROM productos))
GO

SELECT * FROM productoMasCaro

--Vista en donde se muestra el producto con menor rpecio
GO
CREATE VIEW productoMasBarato AS
SELECT * 
FROM productos
WHERE (pro_precio IN(SELECT MIN(pro_precio)
                     FROM productos))
GO

SELECT * FROM productoMasBarato

--Vista en donde muestra la suma de todos los productos
GO
CREATE VIEW sumaTotalOrdenesProductos AS
SELECT SUM(ord_pro_precio_total) AS 'Suma Total de Ordenes'
FROM ordenes_productos
GO

SELECT * FROM sumaTotalOrdenesProductos

--Eliminar la base de datos inventarios en caso de que exista
IF EXISTS (SELECT * 
           FROM sys.databases 
           WHERE name = 'inventarios')
BEGIN 
    USE master;
    DROP DATABASE inventarios;
    PRINT 'La base de datos inventarios ha sido eliminada'
END
ELSE 
    PRINT 'Ya no existe la base de Datos'


