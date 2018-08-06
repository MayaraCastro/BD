package br.ufrpe.libelula.negocio.gerenciamento;

import java.util.ArrayList;

import br.ufrpe.libelula.DAO.PessoaDAO;
import br.ufrpe.libelula.negocio.beans.Pessoa;

public class GerenciamentoPessoa {
	private PessoaDAO pessoa;
	
	public GerenciamentoPessoa() {
		this.pessoa = new PessoaDAO();
	}
	
	public void CadastrarPessoa(Pessoa a) {
			try {
				pessoa.inserir(a); 
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
	public void RemoverPessoa(Pessoa a) {
		try {
			pessoa.remover(a);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Pessoa BuscarPessoa(int cod) {
		try {
			return pessoa.buscar(cod);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public void AtualizarPessoa(Pessoa a) {
		try {
			pessoa.alterar(a);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public ArrayList<Pessoa> ListarPessoa(){
		try {
			return pessoa.listarTodos();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public int pegarCoddoUltimoInserido() {
		try {
			return pessoa.pegarCodigodoUltimoAutoIncrmente();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
}
