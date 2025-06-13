package com.praktikum.gui;

import com.praktikum.Data.DataStore;
import com.praktikum.Data.Item;
import com.praktikum.users.Mahasiswa;
import com.praktikum.users.User;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class AdminDashboard {
    private Stage stage;

    public AdminDashboard(Stage stage) {
        this.stage = stage;
    }

    public void show() {
        stage.setTitle("Hilang & Temukan Barang di Kampus");

        Label greeting = new Label("Halo, Administrator");

        TableView<Item> barangTable = new TableView<>(FXCollections.observableArrayList(DataStore.reportedItems));
        TableColumn<Item, String> namaCol = new TableColumn<>("Nama");
        namaCol.setCellValueFactory(cell -> cell.getValue().itemNameProperty());

        TableColumn<Item, String> lokasiCol = new TableColumn<>("Lokasi");
        lokasiCol.setCellValueFactory(cell -> cell.getValue().locationProperty());

        TableColumn<Item, String> statusCol = new TableColumn<>("Status");
        statusCol.setCellValueFactory(cell -> cell.getValue().statusProperty());

        barangTable.getColumns().addAll(namaCol, lokasiCol, statusCol);
        barangTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);


        ObservableList<Mahasiswa> mahasiswaList = FXCollections.observableArrayList();
        for (User user : DataStore.userList) {
            if (user instanceof Mahasiswa mhs) {
                mahasiswaList.add(mhs);
            }
        }

        TableView<Mahasiswa> mahasiswaTable = new TableView<>(mahasiswaList);
        TableColumn<Mahasiswa, String> namaMhsCol = new TableColumn<>("Nama");
        namaMhsCol.setCellValueFactory(cell -> new ReadOnlyStringWrapper(cell.getValue().getName()));

        TableColumn<Mahasiswa, String> nimCol = new TableColumn<>("NIM");
        nimCol.setCellValueFactory(cell -> new ReadOnlyStringWrapper(cell.getValue().getId()));

        mahasiswaTable.getColumns().addAll(namaMhsCol, nimCol);
        mahasiswaTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        TextField namaField = new TextField();
        namaField.setPromptText("Nama Mahasiswa");

        TextField nimField = new TextField();
        nimField.setPromptText("NIM");

        Button tambahBtn = new Button("Tambah");
        tambahBtn.setOnAction(e -> {
            String name = namaField.getText().trim();
            String nim = nimField.getText().trim();

            if (name.isEmpty() || nim.isEmpty()) {
                showAlert("Nama dan NIM tidak boleh kosong.");
                return;
            }

            Mahasiswa mhs = new Mahasiswa(name, nim); // username = nim, password = nim
            DataStore.userList.add(mhs);
            mahasiswaList.add(mhs);

            namaField.clear();
            nimField.clear();
        });

        HBox formMhs = new HBox(5, namaField, nimField, tambahBtn);

        Button tandaiBtn = new Button("Tandai Claimed");
        tandaiBtn.setOnAction(e -> {
            Item selected = barangTable.getSelectionModel().getSelectedItem();
            if (selected != null && !selected.getStatus().equals("Claimed")) {
                selected.setStatus("Claimed");
                barangTable.refresh();
            }
        });

        Button logout = new Button("Logout");
        logout.setOnAction(e -> {
            LoginPane loginPane = new LoginPane(stage);
            loginPane.showLoginScene();
        });

        // Layout
        VBox leftPane = new VBox(10, new Label("Laporan Barang"), barangTable, tandaiBtn);
        VBox rightPane = new VBox(10, new Label("Data Mahasiswa"), mahasiswaTable, formMhs);

        HBox mainPane = new HBox(20, leftPane, rightPane);
        VBox root = new VBox(10, greeting, mainPane, logout);
        root.setPadding(new Insets(15));

        stage.setScene(new Scene(root, 800, 500));
        stage.show();
    }

    private void showAlert(String msg) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Peringatan");
        alert.setHeaderText(null);
        alert.setContentText(msg);
        alert.showAndWait();
    }
}
