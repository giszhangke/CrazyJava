import java.io.File;
import java.io.IOException;

public class FileTest {
	public static void main(String[] args) throws IOException {
		File file = new File(".");
		// 直接获取文件名
		System.out.println(file.getName());
		System.out.println(file.getParent());
		// 获取绝对路径
		System.out.println(file.getAbsoluteFile());
		// 获取上一级路径
		System.out.println(file.getAbsoluteFile().getParent());
		// 在当前路径下创建一个临时文件
		File tmpFile = File.createTempFile("aaa", ".txt", file);
		System.out.println("tmpFile是否存在: " + tmpFile.exists());
		// 指定当JVM退出时删除该文件
		tmpFile.deleteOnExit();
		// 以系统当前时间作为新文件名创建新文件
		System.out.println(System.currentTimeMillis() + "");
		File newFile = new File(System.currentTimeMillis() + "");
		System.out.println("newFile是否存在：" + newFile.exists());
		// 以指定的newFile对象来创建一个文件
		newFile.createNewFile();
		System.out.println("newFile是否存在：" + newFile.exists());
		// 以newFile对象来创建一个目录，因为newFile已经存在，所以无法用来创建目录
		System.out.println(newFile.mkdir());
		// 使用list()方法列出当前路径下的所有文件和路径
		System.out.println("当前路径下的所有文件和路径: ");
		String[] list = file.list();
		for (String name : list) {
			System.out.println(name);
		}
		// 使用listRoots()静态方法列出当前系统的所有根目录
		System.out.println("系统的所有根目录：");
		File[] roots = File.listRoots();
		for (File root : roots) {
			System.out.println(root);
		}
	}
}

