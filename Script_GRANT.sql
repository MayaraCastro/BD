use AGENCIA;

DROP USER 'admin'@'localhost';
DROP USER 'gerente'@'localhost';
DROP USER 'agente'@'localhost';


	#####################
	#	ADMINISTRADOR	#
	#####################
CREATE USER 'admin'@'localhost' IDENTIFIED BY 'admin';
GRANT ALL PRIVILEGES ON agencia.* TO 'admin'@'localhost';
FLUSH PRIVILEGES;

	#################
    #	GERENTE 	#
    #################
CREATE USER 'gerente'@'localhost' IDENTIFIED BY 'gerente';

GRANT INSERT ON agencia.cliente_fisico TO 'gerente'@'localhost';
GRANT DELETE ON agencia.cliente_fisico TO 'gerente'@'localhost';
GRANT SELECT ON agencia.cliente_fisico TO 'gerente'@'localhost';
GRANT UPDATE ON agencia.cliente_fisico TO 'gerente'@'localhost';

GRANT INSERT ON agencia.passaporte TO 'gerente'@'localhost';
GRANT DELETE ON agencia.passaporte TO 'gerente'@'localhost';
GRANT SELECT ON agencia.passaporte TO 'gerente'@'localhost';
GRANT UPDATE ON agencia.passaporte TO 'gerente'@'localhost';

GRANT INSERT ON agencia.visto TO 'gerente'@'localhost';
GRANT DELETE ON agencia.visto TO 'gerente'@'localhost';
GRANT SELECT ON agencia.visto TO 'gerente'@'localhost';
GRANT UPDATE ON agencia.visto TO 'gerente'@'localhost';

GRANT INSERT ON agencia.cliente_juridico TO 'gerente'@'localhost';
GRANT DELETE ON agencia.cliente_juridico TO 'gerente'@'localhost';
GRANT SELECT ON agencia.cliente_juridico TO 'gerente'@'localhost';
GRANT UPDATE ON agencia.cliente_juridico TO 'gerente'@'localhost';

GRANT INSERT ON agencia.malaDireta TO 'gerente'@'localhost';
GRANT DELETE ON agencia.malaDireta TO 'gerente'@'localhost';
GRANT SELECT ON agencia.malaDireta TO 'gerente'@'localhost';
GRANT UPDATE ON agencia.malaDireta TO 'gerente'@'localhost';

GRANT INSERT ON agencia.arquivo_pdf TO 'gerente'@'localhost';
GRANT DELETE ON agencia.arquivo_pdf TO 'gerente'@'localhost';
GRANT SELECT ON agencia.arquivo_pdf TO 'gerente'@'localhost';
GRANT UPDATE ON agencia.arquivo_pdf TO 'gerente'@'localhost';

GRANT INSERT ON agencia.clienteFisico_recebe_malaDireta TO 'gerente'@'localhost';
GRANT DELETE ON agencia.clienteFisico_recebe_malaDireta TO 'gerente'@'localhost';
GRANT SELECT ON agencia.clienteFisico_recebe_malaDireta TO 'gerente'@'localhost';
GRANT UPDATE ON agencia.clienteFisico_recebe_malaDireta TO 'gerente'@'localhost';

GRANT INSERT ON agencia.clienteJuridico_recebe_malaDireta TO 'gerente'@'localhost';
GRANT DELETE ON agencia.clienteJuridico_recebe_malaDireta TO 'gerente'@'localhost';
GRANT SELECT ON agencia.clienteJuridico_recebe_malaDireta TO 'gerente'@'localhost';
GRANT UPDATE ON agencia.clienteJuridico_recebe_malaDireta TO 'gerente'@'localhost';

GRANT INSERT ON agencia.clientefisico_compra TO 'gerente'@'localhost';
GRANT DELETE ON agencia.clientefisico_compra TO 'gerente'@'localhost';
GRANT SELECT ON agencia.clientefisico_compra TO 'gerente'@'localhost';
GRANT UPDATE ON agencia.clientefisico_compra TO 'gerente'@'localhost';

GRANT INSERT ON agencia.clientejuridico_compra TO 'gerente'@'localhost';
GRANT DELETE ON agencia.clientejuridico_compra TO 'gerente'@'localhost';
GRANT SELECT ON agencia.clientejuridico_compra TO 'gerente'@'localhost';
GRANT UPDATE ON agencia.clientejuridico_compra TO 'gerente'@'localhost';

GRANT INSERT ON agencia.intercambio TO 'gerente'@'localhost';
GRANT DELETE ON agencia.intercambio TO 'gerente'@'localhost';
GRANT SELECT ON agencia.intercambio TO 'gerente'@'localhost';
GRANT UPDATE ON agencia.intercambio TO 'gerente'@'localhost';

GRANT INSERT ON agencia.acomodacao TO 'gerente'@'localhost';
GRANT DELETE ON agencia.acomodacao TO 'gerente'@'localhost';
GRANT SELECT ON agencia.acomodacao TO 'gerente'@'localhost';
GRANT UPDATE ON agencia.acomodacao TO 'gerente'@'localhost';

GRANT INSERT ON agencia.evento TO 'gerente'@'localhost';
GRANT DELETE ON agencia.evento TO 'gerente'@'localhost';
GRANT SELECT ON agencia.evento TO 'gerente'@'localhost';
GRANT UPDATE ON agencia.evento TO 'gerente'@'localhost';

GRANT INSERT ON agencia.transporte TO 'gerente'@'localhost';
GRANT DELETE ON agencia.transporte TO 'gerente'@'localhost';
GRANT SELECT ON agencia.transporte TO 'gerente'@'localhost';
GRANT UPDATE ON agencia.transporte TO 'gerente'@'localhost';

GRANT INSERT ON agencia.servico_proprio TO 'gerente'@'localhost';
GRANT DELETE ON agencia.servico_proprio TO 'gerente'@'localhost';
GRANT SELECT ON agencia.servico_proprio TO 'gerente'@'localhost';
GRANT UPDATE ON agencia.servico_proprio TO 'gerente'@'localhost';

GRANT INSERT ON agencia.servico_parceiro TO 'gerente'@'localhost';
GRANT DELETE ON agencia.servico_parceiro TO 'gerente'@'localhost';
GRANT SELECT ON agencia.servico_parceiro TO 'gerente'@'localhost';
GRANT UPDATE ON agencia.servico_parceiro TO 'gerente'@'localhost';

GRANT INSERT ON agencia.promocao TO 'gerente'@'localhost';
GRANT DELETE ON agencia.promocao TO 'gerente'@'localhost';
GRANT SELECT ON agencia.promocao TO 'gerente'@'localhost';
GRANT UPDATE ON agencia.promocao TO 'gerente'@'localhost';

GRANT INSERT ON agencia.servico_ref TO 'gerente'@'localhost';
GRANT DELETE ON agencia.servico_ref TO 'gerente'@'localhost';
GRANT SELECT ON agencia.servico_ref TO 'gerente'@'localhost';
GRANT UPDATE ON agencia.servico_ref TO 'gerente'@'localhost';


GRANT INSERT ON agencia.item_pacote TO 'gerente'@'localhost';
GRANT DELETE ON agencia.item_pacote TO 'gerente'@'localhost';
GRANT SELECT ON agencia.item_pacote TO 'gerente'@'localhost';
GRANT UPDATE ON agencia.item_pacote TO 'gerente'@'localhost';


FLUSH PRIVILEGES;


	#############
    #	AGENTE	#
    #############
    
CREATE USER 'agente'@'localhost' IDENTIFIED BY 'agente';

GRANT SELECT ON agencia.cliente_fisico TO 'agente'@'localhost';
GRANT SELECT ON agencia.cliente_juridico TO 'agente'@'localhost';

GRANT SELECT ON agencia.pacote TO 'agente'@'localhost';

GRANT INSERT ON agencia.clientefisico_compra TO 'agente'@'localhost';
GRANT SELECT ON agencia.clientefisico_compra TO 'agente'@'localhost';
GRANT UPDATE ON agencia.clientefisico_compra TO 'agente'@'localhost';

GRANT INSERT ON agencia.clientejuridico_compra TO 'agente'@'localhost';
GRANT SELECT ON agencia.clientejuridico_compra TO 'agente'@'localhost';
GRANT UPDATE ON agencia.clientejuridico_compra TO 'agente'@'localhost';

GRANT INSERT ON agencia.fatura TO 'agente'@'localhost';
GRANT UPDATE ON agencia.fatura TO 'agente'@'localhost';
GRANT SELECT ON agencia.fatura TO 'agente'@'localhost';

GRANT INSERT ON agencia.pagamento TO 'agente'@'localhost';
GRANT UPDATE ON agencia.pagamento TO 'agente'@'localhost';
GRANT SELECT ON agencia.pagamento TO 'agente'@'localhost';

FLUSH PRIVILEGES;
