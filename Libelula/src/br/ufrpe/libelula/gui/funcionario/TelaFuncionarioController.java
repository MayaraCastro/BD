package br.ufrpe.libelula.gui.funcionario;

import br.ufrpe.libelula.gui.ScreenManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class TelaFuncionarioController {

    @FXML
    void Tela_Principal(ActionEvent event) {
    	ScreenManager.getInstance().showMenuPrincipal();
    }

}
