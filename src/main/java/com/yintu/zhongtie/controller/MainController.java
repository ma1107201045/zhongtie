package com.yintu.zhongtie.controller;

import cn.hutool.core.io.FileUtil;
import com.yintu.zhongtie.util.DialogBuilder;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

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


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //页面加载
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
}
