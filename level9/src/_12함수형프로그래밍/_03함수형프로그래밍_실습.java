package _12함수형프로그래밍;

import java.util.function.BinaryOperator;

class Calculate{
	static int add(int a, int b) {return a+b;}
	static int substract(int a, int b) {return a-b;}
	static int multiply(int a, int b) {return a*b;}
}

@FunctionalInterface
interface Cal{
	int getResult(int a, int b);
}

public class _03함수형프로그래밍_실습 {

	public static void main(String[] args) {

		Cal add = (int a, int b) -> {return a + b;};
		System.out.println(add.getResult(10, 20));
		
		Cal substract = (a,b) -> {return a-b;};
		System.out.println(substract.getResult(10, 20));
		
		Cal multiply = (a,b) -> a*b;
		System.out.println(multiply.getResult(10, 20));
		System.out.println("====================");
		BinaryOperator<Integer> add2 = (a,b) -> a+b;
		
		System.out.println(add2.apply(10, 20));
		
		
		
	}

}
