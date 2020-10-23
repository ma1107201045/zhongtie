package com.yintu.zhongtie.controller;

import cn.hutool.core.io.FileUtil;
import com.alibaba.fastjson.JSONObject;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import com.yintu.zhongtie.repository.UserRepository;
import com.yintu.zhongtie.util.DialogBuilder;
import com.yintu.zhongtie.util.GlobalProperties;
import com.yintu.zhongtie.util.SpringIOCUtil;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ResourceBundle;

/**
 * @author mlf
 * @version 1.0
 * @date 2020/10/9 17:59
 */
public class LoginController implements Initializable {

    private GlobalProperties globalProperties;
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
        this.globalProperties = SpringIOCUtil.getApplicationContext().getBean(GlobalProperties.class);

    }

    //主窗口
    public void loadMain() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/main.fxml"));
        Parent root;
        try {
            root = fxmlLoader.load();
            Scene scene = new Scene(root, 1600.0, 900.0);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setTitle("盾构设备评估系统");
            stage.getIcons().add(new Image("/img/ico.png"));
            stage.setMinWidth(1024.0);
            stage.setMinHeight(768.0);
            stage.show();
            Stage loginStage = (Stage) anchorPane.getScene().getWindow();
            loginStage.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //登录按钮事件
    public void onLogin(Event event) {
        String inputName = nameField.getText();
        String inputPassword = passwordField.getText();
        if ("".equals(inputName) || "".equals(inputPassword)) {
            new DialogBuilder(anchorPane)
                    .setTitle("提示")
                    .setMessage("用户名或者密码不能为空")
                    .setPositiveBtn("确定")
                    .create();
        } else {
            if (checkBox.isSelected())
                if (FileUtil.exist(globalProperties.getFilePath()))
                    FileUtil.del(FileUtil.newFile(globalProperties.getFilePath()));
            JSONObject jo = new JSONObject(true);
            jo.put("name", inputName);
            jo.put("password", inputPassword);
            FileUtil.writeString(jo.toJSONString(), FileUtil.newFile(globalProperties.getFilePath()), Charset.defaultCharset());
            new DialogBuilder(anchorPane)
                    .setTitle("提示")
                    .setMessage("登录成功")
                    .setPositiveBtn("确定")
                    .create();

            this.loadMain();
        }

    }

}
