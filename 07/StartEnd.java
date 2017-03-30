import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.ParseException;

public class StartEnd
{
	public static void main(String[] args) throws ParseException {
		String str = "Java is a great programing language";
		Matcher matcher = Pattern.compile("\\w+").matcher(str);
		while (matcher.find()) {
			System.out.println(matcher.group() + " " + matcher.start() + " " + matcher.end());
		}

		
		String[] strs = {"zhang@qq.com", "zk@yahoo.com", "damaha@xx.xx"};
		Pattern pattern2 = Pattern.compile("\\w{2,20}@\\w{2,10}\\.(com|org|cn|gvn)");
		Matcher matcher2 = pattern2.matcher("");
		for (String s : strs) {
			matcher2.reset(s);
			System.out.println(matcher2.matches() ? "Yes" : "No");
			System.out.println(matcher2.replaceAll("合法邮箱地址"));
			System.out.println(Arrays.toString(s.split("@")));
			System.out.println(s.replaceAll("\\w+","-"));
		}

		Date date = new Date();
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy年MM月dd日");
		String dateStr = sdf1.format(date);
		System.out.println(dateStr);
	}
}
