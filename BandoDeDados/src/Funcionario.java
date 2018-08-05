import java.sql.Date;
import java.util.ArrayList;

public class Funcionario extends Pessoa{
	private String CPF;
	private String ramal;
	private double salario;
	private String cod_Agencia;
	
	public Funcionario() {
		super();
	}
	
	
	
	public Funcionario(String cPF, String ramal, double salario, int cod, String nome, Date dt_nasc, ArrayList<String> sexo, String fone, byte[] logo, String cep,
			int num, String cod_Agencia) {
		super(cod, nome, dt_nasc, sexo, fone, logo, cep,num);
		CPF = cPF;
		this.ramal = ramal;
		this.salario = salario;
		this.cod_Agencia = cod_Agencia;
	}

	

	public Funcionario(String cPF, String ramal, double salario, String cod_Agencia) {
		super();
		CPF = cPF;
		this.ramal = ramal;
		this.salario = salario;
		this.cod_Agencia= cod_Agencia;
	}

	public String getCPF() {
		return CPF;
	}
	public void setCPF(String cPF) {
		CPF = cPF;
	}
	public String getRamal() {
		return ramal;
	}
	public void setRamal(String ramal) {
		this.ramal = ramal;
	}
	public double getSalario() {
		return salario;
	}
	public void setSalario(double salario) {
		this.salario = salario;
	}



	public String getCod_Agencia() {
		return cod_Agencia;
	}
	public void setCod_Agencia(String cod_Agencia) {
		this.cod_Agencia = cod_Agencia;
	}
	
	
	
}
