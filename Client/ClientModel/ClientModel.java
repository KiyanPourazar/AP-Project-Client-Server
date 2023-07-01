package ClientModel;

import Utility.DataObject;
import Utility.User;

public class ClientModel{
    private static CheckSignUpData csud=new CheckSignUpData();
    
    public static String signUp(String firstName, String lastName, String userName, String email, String passWord, String confirmPassWord, String birthDate, String country, String phoneNumber){
        // email pass confirm birth num
        // bro code for countries
        String result=null;
        if(result.equals("success")){
            User user=new User(userName, phoneNumber, country, email, passWord, firstName, lastName, birthDate);
            DataObject dataObject=new DataObject("sign-up", user);
            dataObject=DataManager.sendData(dataObject);
            return dataObject.getMethod();
        } else{
            return result;
        }
        // return "success";
    }
}