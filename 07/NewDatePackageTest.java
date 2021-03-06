import java.time.Clock;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.Year;
import java.time.YearMonth;
import java.time.MonthDay;

public class NewDatePackageTest
{
	public static void main(String[] args) {
		// Clock
		Clock clock = Clock.systemUTC();
		System.out.println("当前时刻为：" + clock.instant());
		System.out.println(clock.millis());
		System.out.println(System.currentTimeMillis());
		System.out.println("");

		// Duration
		Duration duration = Duration.ofSeconds(6000);
		System.out.println("6000秒相当于" + duration.toMinutes() + "分");
		System.out.println("6000秒相当于" + duration.toHours() + "小时");
		System.out.println("6000秒相当于" + duration.toDays() + "天");
		System.out.println("");		

		// Instant
		Instant instant = Instant.now();//这里得到时间是UTC，北京时间比UTC快8小时
		System.out.println("Instant.now(): " + instant);
		Instant instant2 = instant.plusSeconds(6000);//添加100分钟
		System.out.println(instant2);
		Instant instant3 = Instant.parse("2014-02-23T10:12:35.342Z");
		System.out.println(instant3);
		// 在instant3的基础上添加5小时4分钟
		Instant instant4 = instant3.plus(Duration.ofHours(5).plusMinutes(4));
		System.out.println(instant4);
		// 在instant4的基础上添加10天, 获取instant4的10天前的时刻
		Instant instant5 = instant4.plus(Duration.ofDays(10));
		System.out.println(instant5);
		
		// LocalDate
		LocalDate localDate = LocalDate.now();
		System.out.println(localDate);
		// 获取2017年的第145天
		localDate = LocalDate.ofYearDay(2017, 145);
		System.out.println(localDate);
		// 设置为2017年4月5日
		localDate = LocalDate.of(2017, Month.APRIL, 5);
		System.out.println(localDate);

		// LocalTime
		LocalTime localTime = LocalTime.now();
		System.out.println(localTime);
		// 设置时间为5:32:6
		localTime = LocalTime.of(5, 32, 6);
		System.out.println(localTime);
		// 返回一天中的第5503秒的时间
		localTime = LocalTime.ofSecondOfDay(5503);
		System.out.println(localTime);
		
		// LocalDateTime
		LocalDateTime localDateTime = LocalDateTime.now();
		System.out.println(localDateTime);
		// 当前日期、时间加上25小时3分钟 
		// LocalDateTime添加时间的方法要与Duration添加时间的方法区别，
		// 特别是添加小时
		LocalDateTime future = localDateTime.plusHours(25).plusMinutes(3);
		System.out.println(future);
		
		// Year/Yearmonth/MonthDay
		Year year = Year.now();
		System.out.println(year);
		YearMonth yearMonth = year.atMonth(10);
		System.out.println(yearMonth);//输出2017-10
		year = year.plusYears(5);
		System.out.println(year);
		// 减5年加3个月
		yearMonth = yearMonth.minusYears(5).minusMonths(3);
		System.out.println(yearMonth);
		System.out.println(year);
		MonthDay monthDay = MonthDay.now();
		System.out.println(monthDay);
		// 设置为5月23日
		// 注意MonthDay添加时间的方式
		monthDay = monthDay.with(Month.MAY).withDayOfMonth(23);
		System.out.println(monthDay);// 输出 --5-23
	}
}
