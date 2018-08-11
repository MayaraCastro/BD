package br.ufrpe.libelula.gui.pacote;

import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import br.ufrpe.libelula.gui.ScreenManager;
import br.ufrpe.libelula.negocio.beans.ItemPacote;
import br.ufrpe.libelula.negocio.beans.Pacote;
import br.ufrpe.libelula.negocio.gerenciamento.Fachada;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.util.converter.IntegerStringConverter;

public class PacoteController implements Initializable{
	
	private  Fachada f;
	
	private static Pacote p;
	
	private static ItemPacote item;
	

    @FXML
    private TextField Busca_pacote;

    @FXML
    private  TableView<ItemPacote> lista_itens;

    @FXML
    private TextField desconto;

    @FXML
    private TextField valor;

    @FXML
    private TextField total_pagar;

    @FXML
    private RadioButton individual;

    @FXML
    private RadioButton casal;

    @FXML
    private RadioButton grupo;

    @FXML
    private TextField n_adultos;

    @FXML
    private TextField n_criancas;

    @FXML
    private Label codigo;
    
    @FXML
    private DatePicker dtinicio;

    @FXML
    private DatePicker dtfim;
    
    @FXML
    private Button adicionar_itens;
    
    @FXML
    private TableColumn<ItemPacote, Integer> id_col;

    @FXML
    private TableColumn<ItemPacote, Integer> cod_servico_col;

    @FXML
    private TableColumn<ItemPacote, LocalDate> data_col;

    @FXML
    private TableColumn<ItemPacote, Float> valor_unit_col;

    @FXML
    private TableColumn<ItemPacote, Integer> qtd_col;
    
    @FXML
    private Button remover_button;
    
   private static ArrayList<ItemPacote> ListaItens;

    @FXML
    void Tela_Principal(ActionEvent event) {
    	p = null;
    	ScreenManager.getInstance().showMenuPrincipal();
    }

    @FXML
    void adicionar_itens(ActionEvent event) {
    	PacoteController.setItem(new ItemPacote());
    	ScreenManager.getInstance().showItem();
    	if(p !=null) {
			ObservableList<ItemPacote> oListItens = FXCollections.observableArrayList(f.ListarItemdoPacote(p.getCodigo()));
    		lista_itens.setItems(oListItens);
		}
    }

    
    @FXML
    void novo(ActionEvent event) {
    	p = new Pacote();
    	desconto.clear();
		valor.clear();
		total_pagar.clear();
		n_adultos.clear();
		n_adultos.setDisable(true);
		n_criancas.clear();
		n_criancas.setDisable(true);
		codigo.setText("#");
		
		ListaItens = new ArrayList<ItemPacote>();

		
		ObservableList<ItemPacote> oListItens = FXCollections.observableArrayList(ListaItens);
		lista_itens.setItems(oListItens);
		
		adicionar_itens.setDisable(true);
		remover_button.setDisable(true);
    }

    @FXML
    void buscar(ActionEvent event) {
    	p = f.BuscarPacote(Integer.parseInt(Busca_pacote.getText()));
    	if(p != null) {

    		desconto.setText(Float.toString(p.getVl_desconto()));
    		valor.setText(Float.toString(p.getVl_total()));
    		total_pagar.setText(Float.toString(p.getTotal_a_pagar()));
    		if(p.getTipo() == 1) {
    			individual.setSelected(true);
    			n_adultos.clear();
        		n_criancas.clear();
    		}
    		if(p.getTipo() ==2 ) {
    			casal.setSelected(true);
    			n_adultos.clear();
        		n_criancas.clear();
    		}
    		if(p.getTipo()==3) {
    			grupo.setSelected(true);
    			n_adultos.setText(Integer.toString(p.getN_adultos()));
    			n_criancas.setText(Integer.toString(p.getN_criancas()));
    		}
    		dtinicio.setValue(p.getDatainicio());
    		dtfim.setValue(p.getDatafim());
    		codigo.setText(Integer.toString(PacoteController.p.getCodigo()));
    		    		
    		ObservableList<ItemPacote> oListItens = FXCollections.observableArrayList(this.f.ListarItemdoPacote(p.getCodigo()));
    		lista_itens.setItems(oListItens);
    		
    		adicionar_itens.setDisable(false);
    		
    		remover_button.setDisable(false);
    	}
    }
    
    public boolean verificarDados() {
    	LocalDate date = LocalDate.now();
    	if( dtfim.getValue() == null || dtinicio.getValue() == null 
    			|| total_pagar.getText() == null
    			||desconto.getText() == null
    			||valor.getText() == null) {
    		return false;
    	}
    	if(dtfim.getValue().compareTo(date) < 0 ||dtinicio.getValue().compareTo(date)<0 
    			|| (dtfim.getValue().compareTo(dtinicio.getValue()) < 0 )) {
    		return false;
    	}
    	if(grupo.isSelected()) {
    		if(n_adultos.getText() == null || n_criancas.getText() == null) {
    			return false;
    		}
    		if(Integer.parseInt(n_adultos.getText()) <0 || Integer.parseInt(n_criancas.getText()) < 0) {
    			return false;	
    		}	
    	}
    	if(Float.parseFloat(total_pagar.getText()) < 0
    			||Float.parseFloat(desconto.getText()) <0
    			||Float.parseFloat(valor.getText()) <0) {
    		return false;
    	}
    	
    	return true;
    }
    
    @FXML
    void salvar(ActionEvent event) {
    	try {
	    	p.setDatafim(dtfim.getValue());
	    	p.setDatainicio(dtinicio.getValue());
	    	p.setIndicadorReserva(0);
	    	if(individual.isSelected()) {
				p.setTipo(1);
				p.setN_adultos(null);
				p.setN_criancas(null);
			}
	    	else if(casal.isSelected()) {
				p.setTipo(2);
				p.setN_adultos(null);
				p.setN_criancas(null);
			}
	    	else if(grupo.isSelected()) {
				p.setTipo(3);
				p.setN_adultos(Integer.parseInt(n_adultos.getText()));
				p.setN_criancas(Integer.parseInt(n_criancas.getText()));	
			}
	    	p.setTotal_a_pagar(Float.parseFloat(total_pagar.getText()));
	    	p.setVl_desconto(Float.parseFloat(desconto.getText()));
	    	p.setVl_total(Float.parseFloat(valor.getText()));
	    	
	    	adicionar_itens.setDisable(false);
	    	if(this.verificarDados()) {
		    	if(p.getCodigo() != null) {
		    		f.AtualizarPacote(p);
		    	}
		    	else{
		    		f.CadastrarPacote(p);
		    		codigo.setText(Integer.toString(f.pegarcoddoultimoPacote()));
		    		p.setCodigo(f.pegarcoddoultimoPacote());
		    	}
		    }else {
		    	JOptionPane.showMessageDialog(null, "Informação Inválida!");
		    }
    	}
    	catch(Exception e) {
    		JOptionPane.showMessageDialog(null, "Informação Inválida!"+ e.getMessage());
    	}
    	
    }
    @FXML
    void mudar_total(KeyEvent event) {
    	float a;
    	float b;
    	if(!valor.getText().isEmpty()){
    		a =Float.parseFloat(valor.getText());
    	}else {
    		a = 0;
    	}
    	if(!desconto.getText().isEmpty()) {
        	b = Float.parseFloat(desconto.getText());
    	}else {
    		b=0;
    	}
        float c = a-b;
        total_pagar.setText(Float.toString(c));
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		f = Fachada.getInstance();
		
		ListaItens = new ArrayList<ItemPacote>();
		id_col.setCellValueFactory(
                new PropertyValueFactory<>("id_sk"));
		cod_servico_col.setCellValueFactory(
                new PropertyValueFactory<>("codservico"));
		data_col.setCellValueFactory(
                new PropertyValueFactory<>("dt"));
		valor_unit_col.setCellValueFactory(
                new PropertyValueFactory<>("vl_unitario"));
		qtd_col.setCellValueFactory(
                new PropertyValueFactory<>("qtd"));
		
		qtd_col.setCellFactory(TextFieldTableCell.<ItemPacote, Integer>forTableColumn(new IntegerStringConverter()));
		
		if(p !=null) {
			ObservableList<ItemPacote> oListItens = FXCollections.observableArrayList(f.ListarItemdoPacote(p.getCodigo()));
    		lista_itens.setItems(oListItens);
    		
		}else {
			p = new Pacote();
		}
		
	}
	
	 @FXML
	    void remover_pacote(ActionEvent event) {
		 f.RemoverPacote(p);
	    }
	
	@FXML
    void desabilita_pessoas(ActionEvent event) {
		n_criancas.setEditable(false);
		n_adultos.setEditable(false);
		n_criancas.setText("");
		n_adultos.setText("");
    }

    @FXML
    void entra_pessoas(ActionEvent event) {
    	n_criancas.setEditable(true);
		n_adultos.setEditable(true);
    }
    
    @FXML
    void Modificar_item(ActionEvent event) {
    	PacoteController.setItem(lista_itens.getSelectionModel().getSelectedItem());
    	ScreenManager.getInstance().showItem();
    	if(p !=null) {
			ObservableList<ItemPacote> oListItens = FXCollections.observableArrayList(f.ListarItemdoPacote(p.getCodigo()));
    		lista_itens.setItems(oListItens);
		}
    	
    }
    
    @FXML
    void selecionaitem(MouseEvent event) {
    	if(p !=null) {
			ObservableList<ItemPacote> oListItens = FXCollections.observableArrayList(f.ListarItemdoPacote(p.getCodigo()));
    		lista_itens.setItems(oListItens);
		}
    	PacoteController.setItem(lista_itens.getSelectionModel().getSelectedItem());
    	if(PacoteController.getItem()!=null) {
    		    	ScreenManager.getInstance().showItem();
    	}
    	if(p !=null) {
			ObservableList<ItemPacote> oListItens = FXCollections.observableArrayList(f.ListarItemdoPacote(p.getCodigo()));
    		lista_itens.setItems(oListItens);
		}
    }

	public static Pacote getPacote() {
		return p;
	}

	public static void setPacote(Pacote p) {
		PacoteController.p = p;
	}

	public static ItemPacote getItem() {
		return item;
	}

	public static void setItem(ItemPacote item) {
		PacoteController.item = item;
	}

}
