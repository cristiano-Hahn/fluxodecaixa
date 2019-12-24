create table lancamento_item (
	lai_id          uuid not null,
	lai_lan_id		uuid,
	lai_pro_id		uuid not null,
	lai_quantidade	numeric(15,2)  not null,
	constraint fk_lai_lan_id foreign key (lai_lan_id) references lancamento(lan_id) on delete cascade,
	constraint fk_lai_pro_id foreign key (lai_pro_id) references produto(pro_id),
	constraint pk_lancamento_item primary key (lai_id)
);