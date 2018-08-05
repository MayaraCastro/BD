package br.ufrpe.libelula.negocio.gerenciamento;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Calendar;

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
	
	/** FATURA */
	
	/** CLIENTE */
	
	/** PACOTE */
	
	/** ITEM PACOTE */
	
	/** SERVICO */

}
