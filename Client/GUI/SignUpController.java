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
import javafx.stage.Stage;

public class SignUpController {

    @FXML
    private TextField birthdate;

    @FXML
    private PasswordField coinfirmPassword;

    @FXML
    private TextField country;

    @FXML
    private TextField email;

    @FXML
    private TextField firstname;

    @FXML
    private TextField lastname;

    @FXML
    private PasswordField password;

    @FXML
    private TextField phoneNumber;

    @FXML
    private Button signUpButton;

    @FXML
    private TextField username;

    @FXML
    void signUp(ActionEvent event) {
        String firstName=firstname.getText();
        String lastName=lastname.getText();
        String userName=username.getText();
        String email=this.email.getText();
        String passWord=password.getText();
        String confirmPassWord=coinfirmPassword.getText();
        String birthDate=birthdate.getText();
        String country=this.country.getText();
        String phoneNumber=this.phoneNumber.getText();
        String result=ClientModel.signUp(firstName, lastName, userName, email, passWord, confirmPassWord, birthDate, country, phoneNumber);
        showResult(result);
        if(result.equals("seccess")){
            // TODO: Go to main page
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