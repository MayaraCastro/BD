package br.ufrpe.libelula.negocio.beans;

import java.time.LocalDate;

public class ClienteJuridico extends Pessoa{
	private int cod2;
	private String agencia;
	private String CNPJ;
	private String nome_fantasia;
	
	public ClienteJuridico(Integer cod, String nome, LocalDate dt_nasc, String sexo, String fone, byte[] foto, String cep,
			Integer num, int cod2, String agencia, String CNPJ, String nome_fantasia) {
		super(cod, nome, dt_nasc, sexo, fone, foto, cep, num);
		this.cod2 = cod2;
		this.agencia = agencia;
		this.CNPJ = CNPJ;
		this.nome_fantasia = nome_fantasia;
	}
	public ClienteJuridico(int cod2, String agencia, String CNPJ, String nome_fantasia) {
		super();
		this.cod2 = cod2;
		this.agencia = agencia;
		this.CNPJ = CNPJ;
		this.nome_fantasia = nome_fantasia;
	}
	public int getCodigo() {
		return cod2;
	}
	public void setCodigo(int cod) {
		this.cod2 = cod;
	}
	public String getAgencia() {
		return agencia;
	}
	public void setAgencia(String agencia) {
		this.agencia = agencia;
	}
	public String getCNPJ() {
		return CNPJ;
	}
	public void setCNPJ(String CNPJ) {
		this.CNPJ = CNPJ;
	}
	public String getNome_Fantasia() {
		return nome_fantasia;
	}
	public void setNome_Fantasia(String nome_fantasia) {
		this.nome_fantasia = nome_fantasia;
	}
}
