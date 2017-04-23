import java.lang.reflect.Method;

public class ProcessorTest {
	public static void process(String clazz) throws ClassNotFoundException {
		int passed = 0;
		int failed = 0;
		for (Method m : Class.forName(clazz).getMethods()) {
			if (m.isAnnotationPresent(Testable.class)) {
				try {
					m.invoke(null);
					passed++;
				} catch (Exception ex) {
					System.out.println("����" + m + "����ʧ�ܣ��쳣" + ex.getCause());
					failed++;
				}
			}	
		}
		System.out.println("��������" + (failed + passed) + "������"  + "\n" + "�ɹ���" + passed + "��" + "\n" + "ʧ����" + failed + "��");
	}	
}