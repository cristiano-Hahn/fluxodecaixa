create table usuario (
	usu_id          uuid not null,
	usu_emp_id		uuid not null,
	usu_email       varchar(255) not null,
	usu_senha       varchar(255) not null,
	usu_ativo       bool null,
	constraint pk_usuario primary key (usu_id),
	constraint fk_usu_emp_id foreign key (usu_emp_id) references empresa(emp_id),
	constraint usu_usuario unique (usu_email)
);