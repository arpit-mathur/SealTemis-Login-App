package de.tum.cit.aet;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import java.util.HashMap;
import java.util.Map;

public class SealTemisApp {

    private final Stage stage;
    private final Map<String, String> users = new HashMap<>();
    private String currentUser;

    ///
    int failedLoginAttempts;

    public SealTemisApp(Stage stage) {
        this.stage = stage;
        // TODO 1: Add a student user and a instructor user to the database to be able to login with them
        users.putIfAbsent("student","student123");
        users.putIfAbsent("instructor","instructor123");
        /// Initializing to count the number of failed login attempts
        this.failedLoginAttempts = 0;
    }


    /// Main Login Page
    public Pane getLoginPage() {
        VBox loginPageLayout = new VBox(13);
        // TODO 2: Add an artemgus logo as image to the Login page
        Image image = new Image("file:images/artemgus.png");
        ImageView view = new ImageView(image);
        view.setFitWidth(200);
        view.setPreserveRatio(true);

        // TODO 3: Add the welcome text to the login page

        Label welcomeText = new Label("Welcome to SealTemis. Please login");
        welcomeText.setFont(Font.font("Comic sans ms",FontWeight.BLACK,20));
        welcomeText.setTextFill(Color.WHITE);

        // TODO 4: Add the username and password fields and the login button to the login page

        Label username = new Label("Username:");
        username.setTextFill(Color.WHITE);
        username.setFont(Font.font("Comic sans ms",FontWeight.NORMAL,16));

        TextField usernameField = new TextField();
        usernameField.setFont(Font.font("Comic sans ms",FontWeight.SEMI_BOLD, 18));
        usernameField.setPromptText("Enter your username");

        Label password = new Label("Password:");
        password.setTextFill(Color.WHITE);
        password.setFont(Font.font("Comic sans ms",FontWeight.NORMAL,16));

        PasswordField passwordField = new PasswordField();
        passwordField.setFont(Font.font("Comic sans ms", FontWeight.SEMI_BOLD,18));
        passwordField.setPromptText("Enter your password");

        Button loginButton = new Button("Login");
       loginButton.setStyle("-fx-font-size: 20px;" +
               "-fx-font-family: 'Comic Sans MS';" +
               "-fx-background-color: 'green';" +
               "-fx-text-fill: 'white';");


        //Helpful CSS styling for the login page background:
        loginPageLayout.setStyle("-fx-background-image: url('file:images/NavyBlueSolid.png');"
                + "-fx-background-size: cover;"
                + "-fx-background-position: center center;"+
                "-fx-padding: 70;");

        // TODO 5: Implement the scene change when the login button is clicked

        Label errorLabel = new Label();
        errorLabel.setTextFill(Color.RED);
        errorLabel.setFont(Font.font("Comic sans ms",FontWeight.SEMI_BOLD,18));


        loginButton.setOnAction(e -> {
            String username1 = usernameField.getText();
            String password1 = passwordField.getText();
            if (users.containsKey(username1) && users.get(username1).equals(password1)) {
                currentUser = username1;
                stage.setScene(new Scene(getWelcomePage(), 600, 700));
            } else {
                errorLabel.setText("Invalid username or password.");
            }
        });


        /// Optional Challenge -->
        Label createAccountLabel = new Label("Don't have an account?");
        createAccountLabel.setTextFill(Color.LIGHTGRAY);
        createAccountLabel.setFont(Font.font("Comic sans ms",FontWeight.NORMAL,18));

        Button signupButton = new Button("Sign up here");
        signupButton.setStyle("-fx-font-size: 18px;" +
                "-fx-font-family: 'Comic Sans MS';" +
                "-fx-background-color: 'transparent';" +
                "-fx-text-fill: 'lightgray';"+
                "-fx-underline: true;");

        signupButton.setOnAction(action -> stage.setScene(new Scene(getRegistrationPage(),600,700)));

        /// Adding all the nodes to the Scene
        loginPageLayout.getChildren().addAll(view,welcomeText,username,usernameField,password,passwordField,loginButton,errorLabel,createAccountLabel,signupButton);

        loginPageLayout.setAlignment(Pos.CENTER);
        return loginPageLayout;
    }


    public Pane getWelcomePage() {
        VBox welcomePageLayout = new VBox(30);

        welcomePageLayout.setAlignment(Pos.CENTER);
        welcomePageLayout.setStyle("-fx-background-image: url('file:images/NavyBlueSolid.png');"
                + "-fx-background-size: cover;"
                + "-fx-background-position: center center;");

        Image image = new Image("file:images/artemgus2.png");
        ImageView view = new ImageView(image);
        view.setFitWidth(250);
        view.setPreserveRatio(true);

        Label welcomeLabel = new Label("Welcome, "+ currentUser + "!");
        welcomeLabel.setFont(Font.font("Comic sans ms",FontWeight.BOLD,23));
        welcomeLabel.setTextFill(Color.WHITE);

        Button logoutButton = new Button("Logout");
        logoutButton.setStyle("-fx-font-size: 22px;" +
                "-fx-font-family: 'Comic Sans MS';" +
                "-fx-background-color: 'red';" +
                "-fx-text-fill: 'white';");
        logoutButton.setOnAction(action -> stage.setScene(new Scene(getLoginPage(),600,700)));

        welcomePageLayout.getChildren().addAll(view, welcomeLabel,logoutButton);
        return welcomePageLayout;
    }


    /// Optional -->

    public Pane getRegistrationPage() {

        VBox registrationPageLayout = new VBox(13);
        // TODO 2: Add an artemgus logo as image to the Login page
        Image image = new Image("file:images/artemgus3.png");
        ImageView view = new ImageView(image);
        view.setFitWidth(200);
        view.setPreserveRatio(true);

        // TODO 3: Add the welcome text to the login page

        Label welcomeText = new Label("Create your account");
        welcomeText.setFont(Font.font("Comic sans ms",FontWeight.BLACK,25));
        welcomeText.setTextFill(Color.WHITE);

        // TODO 4: Add the username and password fields and the login button to the login page

        Label name = new Label("Name:");
        name.setTextFill(Color.WHITE);
        name.setFont(Font.font("Comic sans ms",FontWeight.NORMAL,16));

        TextField textName = new TextField();
        textName.setFont(Font.font("Comic sans ms",FontWeight.SEMI_BOLD, 18));
        textName.setPromptText("Enter your Name");

        Label username = new Label("Username:");
        username.setTextFill(Color.WHITE);
        username.setFont(Font.font("Comic sans ms",FontWeight.NORMAL,16));

        TextField textUsername = new TextField();
        textUsername.setFont(Font.font("Comic sans ms",FontWeight.SEMI_BOLD, 18));
        textUsername.setPromptText("Enter your username");

        Label password = new Label("Password:");
        password.setTextFill(Color.WHITE);
        password.setFont(Font.font("Comic sans ms",FontWeight.NORMAL,16));

        PasswordField passField = new PasswordField();
        passField.setFont(Font.font("Comic sans ms", FontWeight.SEMI_BOLD,18));
        passField.setPromptText("Enter your password");

        Button createAccountButton = new Button("Create Account");
        createAccountButton.setStyle("-fx-font-size: 20px;" +
                "-fx-font-family: 'Comic Sans MS';" +
                "-fx-background-color: #0000EE;" +
                "-fx-text-fill: 'white';");

        Label errorLabel = new Label("");
        errorLabel.setTextFill(Color.RED);
        errorLabel.setFont(Font.font("Comic sans ms",FontWeight.BOLD,18));

        //Helpful CSS styling for the login page background:
        registrationPageLayout.setStyle("-fx-background-image: url('file:images/NavyBlueSolid.png');"
                + "-fx-background-size: cover;"
                + "-fx-background-position: center center;"+
                "-fx-padding: 70;");

        // TODO 5: Implement the scene change when the createAccount button is clicked

        createAccountButton.setOnAction(action -> {

            if(!textName.getText().isEmpty() && !textUsername.getText().isEmpty() && !passField.getText().isEmpty()) {
                /// Resetting the failed login attempts
                failedLoginAttempts = 0;
                users.putIfAbsent(textUsername.getText(), passField.getText());
                currentUser = textName.getText();
                stage.setScene(new Scene(getAccountCreatedPage(), 600, 700));
            }
            else{
                errorLabel.setText("Invalid Input! Please Retry.");
            }
        });

        Button goBack = new Button("Go back");
        goBack.setStyle("-fx-font-size: 18px;" +
                "-fx-font-family: 'Comic Sans MS';" +
                "-fx-background-color: 'transparent';" +
                "-fx-text-fill: 'lightgray';"+
                "-fx-underline: true;");

        goBack.setOnAction(action -> stage.setScene(new Scene(getLoginPage(),600,700)));

        /// Adding all the nodes to the Scene
        registrationPageLayout.getChildren().addAll(view,welcomeText,name,textName,username,textUsername,password,passField,createAccountButton,errorLabel,goBack);

        registrationPageLayout.setAlignment(Pos.CENTER);
        return registrationPageLayout;
    }


    public Pane getAccountCreatedPage() {

        VBox accountCreatedPageLayout = new VBox(20);

        accountCreatedPageLayout.setAlignment(Pos.CENTER);
        accountCreatedPageLayout.setStyle("-fx-background-image: url('file:images/NavyBlueSolid.png');"
                + "-fx-background-size: cover;"
                + "-fx-background-position: center center;"+
                "-fx-padding: 70;");

        Image image = new Image("file:images/artemgus4.png");
        ImageView view = new ImageView(image);
        view.setFitWidth(230);
        view.setPreserveRatio(true);

        Label welcomeLabel = new Label("Account successfully created, "+ currentUser + "!");
        welcomeLabel.setFont(Font.font("Comic sans ms",FontWeight.BOLD,20));
        welcomeLabel.setTextFill(Color.WHITE);

        Button logoutButton = new Button("Back to Login");
        logoutButton.setStyle("-fx-font-size: 20px;" +
                "-fx-font-family: 'Comic Sans MS';" +
                "-fx-background-color: #00C0FF;" +
                "-fx-text-fill: 'white';");

        logoutButton.setOnAction(action -> stage.setScene(new Scene(getLoginPage(),600,700)));

        accountCreatedPageLayout.getChildren().addAll(view, welcomeLabel,logoutButton);
        return accountCreatedPageLayout;
    }
}
