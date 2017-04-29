import java.nio.file.WatchService;
import java.nio.file.Paths;
import java.nio.file.FileSystems;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchKey;
import java.nio.file.WatchEvent;

public class WatchServiceTest {
	public static void main(String[] args) throws Exception {
		WatchService watchService = FileSystems.getDefault().newWatchService();
		// 为C盘注册监听事件
		Paths.get("C:/").register(watchService,
			StandardWatchEventKinds.ENTRY_CREATE,
			StandardWatchEventKinds.ENTRY_DELETE,
			StandardWatchEventKinds.ENTRY_MODIFY);
		while (true) {
			WatchKey key = watchService.take();
			for (WatchEvent<?> event : key.pollEvents()) {
				System.out.println(event.context() + "发生了" + event.kind() + "事件");
			}
			// 重设WatchKey
			boolean valid = key.reset();
			// 如果重设失败，则退出监听
			if (valid != true) {
				break;
			}
		}
	}
}
