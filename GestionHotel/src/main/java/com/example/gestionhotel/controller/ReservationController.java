package com.example.gestionhotel.controller;

import com.example.gestionhotel.model.Reservation;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import com.example.gestionhotel.model.Reservation;
import java.time.LocalDate;

public class ReservationController {

    private ObservableList<Reservation> reservations = FXCollections.observableArrayList();

    @FXML
    private TextField clientIdField;
    @FXML
    private TextField roomIdField;
    @FXML
    private TextField checkInDateField;
    @FXML
    private TextField checkOutDateField;
    @FXML
    private TextField statusField;

    @FXML
    private TableView<Reservation> reservationTable;
    @FXML
    private TableColumn<Reservation, Integer> clientIdColumn;
    @FXML
    private TableColumn<Reservation, Integer> roomIdColumn;
    @FXML
    private TableColumn<Reservation, LocalDate> checkInDateColumn;
    @FXML
    private TableColumn<Reservation, LocalDate> checkOutDateColumn;
    @FXML
    private TableColumn<Reservation, String> statusColumn;

    @FXML
    private void initialize() {
        clientIdColumn.setCellValueFactory(cellData -> cellData.getValue().clientIdProperty().asObject());
        roomIdColumn.setCellValueFactory(cellData -> cellData.getValue().roomIdProperty().asObject());
        checkInDateColumn.setCellValueFactory(cellData -> cellData.getValue().checkInDateProperty());
        checkOutDateColumn.setCellValueFactory(cellData -> cellData.getValue().checkOutDateProperty());
        statusColumn.setCellValueFactory(cellData -> cellData.getValue().statusProperty());

        reservationTable.setItems(reservations);
    }

    @FXML
    private void handleAddReservation() {

        String clientId = clientIdField.getText();
        String roomId = roomIdField.getText();
        String checkInDate = checkInDateField.getText();
        String checkOutDate = checkOutDateField.getText();
        String status = statusField.getText();

        if (clientId.isEmpty() || roomId.isEmpty() || checkInDate.isEmpty() || checkOutDate.isEmpty() || status.isEmpty()) {
            System.out.println("Veuillez remplir tous les champs pour ajouter une réservation.");
            return;
        }

        Reservation newReservation = new Reservation(clientId, roomId, checkInDate, checkOutDate, status);
        reservations.add(newReservation);

        clearFields();
    }

    @FXML
    private void handleDeleteReservation() {
        Reservation selectedReservation = reservationTable.getSelectionModel().getSelectedItem();
        if (selectedReservation != null) {
            reservations.remove(selectedReservation);
        } else {
            System.out.println("Sélectionnez une réservation à supprimer.");
        }
    }

    private void clearFields() {
        clientIdField.clear();
        roomIdField.clear();
        checkInDateField.clear();
        checkOutDateField.clear();
        statusField.clear();
    }
}


