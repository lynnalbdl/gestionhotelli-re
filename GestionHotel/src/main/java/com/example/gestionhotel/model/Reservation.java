package com.example.gestionhotel.model;

import javafx.beans.property.*;
import java.time.LocalDate;

public class Reservation {
    private final IntegerProperty clientId;
    private final IntegerProperty roomId;
    private final ObjectProperty<LocalDate> checkInDate;
    private final ObjectProperty<LocalDate> checkOutDate;
    private final StringProperty status;

    public Reservation(String clientId, String roomId, String checkInDate, String checkOutDate, String status) {
        this.clientId = new SimpleIntegerProperty();
        this.roomId = new SimpleIntegerProperty();
        this.checkInDate = new SimpleObjectProperty<>();
        this.checkOutDate = new SimpleObjectProperty<>();
        this.status = new SimpleStringProperty(status);
    }

    public int getClientId() {
        return clientId.get();
    }

    public IntegerProperty clientIdProperty() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId.set(clientId);
    }

    public int getRoomId() {
        return roomId.get();
    }

    public IntegerProperty roomIdProperty() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId.set(roomId);
    }

    public LocalDate getCheckInDate() {
        return checkInDate.get();
    }

    public ObjectProperty<LocalDate> checkInDateProperty() {
        return checkInDate;
    }

    public void setCheckInDate(LocalDate checkInDate) {
        this.checkInDate.set(checkInDate);
    }

    public LocalDate getCheckOutDate() {
        return checkOutDate.get();
    }

    public ObjectProperty<LocalDate> checkOutDateProperty() {
        return checkOutDate;
    }

    public void setCheckOutDate(LocalDate checkOutDate) {
        this.checkOutDate.set(checkOutDate);
    }

    public String getStatus() {
        return status.get();
    }

    public StringProperty statusProperty() {
        return status;
    }

    public void setStatus(String status) {
        this.status.set(status);
    }
}

