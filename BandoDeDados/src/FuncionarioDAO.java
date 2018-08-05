import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class FuncionarioDAO extends Pessoa{
	public List<Funcionario> busca(Funcionario f, int tipo) throws Exception{
		/* DIfine a SQL*/
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT cod_Funcionario, nome_Funcionario");
		sql.append("from TABELA_Funcionario");
		sql.append("WHRE nome_Funcionario LIKE ?");
		sql.append("ORDER BY nome_Funcionario");
		
		/*Abre a conexao que criamos o retorno é  armazenado na variavel conn*/
		Connection conn = new Conexao().getConnection(tipo);
		
		/*Mapeamento objeto relacional*/
		PreparedStatement comando = conn.prepareStatement(sql.toString());
		comando.setString(1, "%"+f.getSalario()+"%");
		comando.setString(2, "%"+f.getRamal()+"%");
		comando.setString(3, "%"+f.getCPF()+"%");
		comando.setString(4, "%"+f.getCod()+"%");
		comando.setString(5, "%"+f.getCod()+"%");
		comando.setString(6, "%"+f.getCod_Agencia()+"%");
		
		/*Executa a SQL e captura o resultado da consulta*/
		ResultSet resultado = comando.executeQuery();
		
		/*Cria uma lista para armazenar o resultado da consulta*/
		List<Funcionario> lista = new ArrayList<Funcionario>();
		
		/*Percorre o resultado armazenando os valores em uma lista*/
		while(resultado.next()) {
			Funcionario linha = new Funcionario();
			linha.setSalario(resultado.getDouble("salario"));
			linha.setRamal(resultado.getString("ramal"));
			linha.setCPF(resultado.getString("cpf"));
			//TODO CONTINUAR
			lista.add(linha);
		}
		
		/*Fecha a conexao*/
		resultado.close();
		comando.close();conn.close();
		return lista;
		
	}
	public int apagar(Funcionario c, int tipo) throws Exception{
		/* DIfine a SQL*/
		StringBuilder sql = new StringBuilder();
		sql.append("DELETE");
		sql.append("FROM pessoa");
		sql.append("WHRE nome = '"+c+"'");
		
		/*Abre a conexao que criamos o retorno é  armazenado na variavel conn*/
		Connection conn = new Conexao().getConnection(tipo);
		
		/*Mapeamento objeto relacional*/
		PreparedStatement comando = conn.prepareStatement(sql.toString());
		comando.setString(1, "%"+c.getNomeFuncionario()+"%");
		
		/*Executa a SQL e captura o resultado da consulta*/
		int resultado = comando.executeUpdate();
		/*Fecha a conexao*/
		comando.close();conn.close();
		return resultado;
		
	}
	public int inserir (Funcionario c, int tipo) throws Exception{
		/* DIfine a SQL*/
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT");
		sql.append("INTO pessoa(nome)");
		sql.append("VALUES('"+c+"')");
		
		/*Abre a conexao que criamos o retorno é  armazenado na variavel conn*/
		Connection conn = new Conexao().getConnection(tipo);
		
		/*Mapeamento objeto relacional*/
		PreparedStatement comando = conn.prepareStatement(sql.toString());
		comando.setString(1, "%"+c.getNomeFuncionario()+"%");     // preenche os valores
		
		/*Executa a SQL e captura o resultado da consulta*/
		int resultado = comando.executeUpdate();
		/*Fecha a conexao*/
		comando.close();
		conn.close();
		return resultado;
		
	}
	
	public int update (Funcionario c, int tipo) throws Exception{
		/* DIfine a SQL*/
		StringBuilder sql = new StringBuilder();
		sql.append("");
		sql.append("");
		sql.append("");
		
		/*Abre a conexao que criamos o retorno é  armazenado na variavel conn*/
		Connection conn = new Conexao().getConnection(tipo);
		
		/*Mapeamento objeto relacional*/
		PreparedStatement comando = conn.prepareStatement(sql.toString());
		comando.setString(1, "%"+c.getNomeFuncionario()+"%");
		
		/*Executa a SQL e captura o resultado da consulta*/
		int resultado = comando.executeUpdate();
		/*Fecha a conexao*/
		comando.close();conn.close();
		return resultado;
		
	}
}
