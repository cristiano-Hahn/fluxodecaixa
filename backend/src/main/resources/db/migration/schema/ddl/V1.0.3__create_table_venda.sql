create table venda (
	vnd_id          		uuid not null,
	vnd_data				timestamp without time zone not null,
	vnd_meio_pagamento		varchar(50) not null,
	vnd_descricao			varchar(500),
	constraint pk_venda     primary key (vnd_id)
);