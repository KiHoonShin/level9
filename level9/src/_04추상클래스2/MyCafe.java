package _04추상클래스2;

public class MyCafe extends MyBrand {

	private static int myNum = 0;
	private boolean isTakeOut;
	public static String getSlogan() {
		return SLOGAN.formatted("기훈 커피");
	}
	
	public MyCafe(String name , boolean isTakeOut) {
		super(++myNum,name);
		this.isTakeOut = isTakeOut;
	}

	@Override
	public void takeOrder() {
		System.out.printf("기훈카페 %s 음료 주문 완료 %n", super.info());
		if(!isTakeOut) System.out.println("매장에서 드시겠습니까?");
	}
	
}
