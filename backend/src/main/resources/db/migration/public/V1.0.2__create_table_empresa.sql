create table empresa (
	emp_id          	uuid not null,
	emp_razao_social    varchar(255) not null,
	emp_inscricao		varchar(14) not null,
	emp_email    		varchar(255) not null,
	emp_endereco    	varchar(255) not null,
	emp_telefone    	varchar(255) not null,
	emp_schema    	    varchar(255) not null,
	emp_ativa     		bool,
	emp_created         timestamp without time zone not null,
    emp_updated         timestamp without time zone,
    emp_version         bigint not null,
	constraint pk_empresa primary key (emp_id)
);

INSERT INTO empresa (emp_id, emp_razao_social, emp_inscricao, emp_email, emp_endereco, emp_telefone, emp_schema, emp_ativa, emp_created, emp_updated, emp_version) VALUES('301af140-8518-43b9-a4eb-b46afefda395', 'Empresa administração', '00000000000000', 'empresaadministracao@teste.com', 'teste', '49998341135','schema1', true, current_date, null, 0);
