package poly_game_made_hoon_;

import java.util.ArrayList;
import java.util.Random;
import java.util.Vector;

public class StageBattle implements Stage {
	Random rd = new Random();
	ArrayList<Player> playerList = null;
	ArrayList<Unit> monList = null;
	int m_dead = 0;
	int p_dead = 0;

	@Override
	public boolean update() {
		int p_idx = 0;
		int m_idx = 0;
		boolean turn = true;

		while (true) {
			if (turn) {
				print_character();
				if(p_idx < playerList.size()) {
					player_attack(p_idx);
					p_idx +=1 ;
				} else {
					p_idx = 0;
					turn = false;
				}
			} else {
				if(m_idx < monList.size()) {
					monster_attack(m_idx);
					m_idx += 1;
				} else {
					m_idx = 0;
					turn = true;
				}
			}
			check_live();
			if(p_dead <= 0 || m_dead <= 0) {
				break;
			}
		} // while
		GameManager.nextStage = "LOBBY";
		return false;
	}

	void check_live() {
		int num = 0;
		for(int i = 0; i < playerList.size(); i+=1) {
			if(playerList.get(i).curhp <= 0) {
				num += 1;
			}
		}
		p_dead = playerList.size() - num;
		num = 0;
		for(int i = 0; i < monList.size(); i+=1) {
			if(monList.get(i).curhp <= 0) {
				num += 1;
			}
		}
		m_dead = monList.size() - num;
	}
	
	
	@Override
	public void init() {
		UnitManager unitManager = new UnitManager();
		unitManager.mon_list.clear();
		playerList = unitManager.player_list;
		monList = null;
		unitManager.mons_rand_set(4);
		monList = unitManager.mon_list;
		m_dead = monList.size();
		p_dead = playerList.size();
	}

	void print_character() {
		System.out.println("======[BATTLE]======");
		System.out.println("======[PLAYER]======");
		for (int i = 0; i < playerList.size(); i++) {
			playerList.get(i).print();
		}
		System.out.println("======[MONSTER]======");
		for (int i = 0; i < monList.size(); i++) {
			monList.get(i).print();
		}
	}

	void player_attack(int idx) {
		Player p = playerList.get(idx);
		if(p.curhp <= 0) return;
		System.out.println("======[메뉴 선택]======");
		System.out.println("["+p.name+"] [1.어택] [2.스킬]");
		int sel = GameManager.getValue("공격", 1, 2);
		if(sel == 1) {
			while(true) {
			int r = rd.nextInt(monList.size());
			if(monList.get(r).curhp > 0) {
				p.attack(monList.get(r));
				break;
			}
			} //while
		} else {
			// 스킬
			while(true) {
				int r = rd.nextInt(monList.size());
				if(monList.get(r).curhp > 0) {
					p.skill_attack(monList.get(r));
					break;
				}
			}
		}
	}
	
	void monster_attack(int idx) {
		Unit m = monList.get(idx);
		if(m.curhp <= 0) return;
		int r = rd.nextInt(playerList.size());
		if(playerList.get(r).curhp > 0) {
			m.attack(playerList.get(r));
		}
	}
	
	
}