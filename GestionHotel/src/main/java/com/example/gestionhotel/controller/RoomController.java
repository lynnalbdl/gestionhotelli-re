package com.example.gestionhotel.controller;

import com.example.gestionhotel.model.Room;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class RoomController {

    @FXML
    private TextField roomNumberField;
    @FXML
    private TextField typeField;
    @FXML
    private TextField priceField;

    @FXML
    private TableView<Room> roomTable;
    @FXML
    private TableColumn<Room, Integer> roomNumberColumn;
    @FXML
    private TableColumn<Room, String> typeColumn;
    @FXML
    private TableColumn<Room, Double> priceColumn;

    private ObservableList<Room> rooms = FXCollections.observableArrayList();

    @FXML
    private void initialize() {
        roomNumberColumn.setCellValueFactory(cellData -> cellData.getValue().roomNumberProperty().asObject());
        typeColumn.setCellValueFactory(cellData -> cellData.getValue().typeProperty());
        priceColumn.setCellValueFactory(cellData -> cellData.getValue().priceProperty().asObject());

        // Assignation de la liste observable à la TableView
        roomTable.setItems(rooms);
    }

    @FXML
    private void handleAddRoom() {
        String roomNumber = roomNumberField.getText();
        String type = typeField.getText();
        String price = priceField.getText();

        if (roomNumber.isEmpty() || type.isEmpty() || price.isEmpty()) {
            System.out.println("Veuillez remplir tous les champs pour ajouter une chambre.");
            return;
        }

        Room newRoom = new Room(roomNumber, type, price);
        rooms.add(newRoom);

        // Effacer les champs après l'ajout
        clearFields();
    }

    @FXML
    private void handleDeleteRoom() {
        // Récupération de l'élément sélectionné dans la TableView
        Room selectedRoom = roomTable.getSelectionModel().getSelectedItem();
        if (selectedRoom != null) {
            // Suppression de la chambre sélectionnée de la liste observable
            rooms.remove(selectedRoom);
        } else {
            System.out.println("Sélectionnez une chambre à supprimer.");
        }
    }

    // Méthode pour effacer les champs après l'ajout d'une chambre
    private void clearFields() {
        roomNumberField.clear();
        typeField.clear();
        priceField.clear();
    }
}


