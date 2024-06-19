package com.example.gestionhotel.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MainMenuController {

    private boolean loggedIn = false;

    public void login() {
        loggedIn = true;
        redirectToReservationManagement();
    }

    public void logout() {
        loggedIn = false;
        redirectToLogin();
    }

    private void redirectToReservationManagement() {
        if (loggedIn) {
            try {
                Parent root = FXMLLoader.load(getClass().getResource("/com/example/gestionhotel/reservationmanagement-view.fxml"));
                Stage stage = new Stage();
                stage.setTitle("Gestion des réservations");
                stage.setScene(new Scene(root));
                stage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            redirectToLogin();
        }
    }

    private void redirectToLogin() {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("com/example/gestionhotel/registration.fxml"));
            Stage stage = new Stage();
            stage.setTitle("S'inscrire/Se connecter");
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void showRoomManagement() {
    }

    @FXML
    private void showReservationManagement() {
        redirectToReservationManagement();
    }

    @FXML
    private void showClientManagement() {
    }
}



