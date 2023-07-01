package GUI;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.ResourceBundle;

import ClientModel.ClientModel;
import Utility.Time;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class SignUpController implements Initializable{

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
            showResult("no empty fields allowed");
        }
        String result=ClientModel.signUp(firstName, lastName, userName, email, passWord, confirmPassWord, birthDate, country, phoneNumber);
        showResult(result);
        if(result.equals("success")){
            setScene(signUpButton, "FXML\\login.fxml");
        }
    }

    public String getCountryCode(String countryName){
        HashMap<String, String> countryList=Time.getCountryCodes();
        return countryList.get(countryName);
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