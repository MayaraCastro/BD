package br.ufrpe.libelula.negocio.beans;

import java.sql.Date;

public class Acomodacao extends Servico_Ref{
	private int codigo;
	private String descricao;
	private Date data_entrada;
	private Date dt_saida;
	private int capacidade_pessoas;
	private int fumante;
	private int no_estrelas;
	private String tipo;
	
	
	public Acomodacao(int codigo, String descricao,	Date data_entrada, Date dt_saida, int capacidade_pessoas, 
					  int fumante, int no_estrelas,	String tipo) {
		super();
		this.codigo = codigo;
		this.descricao = descricao;
		this.data_entrada = data_entrada;
		this.dt_saida = dt_saida;
		this.capacidade_pessoas = capacidade_pessoas;
		this.fumante = fumante;
		this.no_estrelas = no_estrelas;
		this.tipo = tipo;
		
	}
	
	
	public Acomodacao(int codigo, float valor, String local_destino, Integer nivel, int tipoServico, int codigo2,
			String descricao, Date data_entrada, Date dt_saida, int capacidade_pessoas, int fumante, int no_estrelas,
			String tipo) {
		super(codigo, valor, local_destino, nivel, tipoServico);
		codigo = codigo2;
		this.descricao = descricao;
		this.data_entrada = data_entrada;
		this.dt_saida = dt_saida;
		this.capacidade_pessoas = capacidade_pessoas;
		this.fumante = fumante;
		this.no_estrelas = no_estrelas;
		this.tipo = tipo;
	}

	public Date getData_entrada() {
		return data_entrada;
	}


	public void setData_entrada(Date data_entrada) {
		this.data_entrada = data_entrada;
	}


	public Date getDt_saida() {
		return dt_saida;
	}


	public void setDt_saida(Date dt_saida) {
		this.dt_saida = dt_saida;
	}


	public int getCodigo() {
		return codigo;
	}


	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}


	public String getDescricao() {
		return descricao;
	}


	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}


	public int getCapacidade_pessoas() {
		return capacidade_pessoas;
	}


	public void setCapacidade_pessoas(int capacidade_pessoas) {
		this.capacidade_pessoas = capacidade_pessoas;
	}


	public int getFumante() {
		return fumante;
	}


	public void setFumante(int fumante) {
		this.fumante = fumante;
	}


	public int getNo_estrelas() {
		return no_estrelas;
	}


	public void setNo_estrelas(int no_estrelas) {
		this.no_estrelas = no_estrelas;
	}


	public String getTipo() {
		return tipo;
	}


	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
}
