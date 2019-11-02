create table categoria (
	cat_id          	uuid not null,
	cat_codigo    		int not null,
	cat_descricao		varchar(100) not null,
	constraint pk_categoria primary key (cat_id)
)
