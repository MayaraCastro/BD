use AGENCIA;

-- FUNCTIONS
#1.  para retornar se um CLIENTE está apto a uma certa VIAGEM durante o gerenciamento de seus ITEM_PACOTE com a informação de seu VISTO

delimiter $$
create function cliente_apto (cod int, pais varchar(50), dt_inicio date, dt_fim date) returns bool
 begin
	declare visto_dt_inicio date;
    declare visto_dt_fim date;
    
    select V.dt_inicio, V.dt_fim  into visto_dt_inicio, visto_dt_fim
		from visto V join passaporte P
        on	V.numeroPass = P.numero and P.codcliente = cod
        where
			V.pais = pais;
	
    if dt_inicio >= visto_dt_inicio and dt_fim <= visto_dt_fim then
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