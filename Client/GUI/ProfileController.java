package GUI;

import java.io.File;
import java.io.IOException;

import ClientModel.ClientModel;
import Utility.DataObject;
import Utility.Time;
import Utility.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;

public class ProfileController{

    private GeneralController gc=new GeneralController();
    private String mainUser;

    @FXML
    private TextField accountLocation;

    @FXML
    private ImageView avatar;

    @FXML
    private TextArea bio;

    @FXML
    private Text birthDate;

    @FXML
    private Text country;

    @FXML
    private Text email;

    @FXML
    private Text firstName;

    @FXML
    private ImageView header;

    @FXML
    private Text lastModified;

    @FXML
    private Text lastName;

    @FXML
    private TextField passWord;

    @FXML
    private Text phoneNumber;

    @FXML
    private Text signUpDate;

    @FXML
    private Button update;

    @FXML
    private Text userName;

    @FXML
    private TextField web;

    @FXML
    private Button back;

    @FXML
    private Button follow;

    @FXML
    private Button block;

    public void setUserName(String userName, String mainUser){
        this.mainUser=mainUser;
        this.userName.setText(userName);
        DataObject dataObject=ClientModel.getProfile(userName);
        if(dataObject.getMethod().equals("success")){
            User user=(User)dataObject.getObject();
            setData(user, mainUser);
        } else{
            gc.showResult(dataObject.getMethod());
        }
    }

    public void setData(User user, String mainUser){
        this.mainUser=mainUser;
        passWord.setText(user.getPassWord());
        firstName.setText(user.getFirstName());
        lastName.setText(user.getLastName());
        email.setText(user.getEmail());
        bio.setText(user.getBio());
        phoneNumber.setText(user.getPhoneNumber());
        country.setText(user.getCountry());
        accountLocation.setText(user.getLocation());
        web.setText(user.getWebSiteAddress());
        birthDate.setText(user.getBirthDate());
        lastModified.setText(user.getLastModified());
        signUpDate.setText(user.getSignUpDate());
        // Image avatar=user.getAvatar();
        // Image header=user.getHeader();
        // if(avatar!=null){
        //     this.avatar.setImage(avatar);
        // }
        // if(header!=null){
        //     this.header.setImage(header);
        // }
    }

    @FXML
    void setAvatar(MouseEvent event) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Choose Avatar");
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("PNG Files", "*.png"), 
        new FileChooser.ExtensionFilter("JPG Files", "*.JPG"), new FileChooser.ExtensionFilter("JPEG Files", "*.JPEG"));
        File selectedFile = fileChooser.showOpenDialog(header.getScene().getWindow());
        if(selectedFile!=null){
            avatar.setImage(new Image(selectedFile.toString()));
        }
    }

    @FXML
    void setHeader(MouseEvent event) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Choose Header");
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("PNG Files", "*.png"), 
        new FileChooser.ExtensionFilter("JPG Files", "*.JPG"), new FileChooser.ExtensionFilter("JPEG Files", "*.JPEG"));
        File selectedFile = fileChooser.showOpenDialog(header.getScene().getWindow());
        if(selectedFile!=null){
            header.setImage(new Image(selectedFile.toString()));
        }
    }

    @FXML
    void updateProfile(ActionEvent event) {
        User user=new User(userName.getText(), phoneNumber.getText(), country.getText(), email.getText(), passWord.getText(), firstName.getText(), lastName.getText(), birthDate.getText());
        
        // user.setAvatar(avatar.getImage());
        // user.setHeader(header.getImage());
        user.setBio(bio.getText());
        user.setWebSiteAddress(web.getText());
        user.setLocation(accountLocation.getText());
        user.setSignUpDate(signUpDate.getText());
        user.setLastModified(Time.getCurrentTime());
        String result=ClientModel.updateProfile(user);
        gc.showResult(result);
    }

    @FXML
    void back(ActionEvent event) {
        try {
            FXMLLoader loader=new FXMLLoader(getClass().getResource("FXML/mainMod.fxml"));
            Parent root = loader.load();
            MainController mc=loader.getController();
            mc.setUserName(userName.getText());
            back.getScene().setRoot(root);
        } catch (IOException e) {
            System.exit(-1);
        }
    }

    @FXML
    void blockUser(ActionEvent event) {
        String order=userName.getText()+" | "+mainUser;
        String result=ClientModel.block(order);
        gc.showResult(result);
    }

    @FXML
    void followUser(ActionEvent event) {
        String order=userName.getText()+" | "+mainUser;
        String result=ClientModel.follow(order);
        gc.showResult(result);
    }
}