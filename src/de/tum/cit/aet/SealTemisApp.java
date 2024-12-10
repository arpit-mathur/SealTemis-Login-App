package de.tum.cit.aet;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.util.HashMap;
import java.util.Map;

public class SealTemisApp {

    private final Stage stage;
    private final Map<String, String> users = new HashMap<>();
    private String currentUser;

    public SealTemisApp(Stage stage) {
        this.stage = stage;
        // TODO 1: Add a student user and a instructor user to the database to be able to login with them
    }

    public Pane getLoginPage() {
        // TODO 2: Add an artemgus logo as image to the Login page

        // TODO 3: Add the welcome text to the login page

        // TODO 4: Add the username and password fields and the login button to the login page

        /* Helpful CSS styling for the login page background:
        loginPane.setStyle("-fx-background-image: url('file:images/NavyBlueSolid.png');"
                + "-fx-background-size: cover;"
                + "-fx-background-position: center center;");

         */

        // TODO 5: Implement the scene change when the login button is clicked

        return new Pane();
    }

    public Pane getWelcomePage() {
        return new Pane();
    }
}
