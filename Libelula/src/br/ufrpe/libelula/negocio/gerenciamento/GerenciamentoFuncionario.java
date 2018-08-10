package br.ufrpe.libelula.negocio.gerenciamento;

import java.util.ArrayList;

import br.ufrpe.libelula.DAO.GerenteDAO;
import br.ufrpe.libelula.DAO.PessoaDAO;
import br.ufrpe.libelula.negocio.beans.Gerente;
import br.ufrpe.libelula.negocio.beans.Pessoa;

public class GerenciamentoFuncionario {
	private GerenteDAO gerente;
	private PessoaDAO pessoa;
	
	public GerenciamentoFuncionario() {
		this.gerente = new GerenteDAO();
		this.pessoa = new PessoaDAO();
	}
	
	public void CadastrarFuncionario(Pessoa a) {
			try {
				pessoa.inserir(a);
				a.setCod(pessoa.pegarCodigodoUltimoAutoIncrmente());
				if(a instanceof Gerente) {
					gerente.inserir(((Gerente)a));
				}
				 
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
	public void RemoverFuncionario(Pessoa a) {
		try {
			
			if(a instanceof Gerente) {
				gerente.remover(((Gerente)a));
			}
			pessoa.remover(a);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Pessoa BuscarFuncionario(int cod) {
		try {
				Pessoa p = pessoa.buscar(cod);
				Gerente g;
				
				if(p !=null) {
					g = gerente.buscar(cod);
						if(g != null) {
							g = new Gerente(cod,p.getNome(),p.getDt_nasc(), p.getSexo(), p.getFone(), p.getFoto(), p.getCep(), p.getNum(), g.getSalario(), g.getRamal(), g.getCPF(), g.getCod_Agencia());
									return g;
						}
				}
				
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public void AtualizarFuncionario(Pessoa a) {
		try {
			pessoa.alterar(a);
			if(a instanceof Gerente) {
				gerente.alterar(((Gerente)a));
			}
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public ArrayList<Pessoa> ListarFuncionario(){
		return null; //gerente.listarTodos();
	}
}
