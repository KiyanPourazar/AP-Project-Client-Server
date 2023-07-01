package GUI;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class LoginController {

    @FXML
    private Button logInButton;

    @FXML
    private PasswordField password;

    @FXML
    private Button signUpButton;

    @FXML
    private TextField username;

    @FXML
    private Text wrongLogIn;

    @FXML
    void logIn(ActionEvent event) {

    }

    @FXML
    void signUp(ActionEvent event) {
        setScene(signUpButton, "FXML\\signup.fxml");
    }

    public void setScene(Button button, String address){
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource(address));
            button.getScene().setRoot(root);
        } catch (IOException e) {
            System.exit(-1);
        }
    }
}