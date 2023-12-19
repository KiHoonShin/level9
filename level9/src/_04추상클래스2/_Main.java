package _04추상클래스2;

public class _Main {

	public static void main(String[] args) {
    //                   추상 클래스는 객체 생성 불가능
	//	MyBrand kihoon = new MyBrand(1,"강남");
		
		System.out.println(MyChicken.getSlogan());
		System.out.println(MyCafe.getSlogan());
		System.out.println(MyBakery.getSlogan());
		
		MyChicken store1 = new MyChicken("강남");
		MyChicken store2 = new MyChicken("홍대");
		MyChicken store3 = new MyChicken("압구정");
		
		MyCafe store4 = new MyCafe("제주도" , true);
		MyCafe store5 = new MyCafe("신촌" , true);
		MyCafe store6 = new MyCafe("강남" , false);
		MyBakery store7 = new MyBakery("구디");
		MyBakery store8 = new MyBakery("강남");
		MyBrand[] myStores = {store1, store2, store3, store4, store5,
				store6, store7, store8};
		
		for(MyBrand mystore : myStores) {
			//인스턴스(객체) instanceof 클래스 -> 클래스의 객체면 true / false
			if(mystore instanceof MyBakery) {
				mystore.takeOrder();
			}
		}
		
		
	}

}
