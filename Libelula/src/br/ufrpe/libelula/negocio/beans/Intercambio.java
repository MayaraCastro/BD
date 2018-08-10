package br.ufrpe.libelula.negocio.beans;

import java.sql.Date;

public class Intercambio extends Servico_Ref{
	private int codigo;
	private String obs;
	private String detalhe;
	private String tipo_intercambio;
	private String cargo;
	private Date dt_inicio;
	private Date dt_fim;
	private String cargaHoraria;
	private String nome_curso;
	private String lingua;
	
	public Intercambio(int codigo,	String obs,	String detalhe,	String tipo_intercambio, String cargo,	Date dt_inicio,
					   Date dt_fim,	String cargaHoraria, String nome_curso,	String lingua) {
		super();
		this.codigo = codigo;
		this.obs = obs;
		this.detalhe = detalhe;
		this.tipo_intercambio = tipo_intercambio;
		this.cargo = cargo;
		this.dt_inicio = dt_inicio;
		this.dt_fim = dt_fim;
		this.cargaHoraria = cargaHoraria;
		this.nome_curso = nome_curso;
		this.lingua = lingua;
		
	}
	
	public Intercambio(int codigo, float valor, String local_destino, Integer nivel, int tipoServico, 
					   int codigo2,	String obs,	String detalhe,	String tipo_intercambio, String cargo,	
					   Date dt_inicio, Date dt_fim,	String cargaHoraria, String nome_curso,	String lingua) {
		super(codigo, valor, local_destino, nivel, tipoServico);
		this.codigo = codigo2;
		this.obs = obs;
		this.detalhe = detalhe;
		this.tipo_intercambio = tipo_intercambio;
		this.cargo = cargo;
		this.dt_inicio = dt_inicio;
		this.dt_fim = dt_fim;
		this.cargaHoraria = cargaHoraria;
		this.nome_curso = nome_curso;
		this.lingua = lingua;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getObs() {
		return obs;
	}

	public void setObs(String obs) {
		this.obs = obs;
	}

	public String getDetalhe() {
		return detalhe;
	}

	public void setDetalhe(String detalhe) {
		this.detalhe = detalhe;
	}

	public String getTipo_intercambio() {
		return tipo_intercambio;
	}

	public void setTipo_intercambio(String tipo_intercambio) {
		this.tipo_intercambio = tipo_intercambio;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public Date getDt_inicio() {
		return dt_inicio;
	}

	public void setDt_inicio(Date dt_inicio) {
		this.dt_inicio = dt_inicio;
	}

	public Date getDt_fim() {
		return dt_fim;
	}

	public void setDt_fim(Date dt_fim) {
		this.dt_fim = dt_fim;
	}

	public String getCargaHoraria() {
		return cargaHoraria;
	}

	public void setCargaHoraria(String cargaHoraria) {
		this.cargaHoraria = cargaHoraria;
	}

	public String getNome_curso() {
		return nome_curso;
	}

	public void setNome_curso(String nome_curso) {
		this.nome_curso = nome_curso;
	}

	public String getLingua() {
		return lingua;
	}

	public void setLingua(String lingua) {
		this.lingua = lingua;
	}
}
