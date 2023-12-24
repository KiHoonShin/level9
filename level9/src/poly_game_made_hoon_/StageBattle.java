package poly_game_made_hoon_;

import java.util.ArrayList;
import java.util.Random;
import java.util.Vector;

public class StageBattle implements Stage {
	ArrayList<Player> playerList = null;
	ArrayList<Unit> monList = null;
	Random rd = new Random();
	int m_dead = 0;
	int p_dead = 0;
	  
	@Override
	public void init() {
		UnitManager unitManager = new UnitManager();
		unitManager.mon_list.clear();
		playerList = unitManager.player_list;
		monList = null;
		unitManager.monster_rand_set(4);
		monList = unitManager.mon_list;
		m_dead = monList.size();
		p_dead = playerList.size();
	}
	
	@Override
	public boolean update() {
		boolean run = true;
		int p_index = 0;
		int m_index = 0;
		boolean turn = true;
		
		while(run) {
			if(turn) {
				print_character();
				if(p_index < playerList.size()) {
					player_attack(p_index);
					
					p_index +=1 ;
				} else {
					p_index = 0;
					turn = false;
				}
			} else {
				if(m_index < monList.size()) {
					monster_attack(m_index);
					m_index+=1;
				} else {
					m_index = 0;
					turn = true;
				}
			}
			check_live();
			if(m_dead <= 0 || p_dead <=0) {
				break;
			}
		} // while
		GameManager.nextStage = "LOBBY";
		return false;
	}

	void print_character() {
		System.out.println("=====[BATTLE]=====");
		System.out.println("=====[PLAYER]=====");
		for(int i = 0; i < playerList.size();i++) {
			playerList.get(i).printData();
		}
		System.out.println("=====[MONSTER]=====");
		for(int i = 0; i < monList.size(); i++) {
			monList.get(i).printData();
		}
	}
	
	void player_attack(int index) {
		Player p = playerList.get(index);
		if(p.curhp <= 0) return;
		System.out.println("======[메뉴 선택]=====");
		System.out.println("["+p.name+"] [1.어택] [2.스킬]");
		int sel = GameManager.getValue("공격 선택", 1, 2);
		if(sel == 1) {
			while(true) {
				int idx = rd.nextInt(monList.size());
				
				if(monList.get(idx).curhp > 0) {
					p.attack(monList.get(idx));
					break;
				}
			} // while
		} else {
			// 스킬
		}
	}
	
	void monster_attack(int index) {
		Unit m = monList.get(index);
		if(m.curhp <= 0) {
			return;
		}
		while(true) {
			 int idx = rd.nextInt(playerList.size());
			 if(playerList.get(idx).curhp > 0) {
				 m.attack(playerList.get(idx));
				 break;
			 }
		} //while
	}
	
	void check_live() {
		int num = 0;
		for(int i = 0; i < playerList.size(); i++) {
			if(playerList.get(i).curhp <= 0) {
				num += 1;
			}
		}
		p_dead = playerList.size() - num;
		num = 0;
		for(int i = 0; i < monList.size(); i++) {
			if(monList.get(i).curhp <= 0) {
				num += 1;
			}
		}
		m_dead = monList.size() - num;
	}
	
	
	
	
}