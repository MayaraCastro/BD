package br.ufrpe.libelula.gui.MenuPrincipal;
import br.ufrpe.libelula.gui.ScreenManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

public class TelaMenuPrincipalController {

    @FXML
    private Button button_logoff;

    @FXML
    void log_off(ActionEvent event) {

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

}
