public class FloatTest
{
	public static void main(String[] args)
	{
		float af = 5.2345556f;
		//��ӡ���ʱaf��ֵ�Ѿ������˸ı�
		System.out.println("af: " + af);
		double a = 0.0;
		double c = Double.NEGATIVE_INFINITY;
		float d = Float.NEGATIVE_INFINITY;
		//float��double�ĸ����������ȵ�
		System.out.println("c==d: " + (c==d));
		//0.0����0.0�����ַ���
		System.out.println("a/a: " + (a/a));
		//��������֮���ǲ���ȵ�
		System.out.println("a/a == Float.NaN: " + (a/a == Float.NaN));
		//���������������ȵ�
		System.out.println("6.0/0 == 555.0/0: " + (6.0/0 == 555.0/0));
		//��������0.0�ȵ��������
		System.out.println(-8/a);

		try
		{
			//ֻ�и���������0�ſ��Եõ��������������
			//���һ������ֵ����0������׳�һ���쳣
			//������뽫�׳�����0���쳣
			System.out.println(0/0);
		}
		catch(Exception ex)
		{
			System.out.println(ex.getMessage());
			ex.printStackTrace();
		}

	}
}
