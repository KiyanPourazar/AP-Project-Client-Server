package GUI;

import java.net.URL;
import java.util.HashMap;
import java.util.ResourceBundle;

import ClientModel.ClientModel;
import Utility.Time;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class SignUpController implements Initializable{

    private GeneralController gc=new GeneralController();

    @FXML
    private Button backButton;

    @FXML
    private TextField birthdate;

    @FXML
    private PasswordField coinfirmPassword;

    @FXML
    private ChoiceBox<String> countryChoice;

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

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        HashMap<String, String> countryList=Time.getCountryCodes();
        countryChoice.getItems().addAll(countryList.keySet());
    }

    @FXML
    void signUp(ActionEvent event) {
        String firstName=firstname.getText();
        String lastName=lastname.getText();
        String userName=username.getText();
        String email=this.email.getText();
        String passWord=password.getText();
        String confirmPassWord=coinfirmPassword.getText();
        String birthDate=birthdate.getText();
        String country=getCountryCode(countryChoice.getValue());
        String phoneNumber=this.phoneNumber.getText();
        if(firstName==null || lastName==null || userName==null || email==null || passWord==null || confirmPassWord==null || birthDate==null || country==null || phoneNumber==null){
            gc.showResult("no empty fields allowed");
            return;
        }
        String result=ClientModel.signUp(firstName, lastName, userName, email, passWord, confirmPassWord, birthDate, country, phoneNumber);
        gc.showResult(result);
        if(result.equals("success")){
            gc.setScene(signUpButton, "FXML/login.fxml");
        }
    }

    @FXML
    void goBack(ActionEvent event) {
        gc.setScene(signUpButton, "FXML/login.fxml");
    }

    public String getCountryCode(String countryName){
        HashMap<String, String> countryList=Time.getCountryCodes();
        return countryList.get(countryName);
    }
}