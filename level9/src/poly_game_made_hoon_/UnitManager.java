package poly_game_made_hoon_;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Vector;

public class UnitManager {
	Random rd = new Random();
	ArrayList<Player> player_list = new ArrayList<Player>();
	ArrayList<Unit> mon_list = new ArrayList<Unit>();
	String path = UnitManager.class.getPackageName()+".";
	String[] mons = {"UnitWolf","UnitOrc","UnitBat"};
	
	UnitManager(){
		player_list.add(new Player("전사", 1000, 45));
		player_list.add(new Player("마법사", 800, 60));
		player_list.add(new Player("힐러", 500, 70));
	}
	
	void monster_rand_set(int size) {
		for(int i = 0; i < size; i ++) {
			int num = rd.nextInt(mons.length);
			try {
			Class<?> clazz = Class.forName(path+mons[num]);
			Object obj = clazz.getDeclaredConstructor().newInstance();
			Unit temp = (Unit) obj;
			int hp = rd.nextInt(100)+100;
			int power = rd.nextInt(10)+10;
			temp.init(hp, power);
			mon_list.add(temp);
			} catch(Exception e) {
				e.printStackTrace();
			}
		} // i
	}
	
	
	

}