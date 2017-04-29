import java.io.File;

public class FilenameFilterTest {
	public static void main(String[] args) {
		File file = new File(".");
		// 使用Lambda表达式（目标类型为FilenameFilter）实现文件过滤器
		// 列出file目录下的java文件或子文件夹
		String[] fileList = file.list((dir, name) -> name.endsWith(".java") || new File(name).isDirectory());
		for (String fileName : fileList) {
			System.out.println(fileName);
		}
	}	
}
