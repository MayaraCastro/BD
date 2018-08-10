package br.ufrpe.libelula.negocio.gerenciamento;

import java.util.ArrayList;

import br.ufrpe.libelula.DAO.Servico_RefDAO;
import br.ufrpe.libelula.negocio.beans.Servico_Ref;

public class GerenciamentoCliente {
private ClienteDAO servico;
	
	public GerenciamentoCliente() {
		this.servico = new Servico_RefDAO();
	}
	public Servico_Ref BuscarServico(int cod) {
		try {
			return servico.buscar(cod);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public void CadastrarServico(Servico_Ref a, int tipo) {
			try {
				servico.inserir(a, tipo); 
				
			} catch (Exception e) {
				e.printStackTrace();
			}
	}
	
	public void RemoverFuncionario(Servico_Ref a, int tipo) {
		try {
			servico.remover(a, tipo);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void AtualizarFuncionario(Servico_Ref a, int tipo) {
		try {
			servico.alterar(a, tipo);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<Servico_Ref> ListarServico(){
		try {
			return servico.listarTodos();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
