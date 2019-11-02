create table unidade_medida (
	und_id          	uuid not null,
	und_emp_id			uuid not null,
	und_codigo    		int not null,
	und_descricao		varchar(100) not null,
	constraint pk_unidade_medida primary key (und_id),
	constraint fk_und_emp_id foreign key (und_emp_id) references empresa(emp_id)
)