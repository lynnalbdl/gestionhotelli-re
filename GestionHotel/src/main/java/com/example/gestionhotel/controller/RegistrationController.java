package com.example.gestionhotel.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class RegistrationController {

    @FXML
    private TextField usernameTextField;
    @FXML
    private TextField emailTextField;
    @FXML
    private PasswordField passwordField;
    @FXML
    private PasswordField confirmPasswordField;
    @FXML
    private Button backToLoginButton;

    @FXML
    private void handleBackToLogin(ActionEvent event) {
        if (userExists()) {
            redirectToLogin();
        } else {
            System.out.println("Utilisateur non enregistré. Veuillez remplir tous les champs pour vous inscrire.");
        }
    }

    // Méthode pour vérifier si l'utilisateur est déjà enregistré (simulation)
    private boolean userExists() {
        // Ici, vous devriez mettre en place la logique réelle pour vérifier si l'utilisateur existe déjà
        // Ceci est une simulation basique
        String username = usernameTextField.getText();
        String email = emailTextField.getText();
        String password = passwordField.getText();
        String confirmPassword = confirmPasswordField.getText();

        // Vérifie si tous les champs nécessaires sont remplis pour simuler l'enregistrement
        return !username.isEmpty() && !email.isEmpty() && !password.isEmpty() && !confirmPassword.isEmpty();
    }

    private void redirectToLogin() {
        Stage stage = (Stage) backToLoginButton.getScene().getWindow();
        stage.close();
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/path/to/Login.fxml"));
            Stage loginStage = new Stage();
            loginStage.setTitle("Connexion");
            loginStage.setScene(new Scene(root));
            loginStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    // Méthode appelée lorsque l'utilisateur clique sur le bouton "S'inscrire"
    @FXML
    private void handleRegistration(ActionEvent event) {
        // Implémentez ici la logique d'inscription réelle
        // Vous pouvez ajouter la validation des champs avant d'enregistrer l'utilisateur
        // Par exemple, vérifiez si les champs sont non vides et si les mots de passe correspondent
        String username = usernameTextField.getText();
        String email = emailTextField.getText();
        String password = passwordField.getText();
        String confirmPassword = confirmPasswordField.getText();

        // Exemple de validation basique (à adapter selon vos besoins)
        if (username.isEmpty() || email.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
            System.out.println("Veuillez remplir tous les champs.");
            return;
        }

        if (!password.equals(confirmPassword)) {
            System.out.println("Les mots de passe ne correspondent pas.");
            return;
        }

        // Si la validation réussit, vous pouvez enregistrer l'utilisateur dans votre système
        System.out.println("Utilisateur enregistré avec succès.");
    }
}
