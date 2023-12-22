package poly_game_made_hoon_;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class GameManager {
	static Scanner sc = new Scanner(System.in);
	Map<String, Stage> stageList = new HashMap<String, Stage>();
	String curStage = "";
	static String nextStage = "";
	
	
	GameManager(){
		stageList.put("TITLE", new StageTitle());
		stageList.put("BATTLE", new StageBattle());
		stageList.put("LOBBY", new StageLobby());
		
		nextStage = "TITLE";
	}
	
	boolean changeStage() {
		System.out.println("curStage : " + curStage);
		System.out.println("nextStage : " + nextStage);
		
		if(curStage.equals(nextStage)) return true;
		
		curStage = nextStage;
		
		Stage stage = stageList.get(curStage);
		stage.init();
		
		boolean run = true;
		while(true) {
			 run = stage.update();
			
			if(!run) {
				break;
			}
		}
		
		if(nextStage.equals("")) {
			return false;
		} else {
			return true;
		}
		
	}
	
	
}