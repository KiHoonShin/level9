package _07enum;

enum ButtonMode{
	LIGHT, DARK
}

class Button{
	
	String buttonMode = "LIGHT";
	String buttonSpace = "SINGLE";
}






public class _01enum개념1 {

	public static void main(String[] args) {
		
		String day = "MON";
		day = "KIM";
		
		//Week day2 = "MON";  = > 불가	
		Week day2 = Week.MON;
		System.out.println(day2);
		
		if(day2 == Week.MON) {
			System.out.println("오늘은 월요일이야");
		}
		
		int mode = 3;
		int space = 1;
		
		Button button1 = new Button();
		button1.buttonMode = "DOUBLE";
		button1.buttonSpace = "DARK";
		
		
		
		
	}
}
