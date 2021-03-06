import java.util.List;
import java.util.ArrayList;
import java.nio.charset.Charset;
import java.nio.file.FileStore;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.FileOutputStream;

public class FilesTest {
	public static void main(String[] args) throws Exception {
		Files.copy(Paths.get("FilesTest.java"), new FileOutputStream("a.txt"));		
		System.out.println("文件是否为隐藏文件：" + Files.isHidden(Paths.get("FilesTest.java")));
		System.out.println("文件大小" + Files.size(Paths.get("FilesTest.java")));
		List<String> lines = Files.readAllLines(Paths.get("FilesTest.java"), Charset.forName("utf-8"));
		System.out.println(lines);
		List<String> poem = new ArrayList<>();
		poem.add("水晶潭底银鱼跃");
		poem.add("清徐风中碧杆横");
		Files.write(Paths.get("poem.txt"), poem, Charset.forName("utf-8"));
		//
		Files.list(Paths.get(".")).forEach(path -> System.out.println(path));
		Files.readAllLines(Paths.get("FilesTest.java"), Charset.forName("utf-8")).forEach(System.out::println);
		String root = Paths.get(".").toAbsolutePath().getRoot().toString();
		FileStore curStore = Files.getFileStore(Paths.get(root));
		System.out.println("当前盘的总空间为：" + curStore.getTotalSpace());
		System.out.println("当前盘的可用空间为: " + curStore.getUsableSpace());
	}
}
