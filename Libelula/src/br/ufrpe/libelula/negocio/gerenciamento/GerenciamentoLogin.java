package br.ufrpe.libelula.negocio.gerenciamento;

import java.sql.Connection;
import java.sql.SQLException;

import br.ufrpe.libelula.DAO.DAOLogin;

public class GerenciamentoLogin {
	
	private DAOLogin login;

	public GerenciamentoLogin() {
		this.login = new DAOLogin();
	}

	public void fecharConexao() throws SQLException {
		login.fechar();
	}

	public void fazerLogin(String nome, String senha) throws Exception {
		login.fazerLogin(nome, senha);
	}

	public Connection getConnection() {
		return login.getConnection();
	}

}
