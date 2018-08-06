package br.ufrpe.libelula.gui.MenuPrincipal;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import br.ufrpe.libelula.gui.ScreenManager;
import br.ufrpe.libelula.negocio.gerenciamento.Fachada;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

public class TelaMenuPrincipalController implements Initializable {
	private Fachada f;
    @FXML
    private Button button_logoff;

    @FXML
    void log_off(ActionEvent event) {
    	try {
			f.logout();
			ScreenManager.getInstance().showLogin();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    @FXML
    void tela_agencia(MouseEvent event) {

    }

    @FXML
    void tela_clientes(MouseEvent event) {

    }

    @FXML
    void tela_comprar(MouseEvent event) {

    }

    @FXML
    void tela_funcionarios(MouseEvent event) {
    	ScreenManager.getInstance().showFuncionario();
    }

    @FXML
    void tela_pacotes(MouseEvent event) {
    	ScreenManager.getInstance().showPacote();
    }

    @FXML
    void tela_parceiros(MouseEvent event) {

    }

    @FXML
    void tela_promocoes(MouseEvent event) {

    }

    @FXML
    void tela_servicos(MouseEvent event) {

    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		f = Fachada.getInstance();
		
	}

}
