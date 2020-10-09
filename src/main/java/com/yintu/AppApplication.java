package com.yintu;/**
 * @author mlf
 * @date 2020/10/8 8:55
 * @version 1.0
 */

import com.yintu.util.SpringIOCUtil;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.awt.*;
import java.io.IOException;

@Component
public class AppApplication extends Application {


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        SpringIOCUtil.init();//加载spring配置文件,初始化spring容器

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/controller/login.fxml"));
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root);
        scene.getStylesheets().add("/css/style.css");
        primaryStage.setScene(scene);
        primaryStage.setTitle("Admin Login");
        primaryStage.setMaximized(false);
        primaryStage.getIcons().add(new Image("/img/logo.png"));
        primaryStage.show();
    }
}
