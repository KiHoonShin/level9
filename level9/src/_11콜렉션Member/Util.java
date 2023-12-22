package _11콜렉션Member;

import java.util.Scanner;

public class Util {

	static Scanner sc = new Scanner(System.in);
	
	private static Util instance = new Util();
	public static Util getInstance(){
		return instance;
	}
	
	public int getValue(String msg, int start, int end) {
		while(true) {
			System.out.printf("%s [%d ~ %d] %n",msg,start,end);
			int sel = sc.nextInt();
			if(sel < start || sel > end) {
				System.out.printf("%d ~ %d 범위 입력 %n" , start, end);
				continue;
			}
			return sel;
		}
	}
	
}
