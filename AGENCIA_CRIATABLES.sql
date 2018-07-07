-- DEFINE O BANCO DE DADOS "AGENCIA"
CREATE SCHEMA AGENCIA;
USE AGENCIA;

-- COMMANDOS DE SQL DDL PARA CRIAÇÃO DAS TABELAS

CREATE TABLE pessoa (
	cod int not null auto_increment,
	nome    varchar(100) not null, 
	dt_nasc date,
	sexo      enum ('M', 'F'),
	fone   varchar(15),
    foto blob,
    cep varchar(10) , #da relacao
    num int, #da relacao
	primary key (cod),
    foreign key (cep) references endereco(cep)
);

create table endereco(

cep varchar(10) not null,
estado varchar(2),
predio varchar(10),
complemento varchar (20),
cidade varchar(20),
primary key (cep)

);

create table agencia(

CNPJ char (18) not null,
nome_fantasia varchar(50),
cep varchar(10) , #da relacao
num int, #da relacao
primary key (CNPJ),
foreign key (cep) references endereco(cep)
);

create table funcionario(
salario decimal(10,2), 
ramal int,
cpf char(9) not null,
cod int not null, #da hierarquia
tipo int not null, #tipo do funcionario
primary key(cpf, cod),
foreign key (cod) references pessoa(cod)
);


create table trabalha_para(
cpf char(9) not null,
CNPJ char (18) not null,

primary key (cpf, CNPJ),
foreign key (agencia) references agencia(CNPJ),
foreign key (cpf) references funcionario(cpf)
);

create table cliente( 
cod int not null, #da hierarquia
agencia char (18),

primary key(cod),
foreign key (agencia) references agencia(CNPJ),
foreign key (cod) references pessoa(cod)

);

create table cliente_juridico( 
cod int not null, #da hierarquia
agencia char (18),
CNPJ char (18), 
nome_fantasia varchar(50),

primary key(cod),
foreign key (agencia) references agencia(CNPJ),
foreign key (cod) references pessoa(cod)

);

create table cliente_recebe_malaDireta(

codcliente int not null,
codmala int not null, 

primary key(codcliente, codmala),
foreign key(codcliente) references cliente(cod),
foreign key(codmala) references malaDireta(codigo)
);
create table passaporte(
numero varchar(10) not null unique, 
pais_emissao varchar(50),
validade date,
dt_emissao date, 
codcliente int not null,

primary key(numero, codcliente),
foreign key(codcliente) references cliente(cod)
);

create table visto(
controlnumber varchar(10) not null unique,
numeroPass varchar(10) not null unique,
tipo int, 
pais varchar(50),
dt_inicio date, 
dt_fim date, 
codcliente int not null, 


primary key(controlnumber, numeroPass, codcliente),
foreign key(codcliente) references cliente(cod),
foreign key(numeroPass) references passaporte(numero)
);

create table malaDireta(
codigo int not null auto_increment,
texto varchar(300),
dt_criacao date,
dt_envio date,

primary key (codigo)
);

create table arquivo_pdf(
codmala int not null,
arquivo varbinary(80000),

primary key (codmala, arquivo),
foreign key(codmala) references malaDireta(codigo)
);

create table pacote(

);

create table item_pacote(

);

create table fatura(

);

create table pagamento(

);

create table servico_ref(

);

create table promocao(

);

create table nivel_servico(

);

create table intercambio(

);

create table acomodacao(

);

create table evento(

);

create table transporte(

);

create table servico_proprio(

);

create table servico_parceiro(

);

create table parceiro(

);


