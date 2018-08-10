package br.ufrpe.libelula.negocio.gerenciamento;

import java.util.ArrayList;

import br.ufrpe.libelula.DAO.AgenteDAO;
import br.ufrpe.libelula.DAO.GerenteDAO;
import br.ufrpe.libelula.DAO.GuiaDAO;
import br.ufrpe.libelula.DAO.MotoristaDAO;
import br.ufrpe.libelula.DAO.PessoaDAO;
import br.ufrpe.libelula.negocio.beans.Agente;
import br.ufrpe.libelula.negocio.beans.Gerente;
import br.ufrpe.libelula.negocio.beans.Guia;
import br.ufrpe.libelula.negocio.beans.Motorista;
import br.ufrpe.libelula.negocio.beans.Pessoa;

public class GerenciamentoFuncionario {
	private GerenteDAO gerente;
	private PessoaDAO pessoa;
	private AgenteDAO agente;
	private GuiaDAO guia;
	private MotoristaDAO motorista;
	
	public GerenciamentoFuncionario() {
		this.gerente = new GerenteDAO();
		this.pessoa = new PessoaDAO();
		this.agente = new AgenteDAO();
		this.guia = new GuiaDAO();
		this.motorista =  new MotoristaDAO();
	}
	
	public void CadastrarFuncionario(Pessoa a) {
			try {
				pessoa.inserir(a);
				a.setCod(pessoa.pegarCodigodoUltimoAutoIncrmente());
				if(a instanceof Gerente) {
					gerente.inserir(((Gerente)a));
				}else if(a instanceof Agente){
					agente.inserir(((Agente)a));
				}else if(a instanceof Guia){
					guia.inserir(((Guia)a));
				}
				else if(a instanceof Motorista){
					motorista.inserir(((Motorista)a));
				}
				 
				
			} catch (Exception e) {
				e.printStackTrace();
			}
	}
	
	public void RemoverFuncionario(Pessoa a) {
		try {
			
			if(a instanceof Gerente) {
				gerente.remover(((Gerente)a));
			}
			else if(a instanceof Agente) {
				agente.remover(((Agente)a));
			}
			else if(a instanceof Guia) {
				guia.remover(((Guia)a));
			}
			else if(a instanceof Motorista) {
				motorista.remover(((Motorista)a));
			}
			pessoa.remover(a);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public Pessoa BuscarFuncionario(int cod) {
		try {
				Pessoa p = pessoa.buscar(cod);
				Gerente g;
				Agente a;
				Guia gi;
				Motorista m;
				
				if(p !=null) {
					g = gerente.buscar(cod);
					if(g != null) {
						g = new Gerente(cod,p.getNome(),p.getDt_nasc(), p.getSexo(), p.getFone(), p.getFoto(), p.getCep(), p.getNum(),
								g.getSalario(), g.getRamal(), g.getCPF(), g.getCod_Agencia());
							return g;
					}
						
					a = agente.buscar(cod);
					if(a != null) {
						a = new Agente(cod,p.getNome(),p.getDt_nasc(), p.getSexo(), p.getFone(), p.getFoto(), p.getCep(), p.getNum(),
								a.getSalario(), a.getRamal(), a.getCPF(), a.getCod_Agencia());
						return a;
					}
					gi = guia.buscar(cod);
					if(gi != null) {
						gi = new Guia(cod,p.getNome(),p.getDt_nasc(), p.getSexo(), p.getFone(), p.getFoto(), p.getCep(), p.getNum(),
								gi.getSalario(), gi.getRamal(), gi.getCPF(), gi.getCod_Agencia());
						return gi;
					}
					m = motorista.buscar(cod);
					if(m != null) {
						m = new Motorista(cod,p.getNome(),p.getDt_nasc(), p.getSexo(), p.getFone(), p.getFoto(), p.getCep(), p.getNum(),
								m.getSalario(), m.getRamal(), m.getCPF(), m.getCod_Agencia());
						return m;
					}
				}
				
		} catch (Exception e) {
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
			else if(a instanceof Agente) {
				agente.alterar(((Agente)a));
			}
			else if(a instanceof Guia) {
				guia.alterar(((Guia)a));
			}
			else if(a instanceof Motorista) {
				motorista.alterar(((Motorista)a));
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<Pessoa> ListarFuncionario(){
		return null; //gerente.listarTodos();
	}
}
