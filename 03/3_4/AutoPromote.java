public class AutoPromote
{
	public static void main(String[] args)
	{
		short sValue = 5;
		//����ı���ʽ���ұߵ�sValue���Զ�������int���ͣ������ߵı���ʽ����Ϊint
		//��һ��int����ֵ����short���ͱ�������������
		//sValue = sValue - 2;
		

		
		//��ȷ����
		byte b = 40;
		char c = 'a';//ASCII�� 97
		int i = 23;
		double d = .314;

		//����ʽ�ұ���ߵȼ�Ϊdouble���ͣ� ����һ��double���͵ı���	
		double result = b + c + i * d;
		System.out.println(result);

		
		//����ʽ�����ͽ��ϸ񱣳�����ߵȼ�����һ��
		int val = 3;
		int intResult = 23 / val;
		System.out.println(intResult);//�����7
		


		//����ַ���Hello!a7
		System.out.println("Hello!" + 'a' + 7);
		//����ַ���104Hello!
		System.out.println('a' + 7 + "Hello!");

		
		//String���ɱ��࣬������
		String s0 = "hello";
		String s1 = "hello";
		String s2 = "he" + "llo";
		System.out.println( s0 == s1);//true
		System.out.println( s0 == s2);//true

		String s3 = new String("asf");
		String s4 = new String("asf");
		System.out.println( s3 == s4);//false

	}
}