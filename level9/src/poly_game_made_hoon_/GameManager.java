package poly_game_made_hoon_;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class GameManager {
	static Scanner sc = new Scanner(System.in);
	String curStage = "";
	static String nextStage = "";
	Map<String, Stage> stageList = new HashMap<String, Stage>();
	
	GameManager(){
		stageList.put("TITLE", new StageTitle());
		stageList.put("LOBBY", new StageLobby());
		stageList.put("BATTLE", new StageBattle());
		
		nextStage = "TITLE";
	}
	
	boolean change_stage() {
		System.out.println("curStage : " + curStage);
		System.out.println("nextStage : " + nextStage);
		
		if(curStage.equals(nextStage)) return true;
		
		curStage = nextStage;
		Stage stage = stageList.get(curStage);
		stage.init();
		
		boolean run = true;
		while(true) {
			run = stage.update();
			
			if(run == false) {
				break;
			}
		}
		
		if(nextStage.equals("")) {
			return false;
		} else {
			return true;
		}
	}
	
	static int getValue(String msg, int start, int end) {
		while(true) {
			System.out.printf("%s 선택 >> ",msg,start,end);
			try {
				int sel = sc.nextInt();
				if(sel < start || sel > end) {
					System.out.println("범위 오류");
					continue;
				}
				return sel;
			} catch (Exception e) {
				System.out.println("숫자만 입력하세요");
				sc.nextLine();
			}
			
		}
	}
	
	
	
}