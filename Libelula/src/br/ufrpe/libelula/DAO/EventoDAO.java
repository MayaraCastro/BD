package br.ufrpe.libelula.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import br.ufrpe.libelula.negocio.beans.Evento;
import br.ufrpe.libelula.negocio.beans.Intercambio;

public class EventoDAO extends DAO<Evento>{

	@Override
	public void inserir(Evento o) throws Exception {
		String sql = "INSERT INTO `intercambio` (`codigo`,`status`,`data_entrada`,"
				+ "`dt_fim`,`nome`,`detalhe`,`tipo`,`vl_desc`,`obs`,`guiacod`)"
				+ " VALUES " + "(?,?,?,?,?,?,?,?,?,?)";
		preparar(sql);
		getStatement().setInt(1, o.getCodigo());
		getStatement().setString(2, o.getStatus());
		
		if (o.getNivel() != null)
			getStatement().setDate(3, o.getData_entrada());
		else
			getStatement().setDate(3, null);
	
		if (o.getNivel() != null)
			getStatement().setDate(4, o.getDt_fim());
		else
			getStatement().setDate(4, null);
		
		
		getStatement().setString(5, o.getNome());
		getStatement().setString(6, o.getDetalhe());
		getStatement().setInt(7, o.getTipo());
		getStatement().setString(8, o.getVl_desc());
		getStatement().setString(9, o.getObs());
		getStatement().setInt(10, o.getGuiacod());
		
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
	public void remover(Evento o) throws Exception {
		String sql = "DELETE FROM evento WHERE `codigo` = ?";
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
	public void alterar(Evento o) throws Exception {
		String sql = "UPDATE (`codigo`=?, `status` = ?, `data_entrada` = ?, `dt_fim` = ?,"
				+ "`nome` = ?, `detalhe` = ?, `tipo` = ?, `vl_desc`= ?, `obs` = ?,"
				+ "`guiacod`= ?"
				+ "WHERE `codigo` = ?";
		preparar(sql);
		
		getStatement().setInt(1, o.getCodigo());
		getStatement().setString(2, o.getStatus());
		
		if (o.getNivel() != null)
			getStatement().setDate(3, o.getData_entrada());
		else
			getStatement().setDate(3, null);
	
		if (o.getNivel() != null)
			getStatement().setDate(4, o.getDt_fim());
		else
			getStatement().setDate(4, null);
		
		
		getStatement().setString(5, o.getNome());
		getStatement().setString(6, o.getDetalhe());
		getStatement().setInt(7, o.getTipo());
		getStatement().setString(8, o.getVl_desc());
		getStatement().setString(9, o.getObs());
		getStatement().setInt(10, o.getGuiacod());
		
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
	public ArrayList<Evento> listarTodos() throws Exception {
		ArrayList<Evento> r = new ArrayList<Evento>();
		String sql = "SELECT * FROM `Evento`";
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
			Evento o = new Evento(rs.getInt(1), rs.getString(2), rs.getDate(3), rs.getDate(4),
					rs.getString(5), rs.getString(6), rs.getInt(7), rs.getString(8), rs.getString(9), rs.getInt(10));
			r.add(o);
		}
		rs.close();
		fecharStatetment();
		return r;
	}
	
	public Evento buscar(int codigo) throws Exception {
		String sql = "SELECT * FROM `evento` WHERE `codigo` = ?";
		preparar(sql);
		getStatement().setInt(1, codigo);
		ResultSet rs = null;
		try {
			rs = getStatement().executeQuery();
			getConnection().commit();
		} catch (SQLException e) {
			getConnection().rollback();
			fecharStatetment();
			JOptionPane.showMessageDialog(null, "Evento n�o encontrado!");
		}
		rs.next();
		Evento o = new Evento(rs.getInt(1), rs.getString(2), rs.getDate(3), rs.getDate(4),
				rs.getString(5), rs.getString(6), rs.getInt(7), rs.getString(8), rs.getString(9), rs.getInt(10));
		rs.close();
		fecharStatetment();
		return o;
	}

}
