import java.net.URL;
import java.sql.Date;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import br.ufrpe.libelula.gui.ScreenManager;
import br.ufrpe.libelula.gui.fatura.FaturaController;
import br.ufrpe.libelula.gui.pacote.PacoteController;
import br.ufrpe.libelula.negocio.beans.Fatura;
import br.ufrpe.libelula.negocio.beans.ItemPacote;
import br.ufrpe.libelula.negocio.beans.Pagamento;
import br.ufrpe.libelula.negocio.gerenciamento.Fachada;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Tab;
import javafx.scene.control.TextField;

public class PagamentoController implements Initializable{

	private Fachada f;

	private Pagamento p;

	private Fatura fat;

	@FXML
    private DatePicker  dt_venc;

	@FXML
    private Label  dt_vencL;

    @FXML
    private TextField juros;

    @FXML
    private TextField valor_pag;

    @FXML
    private TextField cod_pag;

    @FXML
    private TextField nome_titular;

    @FXML
    private TextField tipoCartao;

    @FXML
    private TextField cod_fat;

    @FXML
    private TextField cod_seq;

    @FXML
    private TextField num_cartao;

    @FXML
    private Label jurosL;

    @FXML
    private Label valor_pagL;

    @FXML
    private Label cod_pagL;

    @FXML
    private Label nome_titularL;

    @FXML
    private Label tipoCartaoL;

    @FXML
    private Label cod_fatL;

    @FXML
    private Label cod_seqL;

    @FXML
    private Label num_cartaoL;


    @FXML
    private Button remover_button;

    @FXML
    private DatePicker dt_pag;

    @FXML
    private TextField nome_titu;

    @FXML
    private DatePicker dt_validade;

    @FXML
    private RadioButton credito;

    @FXML
    private RadioButton debito;

    @FXML
    private Tab tab_pagamento;

    @FXML
    private Label dt_pagL;

    @FXML
    private Label nome_tituL;

    @FXML
    private Label dt_validadeL;



    @FXML
    void buscar_pagamento(ActionEvent event) {
    	 p = this.f.BuscarPagamento(Integer.parseInt(cod_pag.getText()));
    	if(p != null) {
    		valor_pag.setText(Double.toString(p.getVl_pagamento()));
			tab_pagamento.setDisable(false);

    	}
    }

    @FXML
    void cancelar(ActionEvent event) {
    	ScreenManager.getInstance().fecharInfoStage();
    }

    public boolean verificarDados() {
    	if(juros.getText() == null ||
    		valor_pag.getText() == null || cod_pag.getText() == null ||
    		nome_titular.getText() == null || tipoCartao.getText() == null ||
    		dt_venc.getValue() == null || cod_fat.getText() == null ||
    		cod_seq.getText() == null || num_cartao.getText() == null ||
    		dt_pag.getValue() == null || nome_titu.getText() == null ||
    		dt_validade.getValue() == null){

    		return false;
    	}
    	if(dt_venc.getValue().getYear() < 2000  || dt_pag.getValue().getYear() <2000 ||
    			dt_validade.getValue().getYear() < 200) {
    		return false;
    	}
    	if(Integer.parseInt(num_cartao.getText()) <0 || Integer.parseInt(cod_seq.getText()) <0) {
    		return false;
    	}
    	if(Float.parseFloat(valor_pag.getText()) < 0 || Float.parseFloat(juros.getText())< 0) {
    		return false;
    	}
    	return true;
    }

    @FXML
    void salvar(ActionEvent event) {
    	try {
    		LocalDate l1 = dt_pag.getValue();
    		Instant i1 = Instant.from(l1.atStartOfDay(ZoneId.systemDefault()));
    		Date d1 = (Date) Date.from(i1);

    		LocalDate l2 = dt_validade.getValue();
    		Instant i2 = Instant.from(l2.atStartOfDay(ZoneId.systemDefault()));
    		Date d2 = (Date) Date.from(i2);

    		LocalDate l3 = dt_venc.getValue();
    		Instant i3 = Instant.from(l3.atStartOfDay(ZoneId.systemDefault()));
    		Date d3 = (Date) Date.from(i3);

    		this.p.setCod_seg(Integer.parseInt(cod_seq.getText()));
    		this.p.setCodFatura(Integer.parseInt(cod_fat.getText()));
    		this.p.setCodigo(Integer.parseInt(cod_pag.getText()));
    		this.p.setDt_pag(d1);
    		this.p.setDt_validade(d2);
    		this.p.setDt_vence(d3);
    		this.p.setJuros(Double.parseDouble(juros.getText()));
    		this.p.setNome_titular(nome_titular.getText());
    		this.p.setNumero_cartao((num_cartao.getText()));
    		if(credito.isSelected()){
    			p.setTipo(0);
    		}
    		else{
    			this.p.setTipo(1);
    		}

	    	if(this.verificarDados()) {
	    		if(p.getCodigo()!= 0) {
	    			f.AtualizarPagamento(p);
	    		}else {
	    			f.CadastrarPagamento(p);
	    		}
	    		ScreenManager.getInstance().fecharInfoStage();
			}else {
				JOptionPane.showMessageDialog(null, "Informação Inválida!");
			}
	    	PacoteController.setItem(new ItemPacote());
    	}
    	catch(Exception e) {
    		JOptionPane.showMessageDialog(null, "Informação Inválida!" +e.getMessage());
    	}

    }

    @FXML
    void remover(ActionEvent event) {
    	LocalDate l1 = dt_pag.getValue();
		Instant i1 = Instant.from(l1.atStartOfDay(ZoneId.systemDefault()));
		Date d1 = (Date) Date.from(i1);

		LocalDate l2 = dt_validade.getValue();
		Instant i2 = Instant.from(l2.atStartOfDay(ZoneId.systemDefault()));
		Date d2 = (Date) Date.from(i2);

		LocalDate l3 = dt_venc.getValue();
		Instant i3 = Instant.from(l3.atStartOfDay(ZoneId.systemDefault()));
		Date d3 = (Date) Date.from(i3);

    	this.p.setCod_seg(Integer.parseInt(cod_seq.getText()));
		this.p.setCodFatura(Integer.parseInt(cod_fat.getText()));
		this.p.setCodigo(Integer.parseInt(cod_pag.getText()));
		this.p.setDt_pag(d1);
		this.p.setDt_validade(d2);
		this.p.setDt_vence(d3);
		this.p.setJuros(Double.parseDouble(juros.getText()));
		this.p.setNome_titular(nome_titular.getText());
		this.p.setNumero_cartao((num_cartao.getText()));
		if(credito.isSelected()){
			p.setTipo(0);
		}
		else{
			this.p.setTipo(1);
		}


    	if(p.getCodigo()!= 0) {
    		f.RemoverPagamento(p);
    		ScreenManager.getInstance().fecharInfoStage();
    	}

    }

    public void preenchercampospagamento() {
    	LocalDate l1 = dt_pag.getValue();
		Instant i1 = Instant.from(l1.atStartOfDay(ZoneId.systemDefault()));
		Date d1 = (Date) Date.from(i1);

		LocalDate l2 = dt_validade.getValue();
		Instant i2 = Instant.from(l2.atStartOfDay(ZoneId.systemDefault()));
		Date d2 = (Date) Date.from(i2);

		LocalDate l3 = dt_venc.getValue();
		Instant i3 = Instant.from(l3.atStartOfDay(ZoneId.systemDefault()));
		Date d3 = (Date) Date.from(i3);


    	this.p.setCod_seg(Integer.parseInt(cod_seq.getText()));
		this.p.setCodFatura(Integer.parseInt(cod_fat.getText()));
		this.p.setCodigo(Integer.parseInt(cod_pag.getText()));
		this.p.setDt_pag(d1);
		this.p.setDt_validade(d2);
		this.p.setDt_vence(d3);
		this.p.setJuros(Double.parseDouble(juros.getText()));
		this.p.setNome_titular(nome_titular.getText());
		this.p.setNumero_cartao((num_cartao.getText()));
		if(credito.isSelected()){
			p.setTipo(0);
		}
		else{
			this.p.setTipo(1);
		}

	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		this.f = Fachada.getInstance();
		fat = FaturaController.getFatura();
		tab_pagamento.setDisable(false);
		this.preenchercampospagamento();
		if(p.getCodigo()!=0) {
			p = f.BuscarPagamento(p.getCodigo());

			tab_pagamento.setDisable(false);
			this.preenchercampospagamento();
			remover_button.setDisable(false);
		}

	}



}
