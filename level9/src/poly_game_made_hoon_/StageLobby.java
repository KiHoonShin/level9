package poly_game_made_hoon_;

public class StageLobby implements Stage {
	
	
	@Override
	public boolean update() {
		System.out.println("=====[LOBBY]=====");
		System.out.println("[1.전투] [2.종료]");
		int sel = GameManager.getValue("메뉴 선택", 1, 2);
		if(sel == 1) {
			GameManager.nextStage = "BATTLE";
		} else {
			GameManager.nextStage = "";
		}
		return false;
	}

	@Override
	public void init() {

	}

}