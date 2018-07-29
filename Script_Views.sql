use AGENCIA;
create or replace view viewPacote
 as select P.codigo as 'Pacote', I.seq as  'Item', I.qtd as 'quantidade', S.tipoServico as 'tipo de Servico'
	from pacote P join item_pacote I join servico_ref S 
		on P.codigo = I.codpacote
		and  I.codservico = S.codigo 
        join servico_parceiro T ;
