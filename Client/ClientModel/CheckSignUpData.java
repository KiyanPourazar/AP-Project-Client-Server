package ClientModel;

import java.util.HashMap;
import java.util.Locale;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CheckSignUpData {
    public boolean checkData(String regex, String data){
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(data);
        return matcher.matches();
    }

    public boolean checkEmail(String email){
        String regex = "^[\\w!#$%&amp;'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&amp;'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
        return checkData(regex, email);
    }

    public boolean checkPhoneNumber(String phoneNumber){
        String regex = "^\\d{7,16}$";
        return checkData(regex, phoneNumber);
    }

    public HashMap<String, String> showCountryCodes(){
        HashMap<String, String> countryList=new HashMap<String, String>();
        String[] locales=Locale.getISOCountries();
        String countryCode;
        String countryName;
        for(String locale:locales){
            Locale countryDetails = Locale.of("en", locale);
            countryCode=countryDetails.getCountry();
            countryName=countryDetails.getDisplayCountry();
            countryList.put(countryCode, countryName);
            System.out.println(countryCode+":"+countryName);
        }
        return countryList;
    }

    public boolean checkCountryCode(String country, HashMap<String, String> countryList){
        String regex = "^[A-Z]{2}$";
        if(checkData(regex, country)==false){
            return false;
        }
        if(!countryList.containsKey(country)){
            return false;
        }
        return true;
    }

    public boolean checkBirthdateFormat(String birthDate){
        String regex = "^(0[1-9]|[12][0-9]|[3][01])/(0[1-9]|1[012])/\\d{4}$";
        return checkData(regex, birthDate);
    }

    public boolean checkPassWord(String passWord){
        String regex = "^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9]).{8,}$";
        return(checkData(regex, passWord));
    }

    public boolean repeatPassWord(String passWord, Scanner scanner){
        String newPass=scanner.nextLine();
        if(newPass.equals(passWord)){
            return true;
        } 
        return false;
    }
}
