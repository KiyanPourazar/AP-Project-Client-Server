package Utility;

import java. time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Time {
    public static String getCurrentTime(){
        LocalDateTime current = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return current.format(formatter);
    }
}
