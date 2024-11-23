package br.com.fatec.controller;

import br.com.fatec.DAO.FornecedorDAO;
import br.com.fatec.model.Fornecedor;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

public class Cadastrar_FornecedorController implements Initializable {
    
    @FXML
    private TextField txt_nome_forn_cadforn;
    @FXML
    private TextField txt_nome_fan_cadforn;
    @FXML
    private TextField txt_cnpj_cadforn;
    @FXML
    private TextField txt_endereco_cadforn;
    @FXML
    private TextField txt_telefone_cadforn;
    @FXML
    private TextField txt_email_cadforn;
    @FXML
    private ImageView btn_pesquisa_cadforn;
    
    private FornecedorDAO dao;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        dao = new FornecedorDAO();
    }
    
    @FXML
    private void handleSalvar(ActionEvent event) {
        try {
            // Validar campos obrigatórios
            if (txt_nome_forn_cadforn.getText().isEmpty() ||
                txt_nome_fan_cadforn.getText().isEmpty() ||
                txt_cnpj_cadforn.getText().isEmpty() ||
                txt_endereco_cadforn.getText().isEmpty() ||
                txt_telefone_cadforn.getText().isEmpty()) {
                
                showAlert(Alert.AlertType.ERROR, 
                         "Erro ao Salvar", 
                         "Todos os campos obrigatórios devem ser preenchidos!");
                return;
            }
            
            // Criar objeto Fornecedor
            Fornecedor fornecedor = new Fornecedor(
                Long.parseLong(txt_cnpj_cadforn.getText()),
                txt_nome_forn_cadforn.getText(),
                txt_nome_fan_cadforn.getText(),
                txt_endereco_cadforn.getText(),
                Long.parseLong(txt_telefone_cadforn.getText()),
                txt_email_cadforn.getText()
            );
            
            // Verificar se já existe
            Fornecedor existente = dao.busca(fornecedor.getCnpj());
            if (existente == null) {
                dao.insere(fornecedor);
            } else {
                dao.altera(fornecedor);
            }
            
            limparCampos();
            showAlert(Alert.AlertType.INFORMATION, 
                     "Sucesso", 
                     "Fornecedor salvo com sucesso!");
            
        } catch (NumberFormatException e) {
            showAlert(Alert.AlertType.ERROR, 
                     "Erro de Formato", 
                     "CNPJ e Telefone devem conter apenas números!");
        } catch (SQLException e) {
            showAlert(Alert.AlertType.ERROR, 
                     "Erro ao Salvar", 
                     "Erro ao salvar fornecedor: " + e.getMessage());
        }
    }
    
    @FXML
    private void handleBuscar(ActionEvent event) {
        try {
            if (txt_cnpj_cadforn.getText().isEmpty()) {
                showAlert(Alert.AlertType.ERROR, 
                         "Erro na Busca", 
                         "Digite o CNPJ para buscar!");
                return;
            }
            
            long cnpj = Long.parseLong(txt_cnpj_cadforn.getText());
            Fornecedor fornecedor = dao.busca(cnpj);
            
            if (fornecedor != null) {
                preencherCampos(fornecedor);
            } else {
                showAlert(Alert.AlertType.INFORMATION, 
                         "Não Encontrado", 
                         "Fornecedor não encontrado!");
                limparCampos();
            }
            
        } catch (NumberFormatException e) {
            showAlert(Alert.AlertType.ERROR, 
                     "Erro de Formato", 
                     "CNPJ deve conter apenas números!");
        } catch (SQLException e) {
            showAlert(Alert.AlertType.ERROR, 
                     "Erro na Busca", 
                     "Erro ao buscar fornecedor: " + e.getMessage());
        }
    }
    
    @FXML
    private void handleExcluir(ActionEvent event) {
        try {
            if (txt_cnpj_cadforn.getText().isEmpty()) {
                showAlert(Alert.AlertType.ERROR, 
                         "Erro ao Excluir", 
                         "Digite o CNPJ para excluir!");
                return;
            }
            
            long cnpj = Long.parseLong(txt_cnpj_cadforn.getText());
            
            Alert confirmacao = new Alert(Alert.AlertType.CONFIRMATION,
                    "Deseja realmente excluir este fornecedor?",
                    ButtonType.YES, ButtonType.NO);
            confirmacao.showAndWait();
            
            if (confirmacao.getResult() == ButtonType.YES) {
                dao.exclui(cnpj);
                limparCampos();
                showAlert(Alert.AlertType.INFORMATION, 
                         "Sucesso", 
                         "Fornecedor excluído com sucesso!");
            }
            
        } catch (NumberFormatException e) {
            showAlert(Alert.AlertType.ERROR, 
                     "Erro de Formato", 
                     "CNPJ deve conter apenas números!");
        } catch (SQLException e) {
            showAlert(Alert.AlertType.ERROR, 
                     "Erro ao Excluir", 
                     "Erro ao excluir fornecedor: " + e.getMessage());
        }
    }
    
    private void preencherCampos(Fornecedor fornecedor) {
        txt_cnpj_cadforn.setText(String.valueOf(fornecedor.getCnpj()));
        txt_nome_forn_cadforn.setText(fornecedor.getNomeForn());
        txt_nome_fan_cadforn.setText(fornecedor.getNomeFan());
        txt_endereco_cadforn.setText(fornecedor.getEndereco());
        txt_telefone_cadforn.setText(String.valueOf(fornecedor.getTelefone()));
        txt_email_cadforn.setText(fornecedor.getEmail());
    }
    
    private void limparCampos() {
        txt_cnpj_cadforn.clear();
        txt_nome_forn_cadforn.clear();
        txt_nome_fan_cadforn.clear();
        txt_endereco_cadforn.clear();
        txt_telefone_cadforn.clear();
        txt_email_cadforn.clear();
    }
    
    private void showAlert(Alert.AlertType type, String title, String content) {
        Alert alert = new Alert(type, content, ButtonType.OK);
        alert.setTitle(title);
        alert.showAndWait();
    }
}