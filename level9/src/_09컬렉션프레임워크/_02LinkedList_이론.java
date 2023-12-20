package _09컬렉션프레임워크;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class _02LinkedList_이론 {

	public static void main(String[] args) {

		// 보통 실무에서 타입은 인터페이스로 한다
		List<Integer> list1 = new ArrayList<Integer>();
		list1.add(10);
		list1.add(20);
		list1.add(30);
		list1.add(40);
		
		//부모 타입이기 때문에 값 변경에 유연성이 있다
		list1 = new LinkedList<>();
		
		// 링크드 리스트 안에 스택 구현되어 있다
		// 스택 : 가장 처음에 들어간게 가장 마지막에 나온다
		LinkedList<Character> list3 = new LinkedList<Character>();
		list3.push('a');
		list3.push('b');
		list3.push('c');
		list3.push('d');
		list3.push('e');
		// push 는 먼저 넣은 값이 나중에 출력되게끔
		
		
		System.out.println(list3); 
		
		System.out.println(list3.pop());
		System.out.println(list3.pop());
		System.out.println(list3.pop());
		System.out.println(list3.pop());
		System.out.println(list3.pop());
		//System.out.println(list3.pop()); 에러
		
		System.out.println(list3);
	}

}
