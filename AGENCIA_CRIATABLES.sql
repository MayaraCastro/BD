-- DEFINE O BANCO DE DADOS "AGENCIA"
CREATE SCHEMA AGENCIA;
USE AGENCIA;

-- COMMANDOS DE SQL DDL PARA CRIAÇÃO DAS TABELAS
create table endereco(

cep varchar(10) not null,
estado varchar(2),
logradouro varchar(50),
predio varchar(10),
complemento varchar (20),
cidade varchar(20),
primary key (cep)

);
INSERT INTO `endereco` (`cep`,`estado`,`logradouro`,`predio`,`complemento`,`cidade`) VALUES ("14846-260","SP","P.O. Box 903, 8152 Porta St.","3A4","5135 Vitae Ave","Diadema"),
("51470-231","PE","P.O. Box 752, 4420 Proin Road","5","250-2724 Aliquet Ave","Camaragibe"),
("81304-878","PR","7928 Aliquam Ave","488"," Posuere Road","Londrina"),
("50915-737","PE","P.O. Box 342, 9767 Eleifend. St.","99","P.O. Box 315, 6024 Ultrices Av.","Petrolina"),
("66256-869","PA","P.O. Box 497, 1742 Nec Av.","8","6816 Ipsum Street","Castanhal"),
("84324-108","PR","544-9270 Libero Rd.","350","Egestas Rd.","Curitiba"),
("58539-565","PB","P.O. Box 955, 7524 Ut St.","6U4","Arcu. Rd.","Patos"),
("15989-568","SP","325-9635 Faucibus Rd.","U7","709-2996 Dignissim St.","Campinas"),
("14180-514","SP","Volutpat St.","4","Congue, Avenue","Piracicaba"),
("58403-839","PB","2204 Aliquam Ave","1","Proin St.","Patos");

CREATE TABLE pessoa (
cod int not null auto_increment,
nome varchar(100) not null,   
dt_nasc date,
sexo enum ('M', 'F'),
fone varchar(15),
foto blob,
cep varchar(10) unique, #da relacao
num int, #da relacao
primary key (cod),
foreign key (cep) references endereco(cep) # ON UPDATE CASCADE ON DELETE CASCADE
);

INSERT INTO `pessoa` (`cod`,`nome`,`dt_nasc`,`sexo`,`fone`,`ft`,`cep`,`num`) VALUES 
("16450205195","Edan, Jael, Stacy, Quinlan","1989-02-21 15:34:51","F","(449) 231-8183","FT","20210-208",7779),
("16040411122","Glenna, Jada, Lucas, Rigel","1964-10-28 06:29:24","F","(789) 543-0507","FT","14779-192",1886),
("16000712739","Colt, Christopher, Tara, Deirdre","1990-05-02 06:55:25","M","(965) 546-0068","FT","49764-791",4941),
("16550423243","Igor, Maggy, Brenna, Forrest","1998-08-09 06:38:55","F","(744) 262-6212","FT","10799-295",3864),
("16441015622","Kirsten, Oren, Athena, Jerry","1965-09-10 01:47:13","F","(407) 106-0023","FT","08650-587",7237),
("16780930808","Ramona, Aidan, Lilah, Bertha","2000-06-30 15:05:00","M","(154) 337-4965","FT","67153-159",4221),
("16100111876","Raja, Sopoline, Giselle, Ralph","1953-06-28 21:53:19","M","(816) 931-6356","FT","90334-325",153),
("16970207878","Reece, Adrian, Yuri, Nehru","1965-07-28 13:42:10","M","(392) 737-4546","FT","40737-703",3622),
("16910527049","Tarik, Helen, Thomas, Jane","1967-06-23 16:33:28","F","(991) 794-0229","FT","22818-364",8115),
("16010301880","Tyrone, Barclay, Lillith, Willow","1981-03-24 21:49:47","M","(594) 250-4834","FT","30973-085",5884);

create table agencia(

CNPJ char (18) not null unique,
nome_fantasia varchar(50),
cep varchar(10) unique, #da relacao
num int, #da relacao
codgerente int not null unique,  
datainicio date,
num_cliente int,

primary key (CNPJ),
foreign key (cep) references endereco(cep)  #ON UPDATE CASCADE ON DELETE CASCADE duvida sobre isso
#foreign key (codgerente) references gerente(cod)

);

INSERT INTO `agencia` (`CNPJ`,`nome_fantasia`,`cep`,`num`,`codgerente`,`datainicio`,`num_cliente`) VALUES 
("32502760099","Vel Convallis In Corporation","00211-949",473,"11010301880","2018-05-24 20:57:10",238),
("45726444299","Nibh Lacinia Corporation","28397-601",4999,"12910301880","2019-06-04 03:13:35",496),
("72598705499","Magnis LLC","36803-781",1941,"13810301880","2018-10-17 16:41:45",81),
("05310445299","Nec Enim Nunc Foundation","49836-225",325,"14710301880","2018-12-30 10:06:06",205),
("20464828799","Sit Amet Consectetuer Limited","48170-310",6183,"15610301880","2018-03-23 05:19:28",79),
("49774256899","Faucibus Leo Industries","02216-023",575,"16510301880","2018-12-05 15:50:10",815),
("63832865999","Morbi Tristique Senectus Industries","12920-266",1998,"17410301880","2018-01-23 18:07:35",95),
("89514914499","Blandit Viverra Donec Ltd","54855-193",4795,"18310301880","2018-05-15 08:17:29",932),
("15922568399","Luctus Aliquet LLP","13305-106",4640,"19210301880","2018-12-06 07:14:35",901),
("92869851699","Sit Amet LLP","94913-521",2901,"10110101181","2017-08-04 09:43:47",186);


create table agente(
salario decimal(10,2) check(salario>0), 
ramal int,
cpf char(9) not null unique,
cod int not null, #da hierarquia
cod_agencia char (18) not null,

primary key(cod),
constraint fk_agente_pessoa foreign key (cod) references pessoa(cod) on delete cascade on update cascade,
constraint fk_agente_agencia foreign key (cod_agencia) references agencia(CNPJ) on delete cascade on update cascade
);

INSERT INTO `agente` (`salario`,`ramal`,`cpf`,`cod`,`cod_agencia`) VALUES 
(7906,"(396) 153-9903","16790221-1114","16450205195","32502760099"),
(5173,"(876) 950-3594","16540824-4472","16040411122","32502760099"),
(6228,"(963) 847-1204","16870603-8638","16000712739","32502760099");

create table guia(
salario decimal(10,2) check(salario>0), 
ramal int,
cpf char(9) not null unique,
cod int not null, #da hierarquia
cod_agencia char (18) not null,

primary key(cod),
constraint fk_guia_pessoa foreign key (cod) references pessoa(cod) on delete cascade on update cascade,
constraint fk_guia_agencia foreign key (cod_agencia) references agencia(CNPJ)on delete cascade on update cascade
);

NSERT INTO `guia` (`salario`,`ramal`,`cpf`,`cod`,`cod_agencia`) VALUES 
(2776,"(386) 250-9880","16760306-6049","16550423243","45726444299"),
(5244,"(659) 939-8818","16720306-1424","16441015622","45726444299"),
(6301,"(713) 950-5399","16760411-3717","16780930808","45726444299");

create table motorista(
salario decimal(10,2) check(salario>0), 
ramal int,
cpf char(9) not null unique,
cod int not null, #da hierarquia
cod_agencia char (18) not null,

primary key(cod),
constraint fk_motorista_pessoa foreign key (cod) references pessoa(cod) on delete cascade on update cascade,
constraint fk_motorista_agencia foreign key (cod_agencia) references agencia(CNPJ) on delete cascade on update cascade

);

INSERT INTO `motorista` (`salario`,`ramal`,`cpf`,`cod`,`cod_agencia`) VALUES 
(7798,"(964) 637-5087","16500911-5287","16100111876","20464828799"),
(8368,"(393) 954-8705","16890309-7973","16970207878","20464828799"),
(4751,"(122) 642-8174","16290121-2916","16910527049","45726444299"),
(6711,"(529) 380-3446","16670211-2894","16010301880","32502760099");


create table gerente(
salario decimal(10,2) check(salario>0), 
ramal int,
cpf char(9) not null unique,
cod int not null, #da hierarquia
cod_agencia char (18) not null,

primary key(cod),
constraint fk_gerente_pessoa foreign key (cod) references pessoa(cod) on delete cascade on update cascade,
constraint fk_gerente_agencia foreign key (cod_agencia) references agencia(CNPJ)on delete cascade on update cascade

);

INSERT INTO `gerente` (`salario`,`ramal`,`cpf`,`cod`,`cod_agencia`) VALUES 
(7384,"(668) 603-3474","16111122-0743","11010301880","32502760099"),
(6227,"(770) 752-4285","16460223-8075","12910301880","45726444299"),
(5521,"(752) 292-5417","16310828-6737","13810301880","72598705499"),
(2483,"(676) 524-0190","16510919-5239","14710301880","05310445299"),
(9660,"(917) 550-0413","16420110-9784","15610301880","20464828799"),
(3329,"(781) 824-7660","16341120-3502","16510301880","49774256899"),
(2303,"(227) 982-2453","16041020-4952","17410301880","63832865999"),
(8112,"(774) 807-6886","16650107-6357","18310301880","89514914499"),
(4112,"(810) 951-9299","16680801-8243","19210301880","15922568399"),
(5993,"(447) 533-4912","16300609-9208","10110101181","92869851699");


ALTER TABLE agencia ADD constraint fk_agencia_gerente FOREIGN KEY ( codgerente ) REFERENCES gerente (cod) on update cascade; # pois estava dando erro antes


create table malaDireta(
codigo int not null auto_increment,
texto varchar(300),
dt_criacao date,
dt_envio date,

primary key (codigo)
);
INSERT INTO `malaDireta` (`codigo`,`texto`,`dt_criacao`,`dt_envio`) VALUES 
("463961-2839","semper erat, in consectetuer","2019-04-01 05:23:24","2019-08-18 14:21:33"),
("413898-0760","sit","2017-01-06 22:05:14","2017-10-20 08:33:31"),
("652824-3550","erat vel pede blandit congue. In scelerisque scelerisque","2019-05-05 18:19:21","2019-08-14 04:36:30"),
("755316-2764","ut, nulla. Cras eu","2018-02-09 23:40:23","2018-07-23 15:29:39"),
("557027-0602","ac turpis egestas. Aliquam fringilla cursus purus.","2018-02-02 21:29:05","2018-08-01 18:16:36"),
("796070-5981","libero. Donec consectetuer mauris id sapien. Cras","2018-03-12 15:38:04","2018-11-12 19:47:20"),
("985290-2528","at pede. Cras vulputate","2018-08-12 01:01:54","2018-08-22 23:39:37"),
("459561-3607","eros","2017-11-24 04:04:37","2018-04-12 14:02:56"),
("137864-2621","Praesent eu nulla at sem molestie","2017-12-21 11:40:31","2018-03-30 09:48:26"),
("576243-0196","Suspendisse commodo","2018-03-12 02:14:54","2018-10-13 05:21:16");


create table arquivo_pdf(
codmala int not null,
arquivo varbinary(500),

primary key (codmala, arquivo),
constraint fk_arquivo_mala foreign key(codmala) references malaDireta(codigo) on delete cascade on update cascade
);

create table cliente_juridico( 
cod int not null, #da hierarquia
agencia char (18),
CNPJ char (18), 
nome_fantasia varchar(50),

primary key(cod),
constraint fk_juridico_agencia foreign key (agencia) references agencia(CNPJ) on update cascade,
constraint fk_juridico_pessoa foreign key (cod) references pessoa(cod) on delete cascade on update cascade

);

create table clienteJuridico_recebe_malaDireta(

codcliente int not null,
codmala int not null, 

primary key(codcliente, codmala),
constraint fk_juridicoMala_juridico foreign key(codcliente) references cliente_juridico(cod) on delete cascade on update cascade,
constraint fk_juridicoMala_mala foreign key(codmala) references malaDireta(codigo) on delete cascade on update cascade
);

create table cliente_fisico( 
cod int not null, #da hierarquia
agencia char (18),
cpf char (9), 
tipo int not null check(3>=tipo>0), 

primary key(cod),
constraint fk_fisico_agencia foreign key (agencia) references agencia(CNPJ) on update cascade,
constraint fk_fisico_pessoa foreign key (cod) references pessoa(cod) on delete cascade on update cascade

);

create table clienteFisico_recebe_malaDireta(

codcliente int not null,
codmala int not null, 

primary key(codcliente, codmala),
constraint fk_fisicoMala_fisico foreign key(codcliente) references cliente_fisico(cod) on delete cascade on update cascade,
constraint fk_fisicoMala_mala foreign key(codmala) references malaDireta(codigo) on delete cascade on update cascade
);

create table passaporte(
numero varchar(10) not null unique, 
pais_emissao varchar(50),
validade date,
dt_emissao date, 
codcliente int not null,

primary key(numero),
constraint fk_passaporte_fisico foreign key(codcliente) references cliente_fisico(cod) on delete cascade on update cascade
);

create table visto(
controlnumber varchar(10) not null unique,
numeroPass varchar(10) not null,
tipo int, 
pais varchar(50),
dt_inicio date, 
dt_fim date, 

primary key(controlnumber),
constraint fk_visto_passaporte foreign key(numeroPass) references passaporte(numero) on delete cascade on update cascade
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

create table clienteFisico_compra(
dt_compra date not null,
stats int,
codagente int not null,
codpacote int not null, 
codcliente int not null,

primary key (codagente, codpacote,codcliente, dt_compra),
constraint fk_fisicoCompra_agente foreign key (codagente) references agente(cod) on delete cascade on update cascade,
constraint fk_fisicoCompra_pacote foreign key(codpacote) references pacote(codigo) on delete cascade on update cascade,
constraint fk_fisicoCompra_fisico foreign key(codcliente) references cliente_fisico(cod) on delete cascade on update cascade

);

create table clienteJuridico_compra(
dt_compra date not null,
stats int,
codagente int not null,
codpacote int not null, 
codcliente int not null,

primary key (codagente, codpacote,codcliente, dt_compra),
constraint fk_juridicoCompra_agente foreign key (codagente) references agente(cod) on delete cascade on update cascade,
constraint fk_juridicoCompra_pacote foreign key(codpacote) references pacote(codigo) on delete cascade on update cascade,
constraint fk_juridicoCompra_juridico foreign key(codcliente) references cliente_juridico(cod) on delete cascade on update cascade

);

create table nivel_servico(
codigo int not null unique,
nivel int, 
descr varchar(100),

primary key(codigo)
);

create table servico_ref(
codigo int not null unique auto_increment, 
valor decimal(10,2),
local_destino varchar(50),
nivel int ,
tipoServico int not null, #serviço parceiro, serviço proprio

primary key(codigo),
foreign key(nivel) references nivel_servico(codigo) 
);

create table item_pacote(
id_sk int unique auto_increment ,
codservico int not null, 
codpacote int not null, 
dt date,
vl_unitario decimal(10,2),
qtd int, 
seq int,
vl_com_desconto decimal(10,2),

primary key(id_sk),
constraint fk_itemPacote_pacote foreign key(codpacote) references pacote(codigo) on delete cascade on update cascade,
constraint fk_itemPacote_servico foreign key (codservico) references servico_ref(codigo) on delete cascade on update cascade,
unique index sk (codpacote, codservico)
);

create table fatura(
id int not null unique auto_increment,
codpacote int ,
dt_fatura date, 
stats int, 

primary key(id),
foreign key(codpacote) references pacote(codigo)

);

create table itens_fatura(
id int not null,
sk_itemPacote int not null,

primary key(id, sk_itemPacote),
constraint fk_itemFatura_fatura foreign key(id) references fatura(id) on delete cascade on update cascade,
constraint fk_itemFatura_pacote foreign key(sk_itemPacote)references item_pacote(id_sk) on delete cascade on update cascade
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

create table mapa_arquivo(
codServico int not null, 
mapa varbinary(500) not null,

primary key(mapa, codServico),
constraint fk_mapa_servico foreign key(codServico) references servico_ref(codigo) on delete cascade on update cascade
);

create table promocao(
id int not null unique,
dt_fim date,
porcentagem_desconto double,
tipo int, 
dt_inicio date,
codservico int,

primary key(id),
constraint fk_promocao_servico foreign key(codservico)  references servico_ref(codigo) on delete cascade on update cascade
);

create table intercambio(
codigo int not null,
obs varchar(200),
detalhe varchar(200),
tipo_intercambio int not null, #hierarquia

cargo varchar(20),#trabalho
dt_inicio date,
dt_fim date,

cargaHoraria int, #estudo
nome_curso varchar(50),
lingua varchar(20),

primary key(codigo),
constraint fk_intercambio_servico foreign key(codigo) references servico_ref(codigo) on delete cascade on update cascade
);

create table acomodacao(
codigo int not null,
descricao varchar(100),
data_entrada date,
dt_saida date,
capacidade_pessoas int,
fumante int check (1 >= fumante >=0),
no_estrelas int,
tipo varchar(100), 

primary key(codigo),
constraint fk_acomodacao_servico foreign key(codigo) references servico_ref(codigo) on delete cascade on update cascade
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
guiacod int not null,

primary key(codigo),
constraint fk_evento_servico foreign key(codigo) references servico_ref(codigo) on delete cascade on update cascade,
FOREIGN KEY(guiacod) REFERENCES guia(cod) 

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
motoristacod int not null,

primary key(codigo),
constraint fk_transporte_servico foreign key(codigo) references servico_ref(codigo) on delete cascade on update cascade,
FOREIGN KEY(motoristacod) REFERENCES motorista(cod)

);

create table servico_proprio(
codigo int not null,

primary key(codigo),
constraint fk_servicoProprio_servico foreign key(codigo) references servico_ref(codigo) on delete cascade on update cascade
);

create table servico_parceiro(
codigo int not null,

primary key(codigo),
constraint fk_servicoParceiro_servico foreign key(codigo) references servico_ref(codigo) on delete cascade on update cascade
);

create table parceiro(

CNPJ varchar(18) not null unique,
nome_fantasia varchar(50),
status int, 
tipo int, 
ramo varchar(10),

primary key(CNPJ)
);

create table oferece(
codigo int not null,
CNPJ varchar(18) not null,
dt_inicio date, 
dt_fim date, 
percentual float, 
no_contrato int not null,

primary key(codigo, CNPJ, no_contrato),
constraint fk_oferece_servicoParceiro foreign key(codigo) references servico_parceiro(codigo) on delete cascade on update cascade,
constraint fk_oferece_parceiro foreign key(CNPJ) references parceiro(CNPJ) on delete cascade on update cascade

);


