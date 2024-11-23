/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package br.com.fatec.controller;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import java.io.IOException;

public class Menu_AlmoxarifadoController implements Initializable {
    @FXML
    private Button btnSair;

    @FXML
    private Button btncadastrar_Fornecedor;

    @FXML
    private Button btncadastrar_Equipamento;

    @FXML
    private Button btnbaixa_Retirada_Equipamentos;


    @FXML
    private Button btndevolutiva_Equipamento;

    @FXML
    private Button btnconsultar_Equipamentos;
    @FXML
    private Button btncadastrar_Reserva;

    @FXML
    void sair(ActionEvent event) {
        // Fecha a aplicação
        Stage stage = (Stage) btnSair.getScene().getWindow();
        stage.close();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Inicialização, se necessário
    }

    @FXML
    private void carregarTela(ActionEvent event) {
        String[] split = event.getSource().toString().split("id=btn");

        String form = split[1]; //Formulário a abrir

        split = form.split(",");
        form = split[0];
        
        String diretorio = "/br/com/fatec/view/";
        
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(diretorio + form + ".fxml"));
            Parent root = loader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            mostrarAlerta("Erro ao carregar a tela", e.getMessage());
        }
    }

    private void mostrarAlerta(String titulo, String mensagem) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(titulo);
        alert.setContentText(mensagem);
        alert.showAndWait();
    }

}
