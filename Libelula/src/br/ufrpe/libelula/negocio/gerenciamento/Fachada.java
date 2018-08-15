package br.ufrpe.libelula.negocio.gerenciamento;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import br.ufrpe.libelula.negocio.beans.ItemPacote;
import br.ufrpe.libelula.negocio.beans.Pacote;
import br.ufrpe.libelula.negocio.beans.Pessoa;
import br.ufrpe.libelula.negocio.beans.Servico_Ref;

public class Fachada {

	private GerenciamentoFuncionario gfu;
	private GerenciamentoFatura gfa;
	private GerenciamentoCliente gc;
	private GerenciamentoPacote gp;
	private GerenciamentoItemPacote gip;
	private GerenciamentoServico gs;
	private GerenciamentoLogin login;
	private GerenciamentoPagamento gpag;
	
	private GerenciamentoPessoa gpessoa;
	
	private static Fachada instance;

	private Fachada() {
		this.gfu = new GerenciamentoFuncionario();
		this.gfa = new GerenciamentoFatura();
		this.gc = new GerenciamentoCliente();
		this.gp = new GerenciamentoPacote();
		this.gip = new GerenciamentoItemPacote();
		this.gs = new GerenciamentoServico();
		this.login = new GerenciamentoLogin();
		this.gpessoa = new GerenciamentoPessoa();
		}

	public static Fachada getInstance() {
		if (instance == null)
			instance = new Fachada();
		return instance;
	}

	/** LOGIN */
	public void logout() throws SQLException {
		login.fecharConexao();
	}

	public void login(String nome, String senha) throws Exception {
		login.fazerLogin(nome, senha);
	}

	public Connection getConnection() {
		return login.getConnection();
	}
	
	/** FUNCIONARIO */
	public void CadastrarFuncionario(Pessoa a) {
		this.gfu.CadastrarFuncionario(a);
	}
	
	public void RemoverFuncionario(Pessoa a) {
		this.gfu.RemoverFuncionario(a);
	}
	
	public Pessoa BuscarFuncionario(int cod) {
		return this.gfu.BuscarFuncionario(cod);
	}
	
	public ArrayList<Pessoa> ListarFuncionario(){
		return this.gfu.ListarFuncionario();
	}
	
	public void AtualizarFuncionario(Pessoa a) {
		this.gfu.AtualizarFuncionario(a);
	}
	
	/** PACOTE */
	public void CadastrarPacote(Pacote a) {
		this.gp.CadastrarPacote(a);
	}
	
	public void RemoverPacote(Pacote a) {
		this.gp.RemoverPacote(a);
	}
	
	public Pacote BuscarPacote(int cod) {
		return this.gp.BuscarPacote(cod);
	}
	
	public ArrayList<Pacote> ListarPacote(){
		return this.gp.ListarPacote();
	}
	
	public void AtualizarPacote(Pacote a) {
		this.gp.AtualizarPacote(a);
	}
	public int pegarcoddoultimoPacote() {
		return this.gp.pegarCoddoUltimoInserido();
	}
	/** ITEM PACOTE */
	public void CadastrarItemPacote(ItemPacote a) {
		this.gip.CadastrarItemPacote(a);
	}
	
	public void RemoverItemPacote(ItemPacote a) {
		this.gip.RemoverItemPacote(a);
	}
	
	public ItemPacote BuscarItemPacote(int cod) {
		return this.gip.BuscarItemPacote(cod);
	}
	
	public ArrayList<ItemPacote> ListarItemPacote(){
		return this.gip.ListarItemPacote();
	}
	
	public void AtualizarItemPacote(ItemPacote a) {
		this.gip.AtualizarItemPacote(a);
	}
	
	public ArrayList<ItemPacote> ListarItemdoPacote(int cod) {
		return this.gip.ListarItemdoPacote(cod);
	}
	
	/** PESSOA */
	public void CadastrarPessoa(Pessoa a) {
		this.gpessoa.CadastrarPessoa(a);
	}
	
	public void RemoverPessoa(Pessoa a) {
		this.gpessoa.RemoverPessoa(a);
	}
	
	public Pessoa BuscarPessoa(int cod) {
		return this.gpessoa.BuscarPessoa(cod);
	}
	
	public ArrayList<Pessoa> ListarPessoa(){
		return this.gpessoa.ListarPessoa();
	}
	
	public void AtualizarPessoa(Pessoa a) {
		this.gpessoa.AtualizarPessoa(a);
	}
	
	public int pegarcoddoultimo() {
		return this.gpessoa.pegarCoddoUltimoInserido();
	}
	
	/** SERVICO */
	public Servico_Ref BuscarServico(int cod) {
		return gs.BuscarServico(cod);
	}
	
		/**PAGAMENTO
	 * @param i **/
	public ArrayList<Pagamento> ListarPagamento() {
		// TODO Auto-generated method stub
		return this.gpag.ListarPagamento();
	}

	public Pagamento BuscarPagamento(int cod) {
		// TODO Auto-generated method stub
		return this.gpag.BuscarPagamento(cod);
	}

	public void AtualizarPagamento(Pagamento pag) {
		this.gpag.AtualizarPagamento(pag);

	}

	public void CadastrarPagamento(Pagamento pag) {
		// TODO Auto-generated method stub
		this.gpag.CadastrarPagamento(pag);

	}
	public int pegarcoddoultimoPagamento() {
		return this.gpag.pegarCoddoUltimoInserido();
	}

	public void RemoverPagamento(Pagamento pag) {
		// TODO Auto-generated method stub
		this.gpag.RemoverPagamento(pag);

	}
	
	/** CLIENTE */
	public void CadastrarCliente(Pessoa a) {
		this.gc.CadastrarCliente(a);
	}
	
	public void RemoverCliente(Pessoa a) {
		this.gc.RemoverCliente(a);
	}
	
	public Pessoa BuscarCliente(int cod) {
		return this.gc.BuscarCliente(cod);
	}
	
	public ArrayList<Pessoa> ListarCliente(){
		return this.gc.ListarCliente();
	}
	
	public void AtualizarCliente(Pessoa a) {
		this.gc.AtualizarCliente(a);
	}


}
