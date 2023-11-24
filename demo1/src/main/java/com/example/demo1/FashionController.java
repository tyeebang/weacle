package com.example.demo1;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class FashionController implements Initializable {
    @Override
    public void initialize(URL location, ResourceBundle resource){
    }

    public void coordinator() {
        try {
            MenuController lol = new MenuController();

            if (Integer.parseInt(lol.weatherA) >= 20) {
                
            } else if ((Integer.parseInt(lol.weatherA) < 20) && (Integer.parseInt(lol.weatherA) >= 10)) {

            } else if ((Integer.parseInt(lol.weatherA) < 10) && (Integer.parseInt(lol.weatherA) >= 0)) {

            } else if (Integer.parseInt(lol.weatherA) < 0) {

            }
        } catch (Exception e) {

        }
    }

    @FXML
    private Button changeBtn;
    public void changeScene() {
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
}
