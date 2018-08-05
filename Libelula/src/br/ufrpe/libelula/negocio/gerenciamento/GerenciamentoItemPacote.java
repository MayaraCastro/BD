package br.ufrpe.libelula.negocio.gerenciamento;

import java.util.ArrayList;

import br.ufrpe.libelula.DAO.FuncionarioDAO;
import br.ufrpe.libelula.DAO.ItemPacoteDAO;
import br.ufrpe.libelula.negocio.beans.Funcionario;
import br.ufrpe.libelula.negocio.beans.ItemPacote;

public class GerenciamentoItemPacote {
	private ItemPacoteDAO item;
	
	public GerenciamentoItemPacote() {
		this.item = new ItemPacoteDAO();
	}
	
	public void CadastrarItemPacote(ItemPacote a) {
			try {
				item.inserir(a); 
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
	public void RemoverItemPacote(ItemPacote a) {
		try {
			item.remover(a);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public ItemPacote BuscarItemPacote(String cod) {
		return item.buscar(cod);
	}
	
	public void AtualizarItemPacote(ItemPacote a) {
		try {
			item.atualizar(a);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public ArrayList<ItemPacote> ListarItemPacote(){
		return item.listar();
	}
}
