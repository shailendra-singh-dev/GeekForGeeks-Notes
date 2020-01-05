package problems.string;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;


public class StringVsBytes {

	public static void bytesToString() {
		byte[] byteArray1 = new byte[] { 'J', 'A', 'V', 'A' };
		byte[] byteArray2 = new byte[] { 74, 65, 86, 65 };

		String str1 = new String(byteArray1);
		String str2 = new String(byteArray2);

		System.out.println("str1:" + str1);
		System.out.println("str2:" + str2);
		String str = null;
		try {
			str = new String(byteArray1, 0, 2, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		System.out.println(str);
	}

	public static void stringToBytes() {
		String str = "JAVA";
		byte[] bytes = null;
		try {
			bytes = str.getBytes("UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		System.out.println(Arrays.toString(bytes));
	}

	public static void test() {
		bytesToString();
		stringToBytes();
	}
}
