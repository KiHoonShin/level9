package _01상속_개념;

//class Parent{
//	int a = 10;
//	int num = 100;
//	void test1(){
//		System.out.println("부모 test1 호출");
//	}
//}
//
//class Child extends Parent{
//	int b = 20;
//	int num = 10;
//	void test2() {
//		System.out.println("test2 호출");
//	}
//	
//	@Override // 만약 주석처리하면 부모 test1이 호출이 됨
//	void test1() { // 부모 클래스에 있는 같은 이름의 메서드를 자식 클래스를 재정의
//		System.out.println("자식 test1 호출");
//		super.test1(); // -> super 키워드로 부모 클래스도 호출 가능
//	}
//	
//	void printNum() {
//		System.out.println(num); // => 10;
//		System.out.println(super.num); // => 100
//	}
//}


public class _07추상클래스2 {

	public static void main(String[] args) {

		// upcasting : 자식 객체가 부모 클래스 타입을 가지는 것
		
		Parent p = new Parent();
		
		Child c1 = new Child();
		
		// 이미 자식은 부모를 생성하기 때문에
		// 부모클래스 타입으로 만들 수 있다.
		Parent c2 = new Child();
		
		Parent c3 = (Parent)c1; // 강제로 업캐스팅
		
		//부모는 자식을 생성하지 않기 때문에 자식타입으로 선언 불가능
		// Child p1 = new Parent();
		
		
		// downcasting : 부모타입 => 자식타입으로 변경
		
		Child c4 = (Child)c2;
		
		
		
	}

}
