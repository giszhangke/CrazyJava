import java.lang.reflect.Method;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class CompileClassLoader extends ClassLoader {
	private byte[] getBytes(String fileName) throws IOException {
		File file = new File(fileName);	
		long fileLength = file.length();
		byte[] fileBytes = new byte[(int)fileLength];
		try (
			FileInputStream inFileStream = new FileInputStream(file);
		) {
			int r = inFileStream.read(fileBytes);
			if (r != fileLength) {
				throw new IOException("无法读取全部文件");
			}
			return fileBytes;	
		}		
	}

	private boolean compile(String javaFile) throws IOException {
		System.out.println("CompileClassLoader: 正在编译" + javaFile + "...");
		Process p = Runtime.getRuntime().exec("javac " + javaFile);
		try {
			p.waitFor();
		} catch (InterruptedException ie) {
			System.out.println(ie);
		}
		int ret = p.exitValue();
		return ret == 0;
	}

	protected Class<?> findClass(String name) throws ClassNotFoundException {
		Class clazz = null;
		// 把路径中的 . 变成 / 	
		String fileStub = name.replace(".", "/");
		String javaFileName = fileStub + ".java";
		String classFileName = fileStub + ".class";
		File javaFile = new File(javaFileName);
		File classFile = new File(classFileName);	
		if (javaFile.exists() 
			&& (!classFile.exists() || javaFile.lastModified() > classFile.lastModified())) {
			try {
				if (!compile(javaFileName) || !classFile.exists()) {
					throw new ClassNotFoundException("ClassNotFoundException: " + javaFileName);
				}
			} catch (IOException ioe) {
				ioe.printStackTrace();
			}
		}
		
		// 如果class文件存在，则将class文件转换成Class对象
		if (classFile.exists()) {
			try {
				byte[] raw = getBytes(classFileName);	
				clazz = defineClass(name, raw, 0, raw.length);
		
			} catch (IOException ioe) {
				ioe.printStackTrace();
			}
		}

		if (clazz == null) {
			throw new ClassNotFoundException(name);
		}

		return clazz;
	}

	public static void main(String[] args) throws Exception {
		if (args.length < 1) {
			System.out.println("缺少目标类，请按如下格式运行源文件：");
			System.out.println("java CompileClassLoader ClassName");
		}	
		
		String progClass = args[0];
		String[] progArgs = new String[args.length - 1];
		System.arraycopy(args, 1, progArgs, 0, progArgs.length);
		CompileClassLoader ccLoader = new CompileClassLoader();
		Class clazz = ccLoader.loadClass(progClass);
		Method main = clazz.getMethod("main", (new String[0]).getClass());
		Object[] argsArray = {progArgs};
		main.invoke(null, argsArray);
	}
}
