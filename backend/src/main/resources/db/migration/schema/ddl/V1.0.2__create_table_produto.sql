create table produto (
	pro_id          		uuid not null,
	pro_und_id				uuid,
	pro_cat_id				uuid,
	pro_codigo    			serial not null,
	pro_nome				varchar(100) not null,
	pro_preco_custo    		numeric(15,2) not null,
	pro_preco_venda    		numeric(15,2) not null,
	pro_margem_lucro        numeric(15,4) not null,
	pro_observacao          varchar(1000),
	constraint pk_produto primary key (pro_id),
	constraint fk_pro_und_id foreign key (pro_und_id) references unidade_medida(und_id),
	constraint fk_pro_cat_id foreign key (pro_cat_id) references categoria(cat_id),
	constraint uk_pro_codigo unique (pro_codigo)
);