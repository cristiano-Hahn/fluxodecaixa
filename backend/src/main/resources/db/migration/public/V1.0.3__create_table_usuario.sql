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

--password: trg5wt5m
INSERT INTO usuario (usu_id, usu_emp_id, usu_email, usu_senha, usu_ativo) VALUES('7d0c147c-f5b9-11e9-802a-5aa538984bd8', '301af140-8518-43b9-a4eb-b46afefda395', 'admin@admin.com', '$2a$11$Pfuoi8guDxxHhuYycD1v9O3b0RtujsbHA.aXXGCJOXEffY089ZlCi', true);
