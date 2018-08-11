package br.ufrpe.libelula.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import br.ufrpe.libelula.negocio.beans.Acomodacao;
import br.ufrpe.libelula.negocio.beans.ClienteFisico;

public class ClienteFisicoDAO extends DAO<ClienteFisico>{

	@Override
	public void inserir(ClienteFisico o) throws Exception {
		String sql = "INSERT INTO `cliente_fisico` (`codigo`,`agencia`,`cpf`,`tipo`)"
				+ " VALUES " + "(?,?,?,?)";
		preparar(sql);
		getStatement().setInt(1, o.getCodigo());
		getStatement().setString(2, o.getAgencia());
		getStatement().setString(3, o.getCPF());
		getStatement().setInt(4, o.getTipo());
		
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
	public void remover(ClienteFisico o) throws Exception {
		String sql = "DELETE FROM cliente_fisico WHERE `codigo` = ?";
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
	public void alterar(ClienteFisico o) throws Exception {
		String sql = "UPDATE (`codigo`=?, `agencia` = ?, `cpf` = ?, `tipo` = ?"
				+ "WHERE `codigo` = ?";
		preparar(sql);
		
		getStatement().setInt(1, o.getCodigo());
		getStatement().setString(2, o.getAgencia());
		getStatement().setString(3, o.getCPF());
		getStatement().setInt(4, o.getTipo());
		
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
	public ArrayList<ClienteFisico> listarTodos() throws Exception {
		ArrayList<ClienteFisico> r = new ArrayList<ClienteFisico>();
		String sql = "SELECT * FROM `cliente_fisico`";
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
			ClienteFisico o = new ClienteFisico(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4));
			
			r.add(o);
		}
		rs.close();
		fecharStatetment();
		return r;
	}
	
	public ClienteFisico buscar(int codigo) throws Exception {
		String sql = "SELECT * FROM `cliente_fisico` WHERE `codigo` = ?";
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
		ClienteFisico o = new ClienteFisico(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4));
		rs.close();
		fecharStatetment();
		return o;
	}
}
