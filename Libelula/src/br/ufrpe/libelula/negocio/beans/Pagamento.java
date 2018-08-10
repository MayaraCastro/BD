package br.ufrpe.libelula.negocio.beans;

import java.sql.Date;

public class Pagamento {
	private int codigo;
	private double vl_pagamento;
	private double juros;
	private Date dt_vence;
	private Date dt_pag;
	private int codFatura;
	private int tipo;
	private int cod_seg;
	private String numero_cartao;
	private Date dt_validade;
	private int tipoCartao;
	private String nome_titular;
	

	public Pagamento(int codigo, double vl_pagamento, double juros, Date dt_vence, Date dt_pag, int codFatura, int tipo,
			int cod_seg, String numero_cartao, Date dt_validade, int tipoCartao, String nome_titular) {
		super();
		this.codigo = codigo;
		this.vl_pagamento = vl_pagamento;
		this.juros = juros;
		this.dt_vence = dt_vence;
		this.dt_pag = dt_pag;
		this.codFatura = codFatura;
		this.tipo = tipo;
		this.cod_seg = cod_seg;
		this.numero_cartao = numero_cartao;
		this.dt_validade = dt_validade;
		this.tipoCartao = tipoCartao;
		this.nome_titular = nome_titular;
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public double getVl_pagamento() {
		return vl_pagamento;
	}
	public void setVl_pagamento(double vl_pagamento) {
		this.vl_pagamento = vl_pagamento;
	}
	public Date getDt_vence() {
		return dt_vence;
	}
	public void setDt_vence(Date dt_vence) {
		this.dt_vence = dt_vence;
	}
	public Date getDt_pag() {
		return dt_pag;
	}
	public void setDt_pag(Date dt_pag) {
		this.dt_pag = dt_pag;
	}
	public int getCodFatura() {
		return codFatura;
	}
	public void setCodFatura(int codFatura) {
		this.codFatura = codFatura;
	}
	public int getTipo() {
		return tipo;
	}
	public void setTipo(int tipo) {
		this.tipo = tipo;
	}
	public int getCod_seg() {
		return cod_seg;
	}
	public void setCod_seg(int cod_seg) {
		this.cod_seg = cod_seg;
	}
	public String getNumero_cartao() {
		return numero_cartao;
	}
	public void setNumero_cartao(String numero_cartao) {
		this.numero_cartao = numero_cartao;
	}
	public Date getDt_validade() {
		return dt_validade;
	}
	public void setDt_validade(Date dt_validade) {
		this.dt_validade = dt_validade;
	}
	public int getTipoCartao() {
		return tipoCartao;
	}
	public void setTipoCartao(int tipoCartao) {
		this.tipoCartao = tipoCartao;
	}
	public String getNome_titular() {
		return nome_titular;
	}
	public void setNome_titular(String nome_titular) {
		this.nome_titular = nome_titular;
	}
	public double getJuros() {
		return juros;
	}
	public void setJuros(double juros) {
		this.juros = juros;
	}
	
	
}
