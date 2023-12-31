package _09컬렉션프레임워크;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class _05Map이론 {

	public static void main(String[] args) {

		Map<String, Integer> list = new HashMap<>();
		list.put("apple", 1000);
		list.put("orange", 1500);
		list.put("melon", 5000);
		list.put("water melon", 15000);
		list.put("apple", 2000); // 키 값은 중복 허용이 안 돼서 값이 덮어쓰기 됨
		System.out.println(list);
		
		System.out.println(list.get("melon"));
		System.out.println(list.size());
		
		Set<String>listKeys = list.keySet();
		
		for(String s : listKeys) {
			System.out.println(s + " " + list.get(s));
		}
		
		System.out.println(list.containsKey("apple"));
		System.out.println(list.containsKey("banana"));
		System.out.println(list.containsKey(1000));
		
		Set<Entry<String, Integer>> list2 = list.entrySet();
		
		for(Entry<String, Integer> entry : list2) {
			System.out.println(entry);
			//System.out.println("%s %d ".formatted(entry.getKey(), entry.getValue()));
		}
		
		
		
		
		
		
		
	}

}
