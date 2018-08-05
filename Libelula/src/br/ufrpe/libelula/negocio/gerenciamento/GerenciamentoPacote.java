package br.ufrpe.libelula.negocio.gerenciamento;

import java.util.ArrayList;

import br.ufrpe.libelula.DAO.ItemPacoteDAO;
import br.ufrpe.libelula.DAO.PacoteDAO;
import br.ufrpe.libelula.negocio.beans.ItemPacote;
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
			pacote.apagar(a);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Pacote BuscarPacote(String cod) {
		return pacote.busca(cod);
	}
	
	public void AtualizarPacote(Pacote a) {
		try {
			pacote.update(a);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public ArrayList<Pacote> ListarPacote(){
		return pacote.listar();
	}
}
