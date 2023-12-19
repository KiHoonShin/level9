package _04추상클래스2;

public class MyBakery extends MyBrand{

	public static String getSlogan() {
		return SLOGAN.formatted("기훈 빵집");
	}
	
	private static int myNum = 0;
	
	public MyBakery(String name) {
		super(++myNum , name);
	}

	@Override
	public void takeOrder() {
		System.out.printf("기훈빵집 %s 주문 완료 %n", super.info());
	}
}
