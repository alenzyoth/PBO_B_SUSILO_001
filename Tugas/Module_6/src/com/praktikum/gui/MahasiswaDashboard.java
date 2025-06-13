package com.praktikum.gui;

import com.praktikum.Data.DataStore;
import com.praktikum.Data.Item;
import com.praktikum.users.Mahasiswa;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MahasiswaDashboard {

    private final Stage stage;
    private final Mahasiswa mahasiswa;
    private final ObservableList<Item> mahasiswaItems = FXCollections.observableArrayList();

    public MahasiswaDashboard(Stage stage, Mahasiswa mahasiswa) {
        this.stage = stage;
        this.mahasiswa = mahasiswa;

        for (Item item : DataStore.reportedItems) {
            if (item.getPelapor().equals(mahasiswa.getName())) {
                mahasiswaItems.add(item);
            }
        }
    }

    public void show() {
        stage.setTitle("Lost & Found Kampus - Mahasiswa");

        Label welcome = new Label("Selamat datang, " + mahasiswa.getName());

        TextField itemNameField = new TextField();
        itemNameField.setPromptText("Nama Barang");

        TextField descField = new TextField();
        descField.setPromptText("Deskripsi");

        TextField locField = new TextField();
        locField.setPromptText("Lokasi");

        Button reportButton = new Button("Laporkan");

        TableView<Item> table = new TableView<>(mahasiswaItems);

        TableColumn<Item, String> nameCol = new TableColumn<>("Nama");
        nameCol.setCellValueFactory(cell -> new ReadOnlyStringWrapper(cell.getValue().getItemName()));

        TableColumn<Item, String> locCol = new TableColumn<>("Lokasi");
        locCol.setCellValueFactory(cell -> new ReadOnlyStringWrapper(cell.getValue().getLocation()));

        table.getColumns().addAll(nameCol, locCol);
        table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        reportButton.setOnAction(e -> {
            String itemName = itemNameField.getText().trim();
            String desc = descField.getText().trim();
            String loc = locField.getText().trim();

            if (itemName.isEmpty() || loc.isEmpty()) {
                showAlert("Nama dan lokasi barang wajib diisi.");
                return;
            }

            Item item = new Item(itemName, desc, loc, mahasiswa.getName());
            DataStore.reportedItems.add(item);
            mahasiswaItems.add(item);

            itemNameField.clear();
            descField.clear();
            locField.clear();
        });

        Button logout = new Button("Logout");
        logout.setOnAction(e -> {
            LoginPane loginPane = new LoginPane(stage);
            loginPane.showLoginScene();
        });

        HBox form = new HBox(5, itemNameField, descField, locField, reportButton);
        VBox layout = new VBox(10, welcome, form, new Label("Daftar Barang yang Anda Laporkan"), table, logout);
        layout.setPadding(new Insets(15));

        stage.setScene(new Scene(layout, 500, 400));
        stage.show();
    }

    private void showAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Peringatan");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
