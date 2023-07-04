package GUI;

import ClientModel.ClientModel;
import Utility.Tweet;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class SendTweet {

    private String userName;
    private GeneralController gc=new GeneralController();

    @FXML
    private TextArea Tweet;

    @FXML
    private TextField hashTag;

    @FXML
    private Button sendButton;

    public void setUserName(String userName){
        this.userName=userName;
    }

    @FXML
    void sendTweet(ActionEvent event) {
        String text=Tweet.getText();
        String hashTag=this.hashTag.getText();
        if(text.length()>280){
            gc.showResult("Too long");
        }
        Tweet tweet=new Tweet(userName, text, hashTag);
        String result=ClientModel.sendTweet(tweet);
        gc.showResult(result);
        Stage stage=(Stage)sendButton.getScene().getWindow();
        stage.close();
    }

}