package br.ufrpe.libelula.negocio.beans;

public class Gerente extends Pessoa{
	private String CPF;
	private Integer ramal;
	private double salario;
	private String cod_Agencia;
	
	public Gerente(String cPF, Integer ramal, double salario, String cod_Agencia) {
		super();
		CPF = cPF;
		this.ramal = ramal;
		this.salario = salario;
		this.cod_Agencia = cod_Agencia;
	}

	public String getCPF() {
		return CPF;
	}

	public void setCPF(String cPF) {
		CPF = cPF;
	}

	public Integer getRamal() {
		return ramal;
	}

	public void setRamal(Integer ramal) {
		this.ramal = ramal;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	public String getCod_Agencia() {
		return cod_Agencia;
	}

	public void setCod_Agencia(String cod_Agencia) {
		this.cod_Agencia = cod_Agencia;
	}
	

}
