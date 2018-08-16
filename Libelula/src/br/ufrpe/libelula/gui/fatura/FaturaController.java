package br.ufrpe.libelula.gui.fatura;

import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;


import br.ufrpe.libelula.gui.ScreenManager;
import br.ufrpe.libelula.gui.pacote.PacoteController;
import br.ufrpe.libelula.negocio.beans.Fatura;
import br.ufrpe.libelula.negocio.beans.ItemPacote;
import br.ufrpe.libelula.negocio.beans.Pagamento;
import br.ufrpe.libelula.negocio.gerenciamento.Fachada;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
public class FaturaController implements Initializable{

    private  Fachada f;

    private static Fatura fat;

    private static Pagamento pag;


    @FXML
    private TextField Busca_pagamento;

    @FXML
    private  TableView<Pagamento> lista_pagamento;

    @FXML
    private TextField codpacote;

    @FXML
    private DatePicker dt_fatura;

    @FXML
    private TextField id;

    @FXML
    private TextField status;

    @FXML
    private Button adicionar_itens;

    @FXML
    private TableColumn<Pagamento, Integer> id_col;

    @FXML
    private TableColumn<Pagamento, Integer> cod_pacote_col;

    @FXML
    private TableColumn<Pagamento, LocalDate> data_col;

    @FXML
    private TableColumn<Pagamento, Integer> status_col;

    @FXML
    private Button remover_button;

   private static ArrayList<Pagamento> ListaPagamento;

    @FXML
    void Tela_Principal(ActionEvent event) {
        f = null;
        ScreenManager.getInstance().showMenuPrincipal();
    }

    @FXML
    void adicionar_itens(ActionEvent event) {
        FaturaController.setPagamento(new Pagamento());
        ScreenManager.getInstance().showItem();
        if(fat !=null) {
            ObservableList<Pagamento> oListPaga = FXCollections.observableArrayList(f.ListarPagamento());
            (lista_pagamento).setItems(oListPaga);
        }
    }


    @FXML
    void novo(ActionEvent event) {
        pag = new Pagamento();
        codpacote.clear();
        id.clear();
        status.clear();
        ListaPagamento = new ArrayList<Pagamento>();


        ObservableList<Pagamento> oListItens = FXCollections.observableArrayList(ListaPagamento);
        lista_pagamento.setItems(oListItens);

        adicionar_itens.setDisable(true);
        remover_button.setDisable(true);
    }

    @FXML
    void buscar(ActionEvent event) {
        pag = f.BuscarPagamento(Integer.parseInt(Busca_pagamento.getText()));
        if(fat != null) {
        	codpacote.setText(Float.toString(fat.getCodpacote()));
            id.setText(Float.toString(fat.getId()));
            status.setText(Float.toString(fat.getStatus()));

            dt_fatura.setValue(fat.getDt_fatura());

            ObservableList<Pagamento> oListItens = FXCollections.observableArrayList(this.f.ListarPagamento());
            lista_pagamento.setItems(oListItens);

            adicionar_itens.setDisable(false);

            remover_button.setDisable(false);
        }
    }

    public boolean verificarDados() {
        LocalDate date = LocalDate.now();
        if( dt_fatura.getValue() == null ||codpacote.getText() == null
                ||id.getText() == null
                ||status.getText() == null) {
            return false;
        }
        if(dt_fatura.getValue().compareTo(date) < 0 || dt_fatura.getValue().compareTo(date)<0
                || (dt_fatura.getValue().compareTo(dt_fatura.getValue()) < 0 )) {
            return false;
        }
        return true;
    }

    @FXML
    void salvar(ActionEvent event) {
        try {
            fat.setDt_fatura(dt_fatura.getValue());
            fat.setCodpacote(Integer.parseInt(codpacote.getText()));
            fat.setId(0);
            fat.setStatus(Integer.parseInt(status.getText()));
                       adicionar_itens.setDisable(false);
            if(this.verificarDados()) {
                if(pag.getCodigo() != 0) {
                    f.AtualizarPagamento(pag);
                }
                else{
                    f.CadastrarPagamento(pag);
                    codpacote.setText(Integer.toString(f.pegarcoddoultimoPacote()));
                    fat.setCodpacote(f.pegarcoddoultimoPacote());
                }
            }else {
                JOptionPane.showMessageDialog(null, "Informa��o Inv�lida!");
            }
        }
        catch(Exception e) {
            JOptionPane.showMessageDialog(null, "Informa��o Inv�lida!"+ e.getMessage());
        }

    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        f = Fachada.getInstance();

        ListaPagamento = new ArrayList<Pagamento>();
        id_col.setCellValueFactory(
                new PropertyValueFactory<>("id_sk"));
        cod_pacote_col.setCellValueFactory(
                new PropertyValueFactory<>("codpacote"));
        data_col.setCellValueFactory(
                new PropertyValueFactory<>("dt"));
        status_col.setCellValueFactory(
                new PropertyValueFactory<>("status"));
        if(fat !=null) {
            ObservableList<Pagamento> oListItens = FXCollections.observableArrayList(f.ListarPagamento());
            lista_pagamento.setItems(oListItens);

        }else {
            fat = new Fatura();
        }

    }

     @FXML
        void remover_pagamento(ActionEvent event) {
         f.RemoverPagamento(pag);
        }



    @FXML
    void Modificar_item(ActionEvent event) {
        FaturaController.setPagamento(lista_pagamento.getSelectionModel().getSelectedItem());
        ScreenManager.getInstance().showItem();
        if(fat !=null) {
            ObservableList<Pagamento> oListItens = FXCollections.observableArrayList(f.ListarPagamento());
            lista_pagamento.setItems(oListItens);
        }

    }

	@FXML
    void selecionaPagamento(MouseEvent event) {
        if(fat !=null) {
            ObservableList<Pagamento> oListItens = FXCollections.observableArrayList(f.ListarPagamento());
            lista_pagamento.setItems(oListItens);
        }
        FaturaController.setPagamento(lista_pagamento.getSelectionModel().getSelectedItem());
        if(PacoteController.getItem()!=null) {
                    ScreenManager.getInstance().showItem();
        }
        if(fat !=null) {
            ObservableList<Pagamento> oListItens = FXCollections.observableArrayList(f.ListarPagamento());
            lista_pagamento.setItems(oListItens);
        }
    }

    public static Pagamento getPagamento() {
        return pag;
    }

    public static void setPagamento(Pagamento p) {
        FaturaController.pag = p;
    }

    public static Fatura getFatura(){
    	return fat;
    }

}
