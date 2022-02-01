package study;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.format.annotation.DateTimeFormat;

public class LocalDateTimeDemo {
	public static void main(String[] args) {
		LocalDateTime now = LocalDateTime.now();
		System.out.println(now);
		LocalDateTime time1 = LocalDateTime.of(2022,1,22,0, 0); 
		System.out.println(time1);
		
		LocalDateTime now2 = LocalDate.now().atTime(0,0);
		System.out.println(now2);
		
		// 날짜 포맷 
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy년 MM월 dd일 hh시 mm분");
		System.out.println(dtf.format(now));
	}
}
