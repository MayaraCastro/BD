package br.ufrpe.libelula.DAO;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;

import br.ufrpe.libelula.gui.ScreenManager;
import br.ufrpe.libelula.negocio.beans.ItemPacote;
import br.ufrpe.libelula.negocio.beans.Pacote;

public class PacoteDAO extends DAO<Pacote> {
	@Override
	public void inserir(Pacote o) throws Exception {
		String sql = "INSERT INTO `pacote` (`codigo`,`total_a_pagar`,`vl_total`,`vl_desconto`,`datafim`,`datainicio`,`indicadorReserva`,`tipo`,`n_criancas`,`n_adultos`)"
				+ " VALUES " + "(?,?,?,?,?,?,?,?,?,?)";
		preparar(sql);
		getStatement().setString(1, o.getCpf());
		getStatement().setString(2, o.getNome());
		getStatement().setString(3, o.getEspecializacao());
		getStatement().setString(4, o.getFone_1());
		getStatement().setString(5, o.getFone_2());
		getStatement().setDate(6, Date.valueOf(o.getData_de_contratacao()));
		getStatement().setDouble(7, o.getSalario());
		getStatement().setString(8, o.getEndereco());
		getStatement().setInt(9, o.getJornada_trabalho());
		getStatement().setInt(10, o.getId_zoo());
		try {
			getStatement().execute();
			getConnection().commit();
			ScreenManager.alertaInformativo("Inserção realizada com sucesso!");
		} catch (SQLException e) {
			getCon().rollback();
			ScreenManager.alertaErro("Não foi possível inserir!");
		} finally {
			fecharStatetment();
		}
	}

	@Override
	public void remover(Pacote o) throws Exception {
		String sql = "DELETE FROM funcionario WHERE `CPF` = ?";
		preparar(sql);
		getStmt().setString(1, o.getCpf());
		try {
			getStmt().execute();
			getCon().commit();
			ScreenManager.alertaInformativo("Remoção realizada com sucesso!");
		} catch (SQLException e) {
			getCon().rollback();
			ScreenManager.alertaErro("Não foi possível remover!");
		} finally {
			fecharStmt();
		}
	}

	@Override
	public void alterar(Pacote o) throws Exception {
		String sql = "UPDATE `funcionario` SET `Nome` = ?,`especializacao` = ?,`fone_1` = ?,"
				+ "`fone_2` = ?,`data_de_contratacao` = ?,"
				+ "`salario` = ?,`ender` = ?,`jornada_trabalho` = ?,`idZoo` = ? " + "WHERE `CPF` = ?";
		preparar(sql);
		getStmt().setString(1, o.getNome());
		getStmt().setString(2, o.getEspecializacao());
		getStmt().setString(3, o.getFone_1());
		getStmt().setString(4, o.getFone_2());
		getStmt().setDate(5, Date.valueOf(o.getData_de_contratacao()));
		getStmt().setDouble(6, o.getSalario());
		getStmt().setString(7, o.getEndereco());
		getStmt().setInt(8, o.getJornada_trabalho());
		getStmt().setInt(9, o.getId_zoo());
		getStmt().setString(10, o.getCpf());
		try {
			getStmt().execute();
			getCon().commit();
			ScreenManager.alertaInformativo("Alteração realizada com sucesso!");
		} catch (SQLException e) {
			getCon().rollback();
			ScreenManager.alertaErro("Não foi possível alterar!");
		} finally {
			fecharStmt();
		}
	}

	public Funcionario buscar(String codigo) throws Exception {
		String sql = "SELECT * FROM `funcionario` WHERE `CPF` = ?";
		preparar(sql);
		getStmt().setString(1, cpf);
		ResultSet rs = null;
		try {
			rs = getStmt().executeQuery();
			getCon().commit();
		} catch (SQLException e) {
			getCon().rollback();
			fecharStmt();
			ScreenManager.alertaErro("Funcionário não encontrado!");
		}
		rs.next();
		Funcionario o = new Funcionario(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
				rs.getString(5), rs.getDate(6).toLocalDate(), rs.getDouble(7), rs.getString(8), rs.getInt(9),
				rs.getInt(10));
		rs.close();
		fecharStmt();
		return o;
	}

	@Override
	public ArrayList<Funcionario> listarTodos() throws Exception {
		ArrayList<Funcionario> r = new ArrayList<Funcionario>();
		String sql = "SELECT * FROM `funcionario`";
		preparar(sql);
		ResultSet rs = null;
		try {
			rs = getStmt().executeQuery();
			getCon().commit();
		} catch (SQLException e) {
			getCon().rollback();
			fecharStmt();
			e.printStackTrace();
		}
		while (rs.next()) {
			Funcionario o = new Funcionario(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
					rs.getString(5), rs.getDate(6).toLocalDate(), rs.getDouble(7), rs.getString(8), rs.getInt(9),
					rs.getInt(10));
			r.add(o);
		}
		rs.close();
		fecharStmt();
		return r;

	}
}
