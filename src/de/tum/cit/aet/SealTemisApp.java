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

    /// attribute to count the number of failed attempts
    private int failedLoginAttempts;

    public SealTemisApp(Stage stage) {
        this.stage = stage;
        // TODO 1: Add a student user and a instructor user to the database to be able to login with them
        users.put("student","student123");
        users.put("instructor","instructor123");
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
               "-fx-text-fill: 'white';"
        );


        //Helpful CSS styling for the login page background:
        loginPageLayout.setStyle("-fx-background-image: url('file:images/NavyBlueSolid.png');"
                + "-fx-background-size: cover;"
                + "-fx-background-position: center center;"+
                "-fx-padding: 70;"
        );


        /// error message will be displayed here (Invalid credentials)
        Label errorLabel = new Label();
        errorLabel.setTextFill(Color.RED);
        errorLabel.setFont(Font.font("Comic sans ms",FontWeight.SEMI_BOLD,18));

        /// TODO 5: Login button Logic-->

        loginButton.setOnAction(action -> {
            /// If the credentials are valid, change the scene to welcome page -->
            if(users.containsKey(usernameField.getText()) && users.get(usernameField.getText())
                    .equals(passwordField.getText()) && failedLoginAttempts < 3){
                currentUser = usernameField.getText();
                stage.setScene(new Scene(getWelcomePage(),600,750));
            }
            ///  If the credentials are Invalid -->
            else {
                failedLoginAttempts++;
                /// Based on number of failed login attempts the errorLabel text is set.
                if (failedLoginAttempts >= 3){
                    errorLabel.setText("Maximum attempts reached! Try again later");
                }
                else {
                    errorLabel.setText("Invalid username or password. Remaining attempts: " +
                            (3-failedLoginAttempts));
                }
            }
        });


        /// Optional Challenge -->
        /// Label and button to take us to the registration page
        Label createAccountLabel = new Label("Don't have an account?");
        createAccountLabel.setTextFill(Color.LIGHTGRAY);
        createAccountLabel.setFont(Font.font("Comic sans ms",FontWeight.NORMAL,16));

        Button signupButton = new Button("Sign up here");
        signupButton.setStyle("-fx-font-size: 16px;" +
                "-fx-font-family: 'Comic Sans MS';" +
                "-fx-background-color: 'transparent';" +
                "-fx-text-fill: 'lightgray';"+
                "-fx-underline: true;"
        );
        
        /// Sets the scene to the registration page
        signupButton.setOnAction(action -> stage.setScene(new Scene(getRegistrationPage(),600,750)));

        /// Adding all the nodes to the pane and then the pane to the scene
        loginPageLayout.getChildren()
                .addAll(view,welcomeText,username,usernameField,password,passwordField,loginButton,errorLabel,createAccountLabel,signupButton);

        loginPageLayout.setAlignment(Pos.CENTER);
        return loginPageLayout;
    }


    /// Page set to scene when valid inputs are provided
    public Pane getWelcomePage() {
        VBox welcomePageLayout = new VBox(20);
        welcomePageLayout.setAlignment(Pos.CENTER);
        welcomePageLayout.setStyle("-fx-background-image: url('file:images/NavyBlueSolid.png');"
                + "-fx-background-size: cover;"
                + "-fx-background-position: center center;"
        );


        Image image = new Image("file:images/artemgus2.png");
        ImageView view = new ImageView(image);
        view.setFitWidth(240);
        view.setPreserveRatio(true);

        Label welcomeLabel = new Label("Welcome, "+ currentUser + "!");
        welcomeLabel.setFont(Font.font("Comic sans ms",FontWeight.BOLD,22));
        welcomeLabel.setTextFill(Color.WHITE);

        /// How intellij helps styling
        Button logoutButton = new Button("Logout");
        logoutButton.setStyle("-fx-font-size: 22px;" +
                "-fx-font-family: 'Comic Sans MS';" +
                "-fx-background-color: rgba(236,49,78,0.94);" +
                "-fx-text-fill: 'white';"
        );

        /// logout button sets the scene back to login page and resets failed attempts.
        logoutButton.setOnAction(action -> {
            failedLoginAttempts = 0;
            stage.setScene(new Scene(getLoginPage(),600,750));
        });

        
        ///adding the nodes to the pane
        welcomePageLayout.getChildren().addAll(view, welcomeLabel,logoutButton);
        return welcomePageLayout;
    }


    /// Optional Challenge-->
    /// This pane is returned when signup button is pressed.

    public Pane getRegistrationPage() {

        VBox registrationPageLayout = new VBox(13);
        registrationPageLayout.setAlignment(Pos.CENTER);

        Image image = new Image("file:images/artemgus3.png");
        ImageView view = new ImageView(image);
        view.setFitWidth(200);
        view.setPreserveRatio(true);


        Label welcomeText = new Label("Create your account");
        welcomeText.setFont(Font.font("Comic sans ms",FontWeight.BLACK,25));
        welcomeText.setTextFill(Color.WHITE);

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
                "-fx-background-color: #2828ed;" +
                "-fx-text-fill: 'white';"
        );

        Label errorLabel = new Label();
        errorLabel.setTextFill(Color.RED);
        errorLabel.setFont(Font.font("Comic sans ms",FontWeight.SEMI_BOLD,18));

        //Helpful CSS styling for the login page background:
        registrationPageLayout.setStyle("-fx-background-image: url('file:images/NavyBlueSolid.png');"
                + "-fx-background-size: cover;"
                + "-fx-background-position: center center;"
                + "-fx-padding: 70;"
        );


        /// Logic for the create account button -->
        createAccountButton.setOnAction(action -> {
            /// Runs when no input field is empty (Could be more efficient)
            if(!textName.getText().isEmpty() && !textUsername.getText().isEmpty() && !passField.getText().isEmpty()) {
                /// Resetting the failed login attempts
                failedLoginAttempts = 0;
                /// Puts the given username and password to the users Map.
                users.putIfAbsent(textUsername.getText(), passField.getText());
                currentUser = textName.getText();
                stage.setScene(new Scene(getAccountCreatedPage(), 600, 750));
            }
            else{
                errorLabel.setText("Invalid Input! Fields cannot be Empty.");
            }
        });


        Button goBack = new Button("Go back");
        goBack.setStyle("-fx-font-size: 16px;" +
                "-fx-font-family: 'Comic Sans MS';" +
                "-fx-background-color: 'transparent';" +
                "-fx-text-fill: 'lightgray';"+
                "-fx-underline: true;"
        );

        /// sets scene back to login page WITHOUT resetting the failed attempt
        goBack.setOnAction(action -> stage.setScene(new Scene(getLoginPage(),600,750)));

        /// Adding all the nodes to the Scene
        registrationPageLayout.getChildren()
                .addAll(view,welcomeText,name,textName,username,textUsername,password,passField,createAccountButton,errorLabel,goBack);

        return registrationPageLayout;
    }


    /// This is page is accessed when a new account is successfully created
    public Pane getAccountCreatedPage() {

        VBox accountCreatedPageLayout = new VBox(20);
        accountCreatedPageLayout.setAlignment(Pos.CENTER);

        accountCreatedPageLayout.setStyle("-fx-background-image: url('file:images/NavyBlueSolid.png');"
                + "-fx-background-size: cover;"
                + "-fx-background-position: center center;"+
                "-fx-padding: 70;"
        );

        Image image = new Image("file:images/artemgus4.png");
        ImageView view = new ImageView(image);
        view.setFitWidth(230);
        view.setPreserveRatio(true);

        Label accountCreatedLabel = new Label("Account successfully created, "+ currentUser + "!");
        accountCreatedLabel.setFont(Font.font("Comic sans ms",FontWeight.SEMI_BOLD,20));
        accountCreatedLabel.setTextFill(Color.WHITE);

        Button backToLoginButton = new Button("Back to Login");
        backToLoginButton.setStyle("-fx-font-size: 20px;" +
                "-fx-font-family: 'Comic Sans MS';" +
                "-fx-background-color: #1195ef;" +
                "-fx-text-fill: 'white';");

        backToLoginButton.setOnAction(action -> stage.setScene(new Scene(getLoginPage(),600,750)));

        accountCreatedPageLayout.getChildren().addAll(view, accountCreatedLabel,backToLoginButton);
        return accountCreatedPageLayout;
    }
}
