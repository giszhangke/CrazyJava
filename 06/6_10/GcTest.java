import java.lang.ref.WeakReference;

public class GcTest
{
	private static GcTest g ;

	public void info() {
		System.out.println("测试资源回收");
	}

	public static void main(String[] args) throws Exception {
		for (int i = 0; i < 10; i++) {
			new GcTest();
		}
		
		// 下面一行代码在运行时报错NPE, 只有在资源回收调用finalize()时才会对静态变量g赋值
		// GcTest.g.info();

		Runtime.getRuntime().gc();
		Runtime.getRuntime().runFinalization();

		//System.gc();
		//System.runFinalization();
	
		GcTest.g.info();

		String a = new String("hahahaha!");
		WeakReference wr = new WeakReference(a);
		a = null;
		System.out.println(wr.get());
		Runtime.getRuntime().gc();
		Runtime.getRuntime().runFinalization();
		System.out.println(wr.get());

	}

	public void finalize() {
		System.out.println("资源回收中。。。call finalize()");
		g = this;

	}
}
