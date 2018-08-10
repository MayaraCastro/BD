package br.ufrpe.libelula.gui.funcionario;

import br.ufrpe.libelula.gui.ScreenManager;
import br.ufrpe.libelula.negocio.beans.Gerente;
import br.ufrpe.libelula.negocio.beans.Pessoa;
import br.ufrpe.libelula.negocio.gerenciamento.Fachada;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.SingleSelectionModel;
import javafx.scene.control.TextField;

public class TelaFuncionarioController implements Initializable{
	Fachada f;
    Pessoa	pessoa;
    Gerente	gerente;
    /*
     * 
     * Guia	guia;
     * Motorista motorista;
     * Agente agente;
     */
    @FXML
    private JFXTextField agencia;
    
    @FXML
    private TextField buscar_campo;

    @FXML
    private JFXDatePicker data_nascimento;
    
    @FXML
    private JFXComboBox<String> cargo;

    @FXML
    private JFXComboBox<String> sexo;

    @FXML
    private JFXTextField salario;

    @FXML
    private JFXTextField nome;

    @FXML
    private JFXTextField cpf;

    @FXML
    private JFXTextField ramal;

    @FXML
    private JFXTextField telefone;

    @FXML
    private Label codigo;
    
    @FXML
    private JFXTextField cep;

    @FXML
    private JFXTextField num_end;
    
    @FXML
    private Button remover_button;

    @FXML
    void Tela_Principal(ActionEvent event) {
    	ScreenManager.getInstance().showMenuPrincipal();
    }

    @FXML
    void cancelar(ActionEvent event) {
    	this.novo_funcionario(event);
    }

    @FXML
    void novo_funcionario(ActionEvent event) {   
    	pessoa = new Pessoa();
    	gerente = new Gerente();
    	/*
    	 * guia = new Guia();
    	 * motorista = new Motorista();
    	 * agente = new Agente();
    	 *     	 * */
    	salario.clear();
    	nome.clear();
    	cpf.clear();
    	ramal.clear();
    	telefone.clear();
    	codigo.setText("#");
    	cep.clear();
    	num_end.clear();
    	
    	SingleSelectionModel<String> a =cargo.getSelectionModel() ;
		a.clearSelection();
		cargo.setSelectionModel(a);
		
		a =sexo.getSelectionModel() ;
		a.clearSelection();
		sexo.setSelectionModel(a);
		
    	remover_button.setDisable(true);
    }

    @FXML
    void remover(ActionEvent event) {
    	this.preenchercomosdados();
    	f.RemoverFuncionario(pessoa);
    }
    
    @FXML
    void salvar(ActionEvent event) {
    	
    	this.preenchercomosdados();
    	if(pessoa.getCod() != null) {
    		f.AtualizarFuncionario(pessoa);
    	}
    	else{
    		f.CadastrarFuncionario(pessoa);
    	}
    }
    void preenchercomosdados() {
    	if(cargo.getSelectionModel().equals("Gerente")) {
    		
			String s;
			if(sexo.getSelectionModel().equals("Masculino")) {
				s = "M";
			}else
			{
				s ="F";
			}
			
			if(pessoa.getCod() != null) {
				pessoa = new Gerente(pessoa.getCod(), nome.getText(),data_nascimento.getValue(),s ,telefone.getText(), null, cep.getText(),Integer.parseInt(num_end.getText()),
	    				Float.parseFloat(salario.getText()), Integer.parseInt(ramal.getText()), cpf.getText(), agencia.getText());
			}
			else {
				pessoa = new Gerente(nome.getText(),data_nascimento.getValue(),s ,telefone.getText(), null, cep.getText(),Integer.parseInt(num_end.getText()),
    				Float.parseFloat(salario.getText()), Integer.parseInt(ramal.getText()), cpf.getText(), agencia.getText());
    	
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
        	
        	data_nascimento.setValue(pessoa.getDt_nasc());
        	nome.setText(pessoa.getNome());
        	cep.setText(pessoa.getCep());
        	num_end.setText(Integer.toString(pessoa.getNum()));
        	telefone.setText(pessoa.getFone());
    		
        	if(pessoa instanceof Gerente) {
        		SingleSelectionModel<String> a =cargo.getSelectionModel() ;
        		a.select(3);
        		cargo.setSelectionModel(a);
        		
        		salario.setText(Float.toString(((Gerente)pessoa).getSalario()));

        		ramal.setText(Integer.toString(((Gerente)pessoa).getRamal()));
        		
        		cpf.setText(((Gerente)pessoa).getCPF());
        		
        		agencia.setText(((Gerente)pessoa).getCod_Agencia());
        		
        		codigo.setText(Integer.toString(((Gerente)pessoa).getCod()));
        		
        	}//TODO por else if de guia, agente e motorista
        	
        	
        	remover_button.setDisable(false);
    	}
    	
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		ObservableList<String> listSexo = FXCollections.observableArrayList("Masculino","Feminino");
		sexo.setItems(listSexo);
		
		ObservableList<String> listCargo = FXCollections.observableArrayList("Agente","Guia","Motorista","Gerente");
		cargo.setItems(listCargo);
		
		f = Fachada.getInstance();
		
		pessoa = new Pessoa();
    	gerente = new Gerente();
    	/*
    	 * guia = new Guia();
    	 * motorista = new Motorista();
    	 * agente = new Agente();
		*/
		
	}

}
