
package AssignmentEmployee;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.junit.jupiter.api.Test;

class LocalDateTest {
	
	@Test
	void testDateTime() {
		LocalDateTime iday = LocalDateTime.of(1947,8,15,9,15,10);
		System.out.println(iday);
	}
	

	@Test
	void test() {

	
		LocalDate ld = LocalDate.of(1947, 8, 15);
		System.out.println(ld);
		LocalDate ld1 = ld.minusDays(1);
		System.out.println(ld1);
		
		LocalDate ld2 = ld1.plusDays(1);
		System.out.println(ld2);
		
		DateTimeFormatter dft = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		System.out.println(dft.format(ld2));
		
		System.out.println(LocalDate.parse("2025-03-25"));
	}

}
