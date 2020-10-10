package com.yintu.zhongtie.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * @author mlf
 * @version 1.0
 * @date 2020/10/9 19:28
 */
public class MainController implements Initializable {

    @FXML
    private AnchorPane anchorPane;
    @FXML
    private PieChart pieChart;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        for (int j = 0; j < 5; j++) {
            TitledPane titledPane = new TitledPane();
            GridPane gridPane = new GridPane();
            for (int i = 0; i < 5; i++) {
                gridPane.addRow(i, new Button("张三" + i));
            }
            titledPane.setContent(gridPane);
        }
    }
}
