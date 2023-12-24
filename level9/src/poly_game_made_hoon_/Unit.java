package poly_game_made_hoon_;

public abstract class Unit {
	int curhp;
	int maxhp;
	int power;
	String name;
	String state = "노말";

	Unit() {
	};

	Unit(String na, int max, int pw) {
		name = na;
		maxhp = max;
		curhp = max;
		power = pw;
	};

	void init(int max, int pw) {
		maxhp = max;
		curhp = max;
		power = pw;
	};

	void init(String na, int max, int pw) {
		name = na;
		maxhp = max;
		curhp = max;
		power = pw;
	}

	void printData() {
		System.out.println("["+name+"] ["+curhp+"/"+maxhp+"] ["+power+"]" );
	}
	
	void attack(Unit unit) {
		unit.curhp -= power;
		System.out.println("["+name+"] 가 " + "["+unit.name+"] 에게 " + power +"의 데미지를 입힙니다."  );
		if(unit.curhp <= 0) {
			System.out.println(unit.name + "를 처치했습니다.");
			unit.curhp = 0;
		}
	}
	
	
}