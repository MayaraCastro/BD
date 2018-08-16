package br.ufrpe.libelula.gui.cliente;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;

import br.ufrpe.libelula.gui.ScreenManager;
import br.ufrpe.libelula.negocio.beans.Agente;
import br.ufrpe.libelula.negocio.beans.ClienteFisico;
import br.ufrpe.libelula.negocio.beans.ClienteJuridico;
import br.ufrpe.libelula.negocio.beans.Gerente;
import br.ufrpe.libelula.negocio.beans.Guia;
import br.ufrpe.libelula.negocio.beans.Motorista;
import br.ufrpe.libelula.negocio.beans.Pessoa;
import br.ufrpe.libelula.negocio.gerenciamento.Fachada;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.SingleSelectionModel;
import javafx.scene.control.TextField;

public class ClienteController implements Initializable{
	Fachada f;
    Pessoa	pessoa;

    @FXML
    private TextField cnpj;

    @FXML
    private TextField buscar_campo;

    @FXML
    private DatePicker dtinicio;

    @FXML
    private ComboBox<String> tipo;

    @FXML
    private ComboBox<String> sexo;

    @FXML
    private TextField nome;

    @FXML
    private TextField cpf;

    @FXML
    private TextField agencia;

    @FXML
    private TextField num_end;

    @FXML
    private TextField telefone;

    @FXML
    private Label codigo;

    @FXML
    private TextField cep;

    @FXML
    private Button remover_button;

    @FXML
    void Tela_Principal(ActionEvent event) {
    	ScreenManager.getInstance().showMenuPrincipal();
    }

    @FXML
    void cancelar(ActionEvent event) {
    	this.novo_cliente(event);
    }

    @FXML
    void novo_cliente(ActionEvent event) {
    	pessoa = new Pessoa();

    	cnpj.clear();
    	nome.clear();
    	cpf.clear();
    	codigo.setText("#");
    	cep.clear();
    	num_end.clear();
    	telefone.clear();

    	SingleSelectionModel<String> a =tipo.getSelectionModel() ;
		a.clearSelection();
		tipo.setSelectionModel(a);

		a =sexo.getSelectionModel() ;
		a.clearSelection();
		sexo.setSelectionModel(a);
    	remover_button.setDisable(true);
    }

    @FXML
    void remover(ActionEvent event) {
    	this.preenchercomosdados();
    	f.RemoverFuncionario(pessoa);
    	ScreenManager.getInstance().showFuncionario();
    }

    public boolean verificarDados() {
    	LocalDate date = LocalDate.now();
    	if(nome.getText() ==null ||telefone.getText() == null || dtinicio.getValue() == null ||cep.getText() == null ||num_end.getText() == null || agencia.getText() ==null) {
    		return false;
    	}
    	if(tipo.getValue()=="Fisico"){
    		cnpj.setDisable(true);
    	}
    	else{
    		cpf.setDisable(true);
    	}
    	if(dtinicio.getValue().compareTo(date) > 0 || dtinicio.getValue().getYear() < 1900) {
    		return false;
    	}
    	if(Integer.parseInt(num_end.getText()) <0) {
    		return false;
    	}
    	if(Integer.parseInt(cpf.getText().substring(0, 3)) < 0 || Integer.parseInt(cpf.getText().substring(4, 7)) <0
            || Integer.parseInt(cpf.getText().substring(8, 11)) < 0
            || Integer.parseInt(cpf.getText().substring(12, 14)) < 0) {
    		return false;
    	}
    	if(Integer.parseInt(cnpj.getText().substring(0, 3)) < 0 || Integer.parseInt(cnpj.getText().substring(4, 7)) <0
                || Integer.parseInt(cnpj.getText().substring(8, 11)) < 0
                || Integer.parseInt(cnpj.getText().substring(12, 14)) < 0) {
        		return false;
        	}
    	return true;
    }

    @FXML
    void salvar(ActionEvent event) {
    	try {
    		this.preenchercomosdados();


	    	if(this.verificarDados()) {
	    		if(pessoa.getCod() != null) {
	    		f.AtualizarFuncionario(pessoa);
	    		}
	    		else{
	    			f.CadastrarFuncionario(pessoa);
	    			codigo.setText(Integer.toString(f.pegarcoddoultimo()));
	    			remover_button.setDisable(false);
	    		}
	    	}else {
	    		JOptionPane.showMessageDialog(null, "Informação Inválida!");
	    	}
    	}
    	catch(Exception e) {
    		JOptionPane.showMessageDialog(null, "Informação Inválida!");
    	}

    }
    void preenchercomosdados() {

	    	if(tipo.getSelectionModel().getSelectedItem().equals("Fisico")) {

				String s;
				if(sexo.getSelectionModel().getSelectedItem().equals("Masculino")) {
					s = "M";
				}else{
					s ="F";
				}
				String tip;
				if(tipo.getValue()=="Fisico") tip = "0";
				else tip="1";
				if(pessoa.getCod() != null) {

					pessoa = new ClienteFisico(pessoa.getCod(), nome.getText(),dtinicio.getValue(),s ,sexo.getValue(), null ,cep.getText(),Integer.parseInt(num_end.getText()),
		    				Integer.parseInt(codigo.getText()), agencia.getText(), cpf.getText(), Integer.parseInt(tip));
				}
				else {
					pessoa = new ClienteFisico(pessoa.getCod(), nome.getText(),dtinicio.getValue(),s ,sexo.getValue(), null ,cep.getText(),Integer.parseInt(num_end.getText()),
		    				Integer.parseInt(codigo.getText()), agencia.getText(), cpf.getText(), Integer.parseInt(tip));
				}
	    	}
	    	else if(tipo.getSelectionModel().getSelectedItem().equals("Juridico")) {

				String s;
				if(sexo.getSelectionModel().getSelectedItem().equals("Masculino")) {
					s = "M";
				}else{
					s ="F";
				}
				String tip;
				if(tipo.getValue()=="Fisico") tip = "0";
				else tip="1";

				if(pessoa.getCod() != null) {
					pessoa = new ClienteJuridico(pessoa.getCod(), nome.getText(),dtinicio.getValue(),s ,sexo.getValue(), null ,cep.getText(),Integer.parseInt(num_end.getText()),
		    				Integer.parseInt(codigo.getText()), agencia.getText(), cpf.getText(), nome.getText());
				}
				else {
					pessoa = new ClienteJuridico(pessoa.getCod(), nome.getText(),dtinicio.getValue(),s ,sexo.getValue(), null ,cep.getText(),Integer.parseInt(num_end.getText()),
		    				Integer.parseInt(codigo.getText()), agencia.getText(), cpf.getText(), nome.getText());
				}
	    	}

    }

    @FXML
    void buscar(ActionEvent event) {

    	pessoa = f.BuscarFuncionario(Integer.parseInt(buscar_campo.getText()));

    	if(pessoa != null) {
    		if(pessoa.getSexo().equals("M")) {
        		SingleSelectionModel<String> a =sexo.getSelectionModel() ;
        		a.select(0);
        		sexo.setSelectionModel(a);
        	}
        	else {
        		SingleSelectionModel<String> a =sexo.getSelectionModel() ;
        		a.select(1);
        		sexo.setSelectionModel(a);
        	}

        	dtinicio.setValue(pessoa.getDt_nasc());
        	nome.setText(pessoa.getNome());
        	cep.setText(pessoa.getCep());
        	num_end.setText(Integer.toString(pessoa.getNum()));

        	if(pessoa instanceof ClienteFisico) {
        		SingleSelectionModel<String> a =tipo.getSelectionModel() ;
        		a.select(1);
        		tipo.setSelectionModel(a);

        		cpf.setText(((ClienteFisico)pessoa).getCPF());

        		cnpj.setDisable(true);

        		agencia.setText(((ClienteFisico)pessoa).getAgencia());

        		codigo.setText(Integer.toString(((ClienteFisico)pessoa).getCodigo()));

        	}
        	else if(pessoa instanceof ClienteJuridico) {
        		SingleSelectionModel<String> a =tipo.getSelectionModel() ;
        		a.select(0);
        		tipo.setSelectionModel(a);

        		cnpj.setText(((ClienteJuridico)pessoa).getCNPJ());

        		cpf.setDisable(true);

        		agencia.setText(((ClienteJuridico)pessoa).getAgencia());

        		codigo.setText(Integer.toString(((ClienteJuridico)pessoa).getCodigo()));


        	}

        	remover_button.setDisable(false);
    	}

    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		ObservableList<String> listSexo = FXCollections.observableArrayList("Masculino","Feminino");
		sexo.setItems(listSexo);

		ObservableList<String> listCargo = FXCollections.observableArrayList("Agente","Guia","Motorista","Gerente");
		tipo.setItems(listCargo);

		f = Fachada.getInstance();

		pessoa = new Pessoa();


	}


}
