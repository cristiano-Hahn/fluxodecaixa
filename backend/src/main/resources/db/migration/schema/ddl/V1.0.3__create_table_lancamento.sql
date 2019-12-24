create table lancamento (
	lan_id          			uuid not null,
	lan_data					timestamp without time zone not null,
	lan_data_pagamento			timestamp without time zone,
	lan_meio_pagamento			varchar(50) not null,
	lan_tipo 					varchar(50) not null,
	lan_valor					numeric(15,2) not null,
	lan_observacao				varchar(500),
	constraint pk_lancamento   	primary key (lan_id)
);