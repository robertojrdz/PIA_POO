create table estrategas (
	numEmpleado int primary key,
	nombre varchar(60),
	edad int,
	salario float
);

create table ingenieros (
	numEmpleado int primary key,
	nombre varchar(60),
	edad int,
	salario float,
	departamento varchar(20)
);

create table mecanicos (
	numEmpleado int primary key,
	nombre varchar(60),
	edad int,
	salario float,
	seccion varchar(20)
);

create table mercadologos (
	numEmpleado int primary key,
	nombre varchar(60),
	edad int,
	salario float,
	area varchar(20)
);

create table pilotos (
	numEmpleado int primary key,
	nombre varchar(60),
	edad int,
	salario float,
	numPiloto int,
	victorias int,
	nacionalidad varchar(20)
);