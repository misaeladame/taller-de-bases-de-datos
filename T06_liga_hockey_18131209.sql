--Script para crear la base de datos liga_hockey 
--Materia Taller de Base de Datos 
--Fecha de creacion 04/03/20
--Autor: José Misael Adame Sandoval 18131209
--Lugar: Torreon, Coahuila 

--Crear la base de datos
CREATE DATABASE liga_hockey;

--Poner en uso la base de Datos
USE liga_hockey;

--Crear la tabla equipo
CREATE TABLE equipo 
(
    eq_id INT IDENTITY NOT NULL,
    eq_nombre VARCHAR(255) NOT NULL,
    eq_ciudad VARCHAR(150) NOT NULL,
    eq_entrenador VARCHAR(255) NULL,
    jug_id_capitan INT NULL,
    PRIMARY KEY (eq_id)
);

--Crear la tabla jugador
CREATE TABLE jugador 
(
    jug_id INT IDENTITY NOT NULL,
    eq_id INT NOT NULL,
    jug_nombre VARCHAR(255) NOT NULL,
    jug_posicion VARCHAR(2) NOT NULL,
    jug_nivel_de_habilidad TINYINT NOT NULL,
    PRIMARY KEY (jug_id)
);

--Crear la tabla juego
CREATE TABLE juego
(
    jue_id INT IDENTITY NOT NULL,
    eq_id_local INT NOT NULL,
    eq_id_visitante INT NOT NULL,
    jue_marcador_equipo_local INT NOT NULL,
    jue_marcador_equipo_visitante INT NOT NULL,
    jue_fecha DATETIME NOT NULL,
    PRIMARY KEY (jue_id)
);

--Crear la tabla registro_de_lesiones
CREATE TABLE registro_de_lesiones 
(
    reg_id INT IDENTITY NOT NULL,
    jug_id INT NOT NULL,
    reg_descripcion_incidente VARCHAR(255) NOT NULL,
    reg_descripcion_lesion VARCHAR(255) NOT NULL,
    PRIMARY KEY (reg_id)
);

--Crear constraint para que sea unico eq_nombre en la tabla equipo
ALTER TABLE equipo 
ADD UNIQUE (eq_nombre);

/*Crear constraint para referenciar el jug_id de la tabla jugador en 
  jug_id_capitan de la tabla equipo*/
ALTER TABLE equipo
ADD CONSTRAINT jugfk_id_capitan_eq
FOREIGN KEY (jug_id_capitan)
REFERENCES jugador (jug_id);

--Crear constraint para referenciar el eq_id de la tabla equipo en la tabla jugador
ALTER TABLE jugador
ADD CONSTRAINT eqfk_id_jug
FOREIGN KEY (eq_id)
REFERENCES equipo (eq_id)

--Crear constraints para validar jug_posicion y jug_habilidad de la tabla jugador
ALTER TABLE jugador
ADD CONSTRAINT chck_jug_posicion
CHECK 
( 
    jug_posicion IN ('G', 'C', 'LW', 'D', 'RW')
) 

ALTER TABLE jugador
ADD CONSTRAINT chck_jug_nivel_de_habilidad
CHECK 
( 
    jug_nivel_de_habilidad >= 1 AND jug_nivel_de_habilidad <= 6
) 

/*Crear constraint para referenciar el eq_id de la tabla equipo en 
  eq_id_local de la tabla juego*/
ALTER TABLE juego
ADD CONSTRAINT eqfk_id_local_jue
FOREIGN KEY (eq_id_local)
REFERENCES equipo (eq_id)

/*Crear constraint para referenciar el eq_id de la tabla equipo en 
  eq_id_visitante de la tabla juego*/
ALTER TABLE juego
ADD CONSTRAINT eqfk_id_visitante_jue
FOREIGN KEY (eq_id_visitante)
REFERENCES equipo (eq_id)

--Crear constraint para referenciar el jug_id de la tabla jugador en la tabla registro_de_lesiones
ALTER TABLE registro_de_lesiones
ADD CONSTRAINT jugfk_id_reg
FOREIGN KEY (jug_id)
REFERENCES jugador (jug_id)

--Crear un índice único de eq_nombre de la tabla equipo
CREATE UNIQUE NONCLUSTERED INDEX eq_nombre_idx
ON equipo (eq_nombre ASC)

--Crear un índice de eq_id_local de la tabla juego
CREATE NONCLUSTERED INDEX eq_id_local_idx
ON juego (eq_id_local ASC)

--Crear un índice de eq_id_visitante de la tabla juego
CREATE NONCLUSTERED INDEX eq_id_visitante_idx
ON juego (eq_id_visitante ASC)

--Crear un índice de jug_nombre de la tabla jugador
CREATE NONCLUSTERED INDEX jug_nombre_idx
ON jugador (jug_nombre ASC);

--Crear un índice de jug_id de la tabla registro_de_lesiones
CREATE NONCLUSTERED INDEX jug_id_idx 
ON registro_de_lesiones (jug_id ASC); 

--Insertar información en la tabla equipo (sin el capitán)
INSERT INTO equipo 
(
    eq_nombre, eq_ciudad, eq_entrenador
)
VALUES 
(
    'Saint Louis Blues', 'Saint Louis, Missouri, USA', 'Creig Berube'
),
(
    'Montreal Canadiens', 'Montreal, Quebec, CAN', 'Claudie Julien'
),
(
    'Toronto Maple Leafs', 'Toronto, Ontrario, CAN', 'Sheldon Keefe'
);

--Insertar información en la tabla jugador del equipo 1
INSERT INTO jugador 
(
    eq_id, jug_nombre, jug_posicion, jug_nivel_de_habilidad
)
VALUES 
(
    1, 'Jake Allen', 'G', 6
),
(
    1, 'Ivan Barbashev', 'C', 6
),
(
    1, 'Sammy Blais', 'LW', 6
),
(
    1, 'Tyler Bozak', 'C', 6
),
(
    1, 'Troy Brouwer', 'RW', 5
),
(
    1, 'Vince Dunn', 'D', 6
),
(
    1, 'Justin Faulk', 'D', 4
),
(
    1, 'Ryan O''Reilly', 'C', 5
),
(
    1, 'Alex Pietrangelo', 'D', 6
),
(
    1, 'Marco Scandella', 'D', 6
)

--Insertar información en la tabla jugador del equipo 2
INSERT INTO jugador 
(
    eq_id, jug_nombre, jug_posicion, jug_nivel_de_habilidad
)
VALUES 
(
    2, 'Karl Alzner', 'D', 6
),
(
    2, 'Joel Armia', 'RW', 6
),
(
    2, 'Paul Byron', 'LW', 5
),
(
    2, 'Ben Chiarot', 'D', 6
),
(
    2, 'Phillip Danault', 'C', 6 
),
(
    2, 'Max Domi', 'C', 6
),
(
    2, 'Christian Folin', 'D', 6
),
(
    2, 'Tomas Tatar', 'LW', 6
),
(
    2, 'Jordan Weal', 'C', 6
),
(
    2, 'Shea Weber', 'D', 6
)

--Insertar información en la tabla jugador del equipo 3
INSERT INTO jugador 
(
    eq_id, jug_nombre, jug_posicion, jug_nivel_de_habilidad
)
VALUES 
(
    3, 'Frederik Andersen', 'G', 4
),
(
    3, 'Tyson Barrie', 'D', 5
),
(
    3, 'Jack Campbell', 'G', 6
),
(
    3, 'Cody Ceci', 'D', 5
),
(
    3, 'Zach Hyman', 'LW', 6 
),
(
    3, 'Kasperi Kapanen', 'RW', 6
),
(
    3, 'Alexander Kerfoot', 'C', 6
),
(
    3, 'Rasmus Sandin', 'D', 5
),
(
    3, 'Jason Spezza', 'C', 6
),
(
    3, 'John Tavares', 'C', 6
)

--Insertar el capitán en la tabla equipo porque ya hay jugadores registrados
UPDATE equipo
SET jug_id_capitan = 
(
    SELECT jug_id FROM jugador 
    WHERE jug_nombre = 'Alex Pietrangelo'
)
WHERE eq_nombre = 'Saint Louis Blues' 	

UPDATE equipo
SET jug_id_capitan = 
(
    SELECT jug_id FROM jugador
    WHERE jug_nombre = 'Shea Weber'
) 
WHERE eq_nombre = 'Montreal Canadiens'

UPDATE equipo
SET jug_id_capitan = 
(
    SELECT jug_id FROM jugador
    WHERE jug_nombre = 'John Tavares'
)
WHERE eq_nombre = 'Toronto Maple Leafs'

--Insertar información en la tabla juego
INSERT INTO juego 
(
    eq_id_local, eq_id_visitante, jue_marcador_equipo_local, jue_marcador_equipo_visitante, jue_fecha
)
VALUES
(
    1, 2, 5, 2, '2020-02-01 09:00:00 PM'
),
(
    1, 3, 4, 6, '2020-02-08 10:00:00 PM'
),
(
    2, 1, 2, 0, '2020-02-15 06:00:00 PM'
),
(
    2, 3, 1, 1, '2020-02-22 08:00:00 PM'
),
(
    3, 1, 3, 4, '2020-02-29 07:45:00 PM'
),
(
    3, 2, 1, 0, '2020-03-08 12:00:00 PM'
)

--Insertar información en la tabla registro_de_lesiones
INSERT INTO registro_de_lesiones
(
    jug_id, reg_descripcion_incidente, reg_descripcion_lesion
)
VALUES
(
    2, 'Sufrió una barrida fuerte del jugador contrincante Cody Ceci en el juego de St Louis vs Toronto', 'Fractura del Tobillo'
),
(
    7, 'Cayó mal en el juego de St Louis vs Montreal', 'Fractura de muñeca'
),
(
    9, 'Fue sorprendido con una barrida del jugador Frederik Andersen en el juego de St Louis vs Toronto', 'Dislocación de rodilla'
),
(
    13, 'Chocó con su nariz al jugador de su propio equipo Jordan Weal en el juego Montreal vs Toronto', 'Fractura de Nariz'
),
(
    15, 'Sufrió una agresión del jugador Tyler Bozar en el juego Montreal vs St Louis', 'Esguince en el rodilla'
),
(
    16, 'Tuvo una mala caída en el juego de Montreal vs St. Louis', 'Lesión de ligamento cruzado en la rodilla'
),
(
    21, 'Sufrió un aparatoso choque en la portería en el juego de Toronto vs Montreal', 'Fractura del dedo meñique'
),
(
    29, 'Durante en el entrenamiento cayó mal', 'Contractura en el cuello'
),
(
    30, 'En una jugada intensa, chocó contra su propio compañero de equipo Rasmus Sandin', 'Esguince agudo de tobillo'
)

--Actualización de jugadores del equipo 1 a los equipos 2 y 3
UPDATE jugador
SET eq_id = 2
WHERE jug_nombre = 'Jake Allen'

UPDATE jugador
SET eq_id = 2
WHERE jug_nombre = 'Sammy Blais'

UPDATE jugador
SET eq_id = 2
WHERE jug_nombre = 'Troy Brouwer'

UPDATE jugador
SET eq_id = 2
WHERE jug_nombre = 'Justin Faulk'

UPDATE jugador
SET eq_id = 2
WHERE jug_nombre = 'Alex Pietrangelo'

UPDATE jugador
SET eq_id = 3
WHERE jug_nombre = 'Ivan Barbashev'

UPDATE jugador
SET eq_id = 3
WHERE jug_nombre = 'Tyler Bozak'

UPDATE jugador
SET eq_id = 3 
WHERE jug_nombre = 'Vince Dunn'

UPDATE jugador
SET eq_id = 3
WHERE jug_nombre = 'Ryan O''Reilly'

UPDATE jugador
SET eq_id = 3
WHERE jug_nombre = 'Marco Scandella'

--Actualización de jugadores del equipo 2 a los equipos 1 y 3
UPDATE jugador
SET eq_id = 1
WHERE jug_nombre = 'Karl Alzner'

UPDATE jugador
SET eq_id = 1
WHERE jug_nombre = 'Joel Armia'

UPDATE jugador
SET eq_id = 1
WHERE jug_nombre = 'Paul Byron'

UPDATE jugador
SET eq_id = 1
WHERE jug_nombre = 'Ben Chiarot'

UPDATE jugador
SET eq_id = 1
WHERE jug_nombre = 'Phillip Danault'

UPDATE jugador
SET eq_id = 3
WHERE jug_nombre = 'Max Domi'

UPDATE jugador
SET eq_id = 3
WHERE jug_nombre = 'Christian Folin'

UPDATE jugador
SET eq_id = 3
WHERE jug_nombre = 'Tomas Tatar'

UPDATE jugador
SET eq_id = 3
WHERE jug_nombre = 'Jordan Weal'

UPDATE jugador
SET eq_id = 3
WHERE jug_nombre = 'Shea Weber'

--Actualización de jugadores del equipo 3 a los equipos 1 y 2
UPDATE jugador
SET eq_id = 1
WHERE jug_nombre = 'Frederik Andersen'

UPDATE jugador
SET eq_id = 1
WHERE jug_nombre = 'Cody Ceci'

UPDATE jugador
SET eq_id = 1
WHERE jug_nombre = 'Rasmus Sandin'

UPDATE jugador
SET eq_id = 1
WHERE jug_nombre = 'Jason Spezza'

UPDATE jugador
SET eq_id = 1
WHERE jug_nombre = 'John Tavares'

UPDATE jugador
SET eq_id = 2
WHERE jug_nombre = 'Tyson Barrie'

UPDATE jugador
SET eq_id = 2
WHERE jug_nombre = 'Jack Campbell'

UPDATE jugador
SET eq_id = 2
WHERE jug_nombre = 'Zach Hyman'

UPDATE jugador
SET eq_id = 2
WHERE jug_nombre = 'Kasperi Kapanen'

UPDATE jugador
SET eq_id = 2
WHERE jug_nombre = 'Alexander Kerfoot'

--Los capitanes se cambiaron de equipo, entonces cada equipo 
--tiene un nuevo capitán 
UPDATE equipo
SET jug_id_capitan = 
(
    SELECT jug_id FROM jugador 
    WHERE jug_nombre = 'John Tavares'
)
WHERE eq_nombre = 'Saint Louis Blues' 	

UPDATE equipo
SET jug_id_capitan = 
(
    SELECT jug_id FROM jugador
    WHERE jug_nombre = 'Alex Pietrangelo'
) 
WHERE eq_nombre = 'Montreal Canadiens'

UPDATE equipo
SET jug_id_capitan = 
(
    SELECT jug_id FROM jugador
    WHERE jug_nombre = 'Shea Weber'
)
WHERE eq_nombre = 'Toronto Maple Leafs'






