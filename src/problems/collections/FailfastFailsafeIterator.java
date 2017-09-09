package problems.collections;
import java.awt.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class FailfastFailsafeIterator {

	public static void test() {
		FailfastFailsafeIterator failfastFailsafeIterator = new FailfastFailsafeIterator();
		failfastFailsafeIterator.testFailSafe();
	}

	public void testFailfast() {
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(10);
		list.add(20);
		Iterator<Integer> iterator = list.iterator();
		while (iterator.hasNext()) {
			System.out.println("" + iterator.next());
			list.add(30);
		}
	}

	public void testFailSafe() {
		ConcurrentHashMap<String, String> hashMap = new ConcurrentHashMap();
		hashMap.put("1", "1");
		hashMap.put("2", "2");
		hashMap.put("3", "3");
		hashMap.put("4", "4");
		for (Map.Entry<String, String> entry : hashMap.entrySet()) {
			String key = entry.getKey();
			String value = entry.getValue();
			System.out.println("key:" + key + ",value:" + value);
			hashMap.put("5", "5");
			hashMap.put("6", "6");
		}
	}

}
