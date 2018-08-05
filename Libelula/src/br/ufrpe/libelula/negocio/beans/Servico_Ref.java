package br.ufrpe.libelula.negocio.beans;

public class Servico_Ref {
	private int codigo;
	private float valor;
	private String local_destino;
	private Integer nivel; // foreign key
	private int tipoServico;
	
	public Servico_Ref(int codigo, float valor, String local_destino, Integer nivel, int tipoServico) {
		super();
		this.codigo = codigo;
		this.valor = valor;
		this.local_destino = local_destino;
		this.nivel = nivel;
		this.tipoServico = tipoServico;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public float getValor() {
		return valor;
	}

	public void setValor(float valor) {
		this.valor = valor;
	}

	public String getLocal_destino() {
		return local_destino;
	}

	public void setLocal_destino(String local_destino) {
		this.local_destino = local_destino;
	}

	public Integer getNivel() {
		return nivel;
	}

	public void setNivel(Integer nivel) {
		this.nivel = nivel;
	}

	public int getTipoServico() {
		return tipoServico;
	}

	public void setTipoServico(int tipoServico) {
		this.tipoServico = tipoServico;
	}
	
	
	
}
