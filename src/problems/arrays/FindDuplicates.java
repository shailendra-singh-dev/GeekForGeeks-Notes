package problems.arrays;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class FindDuplicates {

	public static ArrayList<Integer> getDuplicatesUsingArray(int[] array) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		if (array == null || array.length == 0) {
			return null;
		}
		for (int i = 0; i < array.length; i++) {
			for (int j = i + 1; j < array.length; j++) {
				if (array[i] == array[j]) {
					if (!list.contains(array[i])) {
						list.add(array[i]);
					}
				}
			}
		}
		return list;
	}

	public static ArrayList<Integer> getDuplicatesUsingSet(int[] array) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		Set<Integer> set = new HashSet<Integer>();
		if (array == null || array.length == 0) {
			return null;
		}
		for(int i: array){
			if(!set.add(i)){
				list.add(i);
			}
		}
		return list;
	}

	public static ArrayList<Integer> getDuplicatesUsingMap(int[] array) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

		for (int i = 0; i < array.length; i++) {
			int number = array[i];
			Integer count = map.get(number);
			if (count == null) {
				map.put(number, 1);
			} else {
				map.put(number, ++count);
			}
		}
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			if (entry.getValue() > 1) {
				list.add(entry.getKey());
			}
		}
		return list;
	}

}
