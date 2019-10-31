create table empresa (
	emp_id          	uuid not null,
	emp_razao_social    varchar(255) not null,
	emp_inscricao		varchar(14) not null,
	emp_email    		varchar(255) not null,
	emp_endereco    	varchar(255) not null,
	emp_telefone    	varchar(255) not null,
	emp_ativa     		bool,
	constraint pk_empresa primary key (emp_id)
);
