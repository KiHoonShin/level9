package _11콜렉션Member;

public class ActionModificate implements Action{

	@Override
	public void excute() {
		MemberDAO dao = MemberDAO.getInstance();
		
		// 멤버 (비밀번호) 수정하는 페이지
		System.out.println("[ 비밀번호 수정 ]");
		if(!dao.hasData()) return;
		System.out.print("▶ 아이디 입력 : ");
		String id = Util.sc.next();
		
		System.out.println("▶ 비밀번호 입력 : ");
		String pw = Util.sc.next();
		
		System.out.print("▶ 신규 비밀번호 입력 : ");
		String newPw = Util.sc.next();
		
		if(dao.modificateMember(id, pw, newPw)) {
			System.out.println("[비밀번호 수정 완료]");
		} else {
			System.out.println("[비밀번호 수정 실패]");
		}
		
	}

}
