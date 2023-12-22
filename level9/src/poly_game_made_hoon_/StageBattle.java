package poly_game_made_hoon_;

import java.util.ArrayList;
import java.util.Random;
import java.util.Vector;

public class StageBattle implements Stage {
	UnitManager unitManager = new UnitManager();
	ArrayList<Player> playerList = null;
	ArrayList<Unit> monsterList = null;
	
	  
	@Override
	public void init() {
		playerList = null;
		playerList = unitManager.player_list;
		monsterList = null;
		monsterList = unitManager.mon_list;
	}
	
	@Override
	public boolean update() {
		
		return false;
	}

	void print_character() {
		System.out.println("======[BATTLE]======");
		System.out.println("======[PLAYER]======");
		for(int i = 0; i < playerList.size(); i++) {
			System.out.println(playerList.get(i));
		}
		System.out.println("======[MONSTER]======");
	}
	
	
}