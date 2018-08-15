use AGENCIA;

            
insert into agente(cod, cpf, cod_agencia) values (1, '102.104.547-85','62.252.681/0001-32' );
delete from cliente_fisico where cod = 26;
insert into cliente_fisico(cod,cpf, agencia, tipo) values(26,'428.703.331-02','62.252.681/0001-32',1);

call gera_malaDireta(2);
select @val:=SUM(f.stats)
		from fatura f join pacote p join clienteJuridico_compra cj join clienteFisico_compra cf 
		on cj.codcliente = 21 or cf.codcliente = 21
		where
				f.codpacote = p.codigo;
                
select cliente_apto(27,'USA', '2014-05-07', '2016-05-20');
select cliente_apto(27,'USA', '2016-05-07', '2016-05-20');
-- FUNCTIONS
#1.  para retornar se um CLIENTE está apto a uma certa VIAGEM durante o gerenciamento de seus ITEM_PACOTE com a informação de seu VISTO
drop function cliente_apto;
delimiter $$
create function cliente_apto (cod int, pais varchar(50), dt_inicio Date, dt_fim date) returns boolean
 begin
	declare visto_dt_inicio date;
    declare visto_dt_fim date;

    select V.dt_inicio, V.dt_fim  into visto_dt_inicio, visto_dt_fim
		from visto V join passaporte P
        on	V.numeroPass = P.numero and P.codcliente = cod
        where
			V.pais = pais;
	
    if  dt_inicio > visto_dt_inicio and dt_fim <  visto_dt_fim then
		
			return true;
            
	else
		return false;
	end if;
 end;
$$



#2.   para retornar se o CLIENTE esta em dias com seus pagamentos de FATURAS

delimiter $$ 
create function cliente_em_dias (cod int, tipo int) returns bool
    begin
    DECLARE val int(11);
	if(tipo=0) then
		select SUM(cj.stats) INTO val
		from fatura f join pacote p join clienteJuridico_compra cj
		on cj.codcliente = cod
		where
			f.codpacote = p.codigo and p.codigo=cj.codpacote;
	else
		select SUM(cf.stats) INTO val
		from fatura f join pacote p join clienteFisico_compra cf
		on cf.codcliente = p.cod
		where
				f.codpacote = p.codigo and p.codigo=cj.codpacote;
	end if;

	if val = 0 then
		return true;
	else
		return false;
	end if;		
	end;
$$



-- PROCEDURES
#1. para gerar malas diretas com textos promocionais em função do consumo de pacotes dos CLIENTEs
delimiter $$
create procedure gera_malaDireta(in tipo_pacote int)
	begin
		if( tipo_pacote = 1 ) then
			INSERT INTO malaDireta (texto, dt_criacao) VALUES ('Promocao Grupo', curdate());
        
        else if( tipo_pacote = 2) then
			INSERT INTO malaDireta (texto, dt_criacao) VALUES ('Promocao Casal', curdate());
        else 
			INSERT INTO malaDireta (texto, dt_criacao) VALUES ('Promocao Individual', curdate());
		end if;
        end if;
    end;
$$ 

#2. para verificar se o "status" de uma FATURA em função dos PAGAMENTOS 


delimiter $$
create procedure Fatura_Pagamentos()
begin
	DECLARE done INT DEFAULT 0;
	DECLARE var1, var2 date;

	DECLARE curs CURSOR FOR (
		select dt_pag, dt_fatura from pagamento join fatura on id = codFatura
	);

	DECLARE CONTINUE HANDLER FOR NOT FOUND SET done = 1;

	OPEN curs;

	REPEAT

		FETCH curs INTO var1, var2;
			IF NOT done THEN
				if datediff(var1,var2) > 0 then
					update fatura set stats = 1;
				else
					update fatura set stats = 0;
				end if;
			END IF;
		UNTIL done END REPEAT;
end
$$

-- TRIGGERS

delimiter $$
create trigger atualiza_num_empregados_agente_delete 
before delete on agente
for each row
begin

	if(old.cod_agencia is not null)then
		update agencia set num_funcionarios = num_funcionarios - 1 where CNPJ = old.cod_agencia;
    end if;
end;
$$

delimiter $$
create trigger atualiza_num_empregados_agente_insert 
after insert on agente
for each row
begin
	if(new.cod_agencia is not null)then
		update agencia set num_funcionarios = num_funcionarios + 1 where CNPJ = new.cod_agencia;
    end if;
end;
$$

delimiter $$
create trigger atualiza_num_empregados_guia_insert 
after insert on guia
for each row
begin
	if(new.cod_agencia is not null)then
		update agencia set num_funcionarios = num_funcionarios + 1 where CNPJ = new.cod_agencia;
    end if;
end;
$$

delimiter $$
create trigger atualiza_num_empregados_guia_delete
after delete on guia
for each row
begin
	if(old.cod_agencia is not null)then
		update agencia set num_funcionarios = num_funcionarios - 1 where CNPJ = old.cod_agencia;
    end if;
end;
$$

delimiter $$
create trigger atualiza_num_empregados_motorista_insert 
after insert on motorista
for each row
begin
	if(new.cod_agencia is not null)then
		update agencia set num_funcionarios = num_funcionarios + 1 where CNPJ = new.cod_agencia;
    end if;
end;
$$

delimiter $$
create trigger atualiza_num_empregados_motorista_delete
after delete on motorista
for each row
begin
	if(old.cod_agencia is not null)then
		update agencia set num_funcionarios = num_funcionarios - 1 where CNPJ = old.cod_agencia;
    end if;
end;
$$

delimiter $$
create trigger atualiza_num_empregados_gerente_insert 
after insert on gerente
for each row
begin
	if(new.cod_agencia is not null)then
		update agencia set num_funcionarios = num_funcionarios + 1 where CNPJ = new.cod_agencia;
    end if;
end;
$$

delimiter $$
create trigger atualiza_num_empregados_gerente_delete
after delete on gerente
for each row
begin
	if(old.cod_agencia is not null)then
		update agencia set num_funcionarios = num_funcionarios - 1 where CNPJ = old.cod_agencia;
    end if;
end;
$$

#2.  Para atualizar o  atributo "numero_clientes" de AGENCIA 
delimiter $$
create trigger atualiza_num_clientes_fisico_delete 
before delete on cliente_fisico
for each row
begin

	if(old.agencia is not null)then
		update agencia set num_cliente = num_cliente - 1 where CNPJ = old.agencia;
    end if;
end;

$$
delimiter $$
create trigger atualiza_num_clientes_juridico_delete 
before delete on cliente_juridico
for each row
begin

	if(old.agencia is not null)then
		update agencia set num_cliente = num_cliente - 1 where CNPJ = old.agencia;
    end if;
end;
$$

delimiter $$
create trigger atualiza_num_clientes_fisico_insert 
after insert on cliente_fisico
for each row
begin
	if(new.agencia is not null)then
		update agencia set num_cliente = num_cliente + 1 where CNPJ = new.agencia;
    end if;
end;
$$

delimiter $$
create trigger atualiza_num_clientes_juridico_insert 
after insert on cliente_juridico
for each row
begin
	if(new.agencia is not null)then
		update agencia set num_cliente = num_cliente + 1 where CNPJ = new.agencia;
    end if;
end;
$$
