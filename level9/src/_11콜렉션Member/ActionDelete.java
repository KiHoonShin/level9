package _11콜렉션Member;

public class ActionDelete implements Action{

	@Override
	public void excute() {
		MemberDAO dao = MemberDAO.getInstance();
		
		// 멤버 삭제하는 페이지
		System.out.println(" [멤버 삭제] ");
		if(!dao.hasData()) return;
		System.out.print("▶ 아이디 입력 : ");
		String id = Util.sc.next();
		
		System.out.print("▶ 비밀번호 입력 : ");
		String pw = Util.sc.next();
		
		if(dao.deleteMember(id, pw)) {
			System.out.println(" [ 회원 삭제 완료 ]");
		} else {
			System.out.println(" [ 회원 삭제 실패 ]");
		}
	}

}
