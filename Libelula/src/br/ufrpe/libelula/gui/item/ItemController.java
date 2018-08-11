package br.ufrpe.libelula.gui.item;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import br.ufrpe.libelula.gui.ScreenManager;
import br.ufrpe.libelula.gui.pacote.PacoteController;
import br.ufrpe.libelula.negocio.beans.ItemPacote;
import br.ufrpe.libelula.negocio.beans.Pacote;
import br.ufrpe.libelula.negocio.beans.Servico_Ref;
import br.ufrpe.libelula.negocio.gerenciamento.Fachada;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TextField;




public class ItemController implements Initializable{
	
	private Fachada f;
	
	private ItemPacote i;
	
	private Pacote p;
	
	private Servico_Ref s;
	
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
    private Label cod_pacote;

    @FXML
    private Label valor_total_pacote;

    @FXML
    private Label valor_desconto_pacote;

    @FXML
    private Label total_pagar_pacote;

    @FXML
    private Label n_criancas;

    @FXML
    private Label dt_inicio;

    @FXML
    private Label dt_final;

    @FXML
    private Label tipo_pacote;

    @FXML
    private Label n_adultos;

    @FXML
    private Label cod_servico;

    @FXML
    private Label valor_servico;

    @FXML
    private Label destino_servico;

    @FXML
    private Label tipo_servico;

    @FXML
    private Label nivel_servico;
    
    @FXML
    private Tab tab_pacote;
    
    @FXML
    private Tab tab_servico;

    @FXML
    void buscar_servico(ActionEvent event) {
    	s = this.f.BuscarServico(Integer.parseInt(cod_serv.getText()));
    	if(s != null) {
    		valor_unitario.setText(Float.toString(s.getValor()));
        	this.preenchercamposservico();
			tab_servico.setDisable(false);

    	}
    }

    @FXML
    void cancelar(ActionEvent event) {
    	ScreenManager.getInstance().fecharInfoStage();
    }
    
    public boolean verificarDados() {
    	LocalDate date = LocalDate.now();
    	if(s ==null || data.getValue() == null || qtd.getText() == null || valor_unitario.getText() == null) {
    		return false;
    	}
    	if(data.getValue().compareTo(date) < 0  ) {
    		return false;
    	}
    	if(Integer.parseInt(qtd.getText()) <0) {
    		return false;
    	}
    	if(Float.parseFloat(valor_unitario.getText()) < 0) {
    		return false;
    	}
    	return true;
    }

    @FXML
    void salvar(ActionEvent event) {
    	try {
	    	this.i.setCodpacote(PacoteController.getPacote().getCodigo());
	    	this.i.setCodservico(s.getCodigo());
	    	this.i.setDt(data.getValue());
	    	this.i.setQtd(Integer.parseInt(qtd.getText()));
	    	this.i.setVl_unitario(Float.parseFloat(valor_unitario.getText()));
	    	
	    	if(this.verificarDados()) {
	    		if(i.getId_sk()!= null) {
	    			f.AtualizarItemPacote(i);
	    		}else {
	    			f.CadastrarItemPacote(i);
	    		}
	    		ScreenManager.getInstance().fecharInfoStage();
			}else {
				JOptionPane.showMessageDialog(null, "Informação Inválida!");
			}
	    	PacoteController.setItem(new ItemPacote());
    	}
    	catch(Exception e) {
    		JOptionPane.showMessageDialog(null, "Informação Inválida!");
    	}

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
    
    public void preenchercampositem() {
    	//item
    	cod_serv.setText(Integer.toString(i.getCodservico()));
		valor_unitario.setText(Float.toString(i.getVl_unitario()));
		qtd.setText(Integer.toString(i.getQtd()));
		data.setValue(i.getDt());
		}
	public void preenchercampospacote() {
		//pacote
		cod_pacote.setText(Integer.toString(p.getCodigo()));
		valor_total_pacote.setText(Float.toString(p.getVl_total()));
		valor_desconto_pacote.setText(Float.toString(p.getVl_desconto()));
		total_pagar_pacote.setText(Float.toString(p.getTotal_a_pagar()));
		dt_inicio.setText(p.getDatainicio().toString());
		dt_final.setText(p.getDatafim().toString());
		if(p.getTipo() == 3) {
			tipo_pacote.setText("Grupo");
			n_criancas.setText(Integer.toString(p.getN_criancas()));
			n_adultos.setText(Integer.toString(p.getN_adultos()));
		}
		else if(p.getTipo() == 2) {
			tipo_pacote.setText("Casal");
		}
		else {
			tipo_pacote.setText("Individual");
		}
			
	}
	public void preenchercamposservico() {
		//servico
		cod_servico.setText(Integer.toString(s.getCodigo()));
		valor_servico.setText(Float.toString(s.getValor()));
		destino_servico.setText(s.getLocal_destino());
		if(s.getTipoServico() == 1) {
			tipo_servico.setText("Serviço Próprio");
		}
		else {
			tipo_servico.setText("Serviço Parceiro");
		}

		nivel_servico.setText(Integer.toString(s.getNivel()));
		
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		this.f = Fachada.getInstance();
		i = PacoteController.getItem();
		p = PacoteController.getPacote();
		tab_pacote.setDisable(false);
		this.preenchercampospacote();
		if(i.getId_sk()!=null) {
			p = f.BuscarPacote(i.getCodpacote());
			s = f.BuscarServico(i.getCodservico());
			
			tab_servico.setDisable(false);
			this.preenchercampositem();
			this.preenchercamposservico();
			remover_button.setDisable(false);
		}
		
	}
    
    

}
