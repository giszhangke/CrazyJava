import static java.lang.System.out;
import java.util.Objects;

public class IdentityHashCodeTest
{
	static IdentityHashCodeTest objTest;// = new IdentityHashCodeTest();

	public static void main(String[] args) throws Exception {
		String s1 = new String("zhangke");
		String s2 = new String("zhangke");		
		out.println(s1.hashCode() + " " + s2.hashCode());
		out.println(System.identityHashCode(s1) + " " + System.identityHashCode(s2));
		String s3 = "kezhang";
		String s4 = "kezhang";		
		out.println(System.identityHashCode(s3) + " " + System.identityHashCode(s4));

		Runtime rt = Runtime.getRuntime();
		out.println("������������" + rt.availableProcessors());
		out.println("�����ڴ棺" + rt.freeMemory());
		out.println("���ڴ�����" + rt.totalMemory());
		out.println("��������ڴ�����" + rt.maxMemory());

		//rt.exec("notepad.exe");

		out.println(Objects.hashCode(objTest));
		out.println(Objects.toString(objTest));
		out.println(Objects.requireNonNull(objTest, "��ָ��"));		
	}
}