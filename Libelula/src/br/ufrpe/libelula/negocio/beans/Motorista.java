package br.ufrpe.libelula.negocio.beans;

import java.time.LocalDate;

public class Motorista extends Pessoa{
	private Float salario;
	private Integer ramal;
	private String CPF;
	private String cod_Agencia;

	
	public Motorista(String nome, LocalDate dt_nasc, String sexo, String fone, byte[] foto, String cep, Integer num,
			Float salario, Integer ramal, String cPF, String cod_Agencia) {
		super(nome, dt_nasc, sexo, fone, foto, cep, num);
		this.salario = salario;
		this.ramal = ramal;
		CPF = cPF;
		this.cod_Agencia = cod_Agencia;
	}


	public Motorista(Integer cod, String nome, LocalDate dt_nasc, String sexo, String fone, byte[] foto, String cep,
			Integer num, Float salario, Integer ramal, String cPF, String cod_Agencia) {
		super(cod, nome, dt_nasc, sexo, fone, foto, cep, num);
		this.salario = salario;
		this.ramal = ramal;
		CPF = cPF;
		this.cod_Agencia = cod_Agencia;
	}


	public Motorista(Float salario, Integer ramal, String cPF,Integer cod, String cod_Agencia) {
		super(cod);
		this.salario = salario;
		this.ramal = ramal;
		CPF = cPF;
		this.cod_Agencia = cod_Agencia;
	}
	

	public Motorista() {
		// TODO Auto-generated constructor stub
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
