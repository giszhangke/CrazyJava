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
		System.out.println("��ǰʱ��Ϊ��" + clock.instant());
		System.out.println(clock.millis());
		System.out.println(System.currentTimeMillis());
		System.out.println("");

		// Duration
		Duration duration = Duration.ofSeconds(6000);
		System.out.println("6000���൱��" + duration.toMinutes() + "��");
		System.out.println("6000���൱��" + duration.toHours() + "Сʱ");
		System.out.println("6000���൱��" + duration.toDays() + "��");
		System.out.println("");		

		// Instant
		Instant instant = Instant.now();//����õ�ʱ����UTC������ʱ���UTC��8Сʱ
		System.out.println("Instant.now(): " + instant);
		Instant instant2 = instant.plusSeconds(6000);//����100����
		System.out.println(instant2);
		Instant instant3 = Instant.parse("2014-02-23T10:12:35.342Z");
		System.out.println(instant3);
		// ��instant3�Ļ���������5Сʱ4����
		Instant instant4 = instant3.plus(Duration.ofHours(5).plusMinutes(4));
		System.out.println(instant4);
		// ��instant4�Ļ���������10��, ��ȡinstant4��10��ǰ��ʱ��
		Instant instant5 = instant4.plus(Duration.ofDays(10));
		System.out.println(instant5);
		
		// LocalDate
		LocalDate localDate = LocalDate.now();
		System.out.println(localDate);
		// ��ȡ2017��ĵ�145��
		localDate = LocalDate.ofYearDay(2017, 145);
		System.out.println(localDate);
		// ����Ϊ2017��4��5��
		localDate = LocalDate.of(2017, Month.APRIL, 5);
		System.out.println(localDate);

		// LocalTime
		LocalTime localTime = LocalTime.now();
		System.out.println(localTime);
		// ����ʱ��Ϊ5:32:6
		localTime = LocalTime.of(5, 32, 6);
		System.out.println(localTime);
		// ����һ���еĵ�5503���ʱ��
		localTime = LocalTime.ofSecondOfDay(5503);
		System.out.println(localTime);
		
		// LocalDateTime
		LocalDateTime localDateTime = LocalDateTime.now();
		System.out.println(localDateTime);
		// ��ǰ���ڡ�ʱ�����25Сʱ3���� 
		// LocalDateTime����ʱ��ķ���Ҫ��Duration����ʱ��ķ�������
		// �ر�������Сʱ
		LocalDateTime future = localDateTime.plusHours(25).plusMinutes(3);
		System.out.println(future);
		
		// Year/Yearmonth/MonthDay
		Year year = Year.now();
		System.out.println(year);
		YearMonth yearMonth = year.atMonth(10);
		System.out.println(yearMonth);//���2017-10
		year = year.plusYears(5);
		System.out.println(year);
		// ��5���3����
		yearMonth = yearMonth.minusYears(5).minusMonths(3);
		System.out.println(yearMonth);
		System.out.println(year);
		MonthDay monthDay = MonthDay.now();
		System.out.println(monthDay);
		// ����Ϊ5��23��
		// ע��MonthDay����ʱ��ķ�ʽ
		monthDay = monthDay.with(Month.MAY).withDayOfMonth(23);
		System.out.println(monthDay);// ��� --5-23
	}
}