package com.praktikum.gui;

import com.praktikum.data.DataStore;
import com.praktikum.data.Item;
import com.praktikum.users.Admin;
import com.praktikum.users.Mahasiswa;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
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

        TableView<Mahasiswa> mhsTable = new TableView<>(FXCollections.observableArrayList(DataStore.mahasiswaList));
        TableColumn<Mahasiswa, String> namaMhsCol = new TableColumn<>("Nama");
        TableColumn<Mahasiswa, String> nimCol = new TableColumn<>("NIM");
        namaMhsCol.setCellValueFactory(m -> new SimpleStringProperty(m.getValue().getNama()));
        nimCol.setCellValueFactory(m -> new SimpleStringProperty(m.getValue().getNim()));
        mhsTable.getColumns().addAll(namaMhsCol, nimCol);

        // Left side - Search button that opens popup
        Button searchBtn = new Button("Cari");
        searchBtn.setOnAction(e -> showSearchPopup(stage, laporanTable, mhsTable));

        VBox leftControls = new VBox(10);
        leftControls.getChildren().addAll(
                new Label("Pencarian:"),
                searchBtn
        );
        leftControls.setAlignment(Pos.TOP_LEFT);

        // Right side - Action buttons
        Button tandaiBtn = new Button("Tandai Claimed");
        tandaiBtn.setOnAction(e -> {
            Item selected = laporanTable.getSelectionModel().getSelectedItem();
            if (selected != null) {
                selected.setStatus("Claimed");
                laporanTable.refresh();
            }
        });

        Button logoutBtn = new Button("Logout");
        logoutBtn.setOnAction(e -> {
            stage.setScene(new Scene(new LoginPane(stage), 400, 250));
        });

        VBox rightControls = new VBox(10);
        rightControls.getChildren().addAll(tandaiBtn, logoutBtn);
        rightControls.setAlignment(Pos.TOP_RIGHT);

        // Main table area
        HBox tablesBox = new HBox(10, laporanTable, mhsTable);

        // Bottom section with controls on left and right
        HBox controlsBox = new HBox();
        controlsBox.getChildren().addAll(leftControls, rightControls);
        HBox.setHgrow(leftControls, Priority.NEVER);
        HBox.setHgrow(rightControls, Priority.ALWAYS);
        rightControls.setMaxWidth(Double.MAX_VALUE);

        VBox vbox = new VBox(10, greeting, tablesBox, controlsBox);
        vbox.setPadding(new Insets(10));

        stage.setScene(new Scene(vbox, 700, 400));
        stage.setTitle("Lost & Found Kampus");
    }

    private void showSearchPopup(Stage parentStage, TableView<Item> itemTable, TableView<Mahasiswa> mahasiswaTable) {
        Stage popupStage = new Stage();
        popupStage.setTitle("Pencarian");
        popupStage.initOwner(parentStage);

        // Create popup content
        Label popupLabel = new Label("Masukkan kata kunci pencarian:");
        TextField searchField = new TextField();
        searchField.setPromptText("Cari item atau mahasiswa...");
        searchField.setPrefWidth(250);

        Button confirmBtn = new Button("Cari");
        Button cancelBtn = new Button("Batal");

        confirmBtn.setOnAction(e -> {
            String searchText = searchField.getText().toLowerCase().trim();
            if (!searchText.isEmpty()) {
                performSearch(searchText, itemTable, mahasiswaTable);
            }
            popupStage.close();
        });

        cancelBtn.setOnAction(e -> popupStage.close());

        // Layout for popup
        HBox buttonBox = new HBox(10, confirmBtn, cancelBtn);
        buttonBox.setAlignment(Pos.CENTER);

        VBox popupLayout = new VBox(15);
        popupLayout.getChildren().addAll(popupLabel, searchField, buttonBox);
        popupLayout.setPadding(new Insets(20));
        popupLayout.setAlignment(Pos.CENTER);

        Scene popupScene = new Scene(popupLayout, 300, 150);
        popupStage.setScene(popupScene);
        popupStage.setResizable(false);
        popupStage.show();

        // Focus on text field
        searchField.requestFocus();
    }

    private void performSearch(String searchText, TableView<Item> itemTable, TableView<Mahasiswa> mahasiswaTable) {
        // Filter items
        var filteredItems = DataStore.itemList.stream()
                .filter(item -> item.getNama().toLowerCase().contains(searchText) ||
                        item.getLokasi().toLowerCase().contains(searchText) ||
                        item.getStatus().toLowerCase().contains(searchText))
                .collect(java.util.stream.Collectors.toList());

        // Filter mahasiswa
        var filteredMahasiswa = DataStore.mahasiswaList.stream()
                .filter(mhs -> mhs.getNama().toLowerCase().contains(searchText) ||
                        mhs.getNim().toLowerCase().contains(searchText))
                .collect(java.util.stream.Collectors.toList());

        // Update tables
        itemTable.setItems(FXCollections.observableArrayList(filteredItems));
        mahasiswaTable.setItems(FXCollections.observableArrayList(filteredMahasiswa));

        // Show result message
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Hasil Pencarian");
        alert.setHeaderText("Pencarian untuk: \"" + searchText + "\"");
        alert.setContentText("Ditemukan " + filteredItems.size() + " item dan " +
                filteredMahasiswa.size() + " mahasiswa");
        alert.showAndWait();
    }
}