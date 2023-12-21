package _11콜렉션Member;

public class ActionStock implements Action{

	@Override
	public void excute() {
		MemberDAO dao = MemberDAO.getInstance();
		
		// 파일 저장하는 페이지
		System.out.println("[ 파일 저장 ]");
		if(!dao.hasData()) return;
		//member.txt
		if(dao.stockToFile()) {
			System.out.println("[ 파일 저장 성공 ]");
		} else {
			System.out.println("[ 파일 저장 실패 ]");
		}
	}

	
	
}
