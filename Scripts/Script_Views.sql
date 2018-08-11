use AGENCIA;
create or replace view viewPacote
 as select P.codigo as 'Pacote', I.seq as  'Item', I.qtd as 'quantidade', S.tipoServico as 'tipo de Servico'
	from pacote P join item_pacote I join servico_ref S 
		on P.codigo = I.codpacote
		and  I.codservico = S.codigo 
        join servico_parceiro T ;

use AGENCIA;
create or replace view viewClienteJuridico
 as select C.codcliente as 'Cliente', PAC.cod as  'Pacote', F.id as 'Fatura', PAG.cod as 'Pagamento'
	from clienteJuridico_compra C join Pacote PAC join Fatura F join Pagamento PAG
		on  PAC.codigo = F.codpacote
		and F.id = PAG.codFatura
		and C.codpacote = PAC.codigo
	join servico_ref S;

use AGENCIA;
create or replace view viewClienteFisico
 as select C.codcliente as 'Cliente', PAC.cod as  'Pacote', F.id as 'Fatura', PAG.cod as 'Pagamento'
	from clienteJuridico_compra C join Pacote PAC join Fatura F join Pagamento PAG
		on  PAC.codigo = F.codpacote
		and F.id = PAG.codFatura
		and C.codpacote = PAC.codigo
	join servico_ref S;
       
