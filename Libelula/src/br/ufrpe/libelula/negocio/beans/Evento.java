package br.ufrpe.libelula.negocio.beans;

import java.sql.Date;

public class Evento extends Servico_Ref{
	private int codigo;
	private String status;
	private Date data_entrada;
	private Date dt_fim;
	private String nome;
	private String detalhe;
	private int tipo;
	private String vl_desc;
	private String obs;
	private int guiacod;
	
	public Evento(int codigo, String status, Date data_entrada,	Date dt_fim, String nome, String detalhe, int tipo,
				  String vl_desc, String obs, int guiacod) {
		super();
		this.codigo = codigo;
		this.status = status;
		this.data_entrada = data_entrada;
		this.dt_fim = dt_fim;
		this.nome = nome;
		this.detalhe = detalhe;
		this.tipo = tipo;
		this.vl_desc = vl_desc;
		this.obs = obs;
		this.guiacod = codigo;
	}
	
	
	public Evento(int cod, float valor, String local_destino, Integer nivel, int tipoServico, int codigo, String status, Date data_entrada,	Date dt_fim, String nome, String detalhe, int tipo,
			  String vl_desc, String obs, int guiacod) {
		super(cod, valor, local_destino, nivel, tipoServico);
		this.codigo = codigo;
		this.status = status;
		this.data_entrada = data_entrada;
		this.dt_fim = dt_fim;
		this.nome = nome;
		this.detalhe = detalhe;
		this.tipo = tipo;
		this.vl_desc = vl_desc;
		this.obs = obs;
		this.guiacod = codigo;
	}


	public int getCodigo() {
		return codigo;
	}


	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public Date getData_entrada() {
		return data_entrada;
	}


	public void setData_entrada(Date data_entrada) {
		this.data_entrada = data_entrada;
	}


	public Date getDt_fim() {
		return dt_fim;
	}


	public void setDt_fim(Date dt_fim) {
		this.dt_fim = dt_fim;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getDetalhe() {
		return detalhe;
	}


	public void setDetalhe(String detalhe) {
		this.detalhe = detalhe;
	}


	public int getTipo() {
		return tipo;
	}


	public void setTipo(int tipo) {
		this.tipo = tipo;
	}


	public String getVl_desc() {
		return vl_desc;
	}


	public void setVl_desc(String vl_desc) {
		this.vl_desc = vl_desc;
	}


	public String getObs() {
		return obs;
	}


	public void setObs(String obs) {
		this.obs = obs;
	}


	public int getGuiacod() {
		return guiacod;
	}


	public void setGuiacod(int guiacod) {
		this.guiacod = guiacod;
	}
	
	

}
