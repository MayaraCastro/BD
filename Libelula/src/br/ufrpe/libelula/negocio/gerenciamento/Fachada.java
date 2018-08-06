package br.ufrpe.libelula.negocio.gerenciamento;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;

import br.ufrpe.libelula.negocio.beans.Funcionario;
import br.ufrpe.libelula.negocio.beans.ItemPacote;
import br.ufrpe.libelula.negocio.beans.Pacote;
import br.ufrpe.libelula.negocio.beans.Servico_Ref;

public class Fachada {

	private GerenciamentoFuncionario gfu;
	private GerenciamentoFatura gfa;
	private GerenciamentoCliente gc;
	private GerenciamentoPacote gp;
	private GerenciamentoItemPacote gip;
	private GerenciamentoServico gs;
	private GerenciamentoLogin login;
	
	private static Fachada instance;

	private Fachada() {
		this.gfu = new GerenciamentoFuncionario();
		this.gfa = new GerenciamentoFatura();
		this.gc = new GerenciamentoCliente();
		this.gp = new GerenciamentoPacote();
		this.gip = new GerenciamentoItemPacote();
		this.gs = new GerenciamentoServico();
		this.login = new GerenciamentoLogin();
	}

	public static Fachada getInstance() {
		if (instance == null)
			instance = new Fachada();
		return instance;
	}

	/** LOGIN */
	public void logout() throws SQLException {
		login.fecharConexao();
	}

	public void login(String nome, String senha) throws Exception {
		login.fazerLogin(nome, senha);
	}

	public Connection getConnection() {
		return login.getConnection();
	}
	
	/** FUNCIONARIO */
	public void CadastrarFuncionario(Funcionario a, int tipo) {
		this.gfu.CadastrarFuncionario(a, tipo);
	}
	
	public void RemoverFuncionario(Funcionario a, int tipo) {
		this.gfu.RemoverFuncionario(a, tipo);
	}
	
	public Funcionario BuscarFuncionario(String cpf) {
		return this.gfu.BuscarFuncionario(cpf);
	}
	
	public ArrayList<Funcionario> ListarFuncionario(){
		return this.gfu.ListarFuncionario();
	}
	
	public void AtualizarFuncionario(Funcionario a, int tipo) {
		this.gfu.AtualizarFuncionario(a, tipo);
	}
	
	/** PACOTE */
	public void CadastrarPacote(Pacote a) {
		this.gp.CadastrarPacote(a);
	}
	
	public void RemoverPacote(Pacote a) {
		this.gp.RemoverPacote(a);
	}
	
	public Pacote BuscarPacote(int cod) {
		return this.gp.BuscarPacote(cod);
	}
	
	public ArrayList<Pacote> ListarPacote(){
		return this.gp.ListarPacote();
	}
	
	public void AtualizarPacote(Pacote a) {
		this.gp.AtualizarPacote(a);
	}
	
	/** ITEM PACOTE */
	public void CadastrarItemPacote(ItemPacote a) {
		this.gip.CadastrarItemPacote(a);
	}
	
	public void RemoverItemPacote(ItemPacote a) {
		this.gip.RemoverItemPacote(a);
	}
	
	public ItemPacote BuscarItemPacote(int cod) {
		return this.gip.BuscarItemPacote(cod);
	}
	
	public ArrayList<ItemPacote> ListarItemPacote(){
		return this.gip.ListarItemPacote();
	}
	
	public void AtualizarItemPacote(ItemPacote a) {
		this.gip.AtualizarItemPacote(a);
	}
	
	public ArrayList<ItemPacote> ListarItemdoPacote(int cod) {
		return this.gip.ListarItemdoPacote(cod);
	}
	
	/** SERVICO */
	public Servico_Ref BuscarServico(int cod) {
		return gs.BuscarServico(cod);
	}
	
	/** FATURA */
	
	/** CLIENTE */
	

}
