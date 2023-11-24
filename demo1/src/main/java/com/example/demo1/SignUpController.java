package com.example.demo1;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class SignUpController implements Initializable {
    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    @FXML
    private Button changeBtn;
    public void changeScene() {
        change(changeBtn);
    }

    @FXML
    private Button changeBtnA;
    public void changeSceneA() {
        change(changeBtnA);
    }

    private void change(Button changeBtnA) {
        try {
            Parent nextScene = FXMLLoader.load(getClass().getResource("mainView.fxml"));
            Scene scene = new Scene(nextScene);

            Stage primaryStage = (Stage) changeBtnA.getScene().getWindow();
            primaryStage.setScene(scene);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}