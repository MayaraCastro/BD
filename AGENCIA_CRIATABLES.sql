 USE AGENCIA;

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

INSERT INTO `pessoa` (`cod`,`nome`,`dt_nasc`,`sexo`,`fone`,`ft`,`cep`,`num`) VALUES 
("16450205195","Edan Jael","1989-02-21 15:34:51","F","(449) 231-8183","FT0","20210-208",7779),
("16040411122","Glenna Rigel","1964-10-28 06:29:24","F","(789) 543-0507","FT1","14779-192",1886),
("16000712739","Colt Christopher","1990-05-02 06:55:25","M","(965) 546-0068","FT2","49764-791",4941),
("16550423243","Igor Forrest","1998-08-09 06:38:55","F","(744) 262-6212","FT3","10799-295",3864),
("16441015622","Kirsten Oren","1965-09-10 01:47:13","F","(407) 106-0023","FT4","08650-587",7237),
("16780930808","Ramona Lilah","2000-06-30 15:05:00","M","(154) 337-4965","FT5","67153-159",4221),
("16100111876","Raja Ralph","1953-06-28 21:53:19","M","(816) 931-6356","FT6","90334-325",153),
("16970207878","Reece Nehru","1965-07-28 13:42:10","M","(392) 737-4546","FT7","40737-703",3622),
("16910527049","Tarik Jane","1967-06-23 16:33:28","F","(991) 794-0229","FT8","22818-364",8115),
("16010301880","Tyrone Willow","1981-03-24 21:49:47","M","(594) 250-4834","FT9","30973-085",5884),
("17550205195","Stacy Quinlan","1969-03-21 15:34:51","F","(44) 231-8183","FT11","19210-208",9779),
("17140411122","Jada Rigel","1974-11-28 06:29:24","F","(78) 541-0507","FT12","03779-192",3886),
("17100712739","Christopher Deirdre","1992-06-02 06:55:25","M","(96) 541-0068","FT13","38764-791",6941),
("17650423243","Maggy Brenna","1998-09-09 06:38:55","F","(74) 261-6212","FT14","09799-295",5864),
("17541015622","Athena Jerry","1975-10-10 01:47:13","F","(40) 101-0023","FT15","97650-587",9237),
("17880930808","Bertha","2000-07-30 15:05:00","M","(15) 331-4965","FT16","56153-159",6221),
("17200111876","Ralph","1963-07-28 21:53:19","M","(81) 931-6356","FT17","89334-325",353),
("17070207878","Yuri Nehru","1975-08-28 13:42:10","M","(39) 737-4546","FT18","39737-703",5622),
("17010527049","Helen Jane","1977-07-23 16:33:28","F","(99) 794-0209","FT19","11818-364",0115),
("17110301880","Barclay Lillith","1992-05-24 21:49:47","F","(59) 330-4834","FT20","29973-085",7884);

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

INSERT INTO `agente` (`salario`,`ramal`,`cpf`,`cod`,`cod_agencia`) VALUES 
(7906,"(396) 153-9903","16790221-1114","16450205195","32502760099"),
(5173,"(876) 950-3594","16540824-4472","16040411122","32502760099"),
(6228,"(963) 847-1204","16870603-8638","16000712739","32502760099");

INSERT INTO `guia` (`salario`,`ramal`,`cpf`,`cod`,`cod_agencia`) VALUES 
(2776,"(386) 250-9880","16760306-6049","16550423243","45726444299"),
(5244,"(659) 939-8818","16720306-1424","16441015622","45726444299"),
(6301,"(713) 950-5399","16760411-3717","16780930808","45726444299");

INSERT INTO `motorista` (`salario`,`ramal`,`cpf`,`cod`,`cod_agencia`) VALUES 
(7798,"(964) 637-5087","16500911-5287","16100111876","20464828799"),
(8368,"(393) 954-8705","16890309-7973","16970207878","20464828799"),
(4751,"(122) 642-8174","16290121-2916","16910527049","45726444299"),
(6711,"(529) 380-3446","16670211-2894","16010301880","32502760099");

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

INSERT INTO `arquivo_pdf` (`codmala`,`arquivo`) VALUES 
("16750607 6756","arq1"),
("16311104 1996","arq2"),
("16970230 9437","arq3"),
("16270102 6888","arq4"),
("16460304 2302","arq5"),
("16161122 2777","arq6"),
("16450708 2578","arq7"),
("16441004 0580","arq8"),
("16660708 8090","arq9"),
("16970916 6046","arq0");

INSERT INTO `cliente_juridico` (`cod`,`agencia`,`CNPJ`,`nome_fantasia`) VALUES 
("17550205195","32502760099","981311","Ac Corporation"),
("17140411122","45726444299","947555","Posuere Cubilia Curae; Limited"),
("17100712739","72598705499","783615","Nec PC"),
("17650423243","20464828799","117101","Rhoncus Donec Ltd"),
("17541015622","05310445299","022917","Ornare Incorporated");

INSERT INTO `clienteJuridico_recebe_malaDireta` (`codcliente`,`codmala`) VALUES 
("17550205195","760099"),
("17140411122","444299"),
("17100712739","705499"),
("17650423243","828799"),
("17541015622","445299"),
("17880930808","865999"),
("17200111876","256899"),
("17070207878","914499"),
("17010527049","568399"),
("17110301880","851699");

INSERT INTO `cliente_fisico` (`cod`,`agencia`,`cpf`,`tipo`) VALUES 
("17880930808","63832865999","330099","3"),
("17200111876","49774256899","440099","0"),
("17070207878","89514914499","330099","1"),
("17010527049","15922568399","770099","2"),
("17110301880","92869851699","550099","0");

INSERT INTO `clienteFisico_recebe_malaDireta`(`codcliente`, `codmala`) VALUES
("17880930808","63832865999"),
("17200111876","49774256899"),
("17070207878","89514914499"),
("17010527049","15922568399"),
("17110301880","92869851699");

INSERT INTO `passaporte` (`numero`,`pais_emissao`,`validade`,`dt_emissao`,`codcliente`) VALUES 
("161702207844","Brazil","2018-09-14 09:17:42","2024-01-09 11:02:03","17880930808"),
("169107200934","Guinea","2019-02-17 20:10:10","2021-03-22 18:08:07","17200111876"),
("165410156490","Finland","2018-01-29 20:58:21","2024-03-19 00:56:40","17070207878"),
("165408282027","Portugal","2019-08-02 22:36:01","2023-02-25 08:43:14","17010527049"),
("169904287795","Panama","2019-08-19 14:12:43","2022-07-14 09:35:37","17110301880");

INSERT INTO `visto` (`numero`,`numeroPass`,tipo,`dt_inicio`,`dt_fim`) VALUES 
("12361702207844","161702207844","Brazil",2,"2018-09-14 09:17:42","2024-01-09 11:02:03"),
("132169107200934","169107200934","Guinea",1,"2019-02-17 20:10:10","2021-03-22 18:08:07"),
("142165410156490","165410156490","Finland",0,"2018-01-29 20:58:21","2024-03-19 00:56:40"),
("152165408282027","165408282027","Portugal",1,"2019-08-02 22:36:01","2023-02-25 08:43:14"),
("162169904287795","169904287795","Panama",2,"2019-08-19 14:12:43","2022-07-14 09:35:37");

INSERT INTO `pacote` (`codigo`,`total_a_pagar`,`vl_desconto`,`datafim`,`datainicio`,`indicadorReserva`,`tipo`,`n_criancas`,`n_adultos`) VALUES
("7044713662",7366.00,19,"2019-04-25 20:06:14","2018-03-08 10:21:39",1,4,3,1),
("0126411008",4387.00,12,"2018-11-18 23:24:55","2017-09-24 19:09:53",0,1,1,1),
("9480231647",4851.00,7,"2018-08-27 22:54:46","2017-06-27 18:41:28",1,1,1,3),
("2185194533",1855.00,11,"2018-12-12 02:21:20","2018-07-22 02:59:58",0,3,5,1),
("0465004604",6763.00,21,"2018-09-24 00:03:41","2018-01-06 09:56:19",0,1,8,5),
("5523568789",8098.00,57,"2018-07-31 23:19:51","2017-06-05 17:56:16",0,2,10,10),
("3647494842",2292.00,61,"2018-04-06 05:33:14","2017-10-03 05:02:38",0,3,6,6),
("4985563297",2867.00,69,"2018-09-29 13:41:19","2017-08-06 10:33:14",1,4,5,7),
("9334043164",7643.00,62,"2018-11-02 14:28:50","2019-07-03 21:53:35",0,2,4,4),
("9827063273",4850.00,18,"2018-12-17 09:32:51","2018-05-20 03:19:21",1,3,8,5);

INSERT INTO `clienteFisico_compra` (`dt_compra`,`status`,`codagente`,`codpacote`,`codcliente`) VALUES 
("2017-10-24 05:56:43",0,"16000712739","7044713662","17880930808"),
("2018-05-30 21:54:59",1,"16040411122","0126411008","17880930808"),
("2017-03-17 08:52:32",0,"16000712739","9480231647","17200111876"),
("2018-11-29 23:29:34",1,"16040411122","2185194533","17200111876"),
("2018-05-21 15:28:08",1,"16000712739","0465004604","17070207878"),
("2017-10-28 03:32:58",0,"16040411122","7044713662","17070207878"),
("2018-06-20 09:55:46",1,"16000712739","0126411008","17010527049"),
("2017-01-25 04:00:31",0,"16040411122","9480231647","17010527049"),
("2018-04-08 16:07:09",1,"16000712739","2185194533","17110301880"),
("2018-10-27 21:08:42",1,"16040411122","0465004604","17110301880");


INSERT INTO `clienteJuridico_compra` (`dt_compra`,`status`,`codagente`,`codpacote`,`codcliente`) VALUES 
("2017-10-24 05:56:43",0,"16000712739","5523568789","17550205195"),
("2018-05-30 21:54:59",1,"16040411122","5523568789","17140411122"),
("2017-03-17 08:52:32",0,"16000712739","3647494842","17140411122"),
("2018-11-29 23:29:34",1,"16040411122","3647494842","17550205195"),
("2018-05-21 15:28:08",1,"16000712739","4985563297","17100712739"),
("2017-10-28 03:32:58",0,"16450205195","4985563297","17100712739"),
("2018-06-20 09:55:46",1,"16000712739","9334043164","17650423243"),
("2017-01-25 04:00:31",0,"16450205195","9334043164","17650423243"),
("2018-04-08 16:07:09",1,"16000712739","9827063273","17650423243"),
("2018-10-27 21:08:42",1,"16450205195","9827063273","17100712739");

INSERT INTO `nivel_servico` (`codigo`,`nivel`,`descr`) VALUES 
("7781997601",1,"nisi. Mauris nulla. Integer urna. Vivamus molestie dapibus ligula. Aliquam"),
("0247140924",2,"consectetuer, cursus et, magna. Praesent interdum ligula eu enim. Etiam"),
("4287489233",0,"augue eu tellus. Phasellus elit pede, malesuada vel, venenatis vel,"),
("9490916773",0,"vestibulum nec, euismod in, dolor. Fusce feugiat. Lorem ipsum dolor"),
("7973796217",1,"Nulla aliquet. Proin velit. Sed malesuada augue ut lacus. Nulla"),
("3984218655",2,"magna. Suspendisse tristique neque venenatis lacus. Etiam bibendum fermentum metus."),
("6387013821",2,"aliquet molestie tellus. Aenean egestas hendrerit neque. In ornare sagittis"),
("8548448284",0,"Vestibulum ante ipsum primis in faucibus orci luctus et ultrices"),
("9562930587",1,"nulla magna, malesuada vel, convallis in, cursus et, eros. Proin"),
("0476285143",3,"dictum mi, ac mattis velit justo nec ante. Maecenas mi");

INSERT INTO `servico_ref` (`codigo`,`valor`,`local_destino`,`nivel`,`tipoServico`) VALUES 
("4332059742",7189.00,"2868 Orci Av.","7781997601",0),
("1135480695",3710.00,"222-8658 Dictum St.","0247140924",1),
("6547059722",7722.00,"1632 Sem St.","4287489233",1),
("4080424163",7356.00,"8726 Mi St.","9490916773",1),
("2368720021",5150.00,"P.O. Box 710, 941 Ipsum. Road","7973796217",1),
("7058791737",5362.00,"Ap #317-2640 In St.","3984218655",1),
("6650208611",6698.00,"P.O. Box 822, 3077 Proin Av.","6387013821",0),
("5436953557",4797.00,"P.O. Box 786, 9270 Neque Avenue","8548448284",1),
("0983921644",4244.00,"Ap #832-2454 Enim Ave","9562930587",0),
("2070763632",8914.00,"Ap #272-1139 Enim Avenue","0476285143",0);

INSERT INTO `item_pacote` (`id_sk`,`codservico`,`codpacote`,`dt`,`vl_unitario`,`qtd`,`seq`,`vl_com_desconto`) VALUES 
(6,"4332059742","7044713662","2018-07-18 14:27:21",5945.00,7,6,85),
(10,"1135480695","0126411008","2018-03-03 14:41:27",9180.00,8,7,63),
(7,"6547059722","9480231647","2019-07-14 05:16:26",5732.00,6,4,8),
(2,"4080424163","2185194533","2018-01-25 00:06:32",5363.00,9,6,42),
(5,"2368720021","0465004604","2018-11-11 21:54:38",8307.00,4,5,84),
(8,"7058791737","5523568789","2018-08-20 02:39:18",3032.00,9,5,38),
(4,"6650208611","3647494842","2019-05-28 08:52:14",3557.00,9,8,1),
(8,"5436953557","4985563297","2018-06-19 22:28:54",2450.00,6,3,79),
(1,"0983921644","9334043164","2018-04-29 04:40:46",1127.00,9,6,90),
(9,"2070763632","9827063273","2018-06-17 05:10:33",7440.00,2,10,86);

INSERT INTO `fatura` (`id`,`codpacote`,`dt_fatura`,`status`) VALUES
("283410 1426","7044713662","2019-07-13 21:02:46",0),
("715900 3404","0126411008","2018-07-02 10:16:51",1),
("724391 0929","9480231647","2018-09-30 10:12:05",1),
("418572 3212","2185194533","2017-11-11 00:37:48",0),
("429970 3449","0465004604","2019-02-28 03:10:12",0),
("285986 1128","5523568789","2018-09-19 16:02:23",0),
("388739 5444","3647494842","2019-06-14 20:06:49",0),
("616873 2862","4985563297","2017-12-15 17:51:14",1),
("942280 4188","9334043164","2018-07-06 01:11:42",1),
("977133 5123","9827063273","2018-02-12 00:47:44",0);


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
