package _05인터페이스;

// 클래스와 클래스간에 결속이 높으면 가독성은 좋지만 유지보수가 어렵다.


// AA 클래스에서 methodA 를 호출 하려면 반드시 CC 객체가 있어야한다.
// 클래스 AA랑 클래스 CC랑 결속력이 높다, 긴밀한 관계다 
class AA {
	
	// 하나를 바꾸면 그거랑 직접적으로 연관된 모든 것을 수정해야 한다
	public void methodA(BB b) {
					//	CC c 
		b.methodB();
		//c.methodC();
	}
}

class BB{
	
	public void methodB() {
		System.out.println("메서드 b를 호출했다");
	}
}

class CC {
	public void methodC() {
		System.out.println("메서드 c를 호출했다");
	}
}



public class _03긴밀한관계 {

	public static void main(String[] args) {

		AA a = new AA();
		//a.methodA(new CC()); ->  주석 처리 다 바꿔야함
		a.methodA(new BB());
	}

}
