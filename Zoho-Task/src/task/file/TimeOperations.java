package task.file;

import java.time.DayOfWeek;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.zone.ZoneRules;

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
        ZonedDateTime zonedDateTime = ZonedDateTime.now(ZoneId.of(zone));
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return zonedDateTime.format(formatter);
    }

    public DayOfWeek getWeekDayFromMillis(long millis) {
        Instant instant = Instant.ofEpochMilli(millis);
        LocalDateTime dateTime = LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
        return dateTime.getDayOfWeek();
    }

    public Month getMonthFromMillis(long millis) {
        Instant instant = Instant.ofEpochMilli(millis);
        LocalDateTime dateTime = LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
        return dateTime.getMonth();
    }

    public int getYearFromMillis(long millis) {
        Instant instant = Instant.ofEpochMilli(millis);
        LocalDateTime dateTime = LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
        return dateTime.getYear();
    }
    
    
    public void checkDST() {
    	ZonedDateTime now = ZonedDateTime.now( ZoneId.of( "America/Montreal" ) );
    	ZoneId z = now.getZone();
    	ZoneRules zoneRules = z.getRules();
    	Boolean isDst = zoneRules.isDaylightSavings( now.toInstant() );
    }

}
