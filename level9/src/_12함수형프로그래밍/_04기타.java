package _12함수형프로그래밍;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _04기타 {
							// 매개변수의 개수를 모를때 사용하는 방법
	public static int getSum(int ...nums) { // int[] num 과 같음
		int sum = 0;
		for(int i = 0; i < nums.length; i+=1) {
			sum += nums[i];
		}
		return sum;
	}
	
	public static void main(String[] args) {

		 int sum = getSum(10,20,30,40,50);
		 
		 System.out.println(sum);
		 System.out.println(getSum(10,10,01,10,10));
		
		 
		 List<String> list = new ArrayList<String>();
		 
		 list.add("강아지");
		 list.add("고양이");
		 list.add("사자");
		 list.add("토끼");
		 
		 for(String s : list) {
			 System.out.println(s);
		 }
		 
		 System.out.println("===========");
		 
		 list = Arrays.asList("강아지","고양이","사자","토끼");
		 
		 // 리스트의 요소를 처음부터 끝까지 한 개씩 꺼내오는 것 forEach
		 list.forEach(s -> System.out.println(s));
		 
		 // 클래스의 메서드 참조 : System.out 객체의 println() 메서드 참조
		 
		 System.out.println("=====================");
		 
		 // 파라미터를 완전히 생략한 축약형태 ->
		 		//	 해당 클래스 객체 :: 메서드 이름
		 list.forEach(System.out::println);
		 
			//list = Arrays.asList("10","20","30","40");   // 10 20 30 40 
			//list.forEach(Integer::new); // (String s) -> Integer new Integer(s)
		 
		 
	}

}
