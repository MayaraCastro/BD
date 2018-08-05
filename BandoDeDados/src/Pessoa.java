import java.sql.Date;
import java.util.ArrayList;
import java.util.Arrays;

public class Pessoa {
	private int cod;
	private String nome;
	private Date dt_nasc;
	private ArrayList<String> sexo;
	private String fone;
	private byte[] logo;
	private String cep;
	private int num ;
	
	public Pessoa() {
		this.cod  = -1;
		this.nome = null;
		this.dt_nasc = null;
		this.sexo = new ArrayList<>(Arrays.asList("M","F"));
		this.fone = null;
		this.logo = null;
		this.cep = null;
		this.num = -1;
		
	}
	
	

	public Pessoa(int cod, String nome, Date dt_nasc, ArrayList<String> sexo, String fone, byte[] logo, String cep,
			int num) {
		super();
		this.cod = cod;
		this.nome = nome;
		this.dt_nasc = dt_nasc;
		this.sexo = sexo;
		this.fone = fone;
		this.logo = logo;
		this.cep = cep;
		this.num = num;
	}



	public int getCod() {
		return cod;
	}

	public void setCod(int cod) {
		this.cod = cod;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) throws InformacaoEmBrancoException{
		if(nome != null) this.nome = nome;
		else throw new InformacaoEmBrancoException();
	}

	public Date getDt_nasc() {
		return dt_nasc;
	}

	public void setDt_nasc(Date dt_nasc) {
		this.dt_nasc = dt_nasc;
	}

	public ArrayList<String> getSexo() {
		return sexo;
	}

	public String getFone() {
		return fone;
	}

	public void setFone(String fone) throws InformacaoEmBrancoException{
		if(fone!=null)
			this.fone = fone;
		else {
			throw new InformacaoEmBrancoException();
		}
		
	}

	public byte[] getLogo() {
		return logo;
	}

	public void setLogo(byte[] logo) throws InformacaoEmBrancoException{
		if(logo!=null)
			this.logo = logo;
		else {
			throw new InformacaoEmBrancoException();
		}
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) throws InformacaoEmBrancoException{
		if(cep!= null)
			this.cep = cep;
		else 
			throw new InformacaoEmBrancoException();
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) throws InformacaoEmBrancoException{
		if(num!=0)
			this.num = num;
		else
			throw new InformacaoEmBrancoException();
	}

	
	
	
}
