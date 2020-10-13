package com.yintu.zhongtie.controller;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * @author mlf
 * @version 1.0
 * @date 2020/10/9 19:28
 */
public class MainController implements Initializable {
    @FXML
    private BorderPane borderPane;
    @FXML
    private AnchorPane topAnchorPane;
    @FXML
    private ImageView imageView;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        topAnchorPane.widthProperty().addListener((observable, oldValue, newValue) -> {
            imageView.setFitWidth(newValue.doubleValue());
        });
    }

    public void test() {
        System.out.println("111");
    }
}
