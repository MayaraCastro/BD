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
logradouro varchar(50),
predio varchar(10),
complemento varchar (20),
cidade varchar(20),
primary key (cep)

);

create table agencia(

CNPJ char (18) not null,
nome_fantasia varchar(50),
cep varchar(10) null, #da relacao
num int, #da relacao
gerentecpf char(9) not null,
gerentecod int not null,  
datainicio date,

primary key (CNPJ),
foreign key (cep) references endereco(cep),
foreign key (cpf,cod) references gerente(cpf,cod)

);

create table guia(
salario decimal(10,2), 
ramal int,
cpf char(9) not null,
cod int not null, #da hierarquia

primary key(cpf, cod),
foreign key (cod) references pessoa(cod)
);


create table guia_trabalha_para(
cpf char(9) not null,
cod int not null,
CNPJ char (18) not null,

primary key (cpf, CNPJ,cod),
foreign key (agencia) references agencia(CNPJ),
foreign key (cpf, cod) references guia(cpf, cod)
);

create table motorista(
salario decimal(10,2), 
ramal int,
cpf char(9) not null,
cod int not null, #da hierarquia

primary key(cpf, cod),
foreign key (cod) references pessoa(cod)
);


create table motorista_trabalha_para(
cpf char(9) not null,
cod int not null,
CNPJ char (18) not null,

primary key (cpf, CNPJ,cod),
foreign key (agencia) references agencia(CNPJ),
foreign key (cpf,cod) references motorista(cpf,cod)
);

create table gerente(
salario decimal(10,2), 
ramal int,
cpf char(9) not null,
cod int not null, #da hierarquia

primary key(cpf, cod),
foreign key (cod) references pessoa(cod)
);


create table gerente_trabalha_para(
cpf char(9) not null,
cod int not null,
CNPJ char (18) not null,

primary key (cpf, CNPJ,cod),
foreign key (agencia) references agencia(CNPJ),
foreign key (cpf,cod) references gerente(cpf,cod)
);

create table agente(
salario decimal(10,2), 
ramal int,
cpf char(9) not null,
cod int not null, #da hierarquia

primary key(cpf, cod),
foreign key (cod) references pessoa(cod)
);

create table agente_trabalha_para(
cpf char(9) not null,
cod int not null,
CNPJ char (18) not null,

primary key (cpf, CNPJ,cod),
foreign key (agencia) references agencia(CNPJ),
foreign key (cpf,cod) references agente(cpf,cod)
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

create table clienteJuridico_recebe_malaDireta(

codcliente int not null,
codmala int not null, 

primary key(codcliente, codmala),
foreign key(codcliente) references cliente_juridico(cod),
foreign key(codmala) references malaDireta(codigo)
);

create table cliente_fisico( 
cod int not null, #da hierarquia
agencia char (18),
cpf char (9), 
tipo int not null, 

primary key(cod),
foreign key (agencia) references agencia(CNPJ),
foreign key (cod) references pessoa(cod)

);

create table clienteFisico_recebe_malaDireta(

codcliente int not null,
codmala int not null, 

primary key(codcliente, codmala),
foreign key(codcliente) references cliente_fisico(cod),
foreign key(codmala) references malaDireta(codigo)
);
create table passaporte(
numero varchar(10) not null unique, 
pais_emissao varchar(50),
validade date,
dt_emissao date, 
codcliente int not null,

primary key(numero, codcliente),
foreign key(codcliente) references cliente_fisico(cod)
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
foreign key(codcliente) references cliente_fisico(cod),
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
arquivo varbinary(65535),

primary key (codmala, arquivo),
foreign key(codmala) references malaDireta(codigo)
);

create table clienteFisico_compra(
dt_compra date not null,
stats int,
cpf char(9) not null,
cod int not null,
codpacote int not null, 
codcliente int not null,

primary key (cpf, cod, codpacote,codcliente, dt_compra),
foreign key (cpf,cod) references agente(cpf,cod),
foreign key(codpacote) references pacote(codigo),
foreign key(codcliente) references cliente_fisico(cod)

);

create table clienteJuridico_compra(
dt_compra date not null,
stats int,
cpf char(9) not null,
cod int not null,
codpacote int not null, 
codcliente int not null,

primary key (cpf, cod, codpacote,codcliente, dt_compra),
foreign key (cpf,cod) references agente(cpf,cod),
foreign key(codpacote) references pacote(codigo),
foreign key(codcliente) references cliente_juridico(cod)

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

create table servico_ref(
codigo int not null unique auto_increment, 
valor decimal(10,2),
local_destino varchar(50),
nivel int,
modalidadeServico int not null, #intercambio, acomodação, evento, transporte
tipoServico int not null, #serviço parceiro, serviço proprio

primary key(codigo),
foreign key(nivel) references nivel_servico(codigo)
);

create table mapa_arquivo(
codServico int not null, 
mapa varbinary(65535) not null,

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
codigo int not null,
obs varchar(200),
detalhe varchar(200),
tipo int not null, #hierarquia

cargo varchar(20),#trabalho
dt_inicio date,
dt_fim date,

cargaHoraria int, #estudo
nome_curso varchar(50),
lingua varchar(20),

primary key(codigo),
foreign key(codigo) references servico_ref(codigo)
);

create table acomodacao(
codigo int not null,
descricao varchar(100),
data_entrada date,
dt_saida date,
capacidade_pessoas int,
fumante int,
no_estrelas int,
tipo varchar(100), 

primary key(codigo),
foreign key(codigo) references servico_ref(codigo)
);

create table evento(
codigo int not null,
stats varchar(100),
data_entrada date,
dt_fim date,
nome varchar(100),
detalhe varchar(100),
tipo int,
vl_desc varchar(100),
obs varchar(100), 
guiacpf char(9) not null,
guiacod int not null,

primary key(codigo),
foreign key(codigo) references servico_ref(codigo),
FOREIGN KEY(guiacpf,guiacod) REFERENCES guia(cpf,cod)

);

create table transporte(
codigo int not null,
local_de_origem varchar(100),
data_ida date,
dt_volta date,
modalidade varchar(100),
marca varchar(100),
tipo int,
num_identificacao int,
capacidade_n_pessoas int,
motoristacpf char(9) not null,
motoristacod int not null,

primary key(codigo),
foreign key(codigo) references servico_ref(codigo),
FOREIGN KEY(motoristacpf,motoristacod) REFERENCES motorista(cpf,cod)

);

create table servico_proprio(
codigo int not null,

primary key(codigo),
foreign key(codigo) references servico_ref(codigo)
);

create table servico_parceiro(
codigo int not null,

primary key(codigo),
foreign key(codigo) references servico_ref(codigo)
);

create table oferece(
codigo int not null,
CNPJ varchar(18) not null,
dt_inicio date, 
dt_fim date, 
percentual float, 
no_contrato int not null,

primary key(codigo, CNPJ, no_contrato),
foreign key(codigo) references servico_parceiro(codigo),
foreign key(CNPJ) references parceiro(CNPJ)

);

create table parceiro(

CNPJ varchar(18) not null unique,
nome_fantasia varchar(50),
status int, 
tipo int, 
ramo varchar(10),

primary key(CNPJ)
);


