package Utility;

import java. time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Locale;

public class Time {
    public static String getCurrentTime(){
        LocalDateTime current = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return current.format(formatter);
    }

    public static HashMap<String, String> getCountryCodes(){
        HashMap<String, String> countryList=new HashMap<String, String>();
        String[] locales=Locale.getISOCountries();
        String countryCode;
        String countryName;
        for(String locale:locales){
            Locale countryDetails = Locale.of("en", locale);
            countryCode=countryDetails.getCountry();
            countryName=countryDetails.getDisplayCountry();
            countryList.put(countryName, countryCode);
        }
        return countryList;
    }
}
