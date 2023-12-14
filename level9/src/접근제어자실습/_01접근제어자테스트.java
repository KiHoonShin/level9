package 접근제어자실습;

import 상속_개념.AccessTest;

class Child extends AccessTest{
	Child(){
		super.a = 10;
		b = 100; // b는 자식 객체라서 내부에서는 접근 가능
	}
	
//	@Override
//	void printAll() {
//		
//	} -> 부모에 final 메서드가 있기 때문에 재정의 불가
	// final 메서드는 자식 클래스에서 재정의가 불가능함
	
}

public class _01접근제어자테스트 {
	public static void main(String[] args) {
		
		Child c = new Child();
		c.a = 100;
		// c.b = 10; child 객체 자체는 Main 다른 패키지 안에 있기 때문에 접근 불가
		
		AccessTest e = new AccessTest();
		// e.b = 0; => 오류
	}
}
