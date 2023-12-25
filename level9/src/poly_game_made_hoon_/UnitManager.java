package poly_game_made_hoon_;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Vector;

public class UnitManager {
	Random rd = new Random();
	String path = UnitManager.class.getPackageName()+".";
	ArrayList<Player> player_list = new ArrayList<>();
	ArrayList<Unit> mon_list = new ArrayList<>();
	String[] mons = {"UnitOrc", "UnitBat" , "UnitWolf"};
	
	UnitManager(){
		player_list.add(new Player("전사", 1000, 45));
		player_list.add(new Player("법사", 800, 60));
		player_list.add(new Player("힐러", 500, 70));
	}
	
	void mons_rand_set(int size) {
		for (int i = 0; i < size; i++) {
			int r = rd.nextInt(mons.length);
			try {
				Class<?> clazz = Class.forName(path + mons[r]);
				Object object = clazz.getDeclaredConstructor().newInstance();
				Unit temp = (Unit) object;
				int hp = rd.nextInt(100) + 100;
				int power = rd.nextInt(10) + 10;
				temp.init(hp, power);
				mon_list.add(temp);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} //i
	}
	
	

}