package com.praktikum.gui;

import com.praktikum.data.DataStore;
import com.praktikum.data.Item;
import com.praktikum.users.Mahasiswa;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class MahasiswaDashboard {
    public MahasiswaDashboard(Stage stage, Mahasiswa mhs) {
        Label welcome = new Label("Selamat datang, " + mhs.getNama());
        TextField namaBarang = new TextField();
        namaBarang.setPromptText("Nama Barang");

        TextField lokasi = new TextField();
        lokasi.setPromptText("Lokasi");

        Button laporBtn = new Button("Laporkan");

        TableView<Item> table = new TableView<>();
        TableColumn<Item, String> namaCol = new TableColumn<>("Nama");
        namaCol.setCellValueFactory(data -> new javafx.beans.property.SimpleStringProperty(data.getValue().getNama()));

        TableColumn<Item, String> lokasiCol = new TableColumn<>("Lokasi");
        lokasiCol.setCellValueFactory(data -> new javafx.beans.property.SimpleStringProperty(data.getValue().getLokasi()));

        TableColumn<Item, String> statusCol = new TableColumn<>("Status");
        statusCol.setCellValueFactory(data -> new javafx.beans.property.SimpleStringProperty(data.getValue().getStatus()));

        table.getColumns().addAll(namaCol, lokasiCol, statusCol);
        table.setItems(FXCollections.observableArrayList(mhs.getLaporanSaya()));

        laporBtn.setOnAction(e -> {
            String nama = namaBarang.getText();
            String loc = lokasi.getText();
            if (!nama.isEmpty() && !loc.isEmpty()) {
                Item item = new Item(nama, loc, mhs.getNama());
                item.setStatus("Not Claimed"); // Set initial status
                mhs.tambahLaporan(item);
                DataStore.itemList.add(item);
                table.getItems().add(item);
                namaBarang.clear();
                lokasi.clear();
            }
        });

        Button logoutBtn = new Button("Logout");
        logoutBtn.setOnAction(e -> {
            LoginPane loginPane = new LoginPane(stage);
            stage.setScene(new Scene(loginPane, 400, 250));
        });

        VBox vbox = new VBox(10, welcome, namaBarang, lokasi, laporBtn, table, logoutBtn);
        vbox.setPadding(new Insets(15));

        stage.setScene(new Scene(vbox, 600, 400));
        stage.setTitle("Lost & Found Kampus");
    }
}