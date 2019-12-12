create table venda_item (
	vni_id          uuid not null,
	vni_vnd_id		uuid,
	vni_pro_id		uuid not null,
	vni_quantidade	numeric(15,2)  not null,
	constraint fk_vni_vnd_id foreign key (vni_vnd_id) references venda(vnd_id) on delete cascade,
	constraint fk_vni_pro_id foreign key (vni_pro_id) references produto(pro_id),
	constraint pk_venda_item primary key (vni_id)
);
