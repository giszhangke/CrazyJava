public class RandomStr
{
	public static void main(String[] args)
	{
		String result = "";
		for(int i = 0 ; i < 6 ; i ++)//������� for(int i = 0 ; i < 6 ; i++); ��ѭ�����ڵ�����ֻ��ִ��һ�� 
		{
			int intVal = (int)(Math.random() * 26 + 97);				      	      result = result + (char)intVal;
		}

		System.out.println(result);
		
		//������䱨��
		//float a = 5.6;
		//��ȷд��Ϊ
		float a = (float)5.6;
		//�������Ͷ�Ӧ�İ�װ����԰��ַ���ת���ɻ�������
		String b="45";
		int iValue = Integer.parseInt(b);

		System.out.println(a);
		System.out.println(iValue);
		
	}
}

