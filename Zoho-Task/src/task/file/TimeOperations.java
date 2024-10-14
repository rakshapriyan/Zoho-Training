package task.file;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class TimeOperations {
	
	public LocalDateTime getCurrentTime() {
        LocalDateTime currentTime = LocalDateTime.now();
        return currentTime;
    }

    public long getCurrentTimeMillis() {
        long timeMillis = Instant.now().toEpochMilli();
        return timeMillis;
    }
    
    
    public long getCurrentTimeMillisUsingSystem() {
        long timeMillis = System.currentTimeMillis();
        return timeMillis;
    }

    public String getTimeInZone(String zone) {
        ZonedDateTime timeInNewYork = ZonedDateTime.now(ZoneId.of(zone));
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return timeInNewYork.format(formatter);
    }

    public String getWeekDayFromMillis(long millis) {
        Instant instant = Instant.ofEpochMilli(millis);
        LocalDateTime dateTime = LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
        return dateTime.getDayOfWeek().toString();
    }

    public String getMonthFromMillis(long millis) {
        Instant instant = Instant.ofEpochMilli(millis);
        LocalDateTime dateTime = LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
        return dateTime.getMonth().toString();
    }

    public int getYearFromMillis(long millis) {
        Instant instant = Instant.ofEpochMilli(millis);
        LocalDateTime dateTime = LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
        return dateTime.getYear();
    }

}
