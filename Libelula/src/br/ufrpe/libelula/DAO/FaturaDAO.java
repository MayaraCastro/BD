package br.ufrpe.libelula.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import br.ufrpe.libelula.negocio.beans.Fatura;

public class FaturaDAO extends DAO<Fatura>{

	@Override
	public void inserir(Fatura o, int tipo) throws Exception {
		String sql = "INSERT INTO `fatura` (`id`,`codpacote`,`dt_fatura`,`status`)"
				+ " VALUES " + "(?,?,?,?)";
		preparar(sql);
		getStatement().setInt(1, o.getId());
		getStatement().setInt(2, o.getCodpacote());
		if(o.getDt_fatura()!=null) {
			getStatement().setDate(3, o.getDt_fatura());
		}
		else{
			getStatement().setDate(3,null);
		}		
		getStatement().setInt(4, o.getStatus());
		
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
	public void remover(Fatura o, int tipo) throws Exception {
		String sql = "DELETE FROM pessoa WHERE `id` = ?";
		preparar(sql);
		getStatement().setInt(1, o.getId());
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
	public void alterar(Fatura o, int tipo) throws Exception {
		String sql = "UPDATE `fatura` SET `id` = ?,`codpacote` = ?,`dt_fatura` = ?,"
				+ "`status` = ?"
				+  "WHERE `id` = ?";
		preparar(sql);
		getStatement().setInt(1, o.getId());
		getStatement().setInt(2, o.getCodpacote());
		if(o.getDt_fatura()!=null) {
			getStatement().setDate(3, o.getDt_fatura());
		}
		else{
			getStatement().setDate(3,null);
		}		
		getStatement().setInt(4, o.getStatus());	

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
	public ArrayList<Fatura> listarTodos() throws Exception {
		ArrayList<Fatura> r = new ArrayList<Fatura>();
		String sql = "SELECT * FROM `fatura`";
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
			Fatura o = new Fatura(rs.getInt(1), rs.getInt(2), rs.getDate(3), rs.getInt(4));
			r.add(o);
		}
		rs.close();
		fecharStatetment();
		return r;

	}
	
	public Fatura buscar(int id) throws Exception {
		String sql = "SELECT * FROM `fatura` WHERE `id` = ?";
		preparar(sql);
		getStatement().setInt(1, id);
		ResultSet rs = null;
		try {
			rs = getStatement().executeQuery();
			getConnection().commit();
		} catch (SQLException e) {
			getConnection().rollback();
			fecharStatetment();
			JOptionPane.showMessageDialog(null, "Fatura n�o encontrado!");
		}
		rs.next();
		Fatura o = new Fatura(rs.getInt(1), rs.getInt(2), rs.getDate(3), rs.getInt(4));
		rs.close();
		fecharStatetment();
		return o;
	}
	

}
