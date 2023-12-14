package 상속_개념;

class Parent{
	int num = 100;
	void test1(){
		System.out.println("부모 test1 호출");
	}
}

class Child extends Parent{
	int num = 10;
	void test2() {
		System.out.println("test2 호출");
	}
	
	@Override // 만약 주석처리하면 부모 test1이 호출이 됨
	void test1() { // 부모 클래스에 있는 같은 이름의 메서드를 자식 클래스를 재정의
		System.out.println("자식 test1 호출");
		super.test1(); // -> super 키워드로 부모 클래스도 호출 가능
	}
	
	void printNum() {
		System.out.println(num); // => 10;
		System.out.println(super.num); // => 100
	}
}

public class _03오버라이딩 {

	public static void main(String[] args) {

		Child c = new Child();
		c.test1();
		c.test2();
		c.printNum();
		
	}

}
