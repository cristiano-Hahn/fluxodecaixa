create table categoria (
	cat_id          	uuid not null,
	cat_emp_id			uuid not null,
	cat_codigo    		int not null,
	cat_descricao		varchar(100) not null,
	constraint pk_categoria primary key (cat_id),
	constraint fk_cat_emp_id foreign key (cat_emp_id) references empresa(emp_id)
)
