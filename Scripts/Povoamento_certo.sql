use agencia;

SET FOREIGN_KEY_CHECKS=0;

INSERT INTO `acomodacao` (`codigo`,`descricao`,`data_entrada`,`dt_saida`,`capacidade_pessoas`,`fumante`,`no_estrelas`,`tipo`) VALUES (4,'Hotel Beira mar','2018-06-07','2018-06-15',5,0,5,'Hotel'),(5,'Hotel Casa Blanca','2018-06-08','2018-06-16',10,0,4,'Hotel');

INSERT INTO `agencia` (`CNPJ`,`nome_fantasia`,`cep`,`num`,`codgerente`,`datainicio`,`num_cliente`,`num_funcionarios`) VALUES ('62.252.681/0001-32','CVC','30666-441',1,16,'2017-08-08',10,20);

INSERT INTO `agente` (`salario`,`ramal`,`cpf`,`cod`,`cod_agencia`) VALUES (1200.00,1,'536.011.852-02',1,'62.252.681/0001-32'),(1200.00,2,'536.011.852-03',2,'62.252.681/0001-32'),(1200.00,3,'536.011.852-04',3,'62.252.681/0001-32'),(1200.00,4,'536.011.852-05',4,'62.252.681/0001-32'),(1200.00,5,'536.011.852-06',5,'62.252.681/0001-32');

INSERT INTO `arquivo_pdf` (`codmala`,`arquivo`) VALUES (1,X'7827363627'),(2,X'7827333627'),(2,X'7827363527'),(3,X'7827363627'),(3,X'7827364127'),(4,X'7827363627'),(4,X'7827364127'),(5,X'7827363627'),(5,X'7827364127');

INSERT INTO `cliente_fisico` (`cod`,`agencia`,`cpf`,`tipo`) VALUES (26,'62.252.681/0001-32','428.703.331-02',1),(27,'62.252.681/0001-32','428.703.331-03',1),(28,'62.252.681/0001-32','428.703.331-04',2),(29,'62.252.681/0001-32','428.703.331-05',2),(30,'62.252.681/0001-32','428.703.331-06',3);

INSERT INTO `cliente_juridico` (`cod`,`agencia`,`CNPJ`,`nome_fantasia`) VALUES (21,'62.252.681/0001-32','01.874.268/0001-15','Bon voyage 1'),(22,'62.252.681/0001-32','01.874.268/0001-16','Bon voyage 2'),(23,'62.252.681/0001-32','01.874.268/0001-17','Bon voyage 3'),(24,'62.252.681/0001-32','01.874.268/0001-18','UFC 1'),(25,'62.252.681/0001-32','01.874.268/0001-19','UFC 2');

INSERT INTO `clientefisico_compra` (`dt_compra`,`stats`,`codagente`,`codpacote`,`codcliente`) VALUES ('2018-08-05',1,1,1,26),('2018-08-10',1,1,6,26),('2018-08-06',1,2,2,27),('2018-08-11',0,2,7,27),('2018-08-07',1,3,3,28),('2018-08-12',0,3,8,28),('2018-08-08',1,4,4,29),('2018-08-13',0,4,9,29),('2018-08-09',1,5,5,30);

INSERT INTO `clientefisico_recebe_maladireta` (`codcliente`,`codmala`) VALUES (26,1),(26,5),(27,2),(27,4),(28,3),(29,2),(29,4),(30,1),(30,5);

INSERT INTO `clientejuridico_compra` (`dt_compra`,`stats`,`codagente`,`codpacote`,`codcliente`) VALUES ('2018-08-05',1,1,1,21),('2018-08-10',1,1,6,21),('2018-08-06',1,2,2,22),('2018-08-11',0,2,7,22),('2018-08-07',1,3,3,23),('2018-08-12',0,3,8,23),('2018-08-08',1,4,4,24),('2018-08-13',0,4,9,24),('2018-08-09',1,5,5,25);

INSERT INTO `clientejuridico_recebe_maladireta` (`codcliente`,`codmala`) VALUES (21,1),(21,5),(22,2),(22,4),(23,3),(24,2),(24,4),(25,1),(25,5);

INSERT INTO `endereco` (`cep`,`estado`,`logradouro`,`predio`,`complemento`,`cidade`) VALUES ('30666-440','MG','Rua Bernardino Vicente 1','Morada da ','apt 192','Belo Horizonte'),('30666-441','MG','Rua Bernardino Vicente 2','Morada da ','apt 193','Belo Horizonte'),('30666-442','MG','Rua Bernardino Vicente 3','Morada da ','apt 194','Belo Horizonte'),('30666-443','MG','Rua Bernardino Vicente 4','Morada da ','apt 195','Belo Horizonte'),('30666-444','MG','Rua Bernardino Vicente 5','Morada da ','apt 196','Belo Horizonte'),('30666-445','MG','Rua Bernardino Vicente 6','Morada da ','apt 197','Belo Horizonte'),('30666-446','MG','Rua Bernardino Vicente 7','Morada da ','apt 198','Belo Horizonte'),('75020-230','GO','Travessa Campos Sales1','Gonzalez 1','apt 1','Anápolis'),('75020-231','GO','Travessa Campos Sales2','Gonzalez 2','apt 2','Anápolis'),('75020-232','GO','Travessa Campos Sales3','Gonzalez 3','apt 3','Anápolis'),('75020-233','GO','Travessa Campos Sales4','Gonzalez 4','apt 4','Anápolis'),('75020-234','GO','Travessa Campos Sales5','Gonzalez 5','apt 5','Anápolis'),('75020-235','GO','Travessa Campos Sales6','Gonzalez 6','apt 6','Anápolis');

INSERT INTO `evento` (`codigo`,`stats`,`data_entrada`,`dt_fim`,`nome`,`detalhe`,`tipo`,`vl_desc`,`obs`,`guiacod`) VALUES (6,NULL,'2018-05-06','2018-05-14','Campus Party 1','nenhum',1,'nenhum','nenhum',6),(7,NULL,'2018-05-07','2018-05-15','Campus Party 2','nenhum',1,'nenhum','nenhum',7);

INSERT INTO `fatura` (`id`,`codpacote`,`dt_fatura`,`stats`) VALUES (1,1,'2018-08-05',1),(2,2,'2018-08-06',0),(3,1,'2018-08-07',1),(4,1,'2018-08-08',0),(5,4,'2018-08-09',1),(6,5,'2018-08-10',0),(7,9,'2018-08-11',1),(8,2,'2018-08-12',1),(9,1,'2018-08-13',1);

INSERT INTO `gerente` (`salario`,`ramal`,`cpf`,`cod`,`cod_agencia`) VALUES (1200.00,1,'585.713.265-76',16,'62.252.681/0001-32');

INSERT INTO `guia` (`salario`,`ramal`,`cpf`,`cod`,`cod_agencia`) VALUES (1200.00,1,'101.160.437-09',6,'62.252.681/0001-32'),(1200.00,2,'101.160.437-10',7,'62.252.681/0001-32'),(1200.00,3,'101.160.437-11',8,'62.252.681/0001-32'),(1200.00,4,'101.160.437-12',9,'62.252.681/0001-32'),(1200.00,5,'101.160.437-13',10,'62.252.681/0001-32');

INSERT INTO `intercambio` (`codigo`,`obs`,`detalhe`,`tipo_intercambio`,`cargo`,`dt_inicio`,`dt_fim`,`cargaHoraria`,`nome_curso`,`lingua`) VALUES (1,'Intercambio de trabalho','nenhum',1,'Atendente','2018-05-06','2018-08-06',NULL,NULL,NULL),(2,'Intercambio de estudo','nenhum',2,NULL,NULL,NULL,40,'Cambridge','Inglês'),(3,'Intercambio de estudo','nenhum',2,NULL,NULL,NULL,40,'EF','Inglês');

INSERT INTO `item_pacote` (`id_sk`,`codservico`,`codpacote`,`dt`,`vl_unitario`,`qtd`,`seq`,`vl_com_desconto`) VALUES (1,1,1,'2015-08-05',500.00,1,1,400.00),(2,2,1,'2015-08-06',500.00,2,2,400.00),(3,3,2,'2015-08-07',500.00,3,3,400.00),(4,4,3,'2015-08-08',500.00,2,4,400.00),(5,5,4,'2015-08-09',500.00,1,5,400.00),(6,6,5,'2015-08-10',600.00,1,6,400.00),(7,7,9,'2018-08-05',600.00,1,7,400.00),(8,8,3,'2018-08-06',600.00,1,8,550.00),(9,9,2,'2018-08-07',900.00,2,9,600.00),(10,10,1,'2018-08-08',1200.00,1,10,1000.00);

INSERT INTO `itens_fatura` (`id`,`sk_itemPacote`) VALUES (1,1),(2,2),(3,3),(4,4),(5,5),(6,6),(7,7),(8,8),(9,1),(9,9);

INSERT INTO `maladireta` (`codigo`,`texto`,`dt_criacao`,`dt_envio`) VALUES (1,' Boa viagem! 1','2017-08-11','2018-01-20'),(2,' Boa viagem! 2','2017-08-12','2018-01-21'),(3,' Boa viagem! 3','2017-08-13','2018-01-22'),(4,' Boa viagem! 4','2017-08-14','2018-01-23'),(5,' Boa viagem! 5','2017-08-15','2018-01-24');

INSERT INTO `mapa_arquivo` (`codServico`,`mapa`) VALUES (1,X'78273734363337303732363927'),(2,X'78273734363337303732373027'),(3,X'78273734363337303732373127'),(4,X'78273734363337303732373227'),(5,X'78273734363337303732373327');

INSERT INTO `motorista` (`salario`,`ramal`,`cpf`,`cod`,`cod_agencia`) VALUES (1200.00,1,'476.260.187-02',11,'62.252.681/0001-32'),(1200.00,2,'476.260.187-03',12,'62.252.681/0001-32'),(1200.00,3,'476.260.187-04',13,'62.252.681/0001-32'),(1200.00,4,'476.260.187-05',14,'62.252.681/0001-32'),(1200.00,5,'476.260.187-06',15,'62.252.681/0001-32');

INSERT INTO `nivel_servico` (`codigo`,`nivel`,`descr`) VALUES (1,1,'nivel 1'),(2,2,'nivel 2'),(3,3,'nivel 3'),(4,4,'nivel 4'),(5,5,'nivel 5');

INSERT INTO `oferece` (`codigo`,`CNPJ`,`dt_inicio`,`dt_fim`,`percentual`,`no_contrato`) VALUES (6,'36.221.286/0001-82','2016-05-04','2019-05-16',20,123),(7,'03.441.244/0001-06','2016-05-05','2019-05-17',20,124),(8,'31.136.096/0001-43','2016-05-06','2019-05-18',20,125),(9,'16.647.823/0001-43','2016-05-07','2019-05-19',20,126),(10,'88.523.192/0001-61','2016-05-08','2019-05-20',20,127);

INSERT INTO `pacote` (`codigo`,`total_a_pagar`,`vl_total`,`vl_desconto`,`datafim`,`datainicio`,`indicadorReserva`,`tipo`,`n_criancas`,`n_adultos`) VALUES (1,700.00,800.00,100.00,'2018-08-20','2018-08-08',0,1,NULL,NULL),(2,700.00,800.00,100.00,'2018-08-21','2018-08-09',0,1,NULL,NULL),(3,700.00,800.00,100.00,'2018-08-22','2018-08-10',1,1,NULL,NULL),(4,800.00,1000.00,200.00,'2018-08-23','2018-08-11',1,2,NULL,NULL),(5,800.00,1000.00,200.00,'2018-08-24','2018-08-12',1,2,NULL,NULL),(6,800.00,1000.00,200.00,'2018-08-25','2018-08-13',1,3,2,2),(7,1200.00,1500.00,300.00,'2018-08-26','2018-08-14',1,1,NULL,NULL),(8,1200.00,1500.00,300.00,'2018-08-27','2018-08-15',1,1,NULL,NULL),(9,1200.00,1500.00,300.00,'2018-08-28','2018-08-16',1,1,NULL,NULL);

INSERT INTO `pagamento` (`codigo`,`vl_pago`,`juros`,`dt_vence`,`dt_pag`,`codFatura`,`tipo`,`cod_seg`,`numero_cartao`,`dt_validade`,`tipoCartao`,`nome_titular`) VALUES (1,1000.00,2.00,'2018-09-07','2018-07-04',1,1,NULL,NULL,NULL,NULL,NULL),(2,1000.00,2.00,'2018-09-08','2018-07-05',2,2,NULL,NULL,NULL,NULL,NULL),(3,1000.00,2.00,'2018-09-09','2018-07-06',3,2,NULL,NULL,NULL,NULL,NULL),(4,1000.00,2.00,'2018-09-10','2018-07-07',4,3,121,'5453010000066167','2020-05-04',1,'Maria A'),(5,1500.00,2.00,'2018-09-11','2018-07-08',5,3,212,'4012001037141112','2020-05-05',1,'Maria B'),(6,1500.00,2.00,'2018-09-12','2018-07-09',6,1,NULL,NULL,NULL,NULL,NULL),(7,1500.00,2.00,'2018-09-13','2018-07-10',7,1,NULL,NULL,NULL,NULL,NULL),(8,1500.00,2.00,'2018-09-14','2018-07-11',8,1,NULL,NULL,NULL,NULL,NULL),(9,1000.00,2.00,'2018-09-15','2018-07-12',9,1,NULL,NULL,NULL,NULL,NULL);

INSERT INTO `parceiro` (`CNPJ`,`nome_fantasia`,`stats`,`tipo`,`ramo`) VALUES ('03.441.244/0001-06','TAM',1,1,'locação'),('16.647.823/0001-43','BRB',1,3,'locação'),('31.136.096/0001-43','GEMI',1,2,'venda'),('36.221.286/0001-82','VIA',1,1,'venda'),('88.523.192/0001-61','CVA',1,4,'locação');

INSERT INTO `passaporte` (`numero`,`pais_emissao`,`validade`,`dt_emissao`,`codcliente`) VALUES ('AA000111','BRA','2025-05-07','2015-05-07',26),('AA000112','BRA','2025-05-08','2015-05-08',27),('AA000113','BRA','2025-05-09','2015-05-09',28),('AA000114','BRA','2025-05-10','2015-05-10',29),('AA000115','BRA','2025-05-11','2015-05-11',30);

INSERT INTO `pessoa` (`cod`,`nome`,`dt_nasc`,`sexo`,`fone`,`foto`,`cep`,`num`) VALUES (1,'Maria da Silva 1','1990-06-09','F','(81)99209-9275',NULL,'30666-440',1),(2,'Maria da Silva 2','1990-06-09','F','(81)99209-9276',NULL,'30666-441',2),(3,'Maria da Silva 3','1990-06-09','F','(81)99209-9277',NULL,'30666-442',3),(4,'Maria da Silva 4','1990-06-09','F','(81)99209-9278',NULL,'30666-443',4),(5,'Maria da Silva 5','1990-06-09','F','(81)99209-9279',NULL,'30666-444',5),(6,'Maria da Silva 6','1956-08-09','F','(81)99209-9280',NULL,'30666-445',6),(7,'Maria da Silva 7','1956-08-09','F','(81)99209-9281',NULL,'30666-446',7),(8,'Maria da Silva 8','1956-08-09','F','(81)99209-9282',NULL,'30666-440',8),(9,'Sofia Souza 1','2000-04-06','F','(81)99209-9283',NULL,'30666-441',9),(10,'Sofia Souza 2','2000-04-06','F','(81)99209-9284',NULL,'30666-442',10),(11,'Sofia Souza 3','2000-04-06','F','(81)99209-9285',NULL,'30666-443',11),(12,'Sofia Souza 4','1956-08-09','F','(81)99209-9286',NULL,'30666-444',12),(13,'Sofia Souza 5','1956-08-09','F','(81)99209-9287',NULL,'30666-445',13),(14,'Sofia Souza 6','1956-08-09','F','(81)99209-9288',NULL,'75020-230',14),(15,'Sofia Souza 7','1990-06-09','F','(81)99209-9289',NULL,'75020-231',15),(16,'João Moura 1','1990-06-09','M','(81)99209-9290',NULL,'75020-232',16),(17,'João Moura 2','1990-06-09','M','(81)99209-9291',NULL,'75020-233',17),(18,'João Moura 3','1990-06-09','M','(81)99209-9292',NULL,'75020-234',18),(19,'João Moura 4','1990-06-09','M','(81)99209-9293',NULL,'75020-235',19),(20,'João Moura 5','1956-08-09','M','(81)99209-9294',NULL,'75020-230',20),(21,'João Moura 6','1980-08-05','M','(81)99209-9295',NULL,'75020-231',21),(22,'João Moura 7','1990-06-09','M','(81)99209-9296',NULL,'75020-232',22),(23,'João Moura 8','1990-05-29','M','(81)99209-9297',NULL,'75020-233',23),(24,'José Costa 1','2000-04-06','M','(81)99209-9298',NULL,'75020-234',24),(25,'José Costa 2','2000-04-06','M','(81)99209-9299',NULL,'75020-235',25),(26,'José Costa 3','2000-04-06','M','(81)99209-9300',NULL,'75020-230',26),(27,'José Costa 4','1956-08-09','M','(81)99209-9301',NULL,'75020-231',27),(28,'José Costa 5','1956-08-09','M','(81)99209-9302',NULL,'75020-232',28),(29,'José Costa 6','2000-04-06','M','(81)99209-9303',NULL,'30666-441',29),(30,'José Costa 7','2000-04-06','M','(81)99209-9304',NULL,'30666-442',30);

INSERT INTO `promocao` (`id`,`dt_fim`,`porcentagem_desconto`,`tipo`,`dt_inicio`,`codservico`) VALUES (1,'2018-06-04',20,1,'2018-05-14',1),(2,'2018-06-05',20,2,'2018-05-15',2),(3,'2018-06-06',10,1,'2018-05-16',3),(4,'2018-06-07',10,1,'2018-05-17',4),(5,'2018-06-08',10,1,'2018-05-18',5);

INSERT INTO `servico_parceiro` (`codigo`) VALUES (6),(7),(8),(9),(10);

INSERT INTO `servico_proprio` (`codigo`) VALUES (1),(2),(3),(4),(5);

INSERT INTO `servico_ref` (`codigo`,`valor`,`local_destino`,`nivel`,`tipoServico`) VALUES (1,500.00,'Recife',1,1),(2,500.00,'Recife',2,1),(3,500.00,'Recife',3,1),(4,500.00,'Recife',4,1),(5,500.00,'Recife',5,1),(6,700.00,'Caruaru',1,2),(7,700.00,'Caruaru',2,2),(8,700.00,'Caruaru',3,2),(9,700.00,'Caruaru',4,2),(10,1500.00,'Caruaru',4,2);

INSERT INTO `transporte` (`codigo`,`local_de_origem`,`data_ida`,`dt_volta`,`modalidade`,`marca`,`tipo`,`num_identificacao`,`capacidade_n_pessoas`,`motoristacod`) VALUES (8,'Recife','2018-05-01','2018-05-10','Carro','Fiat','Terrestre',1,5,11),(9,'Natal','2018-05-02','2018-05-11','Van','wolksvagem','Terrestre',2,12,12),(10,'Olinda','2018-05-03','2018-05-12','Van','wolksvagem','Terrestre',3,12,13);

INSERT INTO `visto` (`controlnumber`,`numeroPass`,`tipo`,`pais`,`dt_inicio`,`dt_fim`) VALUES ('20121940620001','AA000111','B-2','USA','2015-05-07','2025-05-07'),('20121940620002','AA000112','B-3','USA','2015-05-08','2025-05-08'),('20121940620003','AA000113','B-4','USA','2015-05-09','2025-05-09'),('20121940620004','AA000114','B-5','USA','2015-05-10','2025-05-10'),('20121940620005','AA000115','B-6','USA','2015-05-11','2025-05-11'),('20121940620006','AA000111','B-7','CANADA','2015-05-12','2025-05-12'),('20121940620007','AA000112','B-8','CANADA','2015-05-13','2025-05-13'),('20121940620008','AA000113','B-9','CANADA','2015-05-14','2025-05-14'),('20121940620009','AA000114','B-10','CANADA','2015-05-15','2025-05-15'),('20121940620010','AA000115','B-11','CANADA','2015-05-16','2025-05-16');

SET FOREIGN_KEY_CHECKS=1;