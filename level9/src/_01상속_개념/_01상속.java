package _01상속_개념;

// 객체 지향 : OOP : object oriented programming
// 여러 객체들이 상호 협력해서 task를 수행 완료 시키는 것
// ex) 영화를 예매한다 ! (task) -> 스크린(영화의 상영 정보 -> 영화관(영화 가격(할인도) 객체) , 유저, 좌석

// 객체 유기적으로 존재해서 상호작용(메서드를 호출, 리턴 값을 받아오기) => 시스템을 구성하는 프로그램 방식

// 1. 캡슐화 (encapsulation) : 객체를 독립적으로 만든다. private 필드,  getter , setter 통해서
// 메서드는 보여주고 내부 기능은 숨긴다 : 외부 클래스는 해당 클래스가 어떤 기능을 하는지만 안다 !

// 2. 상속 (inheritance) : 자식 클래스가 부모 클래스를 가지고 있다. 한 부모만 상속받을 수 있다.
// 3. 추상화 (abstract) : 미완성된 메서드가 단 한개라도 존재하면 추상 클래스, 추상 클래스 객체 생성 불가능 
//						-> 상속 통해 자식 클래스 구현 완성
// 4. 다형성 (polymorphism) : 다양한 + 형태 => 여러 자식 클래스를 한 개의 부모 타입으로 묶을 수 있다. 자식과 부모의 형 변환이 가능하다.


class A1{
	int a;
	int b;
	
}

class B1{
	A1 a = new A1();
	int c;
	int d;
}

// 상속은 자식 클래스가 extends 부모 클래스 이름 

// 자식 클래스는 
class C1 extends A1{
	int e;
	int f;
	C1(){
		super(); //A1()
		System.out.println("호출2222");
		System.out.println(super.a); // 부모의 주소로 가서 a에 접근
		// super(); 부모의 생성자는 자식 생성자에서 최상위에 있어야함 
		
	}
}

// 상속 받은 자식 클래스
// 1. 부모 클래스의 필드나 메서드에 접근 가능
// 2. 상속은 단 한번만 허용한다

public class _01상속 {

	public static void main(String[] args) {

		A1 a = new A1();
		B1 b = new B1();
		C1 c = new C1();
		
		System.out.println(a.a);
		System.out.println(b.a.a);
		System.out.println(c.a);
		
	}
}
