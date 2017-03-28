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

		// ����һ�д��뱨��Object�಻�Ǻ���ʽ�ӿڣ����Բ���ֱ�Ӱ�Lambda���ʽֱ�Ӹ�ֵ��Object���ʵ��
		//Object r = () -> {
		// ����һ�д�������������У������˺���ʽ�ӿ�Runnableǿ��ת��
		//Object r = (Runnable)() -> {
		Runnable r = () -> {
			System.out.println("100��");

		};
		//r.run();
		
		// �����һ�к͵ڶ��еȼ�
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

