package br.ufrpe.libelula.negocio.gerenciamento;

import java.util.ArrayList;

import br.ufrpe.libelula.DAO.FuncionarioDAO;
import br.ufrpe.libelula.negocio.beans.Funcionario;

public class GerenciamentoFuncionario {
	private FuncionarioDAO funcionario;
	
	public GerenciamentoFuncionario() {
		this.funcionario = new FuncionarioDAO();
	}
	
	public void CadastrarFuncionario(Funcionario a, int tipo) {
			try {
				funcionario.inserir(a, tipo); //tirar tipo
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
	public void RemoverFuncionario(Funcionario a, int tipo) {
		try {
			funcionario.apagar(a, tipo);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Funcionario BuscarFuncionario(String cpf) {
		return funcionario.busca(cpf);
	}
	
	public void AtualizarFuncionario(Funcionario a, int tipo) {
		try {
			funcionario.update(a, tipo);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public ArrayList<Funcionario> ListarFuncionario(){
		return funcionario.listar();
	}
}
