public class StaticAccessNonStatic
{
	public void info()
	{
		System.out.println("haha!");
	}

	public static void main(String[] args)
	{
		// �ھ�̬�����е��÷Ǿ�̬�����ᱨ��
		//info();
		// ʵ�������������������
		new StaticAccessNonStatic().info();
	}
}
