package ClientModel;

import Utility.DataObject;
import Utility.User;

public class ClientModel{
    private static CheckSignUpData csud=new CheckSignUpData();
    
    public static String signUp(String firstName, String lastName, String userName, String email, String passWord, String confirmPassWord, String birthDate, String country, String phoneNumber){
        String result=null;
        if(csud.checkEmail(email)){
            if(csud.checkPassWord(passWord)){
                if(passWord.equals(confirmPassWord)){
                    if(csud.checkBirthdateFormat(birthDate)){
                        if(csud.checkPhoneNumber(phoneNumber)){
                            result="success";
                        } else{
                            result="wrong format or shorter than 7 digits";
                        }
                    } else{
                        result="wrong format dd/MM/yyyy";
                    }
                } else{
                    result="not the same as entered pass";
                }
            } else{
                result="wrong format small, capital, number, longer than 7";
            }
        } else{
            result="wrong format";
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
}