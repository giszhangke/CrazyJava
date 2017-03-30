import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.LocalDateTime;

public class DateTimeFormatterTest
{
	public static void main(String[] args) {
		DateTimeFormatter[] formatters = new DateTimeFormatter[] {
			DateTimeFormatter.ISO_LOCAL_DATE,
			DateTimeFormatter.ISO_LOCAL_TIME,
			DateTimeFormatter.ISO_LOCAL_DATE_TIME,
			DateTimeFormatter.ofLocalizedTime(FormatStyle.LONG),
			DateTimeFormatter.ofPattern("Gyyyy%%MMM%%dd HH:mm:ss")
		};
		LocalDateTime date = LocalDateTime.now();
		for(int i = 0; i < formatters.length; i++) {
			System.out.println(date.format(formatters[i]));
			System.out.println(formatters[i].format(date));
		}

		String dateString = "2017年8月4日 12:23:2";
		DateTimeFormatter dtf1 = DateTimeFormatter.ofPattern("yyyy年M月d日 H:m:s");
		LocalDateTime localDateTime = LocalDateTime.parse(dateString, dtf1);
		System.out.println(localDateTime);
	}
}
