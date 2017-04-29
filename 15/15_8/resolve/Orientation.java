import java.io.Serializable;
import java.io.ObjectStreamException;

public class Orientation implements Serializable {
	public static final Orientation HORIZONTAL = new Orientation(1);
	public static final Orientation VERTICAL = new Orientation(2);
	private int value;

	private Orientation(int value) {
		this.value = value;
	}
	
	// 重写readResolve方法，确保静态返回值的一致
	private Object readResolve() throws ObjectStreamException {
		if (value == 1) {
			return HORIZONTAL;
		} else if (value == 2) {
			return VERTICAL;
		} 
		return null;
	}
}
