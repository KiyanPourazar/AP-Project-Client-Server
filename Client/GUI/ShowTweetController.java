package GUI;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

public class ShowTweetController {

    private int tweetId;

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
    private Button quote;

    @FXML
    private Button retweet;

    @FXML
    private Text retweetNo;

    @FXML
    private TextArea text;

    @FXML
    private TextField userName;

    public void setId(int id){
        tweetId=id;
    }

    @FXML
    void Like(ActionEvent event) {

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

    }

}