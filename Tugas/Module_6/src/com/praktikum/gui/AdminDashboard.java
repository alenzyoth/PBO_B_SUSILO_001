package com.praktikum.gui;

import com.praktikum.data.DataStore;
import com.praktikum.data.Item;
import com.praktikum.users.Admin;
import com.praktikum.users.Mahasiswa;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class AdminDashboard {
    public AdminDashboard(Stage stage, Admin admin) {
        Label greeting = new Label("Halo, Administrator " + admin.getNama());

        TableView<Item> laporanTable = new TableView<>(FXCollections.observableArrayList(DataStore.itemList));
        TableColumn<Item, String> namaCol = new TableColumn<>("Nama");
        TableColumn<Item, String> lokasiCol = new TableColumn<>("Lokasi");
        TableColumn<Item, String> statusCol = new TableColumn<>("Status");

        namaCol.setCellValueFactory(d -> new SimpleStringProperty(d.getValue().getNama()));
        lokasiCol.setCellValueFactory(d -> new SimpleStringProperty(d.getValue().getLokasi()));
        statusCol.setCellValueFactory(d -> new SimpleStringProperty(d.getValue().getStatus()));

        laporanTable.getColumns().addAll(namaCol, lokasiCol, statusCol);

        Button tandaiBtn = new Button("Tandai Claimed");
        tandaiBtn.setOnAction(e -> {
            Item selected = laporanTable.getSelectionModel().getSelectedItem();
            if (selected != null) {
                selected.setStatus("Claimed");
                laporanTable.refresh();
            }
        });

        TableView<Mahasiswa> mhsTable = new TableView<>(FXCollections.observableArrayList(DataStore.mahasiswaList));
        TableColumn<Mahasiswa, String> namaMhsCol = new TableColumn<>("Nama");
        TableColumn<Mahasiswa, String> nimCol = new TableColumn<>("NIM");
        namaMhsCol.setCellValueFactory(m -> new SimpleStringProperty(m.getValue().getNama()));
        nimCol.setCellValueFactory(m -> new SimpleStringProperty(m.getValue().getNim()));
        mhsTable.getColumns().addAll(namaMhsCol, nimCol);

        Button logoutBtn = new Button("Logout");
        logoutBtn.setOnAction(e -> {
            stage.setScene(new Scene(new LoginPane(stage), 400, 250));
        });

        HBox mainBox = new HBox(10, laporanTable, mhsTable);
        VBox vbox = new VBox(10, greeting, mainBox, tandaiBtn, logoutBtn);
        vbox.setPadding(new Insets(10));

        stage.setScene(new Scene(vbox, 700, 400));
        stage.setTitle("Lost & Found Kampus");
    }
}
