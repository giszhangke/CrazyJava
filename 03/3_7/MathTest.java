public class MathTest
{
	public static void main(String args[])
	{
		double a = 3.2;
		double b = Math.pow(a,5);//��a��5�η�
		System.out.println(b);
		double c = Math.sqrt(a);//��a��ƽ����
		System.out.println(c);
		double d = Math.random();//���������������һ��0~1֮���α�����
		System.out.println(d);
		double e = Math.sin(1.57);//��1.57��sin����ֵ��1.57�����ɻ�����
		System.out.println(e);//����ӽ�1
		
		double x = -5.0;
		x = -x;//��x�󸺣���ֵ���5.0
		System.out.println(x);

	}
}
