package br.ufrpe.libelula.DAO;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import br.ufrpe.libelula.negocio.beans.Gerente;
import br.ufrpe.libelula.negocio.beans.Pessoa;

public class PessoaDAO extends DAO<Pessoa> {
	@Override
	public void inserir(Pessoa o) throws Exception {
		String sql = "INSERT INTO `pessoa` (`nome`,`dt_nasc`,`sexo`,`fone`,`foto`,`cep`,`num`)"
				+ " VALUES " + "(?,?,?,?,?,?,?)";
		preparar(sql);
		getStatement().setString(1, o.getNome() );
		getStatement().setDate(2, Date.valueOf(o.getDt_nasc()) );
		getStatement().setString(3, o.getSexo());
		getStatement().setString(4, o.getFone());
		if(o.getFoto() != null) {
			getStatement().setBytes(5, o.getFoto());
		}else {
			getStatement().setBytes(5, null);
		}
		
		getStatement().setString(6, o.getCep());
		if(o.getNum()!=null) {
			getStatement().setInt(7, o.getNum());
		}
		else{
			getStatement().setInt(7,(Integer) null);

		}
		
		
		
		
		try {
			getStatement().execute();
			getConnection().commit();
			JOptionPane.showMessageDialog(null, "Inserção realizada com sucesso!");
		} catch (SQLException e) {
			getConnection().rollback(); //caso aja erro na transação faz um rollback
			JOptionPane.showMessageDialog(null, "Erro na Inserção!");
		} finally {
			fecharStatetment();
		}
	}
	
	public int pegarCodigodoUltimoAutoIncrmente() throws Exception {
		String sql ="SELECT `AUTO_INCREMENT` FROM INFORMATION_SCHEMA.TABLES WHERE TABLE_SCHEMA = 'agencia' AND TABLE_NAME = 'pessoa'";
		preparar(sql);
		
		ResultSet rs = null;
		try {
			rs = getStatement().executeQuery();
			getConnection().commit();
		} catch (SQLException e) {
			getConnection().rollback();
			fecharStatetment();
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		rs.next();
		
			int o = rs.getInt(1) - 1 ;
		rs.close();
		fecharStatetment();
		return o;
	}

	@Override
	public void remover(Pessoa o) throws Exception {
		String sql = "DELETE FROM pessoa WHERE `cod` = ?";
		preparar(sql);
		getStatement().setInt(1, o.getCod());
		try {
			getStatement().execute();
			getConnection().commit();
			JOptionPane.showMessageDialog(null, "Remoção realizada com sucesso!");
		} catch (SQLException e) {
			getConnection().rollback();
			JOptionPane.showMessageDialog(null, "Erro na Remoção!");
		} finally {
			fecharStatetment();
		}
	}

	@Override
	public void alterar(Pessoa o) throws Exception {
		String sql = "UPDATE `pessoa` SET `nome` = ?,`dt_nasc` = ?,`sexo` = ?,"
				+ "`fone` = ?,`foto` = ?,`cep` = ?,`num` = ?"
				+  "WHERE `cod` = ?";
		preparar(sql);
		getStatement().setString(1, o.getNome() );
		getStatement().setDate(2, Date.valueOf(o.getDt_nasc()) );
		getStatement().setString(3, o.getSexo());
		getStatement().setString(4, o.getFone());
		if(o.getFoto() != null) {
			getStatement().setBytes(5, o.getFoto());
		}else {
			getStatement().setBytes(5, null);
		}
		
		getStatement().setString(6, o.getCep());
		if(o.getNum()!=null) {
			getStatement().setInt(7, o.getNum());
		}
		else{
			getStatement().setInt(7,(Integer) null);

		}
		
		getStatement().setInt(8,o.getCod());
		

		try {
			getStatement().execute();
			getConnection().commit();
			JOptionPane.showMessageDialog(null, "Alteração realizada com sucesso!");
		} catch (SQLException e) {
			getConnection().rollback();
			JOptionPane.showMessageDialog(null, "Erro na Alteração!");
		} finally {
			fecharStatetment();
		}
	}

	public Pessoa buscar(int codigo) throws Exception {
		String sql = "SELECT * FROM `pessoa` WHERE `cod` = ?";
		preparar(sql);
		getStatement().setInt(1, codigo);
		ResultSet rs = null;
		try {
			rs = getStatement().executeQuery();
			getConnection().commit();
		} catch (SQLException e) {
			getConnection().rollback();
			fecharStatetment();
			JOptionPane.showMessageDialog(null, "Pessoa não encontrado!");
		}
		rs.next();
		Pessoa o = new Pessoa(rs.getInt(1), rs.getString(2), rs.getDate(3).toLocalDate(), rs.getString(4),
				rs.getString(5), rs.getBytes(6), rs.getString(7), rs.getInt(8));
		rs.close();
		fecharStatetment();
		return o;
	}

	@Override
	public ArrayList<Pessoa> listarTodos() throws Exception {
		ArrayList<Pessoa> r = new ArrayList<Pessoa>();
		String sql = "SELECT * FROM `pessoa`";
		preparar(sql);
		ResultSet rs = null;
		try {
			rs = getStatement().executeQuery();
			getConnection().commit();
		} catch (SQLException e) {
			getConnection().rollback();
			fecharStatetment();
			e.printStackTrace();
		}
		while (rs.next()) {
			Pessoa o = new Pessoa(rs.getInt(1), rs.getString(2), rs.getDate(3).toLocalDate(), rs.getString(4),
					rs.getString(5), rs.getBytes(6), rs.getString(7), rs.getInt(8));
			r.add(o);
		}
		rs.close();
		fecharStatetment();
		return r;

	}
}

