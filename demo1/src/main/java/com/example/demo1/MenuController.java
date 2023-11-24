package com.example.demo1;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.net.URL;
import java.util.ResourceBundle;

public class MenuController implements Initializable {
    @Override
    public void initialize(URL location, ResourceBundle resource) {
        getData();
        style();
    }

    protected String weatherA;
    protected String tempA;
    protected String maxTemA;
    protected String minTemA;
    protected String precipitationProbabilitySetA;
    protected String humiditySetA;

    public void style(){
        weatherA = weatherSet.getText();
        tempA = tempSet.getText();
        maxTemA = maxTemSet.getText();
        minTemA = minTemSet.getText();
        precipitationProbabilitySetA = precipitationProbabilitySet.getText();
        humiditySetA = humiditySet.getText();
    }

    @FXML
    private Label weatherSet;
    @FXML
    private Label tempSet;
    @FXML
    private Label maxTemSet;
    @FXML
    private Label minTemSet;
    @FXML
    private Label precipitationProbabilitySet;
    @FXML
    private Label humiditySet;

    public void getData() {
        try {
            Document doc = Jsoup.connect("https://www.kma.go.kr/wid/queryDFSRSS.jsp?zone=4113559000").get(); // 양디고 기준 서현2동으로 기상청 RSS 서비스 이용 (XML 데이터)
            Elements locList = doc.select("data:nth-child(1)");

            for(Element data : locList) {
                Element weather = data.selectFirst("wfKor"); // 날씨
                Element maxTem = data.selectFirst("tmx"); // 최고기온
                Element minTem = data.selectFirst("tmn"); // 최저기온
                Element temp = data.selectFirst("temp"); // 현재기온
                Element precipitationProbability = data.selectFirst("pop"); // 강수확률
                Element humidity = data.selectFirst("reh"); // 습도

                if (maxTem.text().equals(-999.0)) {
                    continue;
                }

                if (minTem.text().equals(-999.0)) {
                    continue;
                }

                System.out.println(
                        "현재 날씨 : " + weather.text()
                                + " | 현재 기온 : " + temp.text() + "°C"
                                + " | 오늘의 최고 기온 : " + maxTem.text() + "°C"
                                + " | 오늘의 최저 기온 : " + minTem.text() + "°C"
                                + " | 강수 확률 : " + precipitationProbability.text() + "%"
                                + " | 습도 : " + humidity.text() + "%"
                );

                weatherSet.setText("현재 날씨 : " + weather.text());
                tempSet.setText("현재 기온 : " + temp.text() + "°C");
                maxTemSet.setText("오늘의 최고 기온 : " + maxTem.text() + "°C");
                minTemSet.setText("오늘의 최저 기온 : " + minTem.text() + "°C");
                precipitationProbabilitySet.setText("강수 확률 : " + precipitationProbability.text() + "%");
                humiditySet.setText("습도 : " + humidity.text() + "%");
            }
        } catch (Exception e) {

        }
    }
    @FXML
    private Button changeBtn;
    public void changeScene() {
        try {
            Parent nextScene = FXMLLoader.load(getClass().getResource("mainView.fxml"));
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
            Parent nextScene = FXMLLoader.load(getClass().getResource("fashion.fxml"));
            Scene scene = new Scene(nextScene);

            Stage primaryStage = (Stage) changeBtn.getScene().getWindow();
            primaryStage.setScene(scene);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



}
