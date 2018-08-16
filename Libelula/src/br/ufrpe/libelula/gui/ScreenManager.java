package br.ufrpe.libelula.gui;

import java.io.IOException;

import br.ufrpe.libelula.negocio.gerenciamento.Fachada;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class ScreenManager {

	private static ScreenManager instance;
	private Stage mainStage;
	private Stage infoStage;
	
	// private FXMLLoader
	private Scene mainLogin, mainFuncionario, mainMenuPrincipal, mainPacote,mainItem;
	

	public static ScreenManager getInstance() {
		if (instance == null) {
			instance = new ScreenManager();
		}
		return instance;
	}
	
	private ScreenManager() {
		this.setInfoStage(new Stage());
		//LocalDate a = 
		
	}

	// Load scenes
	public void loadPacote() {
		try {
			Pane telaPacote = FXMLLoader.load(this.getClass().getResource("pacote/TelaPacote.fxml"));
			this.mainPacote = new Scene(telaPacote);
		} catch (IOException e) {

			e.printStackTrace();
		}

	}
	public void loadItem() {
		try {
			Pane telaItem = FXMLLoader.load(this.getClass().getResource("item/TelaItem.fxml"));
			this.mainItem = new Scene(telaItem);
		} catch (IOException e) {

			e.printStackTrace();
		}

	}
	
	public void loadServio() {
		try {
			Pane telaServico = FXMLLoader.load(this.getClass().getResource("servico/TelaServico.fxml"));
			this.mainServico = new Scene(telaServico);
		} catch (IOException e) {

			e.printStackTrace();
		}

	}

	public void loadFatura() {
		try {
			Pane telaFatura = FXMLLoader.load(this.getClass().getResource("fatura/TelaFatura.fxml"));
			this.mainFatura = new Scene(telaFatura);
		} catch (IOException e) {

			e.printStackTrace();
		}

	}

	public void loadPagamento() {
		try {
			Pane telaPagamento = FXMLLoader.load(this.getClass().getResource("pagamento/TelaPagamento.fxml"));
			this.mainPagamento = new Scene(telaPagamento);
		} catch (IOException e) {

			e.printStackTrace();
		}

	}
	
	
	public void loadLogin() {
		try {
			Pane telaLogin = FXMLLoader.load(this.getClass().getResource("login/TelaLogin.fxml"));
			this.mainLogin = new Scene(telaLogin);
		} catch (IOException e) {

			e.printStackTrace();
		}

	}

	public void loadFuncionario() {
		try {
			Pane telaFuncionario = FXMLLoader.load(this.getClass().getResource("funcionario/Tela_Funcionarios.fxml"));
			this.mainFuncionario = new Scene(telaFuncionario);
		} catch (IOException e) {

			e.printStackTrace();
		}

	}
	
	public void loadCliente() {
		try {
			Pane ClienteController = FXMLLoader.load(this.getClass().getResource("cliente/TelaCliente.fxml"));
			this.mainCliente = new Scene(ClienteController);
		} catch (IOException e) {

			e.printStackTrace();
		}

	}

	public void loadMenuPrincipal() {
		try {
			Pane telaMenuPrincipal = FXMLLoader
					.load(this.getClass().getResource("MenuPrincipal/TelaPrincipal_adm.fxml"));
			this.mainMenuPrincipal = new Scene(telaMenuPrincipal);
		} catch (IOException e) {

			e.printStackTrace();
		}

	}


	public Stage getMainStage() {
		return mainStage;
	}

	public void setMainStage(Stage mainStage) {
		this.mainStage = mainStage;
		this.mainStage.setTitle("Libélula");
		this.mainStage.setResizable(false);
		// this.mainStage.initStyle(StageStyle.UNDECORATED);
	}
	
	public void setInfoStage(Stage stage){
		this.infoStage = stage;
		this.infoStage.setResizable(false);
		//this.infoStage.initStyle(StageStyle.UNDECORATED);
	}

	// CHAMADA DE TELAS

	public void showLogin() {
		this.loadLogin();
		this.mainStage.setScene(mainLogin);
		this.mainStage.show();
	}

	public void showFuncionario() {
		this.loadFuncionario();
		this.mainStage.setScene(mainFuncionario);
		// this.mainStage.show();
	}

	public void showMenuPrincipal() {
		this.loadMenuPrincipal();
		this.mainStage.setScene(mainMenuPrincipal);
		//this.mainStage.show();

	}
	
	public void showPacote() {
		this.loadPacote();
		this.mainStage.setScene(mainPacote);
		this.mainStage.show();

	}
	
	public void showItem() {
		this.loadItem();
		this.infoStage.setScene(mainItem);
		this.infoStage.show();

	}
	
	
	public void showCliente(){
		this.loadCliente();
		this.infoStage.setScene(mainCliente);
		this.infoStage.show();
	}

	public void showFatura(){
		this.loadFatura();
		this.infoStage.setScene(mainFatura);
		this.infoStage.show();
	}

	public void showPagamento(){
		this.loadPagamento();
		this.infoStage.setScene(mainPagamento);
		this.infoStage.show();
	}

	public void showServico(){
		this.loadServio();
		this.infoStage.setScene(mainServico);
		this.infoStage.show();
	}
	
	public void showInfoStage(){
		this.infoStage.show();
	}

	// show stages
	public void showMainStage() {
		this.mainStage.show();
	}

	// close stages
	public void fecharMainStage() throws Exception {
		this.mainStage.close();
		Fachada.getInstance().logout();

	}
	
	public void fecharInfoStage(){
		this.infoStage.close();
		
	}

	public void minimizarMainStage() {
		this.mainStage.setIconified(true);
	}

}
