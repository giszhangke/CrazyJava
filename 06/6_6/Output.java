package zhang;

public interface Output
{
	int MAX_CACHE_LINE = 50;
	void out();// ������ͽӿ��ж���ĳ��󷽷����ǲ���������ģ�������Ҫ������
	void getData(String msg);
	
	default void print(String... msgs) {
		for (String msg : msgs) {
			System.out.println(msg);	
		}
	}
	
	default void test() {
		System.out.println("ʵ��.test");
	}

	static String staticTest() {
		return "�ӿ�����෽��";
	}

}
