import java.net.HttpURLConnection;

public class DownUtil
{
	private String path;
	private String targetFile;
	private int threadNum;
	private DownThread[] threads;
	private int fileSize;

	public DownUtil(String path, String targetFile, int threadNum)
	{
		this.path = path;
		this.threadNum = threadNum;
		threads = new DownThread[threadNum];
		this.targetFile = targetFile;
	}

	public void download() 
		throws Exception
	{
		URL url = new URL(path);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setConnectTimeout(5 * 1000);
		conn.setRequestMethod("GET");
		conn.setRequestProperty(
			"Accept",
			"image/gif, image/jpeg, image/pjpeg, image/pjpeg, "
			+ "application/x-shockwave-flash, application/xaml+xml, "
			+ "application/vnd.ms-xpsdocumnet, application/x-ms-xbap, "
			+ "application/x-ms-application, application/vnd.ms-excel, "
			+ "application/vnd.ms-powerpoint, application/msword, */*");
		conn.setRequestProperty("Accept-Language", "zh-CN");
		conn.setRequestProperty("Charset", "UTF-8");
		conn.setRequestProperty("Connection", "Keep-Alive");
		
		fileSize = conn.getContentLength();


	}
}
