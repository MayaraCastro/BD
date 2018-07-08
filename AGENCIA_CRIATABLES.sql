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

CREATE TABLE agente(
cpf char(9) not null,
cod int not null,
PRIMARY KEY(cpf,cod),
FOREIGN KEY(cpf,cod) REFERENCES funcionario(cpf,cod)
);

CREATE TABLE motorista(
cpf char(9) not null,
cod int not null,
PRIMARY KEY(cpf,cod),
FOREIGN KEY(cpf,cod) REFERENCES funcionario(cpf,cod)
);

CREATE TABLE guia(
cpf char(9) not null,
cod int not null,
PRIMARY KEY(cpf,cod),
FOREIGN KEY(cpf,cod) REFERENCES funcionario(cpf,cod)
);

CREATE TABLE compra(
status int,
dt_compra date not null, 
cod_pacote int not null unique, 
cpf_agente char(9) not null,
cod_agente int not null,  
cod_cliente int not null, 

PRIMARY KEY(cpf_agente,cod_agente, cod_cliente,cod_pacote, dt_compra),
FOREIGN KEY(cod_cliente) REFERENCES cliente(cod), 
FOREIGN KEY(cpf_agente,cod_agente) REFERENCES agente(cpf,cod),
FOREIGN KEY(cod_pacote) REFERENCES pacote(codigo)
);

create table trabalha_para(
cpf char(9) not null,
CNPJ char (18) not null,
agencia char (18) not null, --faltou
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

create table arquivo_pdf( --error
codmala int not null,
arquivo varbinary(80000), --tamanho maximo 65535

primary key (codmala, arquivo),
foreign key(codmala) references malaDireta(codigo)
);

create table pacote(

codigo int not null unique,
total_a_pagar decimal(10,2),
vl_total decimal(10,2), 
vl_desconto decimal(10,2), 
datafim date,
datainicio date,
indicadorReserva int,
tipo int not null,
n_criancas int,
n_adultos int,

primary key(codigo) 
);

create table item_pacote(
codservico int not null, 
codpacote int not null, 
id_sk int not null unique auto_increment,
dt date,
vl_unitario decimal(10,2),
qtd int, 
seq int,
vl_com_desconto decimal(10,2),

primary key(id_sk, codpacote, codservico),
foreign key(codpacote) references pacote(codigo),
foreign key (codservico) references servico_ref(codigo)
);

create table itens_fatura(
id int not null,
codservico int not null, 
codpacote int not null,
id_sk int not null,

primary key(id, id_sk, codpacote, codservico),
foreign key(id) references fatura(id),
foreign key(id_sk)references item_pacote(id_sk),
foreign key(codservico)references item_pacote(codservico),
foreign key(codpacote) references item_pacote(codpacote)
);

create table fatura(
id int not null unique auto_increment,
codpacote int ,

primary key(id),
foreign key(codpacote) references pacote(codigo)

);

create table pagamento(
codigo int not null unique auto_increment,
vl_pago decimal(10,2),
juros decimal(10,2),
dt_vence date,
dt_pag date,
codFatura int,
tipo int not null, #da hierarquia
cod_seg int,
numero_cartao varchar(20),
dt_validade date, 
tipoCartao int, 
nome_titular varchar(100),

primary key(codigo),
foreign key(codFatura) references fatura(id)
); 

CREATE TABLE boleto(
codigo int not null unique auto_increment,

primary key(codigo),
foreign key(codigo) references pagamento(codigo)

);

CREATE TABLE cheque(
codigo int not null unique auto_increment,

primary key(codigo),
foreign key(codigo) references pagamento(codigo)

);

CREATE TABLE cartao(
codigo int not null unique auto_increment,
cod_seg int not null unique,
numero_cart int not null unique,
dat_validade date not null,
tipo int not null,
nume_titu VARCHAR(100) not null,


primary key(codigo),
foreign key(codigo) references pagamento(codigo)
);

create table servico_ref(
codigo int not null unique auto_increment, 
valor decimal(10,2),
local_destino varchar(50),
nivel int,

primary key(codigo),
foreign key(nivel) references nivel_servico(codigo)
);

create table mapa_arquivo( --tamebm possui errro
codServico int not null, 
mapa varbinary(8000) not null,

primary key(mapa, codServico),
foreign key(codServico) references servico_ref(codigo)
);

create table promocao(
id int not null unique,
dt_fim date,
porcentagem_desconto double,
tipo int, 
dt_inicio date,
codservico int,

primary key(id),
foreign key(codservico)  references servico_ref(codigo)
);

create table nivel_servico(
codigo int not null unique,
nivel int, 
descr varchar(100),

primary key(codigo)
);

create table intercambio(
codigo int not null unique auto_increment, 
detalhe varchar(100),
obs varchar(100),


primary key(codigo),
foreign key(codigo)  references servico_ref(codigo)
);

create table trabalho(
codigo int not null unique auto_increment, 
dt_inicio date,
cargo varchar(100),
dt_fim date,

primary key(codigo),
foreign key(codigo)  references servico_ref(codigo)
);

create table estudo(
codigo int not null unique auto_increment, 
carga_horaria int,
lingua varchar(100),
nome_curso varchar(100),

primary key(codigo),
foreign key(codigo)  references servico_ref(codigo)
);

--ta pintado?
create table acomodacao(
codigo int not null unique auto_increment, 
descricao varchar(100),
data_entrada date,
dt_saida date,
capacidade_pessoas int,
fumante int,
no_estrelas int,
tipo varchar(100), 

primary key(codigo),
foreign key(codigo)  references servico_ref(codigo)
);

create table evento(
codigo int not null unique auto_increment, 
status varchar(100),
data_entrada date,
dt_fim date,
nome varchar(100),
detalhe varchar(100),
tipo int,
vl_desc varchar(100),
obs varchar(100), 
cpf char(9) not null,
cod int not null,


primary key(codigo),
foreign key(codigo)  references servico_ref(codigo),
FOREIGN KEY(cpf,cod) REFERENCES guia(cpf,cod)
);

create table transporte(
codigo int not null unique auto_increment, 
local_de_origem varchar(100),
data_ida date,
dt_volta date,
modalidade varchar(100),
marca varchar(100),
tipo int,
num_identificacao int,
capacidade_n_pessoas int,
cpf char(9) not null,
cod int not null,

primary key(codigo),
foreign key(codigo)  references servico_ref(codigo),
FOREIGN KEY(cpf,cod) REFERENCES motorista(cpf,cod)
);

create table servico_proprio(
codigo int not null unique auto_increment, 

primary key(codigo),
foreign key(codigo) references servico_ref(codigo)

);

create table servico_parceiro(
codigo int not null unique auto_increment, 

primary key(codigo),
foreign key(codigo) references servico_ref(codigo)

);

create table oferece(
codigo_servico int not null unique auto_increment, 
parceiro varchar(18) not null unique,
dt_inicio date,
dt_fim date,
percentual float,
no_contrato int,  -- derivado. nao sei oq fazer

primary key(codigo_servico, parceiro),
foreign key(codigo_servico) references servico_parceiro(codigo),
foreign key(parceiro) references parceiro(CNPJ)
);

create table parceiro(

CNPJ varchar(18) not null unique,
nome_fantasia varchar(50),
status int, 
tipo int, 
ramo varchar(10),

primary key(CNPJ)
);
