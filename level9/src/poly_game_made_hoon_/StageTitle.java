package poly_game_made_hoon_;

public class StageTitle implements Stage {

	@Override
	public boolean update() { 
		System.out.println("==== TEXT RPG ====");
		System.out.println("[시작]을 입력하세요");
		String word = GameManager.sc.next();
		
		if(!word.equals("시작")) {
			System.out.println("입력 오류");
			return true;
		}
		
		GameManager.nextStage = "LOBBY";
		return false;
	}

	@Override
	public void init() {

	}

}