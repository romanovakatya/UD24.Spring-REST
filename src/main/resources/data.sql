DROP table IF EXISTS empleado;

create table empleado(
	id int auto_increment,
	nombre varchar(250),
	trabajo varchar(250),
	salario integer,
    create_date date,
    PRIMARY KEY(id)
);

insert into empleado(nombre, trabajo, salario, create_date) values('Black Jack', 'director', 6000, NOW());
insert into empleado(nombre, trabajo, salario, create_date) values('Juan Molde', 'programador', 3000, NOW());
insert into empleado(nombre, trabajo, salario, create_date) values('Pedro Suarez', 'RRHH', 2000, NOW());
insert into empleado(nombre, trabajo, salario, create_date) values('Pau Martinez', 'administrador', 1600, NOW());
insert into empleado(nombre, trabajo, salario, create_date) values('Maria Cielo', 'vendedor', 1300, NOW());