package br.ufrpe.libelula.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import br.ufrpe.libelula.negocio.beans.Agente;


public class AgenteDAO extends DAO<Agente> {
	@Override
	public void inserir(Agente o) throws Exception {
		String sql = "INSERT INTO `agente` (`salario`,`ramal`,`cpf`,`cod`,`cod_agencia`)"
				+ " VALUES " + "(?,?,?,?,?)";
		preparar(sql);
		getStatement().setFloat(1, o.getSalario() );
		getStatement().setInt(2, o.getRamal());
		getStatement().setString(3, o.getCPF());
		getStatement().setInt(4, o.getCod());
		getStatement().setString(5, o.getCod_Agencia());
		
		
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
	public void remover(Agente o) throws Exception {
		String sql = "DELETE FROM agente WHERE `cod` = ? ";
		preparar(sql);
		getStatement().setInt(1, o.getCod());
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
	public void alterar(Agente o) throws Exception {
		String sql = "UPDATE `agente` SET `salario` = ?,`ramal` = ?,`cpf` = ?,"
				+ "`cod_agencia` = ?"
				+  "WHERE `cod` = ?";
		preparar(sql);
		getStatement().setFloat(1, o.getSalario() );
		getStatement().setInt(2, o.getRamal());
		getStatement().setString(3, o.getCPF());
		getStatement().setString(4, o.getCod_Agencia());
		getStatement().setInt(5, o.getCod());
		

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

	public Agente buscar(int codigo) throws Exception {
		String sql = "SELECT * FROM `agente` WHERE `cod` = ?";
		preparar(sql);
		getStatement().setInt(1, codigo);
		ResultSet rs = null;
		try {
			rs = getStatement().executeQuery();
			getConnection().commit();
		} catch (SQLException e) {
			getConnection().rollback();
			fecharStatetment();
			JOptionPane.showMessageDialog(null, "Agente não encontrado!");
		}
		try {
			rs.next();
			Agente o = new Agente(rs.getFloat(1), rs.getInt(2), rs.getString(3), rs.getInt(4),
				rs.getString(5));
		rs.close();
		fecharStatetment();
		return o;
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
		
	}

	@Override
	public ArrayList<Agente> listarTodos() throws Exception {
		ArrayList<Agente> r = new ArrayList<Agente>();
		String sql = "SELECT * FROM `agente`";
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
			Agente o = new Agente(rs.getFloat(1), rs.getInt(2), rs.getString(3), rs.getInt(4),
					rs.getString(5));
			r.add(o);
		}
		rs.close();
		fecharStatetment();
		return r;

	}
}

