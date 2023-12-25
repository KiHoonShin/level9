package poly_game_made_hoon_;

public abstract class Unit {
	String name;
	int power;
	int curhp;
	int maxhp;
	
	Unit(){
	}
	
	Unit(String name, int maxhp, int power) {
		this.curhp = maxhp;
		this.name = name;
		this.maxhp = maxhp;
		this.power = power;
	}
	
	void init(int max, int pw) {
		maxhp = max;
		curhp = max;
		power = pw;
	};
	
	void init (String name, int max ,int power){
		this.name = name;
		this.maxhp = max;
		this.power = power;
	}
	
	void print() {
		System.out.println("["+name+"] ["+curhp+"/"+maxhp+"] ["+power+"]");
	}
	
	void attack(Unit enemy) {
		enemy.curhp -= power;
		if(enemy.curhp <= 0) {
			enemy.curhp = 0;
			System.out.println(enemy.name+"를 처치했습니다.");
		} else {
			System.out.println("["+name+"] 가 [" + enemy.name+"] 에게 " + power+"의 데미지를 입힙니다");
		}
	}
	
	void skill_attack(Unit enemy) {
		int skill_power = power;
		if(name.equals("전사")) {
			System.out.println("스킬 발동 ! 공격력 2배 증가");
			skill_power *= 2;
		} else if(name.equals("법사")) {
			System.out.println("스킬 발동 ! ");
		} else {
			//힐러
			System.out.println("스킬 발동 ! 피(+50) 회복");
			curhp += 50;
			if(curhp >= maxhp) {
				curhp = maxhp;
			}
		}
		
		enemy.curhp -= skill_power;
		if(enemy.curhp <= 0) {
			enemy.curhp = 0;
			System.out.println(enemy.name+"를 처치했습니다.");
		} else {
			System.out.println("["+name+"] 가 [" + enemy.name+"] 에게 " + skill_power+"의 데미지를 입힙니다");
		}
	}
	
}