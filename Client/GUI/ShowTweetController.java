package GUI;

import java.io.IOException;

import ClientModel.ClientModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ShowTweetController {

    private String mainUser;
    private int tweetId;
    private GeneralController gc=new GeneralController();

    @FXML
    private Button comment;

    @FXML
    private Text commentNo;

    @FXML
    private TextField date;

    @FXML
    private TextField hashTag;

    @FXML
    private Button like;

    @FXML
    private Text likeNo;

    @FXML
    private ImageView picture;

    @FXML
    private ImageView profile;

    @FXML
    private Button profileButton;

    @FXML
    private Button quote;

    @FXML
    private Button retweet;

    @FXML
    private Text retweetNo;

    @FXML
    private TextArea text;

    @FXML
    private TextField username;

    public void setId(int id){
        tweetId=id;
    }

    @FXML
    void Like(ActionEvent event) {
        String order=username+" | "+tweetId;
        String result=ClientModel.like(order);
        gc.showResult(result);
    }

    @FXML
    void addComment(ActionEvent event) {
        
    }

    @FXML
    void addQuote(ActionEvent event) {

    }

    @FXML
    void addReTweet(ActionEvent event) {

    }

    @FXML
    void showProfile(ActionEvent event) {
        try {
            FXMLLoader loader=new FXMLLoader(getClass().getResource("FXML/otherProfile.fxml"));
            Parent root = loader.load();
            ProfileController pc=loader.getController();
            pc.setUserName(username.getText(), mainUser);
            profileButton.getScene().setRoot(root);
        } catch (IOException e) {
            System.exit(-1);
        }
    }

}
