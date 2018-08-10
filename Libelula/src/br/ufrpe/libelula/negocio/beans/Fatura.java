package br.ufrpe.libelula.negocio.beans;

import java.sql.Date;

public class Fatura {
	private int id;
	private int codpacote;
	private Date dt_fatura;
	private int status;
	public Fatura(int id, int codpacote, Date dt_fatura, int status) {
		super();
		this.id = id;
		this.codpacote = codpacote;
		this.dt_fatura = dt_fatura;
		this.status = status;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCodpacote() {
		return codpacote;
	}
	public void setCodpacote(int codpacote) {
		this.codpacote = codpacote;
	}
	public Date getDt_fatura() {
		return dt_fatura;
	}
	public void setDt_fatura(Date dt_fatura) {
		this.dt_fatura = dt_fatura;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
}
