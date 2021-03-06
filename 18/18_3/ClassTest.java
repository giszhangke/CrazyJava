import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Field;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.Annotation;
import java.lang.annotation.RetentionPolicy;
import java.util.Arrays;

@Repeatable(Annos.class)
@interface Anno {}

@Retention(value = RetentionPolicy.RUNTIME)
@interface Annos {
	Anno[] value();
}

@SuppressWarnings(value = "unchecked")
@Deprecated
// 使用重复注解
@Anno
@Anno
public class ClassTest {
	private ClassTest() {}
	public ClassTest(String name) {
		System.out.println("正在执行有参数的构造函数：" + name);
	}	
	public void info() {
		System.out.println("正在执行无参数的info函数");
	}
	public void info(String msg) {
		System.out.println("正在执行有参数的info函数：" + msg);
	}
	// 定义一个内部类
	class Inner {}
	public static void main(String[] args) throws Exception {
		// 获取ClassTest类的class属性值
		Class clazz = ClassTest.class;

		Constructor[] constructors = clazz.getDeclaredConstructors();
		System.out.println("以下是ClassTest类的所有构造函数");
		for (Constructor constructor : constructors) {
			System.out.println(constructor);
		}	
		Constructor[] publicConstructors = clazz.getConstructors();
		System.out.println("以下是ClassTest类的所有公有构造函数");
		for (Constructor publicConstructor : publicConstructors) {
			System.out.println(publicConstructor);
		}
		
		Method[] publicMethods = clazz.getMethods();
		System.out.println("获取ClassTest类的所有公有方法");
		for (Method method : publicMethods) {
			System.out.println(method);	
		}
		System.out.println("获取带有一个参数的info方法");
		System.out.println(clazz.getMethod("info", String.class));

		Annotation[] annotations = clazz.getAnnotations();
		System.out.println("ClassTest类的全部Annotation如下");
		for (Annotation annotation : annotations) {
			System.out.println(annotation);
		}
		System.out.println("ClassTest类的@SuppressWarnings注解为：");
		System.out.println(Arrays.toString(clazz.getAnnotationsByType(SuppressWarnings.class)));
		System.out.println("ClassTest类的@Anno注解为：");
		System.out.println(Arrays.toString(clazz.getAnnotationsByType(Anno.class)));
		Class<?>[] inners = clazz.getDeclaredClasses();
		System.out.println("ClassTest类的全部内部类如下");
		for (Class inner : inners) {
			System.out.println(inner);
		}
		// 使用Class.forName(String className)方法加载内部类
		Class innerClazz = Class.forName("ClassTest$Inner");
		System.out.println("innerClazz对应的外部类为：" + innerClazz.getDeclaringClass());
		System.out.println("ClassTest类所在的包为：" + clazz.getPackage());
		System.out.println("ClassTest类所在的父类为：" + clazz.getSuperclass());
	}
}
