public class IntegerValTest
{
	public static void main(String[] args)
	{
		//�� -128~+127 ֮�䣬ϵͳ���Զ���56����byte���ͣ�����Ĵ�������ȷ��
		byte a = 57;
		/*
		 * ����Ĵ����Ǵ���ģ�ϵͳ�����999999999999999����long���ʹ���
		 * ���Գ���int�ı�����Χ���Ӷ��������
		 * */
		// long bigValue = 999999999999999;
		// �����������ȷ�ģ��ھ޴������ֵ��ʹ��L��׺��ǿ��ʹ��long����
		long bigValue2 = 9199999999999993223L;
		
		System.out.println(bigValue2);

		//��0��ͷ������ֵ�ǰ˽��Ƶ�����
		int octalValue = 013;
		//��0x��0X��ͷ������ֵ��ʮ�����Ƶ�����
		int hexValue1 = 0x13;
		int hexValue2 = 0XaF;

		System.out.println(octalValue);
		System.out.println(hexValue1);
		System.out.println(hexValue2);

		//��������8λ�Ķ���������
		int binVal1 = 0b11010100;
		byte binVal2 = 0B01101001;
		//����һ��32λ�Ķ��������������λ�Ƿ���λ
		//����������binVal3ת��ʮ���ƵĹ���
		//1. ����(������Բ������ʽ�������е�����)��1�õ�����
		//2. �������λ���䣬����λȡ���õ�ԭ��
		int binVal3 = 0B10000000000000000000000000000011;
		System.out.println(binVal1);
		System.out.println(binVal2);
		System.out.println(binVal3);

	}
}
