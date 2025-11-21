package com.example.demo1cookieclickerv2;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Coolimage extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Coolimage.class.getResource("CoolimageView.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 540);
        stage.setTitle("Picture Viewer");
        stage.setScene(scene);
        stage.show();
    }
}
