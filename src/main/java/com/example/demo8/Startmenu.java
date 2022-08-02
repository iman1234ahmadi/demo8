package com.example.demo8;
import javafx.animation.FadeTransition;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class Startmenu extends Application {


    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("Startmenu.fxml"));
        stage.setTitle("Hello!");
        stage.setScene(new Scene(root, 919, 661));
        stage.show();
         //new FadeIn(root).play();

            }
            public static void main(String[] args) {

        launch();
    }
    }
