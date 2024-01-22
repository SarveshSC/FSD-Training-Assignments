package collections;

import java.util.*;
import java.util.Iterator;
import java.util.Set;

public class CollectionsPractice {

	public static void main(String[] args) {
		
		List<String> names = new ArrayList<String>();
		names.add("lewis");
		names.add("smith");
		names.add("tom");
		names.add("ravi");
		names.add("max");
		names.add("john");
		
		System.out.println(names);

//		Map<Integer, String> map = new HashMap<Integer, String>();
		Map<Integer, String> map = new LinkedHashMap<Integer, String>();

		map.put(99, "lewis");
		map.put(100, "smith");
		map.put(101, "tom");
		map.put(100, "ravi");
		map.put(99, "max");
		map.put(554, "john");

		System.out.println(map);

		Set<Integer> set = map.keySet();
		Iterator<Integer> it = set.iterator();

		while (it.hasNext()) {
			Integer k = it.next();
			System.out.println(k + " " + map.get(k));
		}
		
		Collection<String> list = map.values();

		for (String name : list) {
			System.out.println(name);
		}
	}

}
