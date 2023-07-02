package Utility;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.Serializable;

import javax.imageio.ImageIO;

import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.Image;

public class User implements Serializable{
    private String userName;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String passWord;
    private String country;
    private String birthDate;
    private String bio;
    private String location;
    private String webSiteAddress;
    private String signUpDate;
    private String lastModified;
    private byte[] avatar;
    private byte[] header;

    public User(String userName, String phoneNumber, String country, String email, String passWord, String firstName, String lastName, String birthDate){
        this.userName=userName;
        this.firstName=firstName;
        this.lastName=lastName;
        this.email=email;
        this.phoneNumber=phoneNumber;
        this.passWord=passWord;
        this.country=country;
        this.birthDate=birthDate;
        this.bio=null;
        this.location=null;
        this.webSiteAddress=null;
        this.signUpDate=Time.getCurrentTime();
        this.lastModified=Time.getCurrentTime();
        this.avatar=null;
        this.header=null;
    }

    public void setPassWord(String pass){
        passWord=pass;
    }

    public void setBio(String bio){
        this.bio=bio;
        setLastModified(Time.getCurrentTime());
    }

    public void setLocation(String location){
        this.location=location;
        setLastModified(Time.getCurrentTime());
    }

    public void setWebSiteAddress(String webSiteAddress){
        this.webSiteAddress=webSiteAddress;
        setLastModified(Time.getCurrentTime());
    }

    public void setAvatar(Image image){
        this.avatar=Time.imageToByteArray(image);
        setLastModified(Time.getCurrentTime());
    }
    
    public void setHeader(Image image){
        this.header=Time.imageToByteArray(image);
        setLastModified(Time.getCurrentTime());
    }

    // public byte[] imageToByteArray(String URL){
    //     try {
    //         File file=new File(URL);
    //         byte [] data=Files.readAllBytes(file.toPath());
    //         // BufferedImage bImage = ImageIO.read(new File(URL));
    //         // ByteArrayOutputStream bos = new ByteArrayOutputStream();
    //         // ImageIO.write(bImage, "jpg", bos);
    //         // byte [] data = bos.toByteArray();
    //         return data;
    //     } catch (IOException e) {
    //         return null;
    //     }
    // }

    public void setSignUpDate(String date){
        signUpDate=date;
    }

    public void setLastModified(String currentTime){
        lastModified=currentTime;
    }

    public String[] getData(){
        String[] data=new String[13];
        data[0]=userName;
        data[1]=phoneNumber;
        data[2]=country;
        data[3]=email;
        data[4]=passWord;
        data[5]=firstName;
        data[6]=lastName;
        data[7]=birthDate;
        data[8]=bio;
        data[9]=location;
        data[10]=webSiteAddress;
        data[11]=signUpDate;
        data[12]=lastModified;
        return data;
    }

    public String getUserName() {
        return userName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getPassWord() {
        return passWord;
    }

    public String getCountry() {
        return country;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public String getBio() {
        return bio;
    }

    public String getLocation() {
        return location;
    }

    public String getWebSiteAddress() {
        return webSiteAddress;
    }

    public String getSignUpDate() {
        return signUpDate;
    }

    public String getLastModified() {
        return lastModified;
    }

    public byte[] getAvatarBytes(){
        return avatar;
    }

    public Image getAvatar() {
        if(avatar==null){
            return null;
        }
        return byteArrayToImage(avatar);
        // String URL=byteArrayToImage(avatar);
        // Image image=new Image(URL);
        // File f=new File(URL);
        // f.delete();
        // return image;
    }

    public byte[] getHeaderBytes(){
        return header;
    }

    public Image getHeader() {
        if(header==null){
            return null;
        }
        return byteArrayToImage(header);
        // String URL=byteArrayToImage(header);
        // Image image=new Image(URL);
        // File f=new File(URL);
        // f.delete();
        // return image;
    }

    public Image byteArrayToImage(byte[] data){
        ByteArrayInputStream bis = new ByteArrayInputStream(data);
        try {
            BufferedImage bufferedImage = ImageIO.read(bis);
            return SwingFXUtils.toFXImage(bufferedImage, null);
        } catch (IOException e) {
            return null;
        }
        
    }
}
// TODO: Saving and loading images according to JavaFX
