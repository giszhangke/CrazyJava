import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.CharsetDecoder;
import java.nio.CharBuffer;
import java.nio.ByteBuffer;

public class CharsetTransform {
	public static void main(String[] args) throws Exception {
		Charset cn = Charset.forName("GBK");
		CharsetEncoder cnEncoder = cn.newEncoder();
		CharsetDecoder cnDecoder = cn.newDecoder();
		CharBuffer cbuff = CharBuffer.allocate(8);
		cbuff.put('孙');
		cbuff.put('悟');
		cbuff.put('空');
		cbuff.flip();
		System.out.println(cbuff);
		ByteBuffer bbuff = cnEncoder.encode(cbuff);
		for (int i = 0; i < bbuff.capacity(); i++) {
			System.out.println(bbuff.get(i));
		}
		System.out.println(cnDecoder.decode(bbuff));
	}
}
