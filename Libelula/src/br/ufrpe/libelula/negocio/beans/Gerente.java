package br.ufrpe.libelula.negocio.beans;

public class Gerente {
	private Float salario;
	private Integer ramal;
	private String CPF;
	private Integer codigoPessoa;
	private String cod_Agencia;
	

	
	

	public Gerente(Float salario, Integer ramal, String cPF, Integer codigoPessoa, String cod_Agencia) {
		super();
		this.salario = salario;
		this.ramal = ramal;
		CPF = cPF;
		this.codigoPessoa = codigoPessoa;
		this.cod_Agencia = cod_Agencia;
	}

	public Integer getCodigoPessoa() {
		return codigoPessoa;
	}

	public void setCodigoPessoa(Integer codigoPessoa) {
		this.codigoPessoa = codigoPessoa;
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

	public float getSalario() {
		return salario;
	}

	public void setSalario(Float salario) {
		this.salario = salario;
	}

	public String getCod_Agencia() {
		return cod_Agencia;
	}

	public void setCod_Agencia(String cod_Agencia) {
		this.cod_Agencia = cod_Agencia;
	}
	

}
