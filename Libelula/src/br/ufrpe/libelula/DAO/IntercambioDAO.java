package br.ufrpe.libelula.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import br.ufrpe.libelula.negocio.beans.Intercambio;
import br.ufrpe.libelula.negocio.beans.Servico_Ref;

public class IntercambioDAO extends DAO<Intercambio>{

	@Override
	public void inserir(Intercambio o) throws Exception {
		String sql = "INSERT INTO `intercambio` (`codigo`,`obs`,`detalhe`,"
				+ "`tipo_intercambio`,`cargo`,`dt_inicio`,`dt_fim`,`cargaHorario`,`nome_curso`,`lingua`)"
				+ " VALUES " + "(?,?,?,?,?,?,?,?,?,?)";
		preparar(sql);
		getStatement().setInt(1, o.getCodigo());
		getStatement().setString(2, o.getObs());
		getStatement().setString(3, o.getDetalhe());
		getStatement().setInt(4, o.getTipo_intercambio());
		
		getStatement().setString(5, o.getCargo());
		
		if (o.getNivel() != null)
			getStatement().setDate(6, o.getDt_inicio());
		else
			getStatement().setDate(6, null);
		
		if (o.getNivel() != null)
			getStatement().setDate(7, o.getDt_fim());
		else
			getStatement().setDate(7, null);
		
		getStatement().setInt(8, o.getCargaHoraria());
		getStatement().setString(9, o.getNome_curso());
		getStatement().setString(10, o.getLingua());
		
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
	public void remover(Intercambio o) throws Exception {
		String sql = "DELETE FROM intercambio WHERE `codigo` = ?";
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
	public void alterar(Intercambio o) throws Exception {
		String sql = "UPDATE (`codigo`=?, `obs` = ?, `detalhe` = ?, `tipo_intercambio` = ?,"
				+ "`cargo` = ?, `dt_inicio` = ?, `dt_fim` = ?, `cargaHorario`= ?, `nome_curso` = ?,"
				+ "`lingua`= ?, `tipoServico` = ?"
				 + "WHERE `codigo` = ?";
		preparar(sql);
		
		getStatement().setInt(1, o.getCodigo());
		getStatement().setString(2, o.getObs());
		getStatement().setString(3, o.getDetalhe());
		getStatement().setInt(4, o.getTipo_intercambio());
		
		getStatement().setString(5, o.getCargo());
		
		if (o.getNivel() != null)
			getStatement().setDate(6, o.getDt_inicio());
		else
			getStatement().setDate(6, null);
		
		if (o.getNivel() != null)
			getStatement().setDate(7, o.getDt_fim());
		else
			getStatement().setDate(7, null);
		
		getStatement().setInt(8, o.getCargaHoraria());
		getStatement().setString(9, o.getNome_curso());
		getStatement().setString(10, o.getLingua());
		
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
	public ArrayList<Intercambio> listarTodos() throws Exception {
		ArrayList<Intercambio> r = new ArrayList<Intercambio>();
		String sql = "SELECT * FROM `intercambio`";
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
			Intercambio o = new Intercambio(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4),
					rs.getString(5), rs.getDate(6), rs.getDate(7), rs.getInt(8), rs.getString(9), rs.getString(10));
			r.add(o);
		}
		rs.close();
		fecharStatetment();
		return r;
	}
	
	public Intercambio buscar(int codigo) throws Exception {
		String sql = "SELECT * FROM `intercambio` WHERE `codigo` = ?";
		preparar(sql);
		getStatement().setInt(1, codigo);
		ResultSet rs = null;
		try {
			rs = getStatement().executeQuery();
			getConnection().commit();
		} catch (SQLException e) {
			getConnection().rollback();
			fecharStatetment();
			JOptionPane.showMessageDialog(null, "Intercambio n�o encontrado!");
		}
		rs.next();
		Intercambio o = new Intercambio(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4),
				rs.getString(5), rs.getDate(6), rs.getDate(7), rs.getInt(8), rs.getString(9), rs.getString(10));
		rs.close();
		fecharStatetment();
		return o;
	}

}
