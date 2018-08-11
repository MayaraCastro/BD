package br.ufrpe.libelula.negocio.beans;

import java.time.LocalDate;

public class ClienteFisico extends Pessoa{
	private int cod2;
	private String agencia;
	private String CPF;
	private int tipo;
	public ClienteFisico(Integer cod, String nome, LocalDate dt_nasc, String sexo, String fone, byte[] foto, String cep,
			Integer num, int cod2, String agencia, String CPF, int tipo) {
		super(cod, nome, dt_nasc, sexo, fone, foto, cep, num);
		this.cod2 = cod2;
		this.agencia = agencia;
		this.CPF = CPF;
		this.tipo = tipo;
	}
	public ClienteFisico(int cod2, String agencia, String CPF, int tipo) {
		super();
		this.cod2 = cod2;
		this.agencia = agencia;
		this.CPF = CPF;
		this.tipo = tipo;
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
	public String getCPF() {
		return CPF;
	}
	public void setCPF(String cPF) {
		CPF = cPF;
	}
	public int getTipo() {
		return tipo;
	}
	public void setTipo(int tipo) {
		this.tipo = tipo;
	}
	
	
}
