import java.lang.reflect.Field;
import java.awt.event.ActionListener;
import javax.swing.AbstractButton;

public class ActionListenerInstaller {
	public static void processAnnotations(Object obj) {
		try {
			Class cl = obj.getClass();
			for (Field f : cl.getDeclaredFields()) {
				// ���ó�Ա��������Ϊ�����ɷ���
				f.setAccessible(true);
				ActionListenerFor a = f.getAnnotation(ActionListenerFor.class);
				// ��ȡ��Ա����f��ֵ 
				Object fObj = f.get(obj);
				if (a != null && fObj != null && fObj instanceof AbstractButton) {
					Class<? extends ActionListener> listenerClazz = a.listener();
					// ʹ�÷��䴴��listener���ʵ������
					ActionListener aL = listenerClazz.newInstance();
					AbstractButton aB = (AbstractButton)fObj;
					// Ϊ��ť�����¼���������
					aB.addActionListener(aL);	
				}
			}	
		} catch (Exception ex) {
			System.out.println(ex.getStackTrace());
		}
	}
}