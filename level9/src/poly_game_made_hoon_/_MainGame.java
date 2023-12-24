package poly_game_made_hoon_;

public class _MainGame {

	public static void main(String[] args) {
		GameManager gameManager = new GameManager();
		
		
		boolean run = true;
		while(true) {
			run = gameManager.changeStage();
			if(run == false) {
				break;
			}
		}
		
		System.out.println("게임 오버");
		
		
 }
}