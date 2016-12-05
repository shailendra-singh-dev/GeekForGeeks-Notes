package hashing;

import java.util.HashMap;
import java.util.Iterator;

public class LRUCache {
	
	private HashMap<Integer, Integer> map=new HashMap<Integer, Integer>();
	
	public void set(int key,int value){
		if(map.containsKey(key)){
			map.remove(key);
		}else if(map.size() == 100){
			Iterator<Integer> iterator = map.keySet().iterator();
			iterator.next();
			iterator.remove();
		}
	}
}
