package poly_game_made_hoon_;

public class StageLobby implements Stage {
	
	
	@Override
	public boolean update() {
		while(true) {
			System.out.println("=====[LOBBY]=====");
			System.out.println("[1.전투] [2.종료]");
			int sel = GameManager.sc.nextInt();
			if (sel == 1) {
				GameManager.nextStage = "BATTLE";
			} else if (sel == 2) {
				return false;
			} else {
				System.out.println("입력 오류");
				continue;
			} 
		} //while
	}

	@Override
	public void init() {

	}

}