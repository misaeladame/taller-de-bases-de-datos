CREATE DATABASE Banco;

USE Banco;

CREATE TABLE clientes
(
    cte_id INT IDENTITY NOT NULL,
    cte_nombre VARCHAR(255) NOT NULL,
    cte_rfc CHAR(13) NOT NULL,
    cte_curp CHAR(18) NOT NULL,
    cte_domicilio VARCHAR(255) NOT NULL,
    cte_email VARCHAR(255) NULL,
    cte_telefono VARCHAR(10) NULL,
    PRIMARY KEY (cte_id)
);

CREATE TABLE tcuentas 
(
    tcta_id INT IDENTITY NOT NULL,
    tcta_nombre VARCHAR(255),
    PRIMARY KEY (tcta_id)
);

CREATE TABLE cuentas 
(
    cta_id INT IDENTITY NOT NULL,
    cta_numero CHAR(15) NOT NULL,
    cta_clabe CHAR(18) NOT NULL,
    cta_saldo DECIMAL(10, 2),
    cta_fapertura DATETIME,
    cte_id INT NOT NULL, 
    tcta_id INT NOT NULL,
    ej_id INT NOT NULL,
    PRIMARY KEY (cta_id)
);

CREATE TABLE movimientos 
(
    mov_id INT IDENTITY NOT NULL,
    mov_monto DECIMAL (10, 2) NOT NULL,
    mov_fecha DATETIME NOT NULL,
    cta_ingreso INT NOT NULL,
    cta_egreso INT NOT NULL,
    PRIMARY KEY (mov_id)
);

CREATE TABLE sucursales
(
    suc_id INT IDENTITY NOT NULL,
    suc_nombre VARCHAR(255) NOT NULL,
    suc_direccion VARCHAR(255) NOT NULL,
    PRIMARY KEY (suc_id)
);

CREATE TABLE ejecutivos
(
    ej_id INT IDENTITY NOT NULL,
    ej_nombre VARCHAR(255) NOT NULL,
    ej_rfc CHAR(13) NOT NULL,
    ej_curp CHAR(18) NOT NULL,
    suc_id INT NOT NULL,
    PRIMARY KEY (ej_id)
);


ALTER TABLE cuentas 
ADD CONSTRAINT ctefk_id_cta
FOREIGN KEY (cte_id)
REFERENCES clientes (cte_id);

ALTER TABLE cuentas 
ADD CONSTRAINT tcta_id_cta
FOREIGN KEY (tcta_id)
REFERENCES tcuentas (tcta_id);

ALTER TABLE cuentas 
ADD CONSTRAINT ejfk_id_cta 
FOREIGN KEY (ej_id)
REFERENCES ejecutivos (ej_id);

ALTER TABLE movimientos
ADD CONSTRAINT ctafk_id_ingreso_mov
FOREIGN KEY (cta_ingreso)
REFERENCES cuentas (cta_id);

ALTER TABLE movimientos
ADD CONSTRAINT ctafk_id_egreso_mov 
FOREIGN KEY (cta_egreso)
REFERENCES cuentas (cta_id);

ALTER TABLE ejecutivos 
ADD CONSTRAINT sucfk_id_ej
FOREIGN KEY (suc_id)
REFERENCES sucursales (suc_id);



INSERT INTO sucursales 
(suc_nombre, suc_direccion)
VALUES 
('Torreón Centro', 'Av. Hidalgo #4432, Col. Centro'),
('Gomez Palacio Hamburgo', 'Blvd. Ejercito Mexicano #5565 , Col. Hamburgo');


INSERT INTO ejecutivos
(ej_nombre, ej_rfc, ej_curp, suc_id)
VALUES 
('Jesús López', 'CUPU800825569', 'BADD110313HCMLNS09', 1),
('Juan Alfaro', 'ALDU800825569', 'ALJD160313HCMLSN11', 1),
('José Rocha', 'ROJA134825569', 'RGJAN181413HCMLSN1', 2);


INSERT INTO clientes
(cte_nombre, cte_rfc, cte_curp, cte_domicilio, cte_email, cte_telefono)
VALUES 
('Iván González', 'GRIE134825570', 'GRIEN181413HCMLSN2', '#232 Col. Santiago Av. Morelos', 'kikin_fighter@hotmail.com', '8712345675'),
('Manuel Rodríguez', 'ROMA134825571', 'ROROM181413HCMLSN3', '#23 Col. Buenos Aires Calle 69', 'manuel_rod@hotmail.com', '8712341234'),
('Ricardo Castro', 'CLRR134825572', 'CLRRA181413HCMLSN4', 'Calle Boca Ejido Roman Riquelme', 'ric_c@gmail.com', '8715444234'),
('Arturo Galindo', 'GUJA134825573', 'GUJAR181413HCMLSN5', '#1116 Col. Tangamandapio Calle Socrates', 'arturigax@outlook.com', '8713349345'),
('Angel Flores', 'FAAF134825574', 'FAAFR181413HCMLSN6', '#123 Calle Legumbres Col. Arabia Saudí', 'faaf@protonmail.com', '8723456789');


INSERT INTO tcuentas
(tcta_nombre)
VALUES
('Lugo''s'),
('Saavedra'),
('Santos');

INSERT INTO cuentas 
(cta_numero, cta_clabe, cta_saldo, cta_fapertura, cte_id, tcta_id, ej_id)
VALUES
('743590251314761','638434164347609123', 23405,'2020-02-22 01:00:00 PM', 1, 1, 1),
('143590251311234','938434164347609456', 100000,'2020-02-21 12:00:00 PM', 1, 1, 2),
('243590251312345','138434164347609444', 125000,'2020-02-20 09:00:00 AM', 2, 1, 3),
('343590251315678','238434164347609123', 20000,'2020-02-19 01:00:00 PM', 3, 1, 1),
('443590251311789','338434164347609999', 150,'2020-02-18 01:00:00 PM', 4, 2, 1),
('512339251314761','738434164347609000', 50000,'2020-02-17 10:00:00 AM', 5, 2, 2),
('698765451324111','638434162421609111', 1500000,'2020-01-13 11:00:00 AM', 5, 3, 3);


INSERT INTO movimientos
(mov_monto, mov_fecha, cta_ingreso, cta_egreso)
VALUES
(4000, '2020-02-22 03:02:00 PM', 1, 2),
(500, '2020-02-22 03:23:00 PM', 2, 3),
(25000, '2020-02-22 03:45:00 PM', 3, 4),
(3500, '2020-02-22 03:56:00 PM', 4, 5),
(100000, '2020-02-22 04:02:00 PM', 5, 1);




/*
Obtener todas las cuentas indicando el cliente, el tipo, saldo, ejecutivo que la creó
y sucursal a la que pertenece, ordenadas por sucursal ascendentemente, ejecutivo también
ascendentemente y por fecha de apertura descendentemente
*/
SELECT cta_numero, cte_nombre, tcta_nombre, cta_saldo, ej_nombre, suc_nombre
FROM cuentas AS cta
INNER JOIN clientes AS cte ON (cta.cte_id = cte.cte_id)
INNER JOIN tcuentas AS tcta ON (cta.tcta_id = tcta.tcta_id)
INNER JOIN ejecutivos AS ej ON (cta.ej_id = ej.ej_id)
INNER JOIN sucursales AS suc ON (ej.suc_id = suc.suc_id)
ORDER BY suc_nombre ASC, ej_nombre ASC, cta_fapertura DESC;

/*
Obtener las cuentas que tengan menos de 10 movimientos, indicando la cantidad de movimientos, 
el tipo de cuenta, el cliente al que pertenece la cuenta y la sucursal donde fue abierta
*/
SELECT cta_numero, tcta_nombre, cte_nombre, suc_nombre, COUNT(*) AS numero_movimientos
FROM movimientos AS mov
INNER JOIN cuentas AS cta ON (mov.cta_ingreso = cta.cta_id ) OR (mov.cta_egreso = cta.cta_id)
INNER JOIN tcuentas AS tcta ON (cta.tcta_id = tcta.tcta_id)
INNER JOIN clientes AS cte ON (cte.cte_id = cta.cte_id)
INNER JOIN ejecutivos AS ej ON (ej.ej_id = cta.ej_id)
INNER JOIN sucursales AS suc ON (suc.suc_id = ej.suc_id)
GROUP BY  cta_numero, tcta_nombre, cte_nombre, suc_nombre
HAVING (COUNT(*) < 10);

-- Mi consulta
/* Generar una lista de las cuentas con saldo incorrecto, imprimir el saldo registrado y el calculado */
SELECT cte_nombre, cta_numero, cta_saldo AS 'Saldo registrado', ( cta_saldo +
                                                                (SELECT SUM(mov_monto)
                                                                FROM movimientos 
                                                                WHERE (cta_ingreso = cta.cta_id)) - 
                                                                (SELECT SUM(mov_monto)
                                                                FROM movimientos 
                                                                WHERE (cta_egreso = cta.cta_id)) 
                                                                ) AS 'Saldo calculado'
FROM cuentas AS cta 
INNER JOIN clientes AS cte ON (cta.cte_id = cte.cte_id)
INNER JOIN movimientos AS movIn ON (cta.cta_id = movIn.cta_ingreso)
INNER JOIN movimientos AS movEg ON (cta.cta_id = movEg.cta_egreso)
GROUP BY cte_nombre, cta_numero, cta_saldo, cta_id;

-- Consulta correcta del inge Ulloa
/* Generar una lista de las cuentas con saldo incorrecto, imprimir el saldo registrado y el calculado */
SELECT cte_nombre, cta_numero, cta_saldo AS 'Saldo registrado', (( SELECT SUM(mov_monto)
                                                                FROM movimientos 
                                                                WHERE (cta_ingreso = cta.cta_id)) - 
                                                                (SELECT SUM(mov_monto)
                                                                FROM movimientos 
                                                                WHERE (cta_egreso = cta.cta_id)) 
                                                                ) AS 'Saldo calculado'
FROM cuentas AS cta 
INNER JOIN clientes AS cte ON (cta.cte_id = cte.cte_id)
INNER JOIN movimientos AS movIn ON (cta.cta_id = movIn.cta_ingreso)
INNER JOIN movimientos AS movEg ON (cta.cta_id = movEg.cta_egreso)
WHERE (cta_saldo <> (( SELECT SUM (mov_monto)
                    FROM movimientos 
                    WHERE (cta_ingreso = cta.cta_id)) - 
                    (SELECT SUM (mov_monto)
                    FROM movimientos 
                    WHERE (cta_egreso = cta.cta_id))));



--CONSULTA POR MI MISMO (Mayor al promedio de saldos)
SELECT cte_nombre, cta_numero, tcta_nombre, suc_nombre, cta_saldo
FROM cuentas AS cta 
INNER JOIN clientes AS cte ON (cta.cte_id = cte.cte_id)
INNER JOIN tcuentas AS tcta ON (tcta.tcta_id = cta.tcta_id)
INNER JOIN ejecutivos AS ej ON (ej.ej_id = cta.ej_id)
INNER JOIN sucursales AS suc ON (suc.suc_id = ej.suc_id)
WHERE (cta_saldo > (SELECT AVG (cta_saldo)
                    FROM cuentas));


/* 
Obtener las cuentas que tengan un saldo calculado mayor al promedio calculado de todas las
cuentas indicando su numero, el tipo, cliente y sucursal a la que pertenece 
*/
SELECT cte_nombre, cta_numero, tcta_nombre, suc_nombre, (( SELECT SUM(mov_monto)
                                                        FROM movimientos 
                                                        WHERE (cta_ingreso = cta.cta_id)) - 
                                                        (SELECT SUM(mov_monto)
                                                        FROM movimientos 
                                                        WHERE (cta_egreso = cta.cta_id)) 
                                                        ) AS 'Saldo calculado'
FROM cuentas AS cta 
INNER JOIN clientes AS cte ON (cta.cte_id = cte.cte_id)
INNER JOIN movimientos AS movIn ON (cta.cta_id = movIn.cta_ingreso)
INNER JOIN movimientos AS movEg ON (cta.cta_id = movEg.cta_egreso)
INNER JOIN tcuentas AS tcta ON (tcta.tcta_id = cta.tcta_id)
INNER JOIN ejecutivos AS ej ON (ej.ej_id = cta.ej_id)
INNER JOIN sucursales AS suc ON (suc.suc_id = ej.suc_id)
WHERE ((( SELECT SUM (mov_monto)
        FROM movimientos 
        WHERE (cta_ingreso = cta.cta_id)) - 
        (SELECT SUM (mov_monto)
        FROM movimientos 
        WHERE (cta_egreso = cta.cta_id))) > (SELECT AVG(prom_cuentas.saldo_calculado)
                                            FROM(
                                                SELECT movIn.cta_ingreso, movIn.ingreso, movEg.egreso, 
                                                (movIn.ingreso - movEg.egreso) AS saldo_calculado
                                                FROM (
                                                    SELECT SUM(mov_monto) AS ingreso, cta_ingreso
                                                    FROM movimientos  
                                                    GROUP BY cta_ingreso 
                                                ) AS movIn
                                                INNER JOIN (
                                                    SELECT SUM(mov_monto) AS egreso, cta_egreso
                                                    FROM movimientos  
                                                    GROUP BY cta_egreso
                                                ) AS movEg ON(movIn.cta_ingreso = movEg.cta_egreso)
                                            ) AS prom_cuentas));



/* 
Obtener las cuentas que tengan un saldo calculado mayor al promedio calculado de todas las
cuentas indicando su numero, el tipo, cliente y sucursal a la que pertenece 
REFACTORIZADA
*/
SELECT cte_nombre, cta_numero, tcta_nombre, suc_nombre, (( SELECT SUM(mov_monto)
                                                        FROM movimientos 
                                                        WHERE (cta_ingreso = cta.cta_id)) - 
                                                        (SELECT SUM(mov_monto)
                                                        FROM movimientos 
                                                        WHERE (cta_egreso = cta.cta_id)) 
                                                        ) AS 'Saldo calculado'
FROM cuentas AS cta 
INNER JOIN clientes AS cte ON (cta.cte_id = cte.cte_id)
INNER JOIN movimientos AS movIn ON (cta.cta_id = movIn.cta_ingreso)
INNER JOIN movimientos AS movEg ON (cta.cta_id = movEg.cta_egreso)
INNER JOIN tcuentas AS tcta ON (tcta.tcta_id = cta.tcta_id)
INNER JOIN ejecutivos AS ej ON (ej.ej_id = cta.ej_id)
INNER JOIN sucursales AS suc ON (suc.suc_id = ej.suc_id)
WHERE ((( SELECT SUM (mov_monto)
        FROM movimientos 
        WHERE (cta_ingreso = cta.cta_id)) - 
        (SELECT SUM (mov_monto)
        FROM movimientos 
        WHERE (cta_egreso = cta.cta_id))) > (SELECT AVG(prom_cuentas.saldo_calculado)
                                            FROM(
                                                SELECT movIn.cta_ingreso, movIn.ingreso, movEg.egreso, 
                                                (movIn.ingreso - movEg.egreso) AS saldo_calculado
                                                FROM (
                                                    SELECT SUM(mov_monto) AS ingreso, cta_ingreso
                                                    FROM movimientos  
                                                    GROUP BY cta_ingreso 
                                                ) AS movIn
                                                INNER JOIN (
                                                    SELECT SUM(mov_monto) egreso, cta_egreso
                                                    FROM movimientos  
                                                    GROUP BY cta_egreso
                                                ) AS movEg ON(movIn.cta_ingreso = movEg.cta_egreso)
                                            ) AS prom_cuentas));

/*
(( SELECT SUM (mov_monto)
FROM movimientos 
WHERE (cta_ingreso = )) - 
(SELECT SUM (mov_monto)
FROM movimientos 
WHERE (cta_egreso = ))
*/
SELECT AVG(prom_cuentas.saldo_calculado), SUM(prom_cuentas.saldo_calculado), COUNT(prom_cuentas.saldo_calculado)
FROM(
    SELECT movIn.cta_ingreso, movIn.ingreso, movEg.egreso, 
    (movIn.ingreso - movEg.egreso) as saldo_calculado
    FROM (
        SELECT SUM(mov_monto) as ingreso, cta_ingreso
        FROM movimientos  
        GROUP BY cta_ingreso 
    ) as movIn
    INNER JOIN (
        SELECT SUM(mov_monto) egreso, cta_egreso
        FROM movimientos  
        GROUP BY cta_egreso
    ) as movEg ON(movIn.cta_ingreso = movEg.cta_egreso)
) as prom_cuentas
WHERE 1=1;



/* 
Obtener las cuentas que tengan un saldo calculado mayor al promedio calculado de todas las
cuentas indicando su numero, el tipo, cliente y sucursal a la que pertenece 
DEL INGE ULLOA
*/
SELECT cta_numero, tcta_nombre, cte_nombre, suc_nombre, (( SELECT SUM(mov_monto)
                                                        FROM movimientos 
                                                        WHERE (cta_ingreso = cta.cta_id)) - 
                                                        (SELECT SUM(mov_monto)
                                                        FROM movimientos 
                                                        WHERE (cta_egreso = cta.cta_id)) 
                                                        ) AS saldo
FROM cuentas AS cta 
INNER JOIN clientes AS cte ON (cta.cte_id = cte.cte_id)
INNER JOIN tcuentas AS tcta ON (tcta.tcta_id = cta.tcta_id)
INNER JOIN ejecutivos AS ej ON (ej.ej_id = cta.ej_id)
INNER JOIN sucursales AS suc ON (suc.suc_id = ej.suc_id)
WHERE ((( SELECT SUM (mov_monto)
        FROM movimientos 
        WHERE (cta_ingreso = cta.cta_id)) - 
        (SELECT SUM (mov_monto)
        FROM movimientos 
        WHERE (cta_egreso = cta.cta_id))) > (SELECT AVG(subconsulta.saldo)
                                            FROM(
                                                SELECT saldo = (SELECT SUM(mov_monto)
                                                                FROM movimientos 
                                                                WHERE (cta_ingreso = cta.cta_id)) -
                                                                (SELECT SUM(mov_monto)
                                                                FROM movimientos
                                                                WHERE (cta_egreso = cta.cta_id))
                                                FROM cuentas AS cta) AS subconsulta)
                                            );




SELECT * FROM clientes;
SELECT * FROM tcuentas;
SELECT * FROM cuentas;
SELECt * FROM sucursales;
SELECT * FROM ejecutivos;
SELECT * FROM movimientos;

USE master;

DROP DATABASE Banco;



	
