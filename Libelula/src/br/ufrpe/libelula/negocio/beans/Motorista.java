package br.ufrpe.libelula.negocio.beans;

import java.sql.Date;
import java.util.ArrayList;

public class Motorista extends Funcionario{
	private int tipo;

	public Motorista() {
		super();
		this.setTipo(0);
	}
	public Motorista(String cPF, String ramal, double salario, int cod, String nome, Date dt_nasc, ArrayList<String> sexo,
			String fone, byte[] logo, String cep, int num, String cod_Agencia) {
		super(cPF, ramal, salario, cod, nome, dt_nasc, sexo, fone, logo, cep, num, cod_Agencia);
		// TODO Auto-generated constructor stub
	}

	public Motorista(String cPF, String ramal, double salario, String cod_Agencia) {
		super(cPF, ramal, salario, cod_Agencia);
		// TODO Auto-generated constructor stub
	}
	public int getTipo() {
		return tipo;
	}
	public void setTipo(int tipo) {
		this.tipo = tipo;
	}
}