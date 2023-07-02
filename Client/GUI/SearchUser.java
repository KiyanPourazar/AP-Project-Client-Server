package GUI;

import java.io.IOException;

import ClientModel.ClientModel;
import Utility.DataObject;
import Utility.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class SearchUser {
    private GeneralController gc=new GeneralController();

    @FXML
    private Button search;

    @FXML
    private TextField userName;

    private String mainUser;

    @FXML
    void searchPressed(ActionEvent event) {
        String userName=this.userName.getText();
        String result;
        if(userName==null){
            result="empty field not allowed";
            return;
        }
        DataObject dataObject=ClientModel.getProfile(userName);
        result=dataObject.getMethod();
        if(result.equals("success")){
            User user=(User)dataObject.getObject();
            user.setPassWord("********");
            setScene(user);
        } else{
            gc.showResult(result);
        }
    }

    public void setMainUser(String userName){
        this.mainUser=userName;
    }

    public void setScene(User user){
        try {
            FXMLLoader loader=new FXMLLoader(getClass().getResource("FXML/otherProfile.fxml"));
            Parent root = loader.load();
            ProfileController mc=loader.getController();
            mc.setData(user, mainUser);
            search.getScene().setRoot(root);
        } catch (IOException e) {
            System.exit(-1);
        }
    }
}