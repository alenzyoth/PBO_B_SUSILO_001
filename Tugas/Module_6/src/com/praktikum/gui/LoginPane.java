package com.praktikum.gui;

import com.praktikum.Data.DataStore;
import com.praktikum.users.*;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class LoginPane extends VBox {
    private Stage stage;

    public LoginPane(Stage stage) {
        this.stage = stage;
        showLoginScene();
    }

    public void showLoginScene() {
        Label titleLabel = new Label("Login Sistem Lost & Found");

        ComboBox<String> roleBox = new ComboBox<>();
        roleBox.getItems().addAll("Admin", "Mahasiswa");
        roleBox.setValue("Mahasiswa");

        TextField usernameField = new TextField();
        usernameField.setPromptText("Nama / Username");

        PasswordField passwordField = new PasswordField();
        passwordField.setPromptText("NIM / Password");

        Button loginButton = new Button("Login");
        Label messageLabel = new Label();

        loginButton.setOnAction(e -> {
            String role = roleBox.getValue();
            String user = usernameField.getText();
            String pass = passwordField.getText();

            boolean success = false;
            for (User u : DataStore.getUserList()) {
                if ((role.equals("Admin") && u instanceof Admin) || (role.equals("Mahasiswa") && u instanceof Mahasiswa)) {
                    if (u.login(user, pass)) {
                        u.displayInfo();
                        if (u instanceof Admin) {
                            new AdminDashboard(stage).show();
                        } else {
                            new MahasiswaDashboard(stage, (Mahasiswa) u).show();
                        }
                        success = true;
                        break;
                    }
                }
            }
            if (!success) {
                messageLabel.setText("Login gagal, periksa kredensial.");
            }
        });

        VBox layout = new VBox(10);
        layout.setPadding(new Insets(20));
        layout.getChildren().addAll(titleLabel, roleBox, usernameField, passwordField, loginButton, messageLabel);

        Scene scene = new Scene(layout, 300, 250);
        stage.setScene(scene);
        stage.setTitle("Lost & Found Kampus");
        stage.show();
    }
}
