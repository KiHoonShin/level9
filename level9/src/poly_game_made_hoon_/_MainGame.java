package poly_game_made_hoon_;

public class _MainGame {

	public static void main(String[] args) {
		GameManager gameManager = new GameManager();
		
		while(true) {
			boolean run = gameManager.changeStage();
			
			
			
			if(!run) {
				System.out.println("게임 종료");
				break;
			}
		}
		
 }
}