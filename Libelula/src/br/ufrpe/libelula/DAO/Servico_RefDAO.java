
package br.ufrpe.libelula.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import br.ufrpe.libelula.negocio.beans.Servico_Ref;

public class Servico_RefDAO extends DAO<Servico_Ref> {
		public void inserir(Servico_Ref o ) throws Exception {
			String sql = "INSERT INTO `servico_ref` (`valor`,`local_destino`,`nivel`,`tipoServico`)"
					+ " VALUES " + "(?,?,?,?)";
			preparar(sql);
			getStatement().setFloat(1, o.getValor());
			getStatement().setString(2, o.getLocal_destino());
			if (o.getNivel() != null)
				getStatement().setInt(3, o.getNivel());
			else
				getStatement().setDate(3, null);
			
			getStatement().setInt(4, o.getTipoServico());

			
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

		public void remover(Servico_Ref o) throws Exception {
			String sql = "DELETE FROM servico_ref WHERE `codigo` = ?";
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

		public void alterar(Servico_Ref o) throws Exception {
			String sql = "UPDATE `servico_ref` SET `valor` = ?,`local_destino` = ?,`nivel` = ?,"
					+ "`tipoServico` = ?"
					 + "WHERE `codigo` = ?";
			preparar(sql);
			getStatement().setFloat(1, o.getValor());
			getStatement().setString(2, o.getLocal_destino());
			if (o.getNivel() != null)
				getStatement().setInt(3, o.getNivel());
			else
				getStatement().setDate(3, null);
			
			getStatement().setInt(4, o.getTipoServico());
			getStatement().setInt(5, o.getCodigo());

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

		public Servico_Ref buscar(int codigo) throws Exception {
			String sql = "SELECT * FROM `servico_ref` WHERE `codigo` = ?";
			preparar(sql);
			getStatement().setInt(1, codigo);
			ResultSet rs = null;
			try {
				rs = getStatement().executeQuery();
				getConnection().commit();
			} catch (SQLException e) {
				getConnection().rollback();
				fecharStatetment();
				JOptionPane.showMessageDialog(null, "Servico n�o encontrado!");
			}
			rs.next();
			Servico_Ref o = new Servico_Ref(rs.getInt(1), rs.getFloat(2), rs.getString(3), rs.getInt(4),
					rs.getInt(5));
			rs.close();
			fecharStatetment();
			return o;
		}

		@Override
		public ArrayList<Servico_Ref> listarTodos() throws Exception {
			ArrayList<Servico_Ref> r = new ArrayList<Servico_Ref>();
			String sql = "SELECT * FROM `servico_ref`";
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
				Servico_Ref o = new Servico_Ref(rs.getInt(1), rs.getFloat(2), rs.getString(3), rs.getInt(4),
						rs.getInt(5));
				r.add(o);
			}
			rs.close();
			fecharStatetment();
			return r;

		}
}

