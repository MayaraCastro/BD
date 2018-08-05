package br.ufrpe.libelula.gui.login;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import br.ufrpe.libelula.gui.ScreenManager;
import br.ufrpe.libelula.negocio.gerenciamento.Fachada;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginController implements Initializable {
	
	private Fachada f;
	
    @FXML
    private TextField caixa_usuario;

    @FXML
    private PasswordField caixa_senha;

    @FXML
    private Button button_logar;

    @FXML
	void logar(ActionEvent event) {
		try {
			this.f.login(caixa_usuario.getText(), caixa_senha.getText());
			// JOptionPane.showMessageDialog(null,"Login com sucesso!" );

			this.chamarTelaPrincipal();

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro no Login");
		}
	}

	public void chamarTelaPrincipal() throws IOException {
		ScreenManager.getInstance().showMenuPrincipal();
	}


	@Override
	public void initialize(URL location, ResourceBundle resources) {
		f = Fachada.getInstance();
	}

}