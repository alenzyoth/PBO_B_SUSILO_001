package com.praktikum.gui;

import com.praktikum.data.DataStore;
import com.praktikum.main.LoginSystem;
import com.praktikum.users.Admin;
import com.praktikum.users.Mahasiswa;
import com.praktikum.users.User;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class LoginPane extends VBox {
    public LoginPane(Stage stage) {
        setSpacing(10);
        setPadding(new Insets(20));
        setAlignment(Pos.CENTER);

        Label title = new Label("Login Sistem Lost & Found");

        ComboBox<String> roleBox = new ComboBox<>();
        roleBox.getItems().addAll("Mahasiswa", "Admin");
        roleBox.setValue("Mahasiswa");

        TextField namaField = new TextField();
        namaField.setPromptText("Nama");

        PasswordField pwField = new PasswordField();
        pwField.setPromptText("Password / NIM");

        Label statusLabel = new Label();

        Button loginBtn = new Button("Login");
        loginBtn.setOnAction(e -> {
            String role = roleBox.getValue();
            String nama = namaField.getText();
            String pass = pwField.getText();

            User user = LoginSystem.login(role, nama, pass);
            if (user != null) {
                if (user instanceof Admin) {
                    new AdminDashboard(stage, (Admin) user);
                } else if (user instanceof Mahasiswa) {
                    new MahasiswaDashboard(stage, (Mahasiswa) user);
                }
            } else {
                statusLabel.setText("Login gagal, periksa kredensial.");
            }
        });

        getChildren().addAll(title, roleBox, namaField, pwField, loginBtn, statusLabel);
    }
}
