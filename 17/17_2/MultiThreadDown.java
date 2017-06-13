public class MultiThreadDown {
	public static void main(String[] args) throws Exception {
		//String path = "http://localhost:8080/manager/images/tomcat.gif";
		//String fileName = "cat.gif";
		String path = "http://www.crazyit.org/attachments/month_1403/1403202355ff6cc9a4fbf6f14a.png";
		String fileName = "ios.png";
		int threadNum = 4;
		DownUtil du = new DownUtil(path, fileName, threadNum);
		du.download();
		new Thread(() -> {
			while (du.getCompleteRate() < 1) {
				System.out.println("已完成：" + du.getCompleteRate());
				try {
					Thread.sleep(1000);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}).start();
	}
}
