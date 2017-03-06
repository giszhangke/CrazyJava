import java.time.*;
public class NewDatePackageTest
{
	public static void main(String[] args)
	{
		//---Clock---
		//获取当前Clock
		Clock clock = Clock.systemUTC();
		//通过Clock获取当前时刻
		System.out.println("当前时刻为：" + clock.instant());
		//获取clock对应的毫秒数，与Symtem.currentTimeMillis()输出相同
		System.out.println(clock.millis());
		System.out.println(System.currentTimeMillis());
		//---Duration---
		Duration d = Duration.ofSeconds(6000);
		System.out.println("6000秒相当于" + d.toMinutes() + "分");
		System.out.println("6000秒相当于" + d.toHours() + "小时"); 	
		System.out.println("6000秒相当于" + d.toDays() + "天");
		//在clock基础上增加6000秒，返回新的clock
		Clock clock2 = Clock.offset(clock,d);
		System.out.println("当前时刻加6000秒为：" + clock2.instant());
		
		//---Instant---
		Instant instant = Instant.now();
		System.out.println(instant);
		//instant 增加6000秒---
		Instant instant2 = instant.plusSeconds(6000);
		System.out.println(instant2);
		//根据字符串解析Instant对象
		Instant instant3 = Instant.parse("2016-10-29T10:12:36.342Z");
		System.out.println(instant3);
		//在Instant3的基础上增加5小时4分钟
		Instant instant4 = instant3.plus(Duration.ofHours(5).plusMinutes(4));
		System.out.println(instant4);
		//获取instant4的5天前的时刻
		Instant instant5 = instant4.minus(Duration.ofDays(5));
		System.out.println(instant5);
		
		//---LocalDate---
		//获取当前时间
		LocalDate localDate = LocalDate.now();
		System.out.println(localDate);
		//获取2016年的第200天
		localDate = LocalDate.ofYearDay(2016, 200);
		System.out.println(localDate);
		//设置为2016年5月1日
		localDate = LocalDate.of(2016, Month.MAY, 1);
		System.out.println(localDate);
		
		//---LocalTime---
		LocalTime localTime = LocalTime.now();
		localTime = LocalTime.of(22,33);
		System.out.println(localTime);
			
	}
}
