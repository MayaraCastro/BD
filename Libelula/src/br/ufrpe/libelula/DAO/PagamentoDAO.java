package br.ufrpe.libelula.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import br.ufrpe.libelula.negocio.beans.Fatura;
import br.ufrpe.libelula.negocio.beans.Pagamento;

public class PagamentoDAO extends DAO<Pagamento>{

	@Override
	public void inserir(Pagamento o, int tipo) throws Exception {
		String sql = "INSERT INTO `fatura` (`codigo`,`vl_pago`,`juro`,`dt_vence`,`dt_pag`,"
				+ "`codFatura`,`tipo`,`cod_seg`"
				+ "`numero_cartao`,`dt_validade`,`tipoCartao`,`nome_titular`)"
				+ " VALUES " + "(?,?,?,?,?,?,?,?,?,?,?)";
		preparar(sql);
		getStatement().setInt(1, o.getCodigo());
		getStatement().setDouble(2, o.getVl_pagamento());
		getStatement().setDouble(3, o.getJuros());
		
		if(o.getDt_vence()!=null) {
			getStatement().setDate(4, o.getDt_vence());
		}
		else{
			getStatement().setDate(4,null);
		}
		
		if(o.getDt_vence()!=null) {
			getStatement().setDate(5, o.getDt_pag());
		}
		else{
			getStatement().setDate(5,null);
		}		
		
		getStatement().setInt(6, o.getCodFatura());
		getStatement().setInt(7, o.getTipo());
		getStatement().setInt(8, o.getCod_seg());
		getStatement().setString(9, o.getNumero_cartao());
		
		if(o.getDt_vence()!=null) {
			getStatement().setDate(10, o.getDt_validade());
		}
		else{
			getStatement().setDate(5,null);
		}
		
		getStatement().setInt(11, o.getTipoCartao());
		getStatement().setString(12, o.getNome_titular());
		
		
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
	public void remover(Pagamento o, int tipo) throws Exception {
		String sql = "DELETE FROM pessoa WHERE `id` = ?";
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
	public void alterar(Pagamento o, int tipo) throws Exception {
		
		String sql = "UPDATE `fatura` SET `codigo`=? ,`vl_pago = ?`,`juro` = ?,`dt_vence` = ?,`dt_pag` = ? ,"
				+ "`codFatura`= ?,`tipo`= ?,`cod_seg`= ? ,`numero_cartao` = ?, `dt_validade`= ?, `tipoCartao`= ?,"
				+ " `nome_titular`= ?"
				+  "WHERE `codigo` = ?";
		preparar(sql);
		getStatement().setInt(1, o.getCodigo());
		getStatement().setDouble(2, o.getVl_pagamento());
		getStatement().setDouble(3, o.getJuros());
		
		if(o.getDt_vence()!=null) {
			getStatement().setDate(4, o.getDt_vence());
		}
		else{
			getStatement().setDate(4,null);
		}
		
		if(o.getDt_vence()!=null) {
			getStatement().setDate(5, o.getDt_pag());
		}
		else{
			getStatement().setDate(5,null);
		}		
		
		getStatement().setInt(6, o.getCodFatura());
		getStatement().setInt(7, o.getTipo());
		getStatement().setInt(8, o.getCod_seg());
		getStatement().setString(9, o.getNumero_cartao());
		
		if(o.getDt_vence()!=null) {
			getStatement().setDate(10, o.getDt_validade());
		}
		else{
			getStatement().setDate(5,null);
		}
		
		getStatement().setInt(11, o.getTipoCartao());
		getStatement().setString(12, o.getNome_titular());
			

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
	public ArrayList<Pagamento> listarTodos() throws Exception {
		ArrayList<Pagamento> r = new ArrayList<Pagamento>();
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
			Pagamento o = new Pagamento(rs.getInt(1), rs.getDouble(2), rs.getDouble(3), rs.getDate(4),
										rs.getDate(5), rs.getInt(6), rs.getInt(7), rs.getInt(8),
										rs.getString(9), rs.getDate(10), rs.getInt(11), rs.getString(12));
			r.add(o);
		}
		rs.close();
		fecharStatetment();
		return r;
	}
	
	public Pagamento buscar(int codigo) throws Exception {
		String sql = "SELECT * FROM `pagamento` WHERE `codigo` = ?";
		preparar(sql);
		getStatement().setInt(1, codigo);
		ResultSet rs = null;
		try {
			rs = getStatement().executeQuery();
			getConnection().commit();
		} catch (SQLException e) {
			getConnection().rollback();
			fecharStatetment();
			JOptionPane.showMessageDialog(null, "Pagamento n�o encontrado!");
		}
		rs.next();
		Pagamento o = new Pagamento(rs.getInt(1), rs.getDouble(2), rs.getDouble(3), rs.getDate(4),
							  rs.getDate(5), rs.getInt(6), rs.getInt(7), rs.getInt(8),
							  rs.getString(9), rs.getDate(10), rs.getInt(11), rs.getString(12));
		rs.close();
		fecharStatetment();
		return o;
	}

}
