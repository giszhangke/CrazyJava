public class CharTest
{
	public CharTest()
	{}

	public static void main(String[] args)
	{
		char aChar = 'a';
		System.out.println(aChar);		
		char enterChar = '\r';
		System.out.println(enterChar);//����س�
		char ch = '\u9999';//ͨ��Unicodeָ������
		System.out.println(ch);//������֡��㡱		
		char zhong = '��';
		System.out.println(zhong);//������֡��衱		
		int zhongValue = zhong;//ֱ�Ӱ�char���ͱ�������һ��int���ͱ���
		System.out.println(zhongValue);
		char c = 97;//ֱ�Ӱ�һ��0~65535��Χ�ڵ�int������ֵ��char����
		System.out.println(c);//�����ĸ��a��

	}
}
