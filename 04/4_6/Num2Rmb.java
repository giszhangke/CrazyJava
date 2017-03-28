import java.util.Arrays;

public class Num2Rmb
{
	private String[] hanArr = {"零", "壹", "贰", "叁", "肆", "伍", "陆", "柒", "捌", "玖"};
	private String[] unitArr = {"十", "百", "千"};

	private String[] divide(double num)
	{
		long zheng = (long)num;
		long xiao = Math.round((num - zheng) * 100);
		return new String[]{zheng + "", String.valueOf(xiao)};
	}

	/**
	 * 把一个四位的数字字符串变成汉字字符串
	 * @param numStr 需要被转换的四位的数字字符串
	 * @return 四位的数字字符串被转换成汉字字符串
	 */
	private String toHanStr(String numStr)
	{
		String result = "";
		int numLen = numStr.length();

		for (int i = 0; i < numLen; i++)
		{
			// 把char型数字转换成int型数字, 因为它们的ASCII码值恰好相差48
			// 因此把char型数字送去48得到int型数字, 例如'4'被转换成4
			int num = numStr.charAt(i) - 48;
			// 如果不是最后一位数字, 而且数字不是零, 则需要添加单位(千, 百, 十)
			if (i != numLen - 1 && num != 0)
			{
				result += hanArr[num] + unitArr[numLen - 2 - i];
			}
			// 否则不要添加单位
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
