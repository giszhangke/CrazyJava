import java.lang.reflect.Field;
import java.awt.event.ActionListener;
import javax.swing.AbstractButton;

public class ActionListenerInstaller {
	public static void processAnnotations(Object obj) {
		try {
			Class cl = obj.getClass();
			for (Field f : cl.getDeclaredFields()) {
				// 将该成员变量设置为可自由访问
				f.setAccessible(true);
				ActionListenerFor a = f.getAnnotation(ActionListenerFor.class);
				// 获取成员变量f的值 
				Object fObj = f.get(obj);
				if (a != null && fObj != null && fObj instanceof AbstractButton) {
					Class<? extends ActionListener> listenerClazz = a.listener();
					// 使用反射创建listener类的实例对象
					ActionListener aL = listenerClazz.newInstance();
					AbstractButton aB = (AbstractButton)fObj;
					// 为按钮添加事件紧监听器
					aB.addActionListener(aL);	
				}
			}	
		} catch (Exception ex) {
			System.out.println(ex.getStackTrace());
		}
	}
}
