--Creacion de la base de datos
CREATE DATABASE miBD18131209

--Poner en uso la base de datos
USE miBD18131209

CREATE TABLE Estudiante
(
est_ID INT (10) IDENTITY PRIMARY KEY,
est_Nombres VARCHAR(255) NOT NULL,
est_Apellidos VARCHAR(255) NOT NULL,
est_Telefono VARCHAR(255) NOT NULL
)

CREATE TABLE Departamento
(
dept_Nombre VARCHAR(255) PRIMARY KEY,
dept_Ubicacion VARCHAR(255) NOT NULL
)

CREATE TABLE Instructor
(
inst_ID INT (10) IDENTITY PRIMARY KEY,
inst_Nombres VARCHAR(255) NOT NULL,
inst_Apellidos VARCHAR(255) NOT NULL,
inst_Telefono VARCHAR(255) NOT NULL,
dept_Nombre VARCHAR(255) NOT NULL CONSTRAINT dept_Nombre_inst FOREIGN KEY REFERENCES Departamento(dept_Nombre),
inst_jefe VARCHAR(255) NOT NULL CONSTRAINT dept_jefe_inst FOREIGN KEY REFERENCES Departamento(dept_Nombre) 

)

CREATE TABLE Curso
(
cur_ID INT(10) IDENTITY PRIMARY KEY,
cur_Nombre VARCHAR(255) NOT NULL,
cur_Duracion INT(10) NOT NULL,
dept_nombre VARCHAR(255) NOT NULL CONSTRAINT dept_Nombre_cur FOREIGN KEY REFERENCES Departamento(dept_Nombre),
inst_ID INT(10) NOT NULL CONSTRAINT inst_ID_cur FOREIGN KEY REFERENCES Instructor(inst_ID)
)

CREATE TABLE Curso_Estudiante
(
cur_ID INT(10) IDENTITY PRIMARY KEY CONSTRAINT cur_ID_cur FOREIGN KEY REFERENCES Curso(cur_ID), 
est_ID INT (10) IDENTITY PRIMARY KEY CONSTRAINT est_ID_est FOREIGN KEY REFERENCES Estudiante(est_ID)
)


--Otra manera de hacerlo

ALTER TABLE Instructor
ADD CONSTRAINT Departmentfk FOREIGN KEY (dept_Nombre) REFERENCES Departamento(dept_Nombre);

ALTER TABLE Instructor
ADD CONSTRAINT DeptHeadedFk FOREIGN KEY (inst_jefe) REFERENCES Departamento(dept_Nombre);

ALTER TABLE Curso
ADD CONSTRAINT DepartmentFk2 FOREIGN KEY (dept_Nombre) REFERENCES Departamento(dept_Nombre);

ALTER TABLE Curso 
ADD CONSTRAINT InstrFk FOREIGN KEY (inst_ID) REFERENCES Instructor(inst_ID);

ALTER TABLE Curso_Estudiante
ADD CONSTRAINT CourseFk FOREIGN KEY (cur_ID) REFERENCES Curso(cur_ID);

ALTER TABLE Curso_Estudiante
ADD CONSTRAINT StudentFk FOREIGN KEY (est_ID) REFERENCES Estudiante(est_ID);

