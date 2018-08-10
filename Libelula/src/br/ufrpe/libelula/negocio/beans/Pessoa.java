package br.ufrpe.libelula.negocio.beans;

import java.time.LocalDate;


public class Pessoa {
	private Integer cod;
	private String nome;
	private LocalDate dt_nasc;
	private String sexo;
	private String fone;
	private byte[] foto;
	private String cep;
	private Integer num ;	
	
	
	public Pessoa(Integer cod) {
		super();
		this.cod = cod;
	}
	public Pessoa(String nome, LocalDate dt_nasc, String sexo, String fone, byte[] foto, String cep, Integer num) {
		super();
		this.nome = nome;
		this.dt_nasc = dt_nasc;
		this.sexo = sexo;
		this.fone = fone;
		this.foto = foto;
		this.cep = cep;
		this.num = num;
	}
	public Pessoa(Integer cod, String nome, LocalDate dt_nasc, String sexo, String fone, byte[] foto, String cep,
			Integer num) {
		super();
		this.cod = cod;
		this.nome = nome;
		this.dt_nasc = dt_nasc;
		this.sexo = sexo;
		this.fone = fone;
		this.foto = foto;
		this.cep = cep;
		this.num = num;
	}
	public Pessoa() {
		// TODO Auto-generated constructor stub
	}
	public Integer getCod() {
		return cod;
	}
	public void setCod(Integer cod) {
		this.cod = cod;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public LocalDate getDt_nasc() {
		return dt_nasc;
	}
	public void setDt_nasc(LocalDate dt_nasc) {
		this.dt_nasc = dt_nasc;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public String getFone() {
		return fone;
	}
	public void setFone(String fone) {
		this.fone = fone;
	}
	public byte[] getFoto() {
		return foto;
	}
	public void setFoto(byte[] foto) {
		this.foto = foto;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public Integer getNum() {
		return num;
	}
	public void setNum(Integer num) {
		this.num = num;
	}
	
	
	
}
