package br.ufrpe.libelula.DAO;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import br.ufrpe.libelula.negocio.beans.ItemPacote;

public class ItemPacoteDAO extends DAO<ItemPacote> {
	@Override
	public void inserir(ItemPacote o) throws Exception {
		String sql = "INSERT INTO `item_pacote` (`codservico`,`codpacote`,`dt`,`vl_unitario`,`qtd`,`vl_com_desconto`)"
				+ " VALUES " + "(?,?,?,?,?,?)";
		preparar(sql);
		getStatement().setInt(1, o.getCodservico());
		getStatement().setFloat(2, o.getCodpacote());
		getStatement().setDate(3, Date.valueOf(o.getDt()));
		getStatement().setFloat(4, o.getVl_unitario());
		getStatement().setInt(5, o.getQtd());
		getStatement().setFloat(6, o.getVl_com_desconto());
		
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
	public void remover(ItemPacote o) throws Exception {
		String sql = "DELETE FROM item_pacote WHERE `id_sk` = ?";
		preparar(sql);
		getStatement().setInt(1, o.getId_sk());
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
	public void alterar(ItemPacote o) throws Exception {
		String sql = "UPDATE `item_pacote` SET `dt` = ?,`vl_unitario` = ?,`qtd` = ?,"
				+ "`vl_com_desconto` = ?,"
				 + "WHERE `id_sk` = ?";
		preparar(sql);
		getStatement().setDate(1, Date.valueOf(o.getDt()));
		getStatement().setFloat(2, o.getVl_unitario());
		getStatement().setInt(3, o.getQtd());
		getStatement().setFloat(4, o.getVl_com_desconto());
		getStatement().setInt(5, o.getId_sk());

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

	public ItemPacote buscar(int codigo) throws Exception {
		String sql = "SELECT * FROM `item_pacote` WHERE `id_sk` = ?";
		preparar(sql);
		getStatement().setInt(1, codigo);
		ResultSet rs = null;
		try {
			rs = getStatement().executeQuery();
			getConnection().commit();
		} catch (SQLException e) {
			getConnection().rollback();
			fecharStatetment();
			JOptionPane.showMessageDialog(null, "Item não encontrado!");
		}
		rs.next();
		ItemPacote o = new ItemPacote(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getDate(4).toLocalDate(),
				rs.getFloat(5), rs.getInt(6), rs.getInt(7),rs.getFloat(8));
		rs.close();
		fecharStatetment();
		return o;
	}
	
	public ArrayList<ItemPacote> listardoPacote(int codigo) throws Exception {
		ArrayList<ItemPacote> r = new ArrayList<ItemPacote>();
		String sql = "SELECT * FROM `item_pacote` WHERE `codpacote` = ?";
		preparar(sql);
		getStatement().setInt(1, codigo);
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
			ItemPacote o = new ItemPacote(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getDate(4).toLocalDate(),
					rs.getFloat(5), rs.getInt(6), rs.getInt(7),rs.getFloat(8));
			r.add(o);
		}
		rs.close();
		fecharStatetment();
		return r;
	}

	@Override
	public ArrayList<ItemPacote> listarTodos() throws Exception {
		ArrayList<ItemPacote> r = new ArrayList<ItemPacote>();
		String sql = "SELECT * FROM `item_pacote`";
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
			ItemPacote o = new ItemPacote(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getDate(4).toLocalDate(),
					rs.getFloat(5), rs.getInt(6), rs.getInt(7),rs.getFloat(8));
			r.add(o);
		}
		rs.close();
		fecharStatetment();
		return r;

	}
}
