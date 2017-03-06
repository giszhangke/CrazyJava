import java.time.*;
public class NewDatePackageTest
{
	public static void main(String[] args)
	{
		//---Clock---
		//��ȡ��ǰClock
		Clock clock = Clock.systemUTC();
		//ͨ��Clock��ȡ��ǰʱ��
		System.out.println("��ǰʱ��Ϊ��" + clock.instant());
		//��ȡclock��Ӧ�ĺ���������Symtem.currentTimeMillis()�����ͬ
		System.out.println(clock.millis());
		System.out.println(System.currentTimeMillis());
		//---Duration---
		Duration d = Duration.ofSeconds(6000);
		System.out.println("6000���൱��" + d.toMinutes() + "��");
		System.out.println("6000���൱��" + d.toHours() + "Сʱ"); 	
		System.out.println("6000���൱��" + d.toDays() + "��");
		//��clock����������6000�룬�����µ�clock
		Clock clock2 = Clock.offset(clock,d);
		System.out.println("��ǰʱ�̼�6000��Ϊ��" + clock2.instant());
		
		//---Instant---
		Instant instant = Instant.now();
		System.out.println(instant);
		//instant ����6000��---
		Instant instant2 = instant.plusSeconds(6000);
		System.out.println(instant2);
		//�����ַ�������Instant����
		Instant instant3 = Instant.parse("2016-10-29T10:12:36.342Z");
		System.out.println(instant3);
		//��Instant3�Ļ���������5Сʱ4����
		Instant instant4 = instant3.plus(Duration.ofHours(5).plusMinutes(4));
		System.out.println(instant4);
		//��ȡinstant4��5��ǰ��ʱ��
		Instant instant5 = instant4.minus(Duration.ofDays(5));
		System.out.println(instant5);
		
		//---LocalDate---
		//��ȡ��ǰʱ��
		LocalDate localDate = LocalDate.now();
		System.out.println(localDate);
		//��ȡ2016��ĵ�200��
		localDate = LocalDate.ofYearDay(2016, 200);
		System.out.println(localDate);
		//����Ϊ2016��5��1��
		localDate = LocalDate.of(2016, Month.MAY, 1);
		System.out.println(localDate);
		
		//---LocalTime---
		LocalTime localTime = LocalTime.now();
		localTime = LocalTime.of(22,33);
		System.out.println(localTime);
			
	}
}
