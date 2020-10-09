package com.yintu.zhongtie;/**
 * @author mlf
 * @date 2020/10/8 8:55
 * @version 1.0
 */

import com.yintu.zhongtie.util.SpringIOCUtil;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class AppApplication extends Application {


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        //SpringIOCUtil.init();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/login.fxml"));
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root);
        scene.getStylesheets().add("/css/style.css");
        primaryStage.setScene(scene);
        primaryStage.setTitle("Admin Login");
        primaryStage.setMaximized(false);
        primaryStage.getIcons().add(new Image("/img/zhongtie.png"));
        primaryStage.show();
    }
}