package de.tum.cit.aet;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) {
        SealTemisApp app = new SealTemisApp(primaryStage);
        primaryStage.setTitle("SealTemis");
        primaryStage.getIcons().add(new Image("file:images/artemgus.png"));
        primaryStage.setScene(new Scene(app.getLoginPage(), 600, 500));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
