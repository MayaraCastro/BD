package br.ufrpe.libelula.negocio.gerenciamento;

import br.ufrpe.libelula.DAO.Servico_RefDAO;
import br.ufrpe.libelula.negocio.beans.Servico_Ref;

public class GerenciamentoServico {
	private Servico_RefDAO servico;
	
	public GerenciamentoServico() {
		this.servico = new Servico_RefDAO();
	}
	public Servico_Ref BuscarServico(int cod) {
		try {
			return servico.buscar(cod);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
