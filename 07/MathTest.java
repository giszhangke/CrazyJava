import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class MathTest
{
	public static void main(String[] args) throws Exception {
		// 取整运算
		System.out.println("Math.floor(3.6): " + Math.floor(3.6));//取小于或等于目标数的最大整数
		System.out.println("Math.floor(3): " + Math.floor(3));//取小于或等于目标数的最大整数
		System.out.println("Math.ceil(3.3): " + Math.ceil(3.3));//取大于或等于目标数的最小整数
		System.out.println("Math.ceil(3): " + Math.ceil(3));//取大于或等于目标数的最小整数
		System.out.println("Math.round(3.3): " + Math.round(3.3));//四舍五入	
		System.out.println("Math.round(3.6): " + Math.round(3.6));
		// 取余
		System.out.println("Math.IEEEremainder(5, 2): " + Math.IEEEremainder(5, 2));		
		// 伪随机数 [0.0, 1.0)
		System.out.println("Math.random(): " + Math.random());
		
		// Random  ThreadLocalRandom
		Random rand = new Random(3);//随机数种子3
		//ThreadLocalRandom rand = ThreadLocalRandom.current();
		System.out.println("rand.nextGaussian(): " + rand.nextGaussian());
		// 生成一个处于int整数范围的伪随机数
		System.out.println("rand.nextInt(): " + rand.nextInt());
		// 生成一个0~26的伪随机数
		System.out.println("rand.nextInt(26): " + rand.nextInt(26));		     
		//下面一行代码ThreadLocalRandom时正常运行
		//System.out.println("rand.nextInt(3, 26): " + rand.nextInt(3, 26));	
		System.out.println(System.currentTimeMillis());
	}
}
