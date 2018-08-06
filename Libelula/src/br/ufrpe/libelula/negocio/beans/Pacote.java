package br.ufrpe.libelula.negocio.beans;

import java.time.LocalDate;

public class Pacote {
	private Integer codigo;
	private float total_a_pagar;
	private float vl_total; 
	private float vl_desconto; 
	private LocalDate  datafim;
	private LocalDate  datainicio;
	private int indicadorReserva;
	
	private int tipo;
	private Integer n_criancas;
	private Integer n_adultos;
	
	
	public Pacote(int codigo, float total_a_pagar, float vl_total, float vl_desconto, LocalDate datafim,
			LocalDate datainicio, int indicadorReserva, int tipo) {
		super();
		this.codigo = codigo;
		this.total_a_pagar = total_a_pagar;
		this.vl_total = vl_total;
		this.vl_desconto = vl_desconto;
		this.datafim = datafim;
		this.datainicio = datainicio;
		this.indicadorReserva = indicadorReserva;
		this.tipo = tipo;
	}
	
	public Pacote(int codigo, float total_a_pagar, float vl_total, float vl_desconto, LocalDate datafim,
			LocalDate datainicio, int indicadorReserva, int tipo, Integer n_criancas, Integer n_adultos) {
		super();
		this.codigo = codigo;
		this.total_a_pagar = total_a_pagar;
		this.vl_total = vl_total;
		this.vl_desconto = vl_desconto;
		this.datafim = datafim;
		this.datainicio = datainicio;
		this.indicadorReserva = indicadorReserva;
		this.tipo = tipo;
		this.n_criancas = n_criancas;
		this.n_adultos = n_adultos;
	}
	
	

	public Pacote(float total_a_pagar, float vl_total, float vl_desconto, LocalDate datafim, LocalDate datainicio,
			int indicadorReserva, int tipo) {
		super();
		this.total_a_pagar = total_a_pagar;
		this.vl_total = vl_total;
		this.vl_desconto = vl_desconto;
		this.datafim = datafim;
		this.datainicio = datainicio;
		this.indicadorReserva = indicadorReserva;
		this.tipo = tipo;
	}

	public Pacote(float total_a_pagar, float vl_total, float vl_desconto, LocalDate datafim, LocalDate datainicio,
			int indicadorReserva, int tipo, Integer n_criancas, Integer n_adultos) {
		super();
		this.total_a_pagar = total_a_pagar;
		this.vl_total = vl_total;
		this.vl_desconto = vl_desconto;
		this.datafim = datafim;
		this.datainicio = datainicio;
		this.indicadorReserva = indicadorReserva;
		this.tipo = tipo;
		this.n_criancas = n_criancas;
		this.n_adultos = n_adultos;
	}

	public Pacote() {
		// TODO Auto-generated constructor stub
	}

	public Integer getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public float getTotal_a_pagar() {
		return total_a_pagar;
	}
	public void setTotal_a_pagar(float total_a_pagar) {
		this.total_a_pagar = total_a_pagar;
	}
	public float getVl_total() {
		return vl_total;
	}
	public void setVl_total(float vl_total) {
		this.vl_total = vl_total;
	}
	public float getVl_desconto() {
		return vl_desconto;
	}
	public void setVl_desconto(float vl_desconto) {
		this.vl_desconto = vl_desconto;
	}
	public LocalDate getDatafim() {
		return datafim;
	}
	public void setDatafim(LocalDate datafim) {
		this.datafim = datafim;
	}
	public LocalDate getDatainicio() {
		return datainicio;
	}
	public void setDatainicio(LocalDate datainicio) {
		this.datainicio = datainicio;
	}
	public int getIndicadorReserva() {
		return indicadorReserva;
	}
	public void setIndicadorReserva(int indicadorReserva) {
		this.indicadorReserva = indicadorReserva;
	}
	public int getTipo() {
		return tipo;
	}
	public void setTipo(int tipo) {
		this.tipo = tipo;
	}
	public Integer getN_criancas() {
		return n_criancas;
	}
	public void setN_criancas(Integer n_criancas) {
		this.n_criancas = n_criancas;
	}
	public Integer getN_adultos() {
		return n_adultos;
	}
	public void setN_adultos(Integer n_adultos) {
		this.n_adultos = n_adultos;
	}
	
	
}
