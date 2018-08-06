package br.ufrpe.libelula.DAO;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import br.ufrpe.libelula.negocio.beans.Gerente;


public class GerenteDAO extends DAO<Gerente> {
	@Override
	public void inserir(Gerente o) throws Exception {
		String sql = "INSERT INTO `pacote` (`codigo`,`total_a_pagar`,`vl_total`,`vl_desconto`,`datafim`,`datainicio`,`indicadorReserva`,`tipo`,`n_criancas`,`n_adultos`)"
				+ " VALUES " + "(?,?,?,?,?,?,?,?,?,?)";
		preparar(sql);
		getStatement().setInt(1, o.getCodigo());
		getStatement().setFloat(2, o.getTotal_a_pagar());
		getStatement().setFloat(3, o.getVl_total());
		getStatement().setFloat(4, o.getVl_desconto());
		getStatement().setDate(5, Date.valueOf(o.getDatafim()));
		getStatement().setDate(6, Date.valueOf(o.getDatainicio()));
		getStatement().setInt(7, o.getIndicadorReserva());
		getStatement().setInt(8, o.getTipo());
		
		if (o.getN_criancas() != null)
			getStatement().setInt(9, o.getN_criancas());	
		else
			getStatement().setDate(9, null);
		
		if (o.getN_adultos() != null)
			getStatement().setInt(10, o.getN_adultos());
		else
			getStatement().setDate(10, null);
		
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

	@Override
	public void remover(Pacote o) throws Exception {
		String sql = "DELETE FROM pacote WHERE `codigo` = ?";
		preparar(sql);
		getStatement().setInt(1, o.getCodigo());
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
	public void alterar(Pacote o) throws Exception {
		String sql = "UPDATE `pacote` SET `total_a_pagar` = ?,`vl_total` = ?,`vl_desconto` = ?,"
				+ "`datafim` = ?,`datainicio` = ?,"
				+ "`indicadorReserva` = ?,`tipo` = ?,`n_criancas` = ?,`n_adultos` = ? " + "WHERE `codigo` = ?";
		preparar(sql);
		getStatement().setFloat(1, o.getTotal_a_pagar());
		getStatement().setFloat(2, o.getVl_total());
		getStatement().setFloat(3, o.getVl_desconto());
		getStatement().setDate(4, Date.valueOf(o.getDatafim()));
		getStatement().setDate(5, Date.valueOf(o.getDatainicio()));
		getStatement().setInt(6, o.getIndicadorReserva());
		getStatement().setInt(7, o.getTipo());
		
		if (o.getN_criancas() != null)
			getStatement().setInt(8, o.getN_criancas());	
		else
			getStatement().setDate(8, null);
		
		if (o.getN_adultos() != null)
			getStatement().setInt(9, o.getN_adultos());
		else
			getStatement().setDate(9, null);
		getStatement().setInt(10, o.getCodigo());

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

	public Pacote buscar(int codigo) throws Exception {
		String sql = "SELECT * FROM `pacote` WHERE `codigo` = ?";
		preparar(sql);
		getStatement().setInt(1, codigo);
		ResultSet rs = null;
		try {
			rs = getStatement().executeQuery();
			getConnection().commit();
		} catch (SQLException e) {
			getConnection().rollback();
			fecharStatetment();
			JOptionPane.showMessageDialog(null, "Pacote não encontrado!");
		}
		rs.next();
		Pacote o = new Pacote(rs.getInt(1), rs.getFloat(2), rs.getFloat(3), rs.getFloat(4),
				rs.getDate(5).toLocalDate(), rs.getDate(6).toLocalDate(), rs.getInt(7), rs.getInt(8), rs.getInt(9),
				rs.getInt(10));
		rs.close();
		fecharStatetment();
		return o;
	}

	@Override
	public ArrayList<Pacote> listarTodos() throws Exception {
		ArrayList<Pacote> r = new ArrayList<Pacote>();
		String sql = "SELECT * FROM `pacote`";
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
			Pacote o = new Pacote(rs.getInt(1), rs.getFloat(2), rs.getFloat(3), rs.getFloat(4),
					rs.getDate(5).toLocalDate(), rs.getDate(6).toLocalDate(), rs.getInt(7), rs.getInt(8), rs.getInt(9),
					rs.getInt(10));
			r.add(o);
		}
		rs.close();
		fecharStatetment();
		return r;

	}
}

