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
    private JFXTextField nameField;
    @FXML
    private JFXPasswordField passwordField;
    @FXML
    private CheckBox checkBox;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //页面加载
    }

    public void onLogin(Event event) {
        if ("".equals(nameField.getText()) || "".equals(passwordField.getText())) {
            new DialogBuilder((JFXButton) event.getSource())
                    .setTitle("提示")
                    .setMessage("用户名或者密码不能为空")
                    .setNegativeBtn("确定")
                    .create();
        } else {
            new DialogBuilder((JFXButton) event.getSource())
                    .setTitle("提示")
                    .setMessage("登录成功")
                    .setNegativeBtn("确定")
                    .create();
            this.loadMain();
        }

    }

    public void loadMain() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/main.fxml"));
        Parent root;
        try {
            root = fxmlLoader.load();
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setTitle("盾构设备评估系统");
            stage.setMaximized(false);
            stage.getIcons().add(new Image("/img/zhongtie.png"));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
