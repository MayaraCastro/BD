package br.ufrpe.libelula.gui;

import java.io.IOException;

import br.ufrpe.libelula.negocio.gerenciamento.Fachada;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class ScreenManager {

	private static ScreenManager instance;
	private Stage mainStage;

	// private FXMLLoader
	private Scene mainLogin, mainFuncionario, mainMenuPrincipal;

	public static ScreenManager getInstance() {
		if (instance == null) {
			instance = new ScreenManager();
		}
		return instance;
	}

	// Load scenes
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
		this.mainStage.show();

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

	public void minimizarMainStage() {
		this.mainStage.setIconified(true);
	}

}
