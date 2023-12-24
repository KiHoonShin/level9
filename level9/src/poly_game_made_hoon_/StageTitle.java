package poly_game_made_hoon_;

public class StageTitle implements Stage {

	@Override
	public boolean update() { 
		System.out.println("==== TEXT RPG ====");
		while (true) {
			System.out.println("[시작]을 입력하세요");
			String input = GameManager.sc.next();
			if (!input.equals("시작")) {
				continue;
		}
			break;
		}//while
		GameManager.nextStage = "LOBBY";
		return false;
	}

	@Override
	public void init() {

	}

}