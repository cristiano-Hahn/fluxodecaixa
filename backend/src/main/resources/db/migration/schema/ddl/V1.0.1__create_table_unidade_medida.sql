create table unidade_medida (
	und_id          	uuid not null,
	und_sigla			varchar (3) not null,
	und_codigo    		int not null,
	und_descricao		varchar(100) not null,
	constraint pk_unidade_medida primary key (und_id)
)