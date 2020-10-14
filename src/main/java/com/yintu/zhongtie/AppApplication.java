package com.yintu.zhongtie;/**
 * @author mlf
 * @date 2020/10/8 8:55
 * @version 1.0
 */

import cn.hutool.core.io.FileUtil;
import com.alibaba.fastjson.JSONObject;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.nio.charset.Charset;

public class AppApplication extends Application {


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        //SpringIOCUtil.init();
        if (FileUtil.exist("C:\\1.txt")) {
            String userInfoJson = FileUtil.readString(FileUtil.newFile("C:\\1.txt"), Charset.defaultCharset());
            JSONObject jo = (JSONObject) JSONObject.parse(userInfoJson);
            if (jo.containsKey("name") && jo.containsKey("password")) {
                this.loadMain(new Stage());
            }
        } else {
            this.loadLogin(primaryStage);
        }
    }

    public void loadLogin(Stage primaryStage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/login.fxml"));
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root, 1024.0, 580.0);
        primaryStage.setScene(scene);
        primaryStage.setTitle("盾构设备评估系统");
        primaryStage.setMaximized(false);
        primaryStage.setResizable(false);
        primaryStage.getIcons().add(new Image("/img/ico.png"));
        primaryStage.show();
    }

    public void loadMain(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/main.fxml"));
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("盾构设备评估系统");
        stage.getIcons().add(new Image("/img/ico.png"));
        stage.setMinWidth(1024.0);
        stage.setMinHeight(768.0);
        stage.show();
    }
}
