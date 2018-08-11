package br.ufrpe.libelula.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import br.ufrpe.libelula.negocio.beans.Acomodacao;
import br.ufrpe.libelula.negocio.beans.Transporte;

public class AcomodacaoDAO extends DAO<Acomodacao>{

	@Override
	public void inserir(Acomodacao o) throws Exception {
		String sql = "INSERT INTO `transporte` (`codigo`,`descricao`,`data_entrada`,"
				+ "`dt_saida`,`capacidade_pessoas`,`fumante`,`np_estrelas`,`tipo`)"
				+ " VALUES " + "(?,?,?,?,?,?,?,?)";
		preparar(sql);
		getStatement().setInt(1, o.getCodigo());
		getStatement().setString(2, o.getDescricao());
		
		if (o.getNivel() != null)
			getStatement().setDate(3, o.getData_entrada());
		else
			getStatement().setDate(3, null);
	
		if (o.getNivel() != null)
			getStatement().setDate(4, o.getDt_saida());
		else
			getStatement().setDate(4, null);
		
		getStatement().setInt(7, o.getCapacidade_pessoas());
		getStatement().setInt(8, o.getFumante());
		getStatement().setInt(9, o.getNo_estrelas());
		getStatement().setInt(10, o.getTipo());
		
		try {
			getStatement().execute();
			getConnection().commit();
			JOptionPane.showMessageDialog(null, "Inser��o realizada com sucesso!");
		} catch (SQLException e) {
			getConnection().rollback(); //caso aja erro na transa��o faz um rollback
			JOptionPane.showMessageDialog(null, "Erro na Inser��o!");
		} finally {
			fecharStatetment();
		}
		
		
	}

	@Override
	public void remover(Acomodacao o) throws Exception {
		String sql = "DELETE FROM acomodacao WHERE `codigo` = ?";
		preparar(sql);
		getStatement().setInt(1, o.getCodigo());
		try {
			getStatement().execute();
			getConnection().commit();
			JOptionPane.showMessageDialog(null, "Remo��o realizada com sucesso!");
		} catch (SQLException e) {
			getConnection().rollback();
			JOptionPane.showMessageDialog(null, "Erro na Remo��o!");
		} finally {
			fecharStatetment();
		}
		
		
	}

	@Override
	public void alterar(Acomodacao o) throws Exception {
		String sql = "UPDATE (`codigo`=?, `descricao` = ?, `data_entrada` = ?, `dt_saida` = ?,"
				+ "`capacidade_pessoas` = ?, `fumante` = ?, `no_estrelas` = ?, `tipo`= ?"
				+ "WHERE `codigo` = ?";
		preparar(sql);
		
		getStatement().setInt(1, o.getCodigo());
		getStatement().setString(2, o.getDescricao());
		
		if (o.getNivel() != null)
			getStatement().setDate(3, o.getData_entrada());
		else
			getStatement().setDate(3, null);
	
		if (o.getNivel() != null)
			getStatement().setDate(4, o.getDt_saida());
		else
			getStatement().setDate(4, null);
		
		getStatement().setInt(7, o.getCapacidade_pessoas());
		getStatement().setInt(8, o.getFumante());
		getStatement().setInt(9, o.getNo_estrelas());
		getStatement().setInt(10, o.getTipo());
		
		try {
			getStatement().execute();
			getConnection().commit();
			JOptionPane.showMessageDialog(null, "Altera��o realizada com sucesso!");
		} catch (SQLException e) {
			getConnection().rollback();
			JOptionPane.showMessageDialog(null, "Erro na Altera��o!");
		} finally {
			fecharStatetment();
		}
	
		
	}

	@Override
	public ArrayList<Acomodacao> listarTodos() throws Exception {
		ArrayList<Acomodacao> r = new ArrayList<Acomodacao>();
		String sql = "SELECT * FROM `acomodacao`";
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
			Acomodacao o = new Acomodacao(rs.getInt(1), rs.getString(2), rs.getDate(3), rs.getDate(4),
					rs.getInt(5), rs.getInt(6), rs.getInt(7),rs.getInt(8));
			
			r.add(o);
		}
		rs.close();
		fecharStatetment();
		return r;
	}
	
	public Acomodacao buscar(int codigo) throws Exception {
		String sql = "SELECT * FROM `transporte` WHERE `codigo` = ?";
		preparar(sql);
		getStatement().setInt(1, codigo);
		ResultSet rs = null;
		try {
			rs = getStatement().executeQuery();
			getConnection().commit();
		} catch (SQLException e) {
			getConnection().rollback();
			fecharStatetment();
			JOptionPane.showMessageDialog(null, "Acamodacao n�o encontrado!");
		}
		rs.next();
		Acomodacao o = new Acomodacao(rs.getInt(1), rs.getString(2), rs.getDate(3), rs.getDate(4),
				rs.getInt(5), rs.getInt(6), rs.getInt(7),rs.getInt(8));
		rs.close();
		fecharStatetment();
		return o;
	}
}
