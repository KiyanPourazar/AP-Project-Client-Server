package GUI;

import java.io.IOException;

import ClientModel.ClientModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

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
        String userName=username.getText();
        String passWord=password.getText();
        String order= userName+" | "+passWord;
        String result=ClientModel.login(order);
        showResult(result);
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

    public void showResult(String result){
        try {
            FXMLLoader loader=new FXMLLoader(getClass().getResource("FXML\\popup.fxml"));
            Parent root = loader.load();
            PopUpController popUpController = loader.getController();
            popUpController.setResult(result);
            Stage stage=new Stage();
            stage.setTitle("Result");
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(-1);
        }
    }
}