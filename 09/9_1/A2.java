import java.util.List;
import java.util.ArrayList;

public class A2 extends Apple {
	
	public A2(String info) {
		super(info);
	}
	@Override
	public String getInfo() {
		return super.getInfo().toString();
	}
	

	public static void main(String[] args) {
		
		A2 a2 = new A2("I'm an A2");
		System.out.println(a2.getInfo());

		List<String> stringList = new ArrayList<>();
		List<Integer> integerList = new ArrayList<>();
		System.out.println(stringList.getClass() == integerList.getClass());
		//下面的代码报错， instanceOf运算符不能用于泛型类
		/*
		if (stringList instanceOf ArrayList<String>) {
			
		}
		*/
	}
}
