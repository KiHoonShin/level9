package _12함수형프로그래밍;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;



public class _05스트림_이론 {

	
	public static void main(String[] args) {

		List<String> names = Arrays.asList("신기훈","유재석","하하","정형돈","노홍철","신기훈","하하");
				
		System.out.println("========1========");
		for(int i = 0; i < names.size(); i+=1) {
			System.out.println(names.get(i));
		}
		System.out.println("--------2---------");
		for(String name : names) {
			System.out.println(name);
		}
		
		System.out.println("========3========");
		
		names.forEach(System.out :: println);
		
		System.out.println("=======4=======");
		Stream<String> nameStream = names.stream(); // 리스트 names에 스트림 객체 생성
		
		//nameStream.forEach(name -> System.out.println(name));
		nameStream.forEach(System.out::println); // 이미 최종연산이 끝나면 스트림객체 .close()
		
		// 최종 연산은 마지막에 한 번만 사용할 수 있다
		// nameStream.count(); -> 오류 : stream has already been operated upon or closed
		
		System.out.println("=======5=======");
		// 메소드 체이닝 중복제거
		names.stream().distinct().forEach(System.out::println);
		
		System.out.println("=======6=======");
		List<String> name2 = names.stream()
								 .distinct()
								 .filter((name)-> name.equals("신기훈"))
								 .collect(Collectors.toList());
		System.out.println(name2);
		
		List<Integer> list = new ArrayList<>(Arrays.asList(5,2,0,8,4,1,7,9,3,6));
		
		System.out.println(list);
		List<Integer> odds = new ArrayList<>();
		
		for(Integer i : list) {
			if(i % 2 == 1) {
				odds.add(i);
			}
		}
		Collections.sort(odds); // -> 오름차순 정렬
		System.out.println(odds);
		
		String text = "";
		for(Integer i : odds) {
			text += i+",";
		}
		text = text.substring(0,text.length()-1);
		System.out.println(text);
		System.out.println("===================");
		
		// -> 축약하여 만들기
		String result = list.stream()
							.filter(i -> i %2 != 0)
							.sorted(Integer::compare)
							.map(i -> i+"")
							.collect(Collectors.joining(", "));
		System.out.println(list);
		System.out.println(result);
		
	}

}
