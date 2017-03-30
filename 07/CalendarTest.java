import static java.util.Calendar.*;
import java.util.Calendar;
import java.util.Date;

public class CalendarTest
{
	public static void main(String[] args) {
		Calendar calendar = Calendar.getInstance();
		Date date = calendar.getTime();
		//System.out.println(calendar);
		System.out.println(date);

		Calendar calendar2 = Calendar.getInstance();
		calendar2.setTime(date);
		//System.out.println(calendar2);
		System.out.println(date);

		System.out.println(calendar.get(YEAR));
		System.out.println(calendar.get(MONTH));
		System.out.println(calendar.get(DATE));

		// 设置时间为 2013-11-23 12:32:23
		calendar.set(2013, 10, 23, 12, 32, 23);
		System.out.println(calendar.getTime());
		calendar.add(YEAR, -1);
		System.out.println(calendar.getTime());
		calendar.roll(MONTH, 8);
		System.out.println(calendar.getTime());
		calendar.add(MONTH, 8);
		System.out.println(calendar.getTime());
		
		// Lenient参数检查
		calendar2.set(MONTH, 13);
		System.out.println(calendar2.getTime());
		//calendar2.setLenient(false); //取消这一行的注释，则下一行的代码抛异常
		calendar2.set(MONTH, 13);
		System.out.println(calendar2.getTime());

		// set延迟
		calendar.set(2017, 2, 31);// 2017-3-31
		calendar.set(MONTH, 3);// 不存在2017-4-31，会自动变成 2017-5-1
		//System.out.println(calendar.getTime());// 代码01
		calendar.set(DATE, 5);
		System.out.println(calendar.getTime());// 不注释代码01时输出日期2017-5-5， 若注释代码01输出日期是2017-4-5
	}
}
