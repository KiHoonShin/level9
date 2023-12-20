package _10Object클래스;

class Person implements Cloneable{
	String name;
	Person(String name) {
		super();
		this.name = name;
	}
	@Override
	public String toString() {
		return "Person [name=" + name + "]";
	}
	
	public Person clone() {
		try {
			Object obj = super.clone();
			return (Person) obj;
		} catch (CloneNotSupportedException e) {
			throw new InternalError(e);
		}
		
	}
	
	
}

public class _02클론 {

	public static void main(String[] args) {

		Person p1 = new Person("홍길동");
		
		// 얕은 복사
		Person p2 = p1;
		
		p2.name = "김건달";
		System.out.println(p1); // 김건달
		System.out.println(p2); // 김건달
		
		System.out.println("---------------------");
		
		// 깊은 복사
		Person p3 = new Person(p1.name);
		System.out.println(p1);// 김건달
		System.out.println(p3);// 김건달
		p3.name = "신기훈";
		System.out.println(p1);// 김건달
		System.out.println(p3);// 신기훈
		System.out.println("---------------------------");
		Person p4 = p1.clone();
		System.out.println(p1);
		System.out.println(p4);
		
		p4.name = "뽀로로";
		System.out.println(p1);
		System.out.println(p4);
	}
}
