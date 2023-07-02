package GUI;

import java.io.IOException;

import ClientModel.ClientModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

public class LoginController{

    private GeneralController gc=new GeneralController();

    @FXML
    private ImageView alphabetLogo;

    @FXML
    private ImageView birdLogo;

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
        if(userName==null || passWord==null){
            gc.showResult("no empty fields allowed");
            return;
        }
        String order= userName+" | "+passWord;
        String result=ClientModel.login(order);
        gc.showResult(result);
        if(result.equals("success")){
            setScene(logInButton, "FXML/mainMod.fxml");
        }
    }

    @FXML
    void signUp(ActionEvent event) {
        gc.setScene(signUpButton, "FXML/signup.fxml");
    }

    public void setScene(Button button, String address){
        try {
            FXMLLoader loader=new FXMLLoader(getClass().getResource(address));
            Parent root = loader.load();
            MainController mc=loader.getController();
            mc.setUserName(username.getText());
            button.getScene().setRoot(root);
        } catch (IOException e) {
            System.exit(-1);
        }
    }

    
}