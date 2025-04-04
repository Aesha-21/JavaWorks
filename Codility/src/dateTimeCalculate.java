import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.Temporal;

public class dateTimeCalculate{
	
	public static void calculateDiffrence(String date1, String date2) {

	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yy HH:mm:ss");
	LocalDateTime localDateTime = LocalDateTime.now();
	LocalDateTime startTime = LocalDateTime.of(2022,11,5,9,30,0);
	LocalDateTime endTime = LocalDateTime.of(2025,3,7,3,55,0);

	Duration duration = Duration.between(startTime, endTime);

	long hours = duration.toHours();
	long minutes = duration.toMinutes() % 60;
	long seconds = duration.toSeconds()% 60;
	
	System.out.println("Diff" +date1+"&"+date2+"is:");
	System.err.println("Hours"+hours+"Minutes"+minutes+"Seconds"+seconds);
	
	}
	
	public static void main(String[] args) {
		
		String dt1 = "2022-11-5 9:30:00";
		String dt2 = "2025-3-7 3:55:00";
		calculateDiffrence(dt1,dt2);
		
	}
	
}
