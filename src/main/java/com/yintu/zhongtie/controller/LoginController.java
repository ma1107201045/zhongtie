package com.yintu.zhongtie.controller;

import com.jfoenix.animation.alert.JFXAlertAnimation;
import com.jfoenix.controls.*;
import com.yintu.zhongtie.util.DialogBuilder;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * @author mlf
 * @version 1.0
 * @date 2020/10/9 17:59
 */
public class LoginController implements Initializable {
    @FXML
    private AnchorPane anchorPane;
    @FXML
    private JFXTextField textField;
    @FXML
    private JFXPasswordField passwordField;
    @FXML
    private CheckBox checkBox;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //页面加载

    }

    public void onLogin(Event event) {
        new DialogBuilder((JFXButton) event.getSource())
                .setTitle("提示")
                .setMessage("登录成功")
                .setNegativeBtn("确定")
                .create();
    }

    public void getMain() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/main.fxml"));
        Parent root = null;
        try {
            root = fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (root != null) {
            Scene scene = new Scene(root);
            scene.getStylesheets().add("/css/main.css");
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setTitle("Admin Main");
            stage.setMaximized(false);
            stage.getIcons().add(new Image("/img/zhongtie.png"));
            stage.show();
        }
    }


}
