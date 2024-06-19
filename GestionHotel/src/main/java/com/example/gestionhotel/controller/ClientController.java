package com.example.gestionhotel.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import com.example.gestionhotel.model.Client;

public class ClientController {

    @FXML
    private TextField nameField;
    @FXML
    private TextField emailField;
    @FXML
    private TextField phoneField;

    @FXML
    private TableView<Client> clientTable;
    @FXML
    private TableColumn<Client, String> nameColumn;
    @FXML
    private TableColumn<Client, String> emailColumn;
    @FXML
    private TableColumn<Client, String> phoneColumn;

    @FXML
    private void handleAddClient() {
        String name = nameField.getText().trim();
        String email = emailField.getText().trim();
        String phone = phoneField.getText().trim();

        if (name.isEmpty() || email.isEmpty() || phone.isEmpty()) {
            System.out.println("Veuillez remplir tous les champs obligatoires.");
            return;
        }

        try {
            clearFields();
        } catch (Exception e) {
            System.out.println("Erreur lors de l'ajout du client : " + e.getMessage());
            e.printStackTrace();
        }
    }

    @FXML
    private void initialize() {
        // Initialisation des colonnes
        nameColumn.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
        emailColumn.setCellValueFactory(cellData -> cellData.getValue().emailProperty());
        phoneColumn.setCellValueFactory(cellData -> cellData.getValue().phoneProperty());

        loadClientData();
    }

    private void loadClientData() {
        ObservableList<Client> clientList = FXCollections.observableArrayList(
                new Client("John Doe", "john.doe@example.com", "123456789"),
                new Client("Jane Smith", "jane.smith@example.com", "987654321")
        );
        clientTable.setItems(clientList);
    }

    private void clearFields() {
        nameField.clear();
        emailField.clear();
        phoneField.clear();
    }
}


