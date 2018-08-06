package br.ufrpe.libelula.negocio.beans;

import java.time.LocalDate;

public class ItemPacote {
	private Integer id_sk;// auto increment
	private Integer codservico;
	private Integer codpacote;
	private LocalDate dt;
	private float vl_unitario;
	private Integer qtd; 
	private Integer seq;
	private float vl_com_desconto;
	
	public ItemPacote(int id_sk, Integer codservico, Integer codpacote, LocalDate dt, float vl_unitario, Integer qtd,
			Integer seq, float vl_com_desconto) {
		super();
		this.id_sk = id_sk;
		this.codservico = codservico;
		this.codpacote = codpacote;
		this.dt = dt;
		this.vl_unitario = vl_unitario;
		this.qtd = qtd;
		this.seq = seq;
		this.vl_com_desconto = vl_com_desconto;
	}
	
	

	public ItemPacote(Integer codservico, Integer codpacote, LocalDate dt, float vl_unitario, Integer qtd,
			float vl_com_desconto) {
		super();
		this.codservico = codservico;
		this.codpacote = codpacote;
		this.dt = dt;
		this.vl_unitario = vl_unitario;
		this.qtd = qtd;
		this.vl_com_desconto = vl_com_desconto;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof ItemPacote))
			return false;
		ItemPacote other = (ItemPacote) obj;
		if (codpacote == null) {
			if (other.codpacote != null)
				return false;
		} else if (!codpacote.equals(other.codpacote))
			return false;
		if (codservico == null) {
			if (other.codservico != null)
				return false;
		} else if (!codservico.equals(other.codservico))
			return false;
		return true;
	}



	public Integer getId_sk() {
		return id_sk;
	}

	public ItemPacote() {
		super();
	}



	public void setId_sk(int id_sk) {
		this.id_sk = id_sk;
	}

	public Integer getCodservico() {
		return codservico;
	}

	public void setCodservico(Integer codservico) {
		this.codservico = codservico;
	}

	public Integer getCodpacote() {
		return codpacote;
	}

	public void setCodpacote(Integer codpacote) {
		this.codpacote = codpacote;
	}

	public LocalDate getDt() {
		return dt;
	}

	public void setDt(LocalDate dt) {
		this.dt = dt;
	}

	public float getVl_unitario() {
		return vl_unitario;
	}

	public void setVl_unitario(float vl_unitario) {
		this.vl_unitario = vl_unitario;
	}

	public Integer getQtd() {
		return qtd;
	}

	public void setQtd(Integer qtd) {
		this.qtd = qtd;
	}

	public Integer getSeq() {
		return seq;
	}

	public void setSeq(Integer seq) {
		this.seq = seq;
	}

	public float getVl_com_desconto() {
		return vl_com_desconto;
	}

	public void setVl_com_desconto(float vl_com_desconto) {
		this.vl_com_desconto = vl_com_desconto;
	}
	
	
	
}
