package com.example.demo1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class MainViewController implements Initializable {
    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    @FXML
    private Button changeBtn;
    public void changeScene() {
        try {
            Parent nextScene = FXMLLoader.load(getClass().getResource("signUp.fxml"));
            Scene scene = new Scene(nextScene);

            Stage primaryStage = (Stage) changeBtn.getScene().getWindow();
            primaryStage.setScene(scene);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private Button changeBtnA;
    public void changeSceneA() {
        try {
            Parent nextScene = FXMLLoader.load(getClass().getResource("menu.fxml"));
            Scene scene = new Scene(nextScene);

            Stage primaryStage = (Stage) changeBtn.getScene().getWindow();
            primaryStage.setScene(scene);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    public Button closeButton;

    public void handleCloseButtonAction(ActionEvent event) {
        Stage stage = (Stage) closeButton.getScene().getWindow();
        stage.close();
    }
}
