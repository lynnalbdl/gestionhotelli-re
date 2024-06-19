package com.example.gestionhotel.model;

import javafx.beans.property.*;

public class Room {
    private final IntegerProperty roomNumber;
    private final StringProperty type;
    private final DoubleProperty price;

    public Room(String roomNumber, String type, String price) {
        this.roomNumber = new SimpleIntegerProperty();
        this.type = new SimpleStringProperty(type);
        this.price = new SimpleDoubleProperty();
    }


    public int getRoomNumber() {
        return roomNumber.get();
    }

    public IntegerProperty roomNumberProperty() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber.set(roomNumber);
    }

    public String getType() {
        return type.get();
    }

    public StringProperty typeProperty() {
        return type;
    }

    public void setType(String type) {
        this.type.set(type);
    }

    public double getPrice() {
        return price.get();
    }

    public DoubleProperty priceProperty() {
        return price;
    }

    public void setPrice(double price) {
        this.price.set(price);
    }
}

