package ClientModel;

import Utility.DataObject;
import Utility.User;

public class ClientModel{
        public static String signUp(String firstName, String lastName, String userName, String email, String passWord, String confirmPassWord, String birthDate, String country, String phoneNumber){
        CheckSignUpData csud=new CheckSignUpData();
        String result=null;
        if(csud.checkEmail(email)){
            if(csud.checkPassWord(passWord)){
                if(passWord.equals(confirmPassWord)){
                    if(csud.checkBirthdateFormat(birthDate)){
                        if(csud.checkPhoneNumber(phoneNumber)){
                            result="success";
                        } else{
                            result="wrong phone number format";
                        }
                    } else{
                        result="wrong birthdate format dd/MM/yyyy";
                    }
                } else{
                    result="not the same as entered pass";
                }
            } else{
                result="wrong password format";
            }
        } else{
            result="wrong email format";
        }
        if(result.equals("success")){
            User user=new User(userName, phoneNumber, country, email, passWord, firstName, lastName, birthDate);
            DataObject dataObject=new DataObject("sign-up", user);
            dataObject=DataManager.sendData(dataObject);
            return dataObject.getMethod();
        } else{
            return result;
        }
    }

    public static String login(String order){
        DataObject dataObject=new DataObject("login", order);
        dataObject=DataManager.sendData(dataObject);
        return dataObject.getMethod();
    }

    public static DataObject getProfile(String userName){
        DataObject dataObject=new DataObject("get-profile", userName);
        dataObject=DataManager.sendData(dataObject);
        return dataObject;
    }

    public static String updateProfile(User user){
        DataObject dataObject=new DataObject("update-profile", user);
        dataObject=DataManager.sendData(dataObject);
        return dataObject.getMethod();
    }

    public static String showFollowers(String userName){
        DataObject dataObject=new DataObject("show-followers", userName);
        dataObject=DataManager.sendData(dataObject);
        return (String)dataObject.getObject();
    }

    public static String showBlocks(String userName){
        DataObject dataObject=new DataObject("show-blocks", userName);
        dataObject=DataManager.sendData(dataObject);
        return (String)dataObject.getObject();
    }

    public static String showFollowing(String userName){
        DataObject dataObject=new DataObject("show-following", userName);
        dataObject=DataManager.sendData(dataObject);
        return (String)dataObject.getObject();
    }
}