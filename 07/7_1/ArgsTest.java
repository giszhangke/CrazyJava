import static java.lang.System.*;
import java.util.Scanner;
import java.util.Map;
import java.util.Properties;
import java.io.File;
import java.io.FileOutputStream;

public class ArgsTest
{
	public static void main(String[] args) throws Exception {
		//main method params
		out.println(args.length);	
		for (String arg : args) {
			out.println(arg);
		}
		
		Scanner s = new Scanner(in);//注意：in out 都是小写
		//s.useDelimiter("\n");
		while (s.hasNext()) {
			String a = s.next().toString();
			if (a.equals("000"))
				break;
			out.println("Print input content: " + a);
		}
		
		//Print file
		s = new Scanner(new File("ArgsTest.java"));
		out.println("Print the content of ArgsTest.java");
		while (s.hasNextLine()) {
			out.println(s.nextLine());
		}

		//Print enviroment params
		Map<String, String> envs = System.getenv();
		for (String name : envs.keySet()) {
			out.println(name + " --> " + envs.get(name));
		}
		out.println(System.getenv("JAVA_HOME"));
		out.println(System.getProperty("os.name"));
		Properties props = System.getProperties();
		props.store(new FileOutputStream("SystemProperties.txt"), "System Properties");

	}
}
