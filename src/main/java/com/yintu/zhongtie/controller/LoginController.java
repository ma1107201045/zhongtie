package com.yintu.zhongtie.controller;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.io.file.FileMode;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;

/**
 * @author mlf
 * @version 1.0
 * @date 2020/10/9 17:59
 */
public class LoginController {
    @FXML
    private AnchorPane anchorPane;
    @FXML
    private TextField textField;
    @FXML
    private PasswordField passwordField;
    @FXML
    private CheckBox checkBox;

    public void onLogin() {
        String name = textField.getText();
        String password = passwordField.getText();
        Alert alert;
        if ("admin".equals(name) && "123456".equals(password)) {
            alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("信息");
            if (checkBox.isSelected()) {

            }
            alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("信息");
            alert.setContentText("登陆成功");
            alert.showAndWait();
            //开启主窗口
            this.getMain();

            //销毁当前窗口
            Stage stage = (Stage) this.anchorPane.getScene().getWindow();
            stage.close();

        } else {
            alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("错误");
            alert.showAndWait();
        }
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
            scene.getStylesheets().add("/css/style.css");
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setTitle("Admin Main");
            stage.setMaximized(false);
            stage.getIcons().add(new Image("/img/zhongtie.png"));
            stage.show();
        }
    }

}
