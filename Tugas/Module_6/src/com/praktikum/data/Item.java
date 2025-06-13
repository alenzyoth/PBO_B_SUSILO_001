package com.praktikum.Data;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Item {
    private final StringProperty itemName;
    private final StringProperty description;
    private final StringProperty location;
    private final StringProperty pelapor;    // Tambahkan atribut pelapor
    private final StringProperty status; // "Reported" atau "Claimed"

    public Item(String itemName, String description, String location, String pelapor) {
        this.itemName = new SimpleStringProperty(itemName);
        this.description = new SimpleStringProperty(description);
        this.location = new SimpleStringProperty(location);
        this.pelapor = new SimpleStringProperty(pelapor);
        this.status = new SimpleStringProperty("Reported");
    }

    public String getItemName() {
        return itemName.get();
    }

    public void setItemName(String itemName) {
        this.itemName.set(itemName);
    }

    public StringProperty itemNameProperty() {
        return itemName;
    }

    public String getDescription() {
        return description.get();
    }

    public void setDescription(String description) {
        this.description.set(description);
    }

    public StringProperty descriptionProperty() {
        return description;
    }

    // Getter dan setter untuk location
    public String getLocation() {
        return location.get();
    }

    public void setLocation(String location) {
        this.location.set(location);
    }

    public StringProperty locationProperty() {
        return location;
    }

    public String getPelapor() {
        return pelapor.get();
    }

    public void setPelapor(String pelapor) {
        this.pelapor.set(pelapor);
    }

    public StringProperty pelaporProperty() {
        return pelapor;
    }

    // Getter dan setter untuk status
    public String getStatus() {
        return status.get();
    }

    public void setStatus(String status) {
        this.status.set(status);
    }

    public StringProperty statusProperty() {
        return status;
    }
}
