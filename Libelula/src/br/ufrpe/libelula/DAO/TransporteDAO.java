package br.ufrpe.libelula.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import br.ufrpe.libelula.negocio.beans.Evento;
import br.ufrpe.libelula.negocio.beans.Transporte;

public class TransporteDAO extends DAO<Transporte>{

	@Override
	public void inserir(Transporte o) throws Exception {
		String sql = "INSERT INTO `transporte` (`codigo`,`local_de_origem`,`data_ida`,"
				+ "`dt_volta`,`modalidade`,`marca`,`tipo`,`num_identificacao`,`capacidade_n_pessoas`,`motoristacod`)"
				+ " VALUES " + "(?,?,?,?,?,?,?,?,?,?)";
		preparar(sql);
		getStatement().setInt(1, o.getCodigo());
		getStatement().setString(2, o.getLocal_de_origem());
		
		if (o.getNivel() != null)
			getStatement().setDate(3, o.getData_ida());
		else
			getStatement().setDate(3, null);
	
		if (o.getNivel() != null)
			getStatement().setDate(4, o.getDt_volta());
		else
			getStatement().setDate(4, null);
		
		getStatement().setString(5, o.getMarca());
		getStatement().setString(6, o.getMarca());
		getStatement().setInt(7, o.getTipo());
		getStatement().setInt(8, o.getNum_identificacao());
		getStatement().setInt(9, o.getCapacidade_n_pessoas());
		getStatement().setInt(10, o.getMotoristacod());
		
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
	public void remover(Transporte o) throws Exception {
		String sql = "DELETE FROM transporte WHERE `codigo` = ?";
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
	public void alterar(Transporte o) throws Exception {
		String sql = "UPDATE (`codigo`=?, `local_de_origem` = ?, `data_ida` = ?, `dt_volta` = ?,"
				+ "`modalidade` = ?, `marca` = ?, `tipo` = ?, `num_identificacao`= ?, `capacidade_n_pessoas` = ?,"
				+ "`motoristacod`= ?"
				+ "WHERE `codigo` = ?";
		preparar(sql);
		
		getStatement().setInt(1, o.getCodigo());
		getStatement().setString(2, o.getLocal_de_origem());
		
		if (o.getNivel() != null)
			getStatement().setDate(3, o.getData_ida());
		else
			getStatement().setDate(3, null);
	
		if (o.getNivel() != null)
			getStatement().setDate(4, o.getDt_volta());
		else
			getStatement().setDate(4, null);
		
		
		getStatement().setString(5, o.getMarca());
		getStatement().setString(6, o.getMarca());
		getStatement().setInt(7, o.getTipo());
		getStatement().setInt(8, o.getNum_identificacao());
		getStatement().setInt(9, o.getCapacidade_n_pessoas());
		getStatement().setInt(10, o.getMotoristacod());
		
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
	public ArrayList<Transporte> listarTodos() throws Exception {
		ArrayList<Transporte> r = new ArrayList<Transporte>();
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
			Transporte o = new Transporte(rs.getInt(1), rs.getString(2), rs.getDate(3), rs.getDate(4),
					rs.getString(5), rs.getString(6), rs.getInt(7), rs.getInt(8), rs.getInt(9), rs.getInt(10));
			
			r.add(o);
		}
		rs.close();
		fecharStatetment();
		return r;
	}
	
	public Transporte buscar(int codigo) throws Exception {
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
		Transporte o = new Transporte(rs.getInt(1), rs.getString(2), rs.getDate(3), rs.getDate(4),
				rs.getString(5), rs.getString(6), rs.getInt(7), rs.getInt(8), rs.getInt(9), rs.getInt(10));
		rs.close();
		fecharStatetment();
		return o;
	}

}
