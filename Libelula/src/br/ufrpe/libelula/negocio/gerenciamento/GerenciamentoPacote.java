package br.ufrpe.libelula.negocio.gerenciamento;

import java.util.ArrayList;

import br.ufrpe.libelula.DAO.PacoteDAO;
import br.ufrpe.libelula.negocio.beans.Pacote;

public class GerenciamentoPacote {
	private PacoteDAO pacote;
	
	public GerenciamentoPacote() {
		this.pacote = new PacoteDAO();
	}
	
	public void CadastrarPacote(Pacote a) {
			try {
				pacote.inserir(a); 
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
	public void RemoverPacote(Pacote a) {
		try {
			pacote.remover(a);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Pacote BuscarPacote(int cod) {
		try {
			return pacote.buscar(cod);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public void AtualizarPacote(Pacote a) {
		try {
			pacote.alterar(a);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public ArrayList<Pacote> ListarPacote(){
		try {
			return pacote.listarTodos();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public int pegarCoddoUltimoInserido() {
		try {
			return pacote.pegarCodigodoUltimoAutoIncrmente();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

}
