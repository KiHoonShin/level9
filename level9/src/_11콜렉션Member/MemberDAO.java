package _11콜렉션Member;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

// 데이터를 처리하는 클래스
public class MemberDAO {
	private MemberDAO() {
		init();
	};
	private static MemberDAO instance = new MemberDAO();
	public static MemberDAO getInstance() {
		return instance;
	}
	
	private static String CUR_PATH = System.getProperty("user.dir")+"\\src\\"
	+ new MemberDAO().getClass().getPackageName()+"\\"; 
	
	private ArrayList<Member> memberList;
	private void init() {
		memberList = new ArrayList<Member>();
	}

	public boolean insertMember(String id, String pw) {
		
		if(!isValidId(id)) {
			System.out.println("이미 사용하는 아이디");
			return false;
		}
		Member member = new Member(id,pw);
		memberList.add(member);
		System.out.println(member +" 추가 완료");
		return true;
	}
	
	public boolean deleteMember(String id, String pw) {
		
		if(isValidId(id)) {
			System.out.println("아이디를 다시 입력하세요.");
			return false;
		}
		
		if(isValidPw(id, pw)) {
			System.out.println("비밀번호를 다시 입력하세요.");
			return false;
		}
		
		for(int i = 0; i < memberList.size(); i++) {
			if(memberList.get(i).getId().equals(id)) {
				memberList.remove(i);
			}
		}
		System.out.println(id + " 삭제 완료");
		return true;
	}
	
	
	private boolean isValidId(String id) {
		if(memberList.size() == 0) return true;
		for(Member member : memberList) {
			if(member.getId().equals(id)) {
				return false;
			}
		}
		return true;
	}
	
	private boolean isValidPw(String id, String pw) {
		if(memberList.size() == 0) return true;
		for(Member member : memberList) {
			if(member.getId().equals(id) && member.getPw().equals(pw)) {
				return false;
			}
		}
		return true;
	}
	
	public boolean modificateMember(String id, String pw, String newPw) {
		if(isValidId(id)) {
			System.out.println("아이디를 다시 입력하세요.");
			return false;
		}
		
		if(isValidPw(id, pw)) {
			System.out.println("비밀번호를 다시 입력하세요.");
			return false;
		}
		
		for(Member member: memberList) {
			if(member.getId().equals(id)) {
				member.setPw(newPw);
				System.out.println(member);
			}
		}
		
		return true;
	}
	
	public boolean hasData() {
		if(memberList.size() == 0) {
			System.out.println("회원 데이터가 존재하지 않습니다.");
			return false;
		}
		return true;
	}
	
	// 회원 출력
	public void printMember() {
		for(Member member : memberList) {
			System.out.println(member);
		}
	}
	
	// id 오름차순 정렬
	public void upMember() {
		ArrayList<Member> tempMember = (ArrayList<Member>) memberList.clone();
		Collections.sort(tempMember);
		System.out.println("---------- id 순으로 정렬 ----------");
		for(Member m : tempMember) {
			System.out.println(m);
		}
	}
	
	// 파일 데이터로 변환
	private String memberData() {
		String data = "";
		for(Member m : memberList) {
			data += m.getId()+"/"+m.getPw()+"\n";
		}
		return data;
	}
	
	// 파일 저장
	public boolean stockToFile() {
		String data = memberData();
		String fileName = "member.txt";
		try(FileWriter fw = new FileWriter(CUR_PATH+fileName)){
			fw.write(data);
			//System.out.println("파일 저장 성공");
			return true;
		} catch (IOException e) {
			//System.out.println("파일 저장 실패");
			e.printStackTrace();
			return false;
		}
	}
	
	// 파일 불러오기
	private String roadToFile(){
		String fileName = "member.txt";
		try(FileReader fr = new FileReader(CUR_PATH+fileName);
			BufferedReader br = new BufferedReader(fr)){
			String data = "";
			while(true) {
				String line = br.readLine();
				if(line == null) {
					break;
				}
				data += line +"\n";
			}
			return data;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public boolean roadFileAddList() {
		String data = roadToFile();
		if(data == null) return false;
		String[] temp = data.split("\n");
		for(int i = 0; i < temp.length; i++) {
			String[] info = temp[i].split("/");
			Member member = new Member(info[0],info[1]);
			memberList.add(member);
		}
		return true;
	}
	
}
