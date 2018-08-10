package br.ufrpe.libelula.gui;

import javax.swing.JOptionPane;
import javafx.application.Application;
import javafx.stage.Stage;

public class MainGUI extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		try {
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
			throw new Exception(e);
		}
		ScreenManager.getInstance().setMainStage(primaryStage);
		ScreenManager.getInstance().showLogin();

	}

	public static void main(String[] args) {
		launch(args);
	}
}