import java.util.List;
import java.util.ArrayList;
import java.util.function.Consumer;

class Apple<T extends Number> {
	T size;

	public Apple() {}

	public Apple(T size) {
		this.size = size;
	}

	public void setSize(T size) {
		this.size = size;
	}

	public T getSize() {
		return size;
	}
}

public class ErasureTest {
	public static void main(String[] args) {
		Apple<Integer> a1 = new Apple<Integer>(8);
		Integer a1Size = a1.getSize();
		System.out.println(a1Size);
		Apple a3 = a1;//类型擦除
		Apple<Number> a2 = a3;
		Number a2Sn = a2.getSize();
		System.out.println(a2Sn);
		//下一行代码编译报错， 类型不一致
		//Integer a2Si = a2.getSize();	
		
		List<Integer> list1 = new ArrayList();
		list1.add(8);
		list1.add(32);
		List list2 = list1;
		List<String> list3 = new ArrayList();
		list3 = list2;
		list3.add("q");
		list3.forEach(new Consumer(){
			public void accept(Object ele) {
				if (ele instanceof String) {
					System.out.println(ele);
				} else if(ele instanceof Integer) {
					System.out.println((Integer)ele * 10);
				}
			}
		});
	}
}
