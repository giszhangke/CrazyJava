import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class MathTest
{
	public static void main(String[] args) throws Exception {
		// ȡ������
		System.out.println("Math.floor(3.6): " + Math.floor(3.6));//ȡС�ڻ����Ŀ�������������
		System.out.println("Math.floor(3): " + Math.floor(3));//ȡС�ڻ����Ŀ�������������
		System.out.println("Math.ceil(3.3): " + Math.ceil(3.3));//ȡ���ڻ����Ŀ��������С����
		System.out.println("Math.ceil(3): " + Math.ceil(3));//ȡ���ڻ����Ŀ��������С����
		System.out.println("Math.round(3.3): " + Math.round(3.3));//��������	
		System.out.println("Math.round(3.6): " + Math.round(3.6));
		// ȡ��
		System.out.println("Math.IEEEremainder(5, 2): " + Math.IEEEremainder(5, 2));		
		// α����� [0.0, 1.0)
		System.out.println("Math.random(): " + Math.random());
		
		// Random  ThreadLocalRandom
		Random rand = new Random(3);//���������3
		//ThreadLocalRandom rand = ThreadLocalRandom.current();
		System.out.println("rand.nextGaussian(): " + rand.nextGaussian());
		// ����һ������int������Χ��α�����
		System.out.println("rand.nextInt(): " + rand.nextInt());
		// ����һ��0~26��α�����
		System.out.println("rand.nextInt(26): " + rand.nextInt(26));		     
		//����һ�д���ThreadLocalRandomʱ��������
		//System.out.println("rand.nextInt(3, 26): " + rand.nextInt(3, 26));	
		System.out.println(System.currentTimeMillis());
	}
}
