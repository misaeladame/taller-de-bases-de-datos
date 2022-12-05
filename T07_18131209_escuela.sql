--Script para crear la base de datos escuela
--Materia Taller de Base de Datos 
--Fecha de creacion 18/03/20
--Autor: José Misael Adame Sandoval 18131209
--Fecha de ultima actualizacion 26/03/20
--Lugar: Torreon, Coahuila 

--Crear la base de datos
CREATE DATABASE escuela;

--Poner en uso la base de datos
USE escuela;

--Crear la tabla alumnos
CREATE TABLE alumnos 
(
    alu_id INT IDENTITY NOT NULL,
    alu_nctrl VARCHAR(9) NOT NULL,
    alu_nombre VARCHAR(255) NOT NULL,
    alu_email VARCHAR(255) NULL,
    alu_celular VARCHAR(13) NULL,
    PRIMARY KEY (alu_id) 
);

--Crear la tabla horarios
CREATE TABLE horarios
(
    hor_id INT IDENTITY NOT NULL,
    hor_dia VARCHAR(16) NOT NULL,
    hor_inicio TIME NOT NULL, 
    hor_fin TIME NOT NULL,
    gpo_id INT NOT NULL,
    PRIMARY KEY (hor_id)
);

--Crear la tabla materias 
CREATE TABLE materias 
(
    mat_id INT IDENTITY NOT NULL, 
    mat_nombre VARCHAR(255) NOT NULL,
    mat_clave CHAR(4) NOT NULL,
    PRIMARY KEY (mat_id)
);

--Crear la tabla grupos
CREATE TABLE grupos
(
    gpo_id INT IDENTITY NOT NULL,
    gpo_nombre VARCHAR(10) NOT NULL,
    gpo_clave CHAR(6) NOT NULL,
    mat_id INT NOT NULL,
    PRIMARY KEY (gpo_id)
);

--Crear la tabla inscripciones
CREATE TABLE inscripciones
(
    insc_id INT IDENTITY NOT NULL,
    insc_fecha DATETIME NOT NULL,
    alu_id INT NOT NULL,
    gpo_id INT NOT NULL,
    PRIMARY KEY (insc_id)
);

--Crear constraint para que sea unico alu_nctrl en la tabla alumnos
ALTER TABLE alumnos
ADD UNIQUE (alu_nctrl);

--Crear constraint para que sea único mat_clave de la tabla materias
ALTER TABLE materias
ADD UNIQUE (mat_clave);

--Crear constraint para que sea unico gpo_clave en la tabla grupos
ALTER TABLE grupos
ADD UNIQUE (gpo_clave);

--Crear constraint para referenciar el alu_id de la tabla alumnos en la tabla inscipciones
ALTER TABLE inscripciones
ADD CONSTRAINT alufk_id_insc
FOREIGN KEY (alu_id)
REFERENCES alumnos (alu_id);

--Crear constraint para referenciar el gpo_id de la tabla grupos en la tabla inscripciones
ALTER TABLE inscripciones
ADD CONSTRAINT gpofk_id_insc
FOREIGN KEY (gpo_id)
REFERENCES grupos (gpo_id);

--Crear constraint para referenciar el mat_id de la tabla materias en la tabla grupos
ALTER TABLE grupos 
ADD CONSTRAINT matfk_id_gpo
FOREIGN KEY (mat_id)
REFERENCES materias (mat_id);

--Crear constraint para referenciar el gpo_id de la tabla grupos en la tabla horarios
ALTER TABLE horarios
ADD CONSTRAINT gpofk_id_hor
FOREIGN KEY (gpo_id)
REFERENCES grupos (gpo_id);

--Crear un índice único de alu_nctrl de la tabla alumnos
CREATE UNIQUE NONCLUSTERED INDEX alu_nctrl_idx
ON alumnos (alu_nctrl ASC);

--Crear un índice de mat_nombre de la tabla materias
CREATE NONCLUSTERED INDEX mat_nombre_idx
ON materias (mat_nombre ASC);

--Insertar información en la tabla alumnos
INSERT INTO alumnos 
(
    alu_nctrl, alu_nombre, alu_email, alu_celular
)
VALUES 
(
    '18131209', 'José Misael Adame Sandoval', 'misael_adame@protonmail.com', '8712755272'
),
(
    '18131252', 'Jesús Daniel López Hernández', 'rcl@hotmail.com', '8712222222'
),
(
    '18131319', 'Iván Enrique González Ruiz', 'kike@gmail.com', '8711111111'
),
(
    '18131222', 'José Luis Carreón Reyes', 'jluis@hotmail.com', '8723333333'
),
(
    '18131273', 'José Ángel Rocha Garcia', 'rocha@gmail.com', '8712345789'  
);

--Insetar información en la tabla materias
INSERT INTO  materias
(
    mat_nombre, mat_clave 
)
VALUES
(
    'Administración de Base de Datos', 'C16'
),
(
    'Algebra Lineal', 'E12'
),
(
    'Arquitectura de Computadoras', 'F15'
),
(
    'Ecuaciones Diferenciales', 'A14'
),
(
    'Taller de Base de Datos', 'C15'
);

--Insertar información en la tabla grupos
INSERT INTO grupos 
(
    gpo_nombre, gpo_clave, mat_id
)
VALUES 
(
    'ABD-M', 'C16A', 1
),
(
    'AL-M', 'E12A', 2
),
(
    'AC-M', 'F16A', 3
),
(
    'AC-V', 'F16B', 3
),
(
    'ED-M', 'A14A', 4
),
(
    'TBD-V', 'C15B', 5
);

--Insertar información en la tabla horarios
INSERT INTO horarios
(
    hor_dia, hor_inicio, hor_fin, gpo_id
)
VALUES
(
    'Lunes', '09:00:00 AM', '10:00:00 AM', 1
),
(
    'Martes', '08:00:00 AM', '12:00:00 PM', 1
),
(
    'Miercoles', '07:00:00 AM', '08:00:00 AM', 2
),
(
    'Jueves', '10:00:00 AM', '12:00:00 PM', 3
),
(
    'Jueves', '12:00:00 PM', '16:00:00', 4 
),
(
    'Viernes', '08:00:00 AM', '11:00:00 AM', 5
),
(
    'Miercoles', '06:00:00 PM', '08:00:00 PM', 6
)

--Insertar información en la tabla inscripciones
INSERT INTO inscripciones
(
    insc_fecha, alu_id, gpo_id
)
VALUES
(
    '2020-01-15 09:00:00 AM', 1, 1
),
(
    '2020-01-15 09:00:00 AM', 1, 2
),
(
    '2020-01-15 11:00:00 AM', 2, 3
),
(
    '2020-01-15 11:00:00 AM', 2, 4
),
(
    '2020-01-16 12:00:00 PM', 3, 5
),
(
    '2020-01-16 12:00:00 AM', 3, 6
),
(
    '2020-01-15 09:00:00 PM', 4, 2
),
(
    '2020-01-17 13:00:00', 5, 4
),
(
    '2020-01-15 09:00:00 AM', 5, 6
);

--Consultar la información de todos los alumnos
SELECT * 
FROM alumnos;

--Consultar el nombre, nctrl, email y celular de los alumnos
SELECT alu_nombre, alu_nctrl, alu_email, alu_celular
FROM alumnos;

--Consulta para ver el numero de control, nombre, email celular del alumno
--además del nombre de la materia y del nombre del grupo
/*SELECT alu_nctrl AS NCtrl, alu_nombre AS Nombre, alu_email AS eMail, 
alu_celular AS Celular, mat_nombre AS Materia, gpo_nombre AS Grupo
FROM alumnos AS alu, materias AS mat, grupos AS gpo;


SELECT alu_nctrl AS NCtrl, alu_nombre AS Nombre, alu_email AS eMail, 
alu_celular AS Celular, mat_nombre AS Materia, hor_inicio +'-' +hor_fin AS 'Horario Martes' 
FROM alumnos AS alu, inscripciones AS incs, grupos AS gpo, materias AS mat, horarios AS hor; */


--Consulta que obtiene datos del alumno y el nombre de la materia de los grupos que tenga un martes 
--como horario que está inscrito el alumno 
SELECT alu_nctrl AS NCtrl, alu_nombre AS Nombre, alu_email AS eMail, 
alu_celular AS Celular, mat_nombre AS Materia, 
CONVERT(VARCHAR(5),hor_inicio) +'-' +CONVERT(VARCHAR(5), hor_fin) AS 'Horario Martes' 
FROM alumnos AS alu, inscripciones AS insc, grupos AS gpo, materias AS mat, horarios AS hor
WHERE (alu.alu_id = insc.alu_id)
AND (insc.gpo_id = gpo.gpo_id)
AND (gpo.mat_id = mat.mat_id)
AND (hor.gpo_id = gpo.gpo_id)
AND (hor.hor_dia = 'Martes');

--Consulta que obtiene la cantidad de inscripciones que hay en cada alumno
SELECT alu_nctrl, alu_nombre, COUNT(*) AS inscripciones
FROM alumnos AS alu, inscripciones AS insc 
WHERE (alu.alu_id = insc.alu_id)
GROUP BY alu_nctrl, alu_nombre;

--Consulta que obtiene la cantidad de alumnos que hay en cada grupo
SELECT gpo_clave AS Grupo, gpo_nombre AS Nombre, COUNT(*) AS Alumnos
FROM grupos AS gpo, inscripciones AS insc
WHERE (gpo.gpo_id = insc.gpo_id)
GROUP BY gpo_clave, gpo_nombre;

--Consulta que obtiene la cantidad de grupos por materia
SELECT mat_clave AS Materia, mat_nombre AS Nombre, COUNT(*) AS Grupos
FROM materias AS mat, grupos AS gpo 
WHERE (mat.mat_id = gpo.mat_id)
GROUP BY mat_clave, mat_nombre;

--Consulta que obtiene los grupos que estén inscritos con menos de 5 alumnos
SELECT gpo_nombre, gpo_clave, mat_nombre, mat_clave, COUNT(*) AS Alumnos
FROM grupos AS gpo, materias AS mat, inscripciones  AS insc 
WHERE (gpo.gpo_id = mat.mat_id)
AND (gpo.gpo_id = insc.gpo_id)
GROUP BY gpo_nombre, gpo_clave, mat_nombre, mat_clave
HAVING (COUNT(*) < 5)

--Consulta que obtiene los alumnos que están inscritos en 7 o más materias
SELECT alu_nctrl, alu_nombre, COUNT(*) AS Materias
FROM alumnos AS alu, grupos AS gpo, inscripciones AS insc
WHERE (alu.alu_id = insc.alu_id)
AND (gpo.gpo_id = insc.gpo_id)
GROUP BY alu_nctrl, alu_nombre
HAVING (COUNT(*) >= 7);


--Consultas con ORDER BY

--Consulta que muestra toda la información de los alumnos ordenada alfabeticamente por nombre
SELECT * 
FROM alumnos 
ORDER BY alu_nombre ASC;

--Consulta que muestra la clave y el nombre de los grupos ordenadas alfabeticamente por nombre
SELECT gpo_clave, gpo_nombre
FROM grupos 
ORDER BY gpo_nombre;

--Consulta que obtiene la información de los grupos que tienen horario en el día jueves ordenadas
--ascendentemente por la hora de inicio
SELECT gpo_clave, mat_nombre, hor_inicio AS 'hor_inicio Jueves', hor_fin AS 'hor_fin Jueves'
FROM grupos AS gpo, materias AS mat, horarios AS hor 
WHERE (gpo.mat_id = mat.mat_id)
AND (gpo.gpo_id = hor.gpo_id)
AND (hor.hor_dia = 'Jueves')
ORDER BY hor_inicio;

--Consulta que muestra el numero de control y nombres de los alumnos 
--inscritos al grupo de AL-M ordenado alfabéticamente mediante el nombre del alumno
SELECT alu_nctrl, alu_nombre 
FROM alumnos AS alu,  grupos AS gpo, inscripciones AS insc
WHERE (alu.alu_id = insc.alu_id)
AND (insc.gpo_id = gpo.gpo_id)
AND (gpo.gpo_nombre = 'AL-M')
ORDER BY alu_nombre;

--Consulta que obtiene la cantidad de inscripciones que hay en cada alumno 
--ordenada del que tiene mayor a menor inscripciones
SELECT alu_nctrl, alu_nombre, COUNT(*) AS inscripciones
FROM alumnos AS alu, inscripciones AS insc 
WHERE (alu.alu_id = insc.alu_id)
GROUP BY alu_nctrl, alu_nombre
ORDER BY inscripciones DESC;

--Consulta que muestra información del grupo y nombre de la materia en las que 
--el grupo está lleno (considerando que un grupo está lleno cuando tiene 35 inscritos)
--ordenada alfabeticamente por el nombre de la materia
SELECT gpo_clave, gpo_nombre, mat_nombre
FROM grupos AS gpo, materias AS mat, inscripciones AS insc
WHERE (gpo.gpo_id = insc.gpo_id)
AND (mat.mat_id = gpo.mat_id)
GROUP BY gpo_clave, gpo_nombre, mat_nombre
HAVING (COUNT(*) = 35)
ORDER BY mat_nombre ASC;

--Consulta que obtiene la cantidad de grupos por materia ordenada 
--alfabéticamente (A - Z) por el nombre de la materia
SELECT mat_clave AS Materia, mat_nombre AS Nombre, COUNT(*) AS Grupos
FROM materias AS mat, grupos AS gpo 
WHERE (mat.mat_id = gpo.mat_id)
GROUP BY mat_clave, mat_nombre
ORDER BY mat_nombre;

--Consulta que obtiene los alumnos que están inscritos en 5 o menos materias
--ordenados alfabéticamente por el nombre
SELECT alu_nctrl, alu_nombre, COUNT(*) AS Materias
FROM alumnos AS alu, grupos AS gpo, inscripciones AS insc
WHERE (alu.alu_id = insc.alu_id)
AND (gpo.gpo_id = insc.gpo_id)
GROUP BY alu_nctrl, alu_nombre
HAVING (COUNT(*) <= 5)
ORDER BY alu_nombre ASC;

--Consulta que obtiene los grupos que están inscrito menos de 15 alumnos 
--ordenadas alfabeticamente por el nombre
SELECT gpo_clave, mat_nombre, COUNT(*) AS Alumnos
FROM grupos AS gpo, materias AS mat, inscripciones AS insc 
WHERE (gpo.gpo_id = insc.gpo_id)
AND (gpo.mat_id = mat.mat_id)
GROUP BY gpo_clave, mat_nombre
HAVING (COUNT(*) < 15)
ORDER BY mat_nombre;

--Consulta que obtiene información de las materias que tienen 3 grupos ordenadas 
--alfabeticamente por nombre
SELECT mat_clave, mat_nombre
FROM materias AS mat, grupos AS gpo
WHERE (mat.mat_id = gpo.mat_id)
GROUP BY mat_clave, mat_nombre
HAVING (COUNT(*) = 3)
ORDER BY mat_nombre;



SELECT TOP 5 gpo_nombre, gpo_clave, mat_nombre, mat_clave, COUNT(*) AS Alumnos
FROM grupos AS gpo, materias AS mat, inscripciones  AS insc 
WHERE (gpo.gpo_id = mat.mat_id)
AND (gpo.gpo_id = insc.gpo_id)
GROUP BY gpo_nombre, gpo_clave, mat_nombre, mat_clave
HAVING (COUNT(*) < 5)
ORDER BY Alumnos DESC;

-- Solo funciona en MySQL
/* SELECT gpo_nombre, gpo_clave, mat_nombre, mat_clave, COUNT(*) AS Alumnos
FROM grupos AS gpo, materias AS mat, inscripciones  AS insc 
WHERE (gpo.gpo_id = mat.mat_id)
AND (gpo.gpo_id = insc.gpo_id)
GROUP BY gpo_nombre, gpo_clave, mat_nombre, mat_clave
HAVING (COUNT(*) < 5)
ORDER BY Alumnos DESC
LIMIT 0, 5; */

--Obtener la fecha local
SELECT GETDATE()

--Obtener la fecha local con el  meridiano de Greenwich
SELECT DATEADD(hour, -6, GETDATE()) 

--
SELECT *
FROM inscripciones AS insc 
INNER JOIN alumnos AS alu ON (insc.alu_id = alu.alu_id)
INNER JOIN grupos AS gpo ON (insc.gpo_id = gpo.gpo_id)
INNER JOIN materias AS mat ON (gpo.mat_id = mat.mat_id)
ORDER BY mat_nombre ASC, gpo_nombre ASC, alu_nctrl ASC;

--
SELECT * 
FROM inscripciones AS insc, alumnos AS alu, grupos AS gpo, materias AS mat 
WHERE (insc.alu_id = alu.alu_id)
AND (insc.gpo_id = gpo.gpo_id)
AND (gpo.mat_id = mat.mat_id)
ORDER BY mat_nombre ASC, gpo_nombre ASC, alu_nctrl ASC;

/*
Se obtienen los alumnos y sus grupos en los que están inscritos,
indicando la materia e incluyendo todos los grupos aunque estén vacíos
*/
SELECT *
FROM inscripciones AS insc 
LEFT OUTER JOIN alumnos AS alu ON (alu.alu_id = insc.alu_id)
RIGHT OUTER JOIN grupos AS gpo ON (insc.gpo_id = gpo.gpo_id)
INNER JOIN materias AS mat ON (gpo.mat_id = mat.mat_id)
ORDER BY mat_nombre ASC, gpo_nombre ASC, alu_nctrl ASC;


/*
Obtener los alumnos con sus grupos y materias a los que están inscritos,
incluyendo los alumnos que no se inscribieron, pero omitiendo los grupos
que no tienen alumnos
*/
SELECT *
FROM inscripciones AS insc 
RIGHT OUTER JOIN alumnos AS alu ON (alu.alu_id = insc.alu_id)
LEFT OUTER JOIN grupos AS gpo ON (insc.gpo_id = gpo.gpo_id)
LEFT OUTER JOIN materias AS mat ON (gpo.mat_id = mat.mat_id)
ORDER BY mat_nombre ASC, gpo_nombre ASC, alu_nctrl ASC;


--Seleccionar la información de cada tabla
SELECT * from alumnos
SELECT * from materias
SELECT * from grupos
SELECT * from inscripciones
SELECT * from horarios