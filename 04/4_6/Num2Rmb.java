import java.util.Arrays;

public class Num2Rmb
{
	private String[] hanArr = {"��", "Ҽ", "��", "��", "��", "��", "½", "��", "��", "��"};
	private String[] unitArr = {"ʮ", "��", "ǧ"};

	private String[] divide(double num)
	{
		long zheng = (long)num;
		long xiao = Math.round((num - zheng) * 100);
		return new String[]{zheng + "", String.valueOf(xiao)};
	}

	/**
	 * ��һ����λ�������ַ�����ɺ����ַ���
	 * @param numStr ��Ҫ��ת������λ�������ַ���
	 * @return ��λ�������ַ�����ת���ɺ����ַ���
	 */
	private String toHanStr(String numStr)
	{
		String result = "";
		int numLen = numStr.length();

		for (int i = 0; i < numLen; i++)
		{
			// ��char������ת����int������, ��Ϊ���ǵ�ASCII��ֵǡ�����48
			// ��˰�char��������ȥ48�õ�int������, ����'4'��ת����4
			int num = numStr.charAt(i) - 48;
			// ����������һλ����, �������ֲ�����, ����Ҫ��ӵ�λ(ǧ, ��, ʮ)
			if (i != numLen - 1 && num != 0)
			{
				result += hanArr[num] + unitArr[numLen - 2 - i];
			}
			// ����Ҫ��ӵ�λ
			else
			{
				result += hanArr[num];
			}
		}

		return result;
	}

	public static void main(String[] args)
	{
		Num2Rmb nr = new Num2Rmb();
		System.out.println(Arrays.toString(nr.divide(12455296966.236)));
		System.out.println(nr.toHanStr("6109"));

	}
}
