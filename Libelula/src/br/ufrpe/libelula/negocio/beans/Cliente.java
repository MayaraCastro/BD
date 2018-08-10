package br.ufrpe.libelula.negocio.beans;

import java.time.LocalDate;

public class Cliente extends Pessoa{
	private String cod_Agencia;
	
	public Cliente() {
		super();
	}

	public Cliente(Integer cod, String nome, LocalDate dt_nasc, String sexo, String fone, byte[] foto, String cep,
			Integer num, String cod_Agencia) {
		super(cod, nome, dt_nasc, sexo, fone, foto, cep, num);
		this.cod_Agencia = cod_Agencia;
	}
	
	public Cliente(String nome, LocalDate dt_nasc, String sexo, String fone, byte[] foto, String cep, Integer num, String cod_Agencia) {
		super(nome, dt_nasc, sexo, fone, foto, cep, num);
		this.cod_Agencia = cod_Agencia;
	}

	public String getCod_Agencia() {
		return cod_Agencia;
	}

	public void setCod_Agencia(String cod_Agencia) {
		this.cod_Agencia = cod_Agencia;
	}
	
	


}
