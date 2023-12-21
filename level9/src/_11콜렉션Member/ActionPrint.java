package _11콜렉션Member;

public class ActionPrint implements Action{

	@Override
	public void excute() {
		MemberDAO dao = MemberDAO.getInstance();
		
		// 회원 목록 출력하는 페이지
		System.out.println("[전체 회원 목록]");
		if(!dao.hasData()) return;
		dao.printMember();
		dao.upMember();
	}
	
}
