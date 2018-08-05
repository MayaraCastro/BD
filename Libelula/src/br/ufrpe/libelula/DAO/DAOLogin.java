package br.ufrpe.libelula.DAO;

import java.sql.Connection;
import java.sql.SQLException;

public class DAOLogin {

	private final String URL = "jdbc:mysql://localhost:3306/agencia";
	@SuppressWarnings("unused")
	private String nome;
	@SuppressWarnings("unused")
	private String senha;
	private Connection con;

	public void fechar() throws SQLException {
		con.close();
	}

	public void fazerLogin(String nome, String senha) throws Exception {
		setNome(nome);
		setSenha(senha);
		con = Conexao.conexao(URL, nome, senha);
		con.setAutoCommit(false);
	}

	public Connection getConnection() {
		return this.con;
	}

	private void setNome(String nome) {
		this.nome = nome;
	}

	private void setSenha(String senha) {
		this.senha = senha;
	}

}