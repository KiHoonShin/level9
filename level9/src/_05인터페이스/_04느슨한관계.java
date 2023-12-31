package _05인터페이스;

interface I{
	void methodI();
}

// 클래스 AAA는 클래스 BBB와 클래스 CCC의 느슨한 관계를 가진다
class AAA {
	// 인터페이스로 타입을 맞췄기 때문에 구현 클래스가 뭐가 오든 AAA클래스에서는 알빠가 아님
	public void methodA(I i) {
		i.methodI();
	}
}

class BBB implements I {
	
	@Override
	public void methodI() {
		System.out.println("메서드 i를 bbb에서 구현");
	}
}

class CCC implements I {

	@Override
	public void methodI() {
		System.out.println("메서드 i를 ccc에서 구현");
	}
	
}



public class _04느슨한관계 {

	public static void main(String[] args) {

		AAA a = new AAA();
		a.methodA(new BBB());
		a.methodA(new CCC());
	}

}
