public class A1 extends Apple<String> {
	public A1(String info) {
		super(info);
	}
	
	/*
	 * 重写父类的方法
	 * */
	@Override
	public String getInfo() {
		//return "subClass: " + super.getInfo();
		return super.getInfo().toString();
	}

	public static void main(String[] args) {
		A1 a1 = new A1("I'm A1!");
		System.out.println(a1.getInfo());
		a1.setInfo("Wow!");
	}

}
