import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.util.Random;

public class TebakAngkaAdvance extends Application {

    private int targetNumber;
    private int attempts; 
    private final Label feedbackLabel = new Label();
    private final Label attemptLabel = new Label("Jumlah percobaan: 0");
    private final TextField inputField = new TextField();
    private final Button guessButton = new Button("🎲 Coba Tebak!");

    private void generateNewNumber() {
        targetNumber = new Random().nextInt(100) + 1;
        attempts = 0;
        attemptLabel.setText("Jumlah percobaan: 0");
        feedbackLabel.setText("");
        inputField.setDisable(false);
        guessButton.setText("🎲 Coba Tebak!");
    }

    @Override
    public void start(Stage primaryStage) {
        generateNewNumber();

        Label titleLabel = new Label("🎯 Tebak Angka 1–100");
        titleLabel.setStyle("-fx-font-size: 18px; -fx-text-fill: #1234ab;");

        Label instructionLabel = new Label("Masukkan tebakanmu!");
        instructionLabel.setStyle("-fx-font-size: 14px;");

        inputField.setPromptText("Masukkan angka di sini");
        inputField.setPrefWidth(150);

        guessButton.setStyle("-fx-background-color: #34c759; -fx-text-fill: white;");
        guessButton.setOnAction(e -> handleGuess());

        HBox inputBox = new HBox(10, inputField, guessButton);
        inputBox.setStyle("-fx-alignment: center;");

        VBox layout = new VBox(15, titleLabel, instructionLabel, inputBox, feedbackLabel, attemptLabel);
        layout.setStyle("-fx-padding: 20px; -fx-alignment: center; -fx-background-color: #eef6ff;");

        primaryStage.setScene(new Scene(layout, 350, 250));
        primaryStage.setTitle("Tebak Angka Advance");
        primaryStage.show();
    }

    private void handleGuess() {
        if (guessButton.getText().equals("Main Lagi")) {
            generateNewNumber();
            inputField.clear();
            return;
        }

        String userInput = inputField.getText();
        try {
            int guess = Integer.parseInt(userInput);
            attempts++;
            attemptLabel.setText("Jumlah percobaan: " + attempts);

            if (guess < targetNumber) {
                feedbackLabel.setText("🔽 Terlalu kecil!!");
                feedbackLabel.setStyle("-fx-text-fill: orange;");
            } else if (guess > targetNumber) {
                feedbackLabel.setText("🔼 Terlalu besar!");
                feedbackLabel.setStyle("-fx-text-fill: orange;");
            } else {
                feedbackLabel.setText("✅ Tebakan benar!");
                feedbackLabel.setStyle("-fx-text-fill: green; -fx-font-weight: bold;");
                inputField.setDisable(true);
                guessButton.setText("Main Lagi");
            }
        } catch (NumberFormatException e) {
            feedbackLabel.setText("⚠ Masukkan angka valid!");
            feedbackLabel.setStyle("-fx-text-fill: red;");
        }

        inputField.clear();
    }

    public static void main(String[] args) {
        launch(args);
    }
}