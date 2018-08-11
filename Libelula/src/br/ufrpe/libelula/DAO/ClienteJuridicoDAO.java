package br.ufrpe.libelula.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import br.ufrpe.libelula.negocio.beans.ClienteJuridico;

public class ClienteJuridicoDAO extends DAO<ClienteJuridico>{
	@Override
	public void inserir(ClienteJuridico o) throws Exception {
		String sql = "INSERT INTO `cliente_juridico` (`codigo`,`agencia`,`CNPJ`,`nome_fantasia`)"
				+ " VALUES " + "(?,?,?,?)";
		preparar(sql);
		getStatement().setInt(1, o.getCodigo());
		getStatement().setString(2, o.getAgencia());
		getStatement().setString(3, o.getCNPJ());
		getStatement().setString(4, o.getNome_Fantasia());
		
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
	public void remover(ClienteJuridico o) throws Exception {
		String sql = "DELETE FROM cliente_juridico WHERE `codigo` = ?";
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
	public void alterar(ClienteJuridico o) throws Exception {
		String sql = "UPDATE (`codigo`=?, `agencia` = ?, `cnpj` = ?, `nome_fantasia` = ?"
				+ "WHERE `codigo` = ?";
		preparar(sql);
		
		getStatement().setInt(1, o.getCodigo());
		getStatement().setString(2, o.getAgencia());
		getStatement().setString(3, o.getCNPJ());
		getStatement().setString(4, o.getNome_Fantasia());
		
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
	public ArrayList<ClienteJuridico> listarTodos() throws Exception {
		ArrayList<ClienteJuridico> r = new ArrayList<ClienteJuridico>();
		String sql = "SELECT * FROM `cliente_juridico`";
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
			ClienteJuridico o = new ClienteJuridico(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
			
			r.add(o);
		}
		rs.close();
		fecharStatetment();
		return r;
	}
	
	public ClienteJuridico buscar(int codigo) throws Exception {
		String sql = "SELECT * FROM `cliente_juridico` WHERE `codigo` = ?";
		preparar(sql);
		getStatement().setInt(1, codigo);
		ResultSet rs = null;
		try {
			rs = getStatement().executeQuery();
			getConnection().commit();
		} catch (SQLException e) {
			getConnection().rollback();
			fecharStatetment();
			JOptionPane.showMessageDialog(null, "Cliente Fisico n�o encontrado!");
		}
		rs.next();
		ClienteJuridico o = new ClienteJuridico(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
		rs.close();
		fecharStatetment();
		return o;
	}
}
