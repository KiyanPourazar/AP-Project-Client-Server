package GUI;

import java.io.IOException;

import ClientModel.ClientModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class MainController {

    private GeneralController gc= new GeneralController();
    private String userName;

    @FXML
    private Button addTweet;

    @FXML
    private Button blocks;

    @FXML
    private Button followers;

    @FXML
    private Button following;

    @FXML
    private Button hashtagSearch;

    @FXML
    private Button myProfile;

    @FXML
    private Button search;

    @FXML
    private Text tweet1;

    @FXML
    private Text tweet10;

    @FXML
    private Text tweet2;

    @FXML
    private Text tweet3;

    @FXML
    private Text tweet4;

    @FXML
    private Text tweet5;

    @FXML
    private Text tweet6;

    @FXML
    private Text tweet7;

    @FXML
    private Text tweet8;

    @FXML
    private Text tweet9;

    public void setUserName(String userName){
        this.userName=userName;
    }

    @FXML
    void addTweet(ActionEvent event) {
        try {
            FXMLLoader loader=new FXMLLoader(getClass().getResource("FXML/sendTweet.fxml"));
            Parent root = loader.load();
            SendTweet pc=loader.getController();
            pc.setUserName(userName);
            Stage stage=new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            System.exit(-1);
        }
    }

    @FXML
    void searchHashTag(ActionEvent event) {

    }

    @FXML
    void searchUser(ActionEvent event) {
        try {
            FXMLLoader loader=new FXMLLoader(getClass().getResource("FXML/searchUser.fxml"));
            Parent root = loader.load();
            SearchUser pc=loader.getController();
            pc.setMainUser(userName);
            addTweet.getScene().setRoot(root);
        } catch (IOException e) {
            System.exit(-1);
        }
        gc.setScene(addTweet, "FXML/searchUser.fxml");
    }

    @FXML
    void showProfile(ActionEvent event) {
        try {
            FXMLLoader loader=new FXMLLoader(getClass().getResource("FXML/profile.fxml"));
            Parent root = loader.load();
            ProfileController pc=loader.getController();
            pc.setUserName(userName, userName);
            addTweet.getScene().setRoot(root);
        } catch (IOException e) {
            System.exit(-1);
        }
    }

    public void showTweet(Text tweet){
        int tweetId=Integer.parseInt(tweet.getText());
        try {
            FXMLLoader loader=new FXMLLoader(getClass().getResource("FXML/showtweet.fxml"));
            Parent root = loader.load();
            ShowTweetController stc=loader.getController();
            stc.setId(tweetId);
            addTweet.getScene().setRoot(root);
        } catch (IOException e) {
            System.exit(-1);
        }
    }

    public void showThree(String result){
        try {
            FXMLLoader loader=new FXMLLoader(getClass().getResource("FXML/follower.fxml"));
            Parent root = loader.load();
            FollowerController pc=loader.getController();
            pc.setTextField(result);
            addTweet.getScene().setRoot(root);
        } catch (IOException e) {
            System.exit(-1);
        }
    }

    @FXML
    void showBlocks(ActionEvent event) {
        String result=ClientModel.showBlocks(userName);
        showThree(result);
    }

    @FXML
    void showFollowers(ActionEvent event) {
        String result=ClientModel.showFollowers(userName);
        showThree(result);
    }

    @FXML
    void showFollowing(ActionEvent event) {
        String result=ClientModel.showFollowing(userName);
        showThree(result);
    }

    @FXML
    void showtTweet1(MouseEvent event) {

    }

    @FXML
    void showtTweet2(MouseEvent event) {

    }

    @FXML
    void showtTweet3(MouseEvent event) {

    }

    @FXML
    void showtTweet4(MouseEvent event) {

    }

    @FXML
    void showtTweet5(MouseEvent event) {

    }

    @FXML
    void showtTweet6(MouseEvent event) {

    }

    @FXML
    void showtTweet7(MouseEvent event) {

    }

    @FXML
    void showtTweet8(MouseEvent event) {

    }

    @FXML
    void showtTweet9(MouseEvent event) {

    }

    @FXML
    void showtTweet10(MouseEvent event) {

    }
}
