package Utility;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java. time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Locale;

import javafx.scene.image.Image;

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

    public static byte[] imageToByteArray(Image image){
        if(image==null){
            return null;
        }
        String URL=image.getUrl();
        try {
            File file=new File(URL);
            byte [] data=Files.readAllBytes(file.toPath());
            return data;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String saveByteArray(byte[] data, String directory, String fileName){
        try {
            if(data==null){
                return null;
            }
            Files.createDirectories(Paths.get(directory));
            String location=directory+"\\"+fileName+".jpg";
            File file=new File(location);
            file.createNewFile();
            Files.write(file.toPath(), data);
            return location;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Image loadImageFromFile(String location){
        if(location==null || location.equals("")){
            return null;
        }
        return new Image("file:"+location);
    }
}
