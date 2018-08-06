package br.ufrpe.libelula.negocio.gerenciamento;

import java.util.ArrayList;

import br.ufrpe.libelula.DAO.ItemPacoteDAO;
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
	
	public ItemPacote BuscarItemPacote(int  cod) {
		try {
			return item.buscar(cod);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public void AtualizarItemPacote(ItemPacote a) {
		try {
			item.alterar(a);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public ArrayList<ItemPacote> ListarItemPacote(){
		try {
			return item.listarTodos();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public ArrayList<ItemPacote> ListarItemdoPacote(int cod){
		try {
			return item.listardoPacote(cod);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
