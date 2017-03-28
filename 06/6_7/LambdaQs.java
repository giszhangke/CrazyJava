interface ProcessArray2
{
	void process(int[] arrays);
}

interface Eateable
{
	void eat();
}

interface Flyable
{
	void fly(String something);
}

interface Addable
{
	int add(int a, int b);
}

@FunctionalInterface
interface Converter
{
	Integer convert(String from);

	default int add(int a, int b) {
		return a + b;
	}
}

public class LambdaQs
{
	public void eat(Eateable e) {
		e.eat();
	}

	public void fly(Flyable f) {
		System.out.println("flyable fly: " + f);
		f.fly("fly something");
	}

	public int add(int a, int b, Addable ad) {
		return ad.add(a, b);
	}
	
	public static void main(String[] args) {
		LambdaQs lam = new LambdaQs();
		lam.eat(() -> System.out.println("I'm eating"));
		lam.fly(something -> { 
			System.out.println("I'm flying: " + something);
		});
		System.out.println(lam.add(3, 8, (a, b) -> a + b));

		// 下面一行代码报错：Object类不是函数式接口，所以不能直接把Lambda表达式直接赋值给Object类的实例
		//Object r = () -> {
		// 下面一行代码可以正常运行：经过了函数式接口Runnable强制转换
		//Object r = (Runnable)() -> {
		Runnable r = () -> {
			System.out.println("100分");

		};
		//r.run();
		
		// 下面第一行和第二行等价
		// Converter converter = from -> Integer.valueOf(from);
		Converter converter = Integer::valueOf;
		Integer inte = converter.convert("99");
		System.out.println(inte);
		System.out.println(converter.add(3, 8));

		int[] arrays = {1, 3, 5, 7, 9};
		//ProcessArray2 pa = (int[] target) -> {
		ProcessArray2 pa = target -> {			
			for (int i : target) {
				System.out.println(i);
			}
		};

		pa.process(arrays);
	}
	
}

