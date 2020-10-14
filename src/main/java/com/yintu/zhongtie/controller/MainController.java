package com.yintu.zhongtie.controller;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.io.FileUtil;
import com.yintu.zhongtie.util.DialogBuilder;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
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
    private Label timeLabel;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //页面加载
        this.setTime();
    }

    //设置时间
    public void setTime() {
        String format = "yyyy年MM月dd日 HH:mm:ss";
        timeLabel.setText(DateUtil.format(DateUtil.date(), format));
        Timeline animation = new Timeline(new KeyFrame(Duration.millis(1000), event -> timeLabel.setText(DateUtil.format(DateUtil.date(), format))));
        animation.setCycleCount(Timeline.INDEFINITE);
        animation.play();
    }


    //登录窗口
    public void loadLogin() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/login.fxml"));
        Parent root;
        try {
            root = fxmlLoader.load();
            Scene scene = new Scene(root, 1024.0, 580.0);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setTitle("盾构设备评估系统");
            stage.setMaximized(false);
            stage.setResizable(false);
            stage.getIcons().add(new Image("/img/ico.png"));
            stage.show();
            Stage mainStage = (Stage) borderPane.getScene().getWindow();
            mainStage.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //退出按钮事件
    public void onLogout(MouseEvent mouseEvent) {
        if (FileUtil.exist("C:\\1.txt"))
            FileUtil.del(FileUtil.newFile("C:\\1.txt"));
        new DialogBuilder(borderPane)
                .setTitle("提示")
                .setMessage("确认退出登录吗？")
                .setNegativeBtn("取消")
                .setPositiveBtn("确认", this::loadLogin)
                .create();
    }
}
