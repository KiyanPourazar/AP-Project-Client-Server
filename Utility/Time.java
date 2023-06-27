package Utility;

import java. time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Time {
    public static String getCurrentTime(){
        LocalDateTime current = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        return current.format(formatter);
    }
}
