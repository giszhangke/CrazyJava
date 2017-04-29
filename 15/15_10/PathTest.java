import java.nio.file.Path;
import java.nio.file.Paths;

public class PathTest {
	public static void main(String[] args) {
		Path path = Paths.get(".");
		System.out.println("获取path包含的路径数: " + path.getNameCount());
		System.out.println("获取path根路径：" + path.getRoot());
		Path absolutePath = path.toAbsolutePath();
		System.out.println("获取绝对路径：" + absolutePath);
		System.out.println("获取绝对路径的根路径：" + absolutePath.getRoot());
		System.out.println("获取绝对路径的路径数：" + absolutePath.getNameCount());
		System.out.println("获取绝对路径的第四个路径" + absolutePath.getName(3));
		Path path2 = Paths.get("C:", "Users", "zhangke", "Desktop");
		System.out.println(path2);
	}
}
