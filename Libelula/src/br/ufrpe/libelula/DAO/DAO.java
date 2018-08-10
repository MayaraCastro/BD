package br.ufrpe.libelula.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import br.ufrpe.libelula.negocio.gerenciamento.Fachada;

public abstract class DAO <T>{
	
	private Connection conexao;
	private PreparedStatement statement;
	
	public PreparedStatement getStatement() {
		return this.statement;
	}

	public Connection getConnection() {
		return this.conexao;
	}

	public void fecharStatetment() throws SQLException {
		this.statement.close();
	}

	public void preparar(String sql) throws Exception {
		this.conexao = Fachada.getInstance().getConnection();
		this.statement = this.conexao.prepareStatement(sql);
	}

	public abstract void inserir(T o) throws Exception; 
	
	public abstract void remover(T o) throws Exception;

	public abstract void alterar(T o) throws Exception;

	public abstract ArrayList<T> listarTodos() throws Exception;

}
