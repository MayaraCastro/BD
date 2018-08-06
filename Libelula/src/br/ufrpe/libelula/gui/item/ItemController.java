package br.ufrpe.libelula.gui.item;

import java.net.URL;
import java.util.ResourceBundle;

import br.ufrpe.libelula.gui.ScreenManager;
import br.ufrpe.libelula.gui.pacote.PacoteController;
import br.ufrpe.libelula.negocio.beans.ItemPacote;
import br.ufrpe.libelula.negocio.beans.Servico_Ref;
import br.ufrpe.libelula.negocio.gerenciamento.Fachada;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
public class ItemController implements Initializable{
	
	private Fachada f;
	
	private ItemPacote i;

    @FXML
    private TextField cod_serv;

    @FXML
    private TextField valor_unitario;

    @FXML
    private TextField qtd;

    @FXML
    private DatePicker data;
    
    @FXML
    private Button remover_button;

    @FXML
    void buscar_servico(ActionEvent event) {
    	Servico_Ref s = this.f.BuscarServico(Integer.parseInt(cod_serv.getText()));
    	if(s != null) {
    		valor_unitario.setText(Float.toString(s.getValor()));
        	System.out.println(Integer.parseInt(cod_serv.getText()));

    	}
    }

    @FXML
    void cancelar(ActionEvent event) {
    	ScreenManager.getInstance().fecharInfoStage();
    }

    @FXML
    void salvar(ActionEvent event) {
    	this.i.setCodpacote(PacoteController.getPacote().getCodigo());
    	this.i.setCodservico(Integer.parseInt(cod_serv.getText()));
    	this.i.setDt(data.getValue());
    	this.i.setQtd(Integer.parseInt(qtd.getText()));
    	this.i.setVl_unitario(Float.parseFloat(valor_unitario.getText()));
    	
    	if(i.getId_sk()!= null) {
    		f.AtualizarItemPacote(i);
    	}else {
    		f.CadastrarItemPacote(i);
    	}
		ScreenManager.getInstance().fecharInfoStage();

    }
    
    @FXML
    void remover(ActionEvent event) {
    	this.i.setCodpacote(PacoteController.getPacote().getCodigo());
    	this.i.setCodservico(Integer.parseInt(cod_serv.getText()));
    	this.i.setDt(data.getValue());
    	this.i.setQtd(Integer.parseInt(qtd.getText()));
    	this.i.setVl_unitario(Float.parseFloat(valor_unitario.getText()));
    	
    	if(i.getId_sk()!= null) {
    		f.RemoverItemPacote(i);
    		ScreenManager.getInstance().fecharInfoStage();
    	}

    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		i = PacoteController.getItem();
		if(i.getId_sk()!=null) {
			cod_serv.setText(Integer.toString(i.getCodservico()));
			valor_unitario.setText(Float.toString(i.getVl_unitario()));
			qtd.setText(Integer.toString(i.getQtd()));
			data.setValue(i.getDt());
			
			remover_button.setDisable(false);
		}
		this.f = Fachada.getInstance();
		
	}
    
    

}
