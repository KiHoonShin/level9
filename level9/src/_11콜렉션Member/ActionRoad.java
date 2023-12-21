package _11콜렉션Member;

public class ActionRoad implements Action {

	@Override
	public void excute() {
		// 파일 로드하는 페이지
		MemberDAO dao = MemberDAO.getInstance();
		System.out.println("[ 파일 불러오기 ]");
		if(dao.roadFileAddList()) {
			System.out.println("[ 파일 로드 성공 ]");
		} else {
			System.out.println("[ 파일 로드 실패 ] ");
		}
	}
	
}
