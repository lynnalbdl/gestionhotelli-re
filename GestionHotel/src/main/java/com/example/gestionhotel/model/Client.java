package com.example.gestionhotel.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Client {
    private final StringProperty name;
    private final StringProperty email;
    private final StringProperty phone;

    public Client(String name, String email, String phone) {
        this.name = new SimpleStringProperty(name);
        this.email = new SimpleStringProperty(email);
        this.phone = new SimpleStringProperty(phone);
    }

    public StringProperty nameProperty() {
        return name;
    }

    public StringProperty emailProperty() {
        return email;
    }

    public StringProperty phoneProperty() {
        return phone;
    }
}

