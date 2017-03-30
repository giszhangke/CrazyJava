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

		// ����ʱ��Ϊ 2013-11-23 12:32:23
		calendar.set(2013, 10, 23, 12, 32, 23);
		System.out.println(calendar.getTime());
		calendar.add(YEAR, -1);
		System.out.println(calendar.getTime());
		calendar.roll(MONTH, 8);
		System.out.println(calendar.getTime());
		calendar.add(MONTH, 8);
		System.out.println(calendar.getTime());
		
		// Lenient�������
		calendar2.set(MONTH, 13);
		System.out.println(calendar2.getTime());
		//calendar2.setLenient(false); //ȡ����һ�е�ע�ͣ�����һ�еĴ������쳣
		calendar2.set(MONTH, 13);
		System.out.println(calendar2.getTime());

		// set�ӳ�
		calendar.set(2017, 2, 31);// 2017-3-31
		calendar.set(MONTH, 3);// ������2017-4-31�����Զ���� 2017-5-1
		//System.out.println(calendar.getTime());// ����01
		calendar.set(DATE, 5);
		System.out.println(calendar.getTime());// ��ע�ʹ���01ʱ�������2017-5-5�� ��ע�ʹ���01���������2017-4-5
	}
}
