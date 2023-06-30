import Client.ClientModel.ClientModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

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
        ClientModel.signUp(firstName, lastName, userName, email, passWord, confirmPassWord, birthDate, country, phoneNumber);
    }

}