package _11콜렉션Member;

public class _Main {

	public static void main(String[] args) {
		Controller con = Controller.getInstance();
   		
		
		while(true) {
			System.out.println("========== 메뉴 ==========");
			System.out.println("[1] 추가");
			System.out.println("[2] 삭제");
			System.out.println("[3] 수정");
			System.out.println("[4] 출력(id 이름순으로 출력)");
			System.out.println("[5] 파일저장");
			System.out.println("[6] 파일로드");
			System.out.println("[0] 종료");
			int sel = Util.sc.nextInt();
			if(sel == 1) {
				con.getAction("insert").excute();
			} else if(sel == 2) {
				con.getAction("delete").excute();
			} else if(sel == 3) {
				con.getAction("modificate").excute();
			} else if(sel == 4) {
				con.getAction("print").excute();
			} else if(sel == 5) {
				con.getAction("stock").excute();
			} else if(sel == 6) {
				con.getAction("road").excute();
			}
			else {
				System.out.println("종료합니다.");
				return;
			}
		 } //while
		
	}

}
   