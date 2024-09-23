package task.file;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.TextStyle;
import java.util.Locale;

public class TimeOperations {
	
	public LocalDateTime getCurrentTime() {
        LocalDateTime currentTime = LocalDateTime.now();
        return currentTime;
    }

    public long getCurrentTimeMillis() {
        long timeMillis = System.currentTimeMillis();
        return timeMillis;
    }

    public ZonedDateTime getTimeInZone(String zone) {
        ZonedDateTime timeInNewYork = ZonedDateTime.now(ZoneId.of("America/New_York"));
        return timeInNewYork;
    }
    
    
    

    public String getWeekDayFromMillis(long millis) {
        Instant instant = Instant.ofEpochMilli(millis);
        LocalDateTime dateTime = LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
        return dateTime.getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.ENGLISH);
    }

    public String getMonthFromMillis(long millis) {
        Instant instant = Instant.ofEpochMilli(millis);
        LocalDateTime dateTime = LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
        return dateTime.getMonth().getDisplayName(TextStyle.FULL, Locale.ENGLISH);
    }

    public int getYearFromMillis(long millis) {
        Instant instant = Instant.ofEpochMilli(millis);
        LocalDateTime dateTime = LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
        return dateTime.getYear();
    }

}
