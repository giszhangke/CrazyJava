import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.FileVisitResult;
import java.nio.file.attribute.BasicFileAttributes;

public class FileVisitorTest {
	public static void main(String[] args) throws IOException {
		Path path = Paths.get("C:/Users/zhangke/Desktop/GitHub/git-code/CrazyJava/15");
		Files.walkFileTree(path, new SimpleFileVisitor<Path>(){
			@Override
			public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
				System.out.println("正在访问文件：" + file);
				if (file.endsWith("FileVisitorTest.java")) {
					System.out.println("文件FileVisitorTest.java已经找到了！");
					return FileVisitResult.TERMINATE;
				}
				return FileVisitResult.CONTINUE;
			}	
			@Override
			public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
				System.out.println("正在打开文件夹: " + dir);
				return FileVisitResult.CONTINUE;	
			}
		});
	}
}
