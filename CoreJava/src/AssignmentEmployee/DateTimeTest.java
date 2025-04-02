package AssignmentEmployee;

import static org.junit.jupiter.api.Assertions.*;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import org.junit.jupiter.api.Test;

class DateTimeTest {

	@Test
	void test() throws ParseException {
		Date now = new Date();
		System.out.println(now);
		
		Date independencday = new Date();
		System.out.println(independencday);
		
		/*
		 * yyyy - year
		 * MM - month -> MMM ex (aug)
		 * dd - day
		 * hour - hh
		 * minute - mm
 		 * second - ss
		 */
		
		DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
		System.out.println(df.format(independencday));
		Date republic = df.parse("26-01-1950");
		System.out.println(republic);
	}

}
