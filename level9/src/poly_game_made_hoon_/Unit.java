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

	void attack(Unit unit) {
		 
	}
	
	
	 void printData() {
		System.out.println("["+name+"] ["+curhp+"/"+maxhp+"] ["+power+"]");
				
	};
	
	
	
}