import java.util.Map;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.lang.reflect.ParameterizedType;

public class GenericTest {
	private Map<String, Integer> score;
	public static void main(String[] args) throws Exception {
		Class<GenericTest> clazz = GenericTest.class;
		Field f = clazz.getDeclaredField("score");
		Class<?> a = f.getType();
		System.out.println("score的类型是：" + a);
		Type gType = f.getGenericType();
		if (gType instanceof ParameterizedType) {
			ParameterizedType pType = (ParameterizedType)gType;
			Type rType = pType.getRawType();
			System.out.println("原始类型是：" + rType);	
			Type[] tArgs = pType.getActualTypeArguments();
			System.out.println("泛型参数信息如下：");
			for (int i = 0; i < tArgs.length; i++) {
				System.out.println("第" + i + "个参数类型：" + tArgs[i]);
			}
		} else {
			System.out.println("没有获取到泛型类型！");
		}
	}	
}
