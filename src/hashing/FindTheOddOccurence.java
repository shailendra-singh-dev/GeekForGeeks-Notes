package hashing;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;


public class FindTheOddOccurence {

	public static int getOddOccurenceNumber(int[] array) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i : array) {
			Integer count = map.get(i);
			if (count == null) {
				map.put(i, 1);
			} else {
				map.put(i, ++count);
			}
		}

		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			if (!(entry.getValue() % 2 == 0)) {
				return entry.getKey();
			}
		}
		return -1;
	}

	public static void test() {
		int[] array = new int[] { 8, 4, 4, 8, 23, 23, 23 };
		int number = getOddOccurenceNumber(array);
		System.out.print("count:" + number);
	}
}
