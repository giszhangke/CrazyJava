import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FindGroup
{
	public static void main(String[] args) {
		String str = "���ǿƳ����ҵ���ϵ��ʽ��13500001111"
			+ "��������ϵ��ʽ��13688829993"
			+ "�᳤����ϵ��ʽ��13788829993";
		Matcher m = Pattern.compile("(13[5-7])\\d{8}").matcher(str);

		while (m.find()) {
			System.out.println(m.group());
		}
	}
}