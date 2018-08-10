package br.ufrpe.libelula.negocio.beans;

import java.sql.Date;

public class Transporte extends Servico_Ref{
	private int codigo;
	private String local_de_origem;
	private Date data_ida;
	private Date dt_volta;
	private String modalidade;
	private String marca;
	private int tipo;
	private int num_identificacao;
	private int capacidade_n_pessoas;
	private int motoristacod;
	
	public Transporte(int cod, String local_de_origem, Date data_ida, Date dt_volta, String modalidade, String marca,
					  int tipo, int num_identificacao, int capacidade_n_pessoas, int motoristacod){
		super();
		this.codigo = cod;
		this.local_de_origem = local_de_origem;
		this.data_ida = data_ida;
		this.dt_volta = dt_volta;
		this.modalidade = modalidade;
		this.marca = marca;
		this.tipo = tipo;
		this.num_identificacao = num_identificacao;
		this.capacidade_n_pessoas = capacidade_n_pessoas;
		this.motoristacod = motoristacod;
		
	}
	
	
	public Transporte(int cod, float valor, String local_destino, Integer nivel, int tipoServico, int codigo, String local_de_origem, Date data_ida, Date dt_volta, String modalidade, String marca,
			  int tipo, int num_identificacao, int capacidade_n_pessoas, int motoristacod) {
		super(cod, valor, local_destino, nivel, tipoServico);
		this.codigo = codigo;
		this.local_de_origem = local_de_origem;
		this.data_ida = data_ida;
		this.dt_volta = dt_volta;
		this.modalidade = modalidade;
		this.marca = marca;
		this.tipo = tipo;
		this.num_identificacao = num_identificacao;
		this.capacidade_n_pessoas = capacidade_n_pessoas;
		this.motoristacod = motoristacod;
	}


	public int getCodigo() {
		return codigo;
	}


	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}


	public String getLocal_de_origem() {
		return local_de_origem;
	}


	public void setLocal_de_origem(String local_de_origem) {
		this.local_de_origem = local_de_origem;
	}


	public Date getData_ida() {
		return data_ida;
	}


	public void setData_ida(Date data_ida) {
		this.data_ida = data_ida;
	}


	public Date getDt_volta() {
		return dt_volta;
	}


	public void setDt_volta(Date dt_volta) {
		this.dt_volta = dt_volta;
	}


	public String getModalidade() {
		return modalidade;
	}


	public void setModalidade(String modalidade) {
		this.modalidade = modalidade;
	}


	public String getMarca() {
		return marca;
	}


	public void setMarca(String marca) {
		this.marca = marca;
	}


	public int getTipo() {
		return tipo;
	}


	public void setTipo(int tipo) {
		this.tipo = tipo;
	}


	public int getNum_identificacao() {
		return num_identificacao;
	}


	public void setNum_identificacao(int num_identificacao) {
		this.num_identificacao = num_identificacao;
	}


	public int getCapacidade_n_pessoas() {
		return capacidade_n_pessoas;
	}


	public void setCapacidade_n_pessoas(int capacidade_n_pessoas) {
		this.capacidade_n_pessoas = capacidade_n_pessoas;
	}


	public int getMotoristacod() {
		return motoristacod;
	}


	public void setMotoristacod(int motoristacod) {
		this.motoristacod = motoristacod;
	}
}
