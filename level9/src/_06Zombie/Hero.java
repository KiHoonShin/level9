package _06Zombie;

//보스인지 아닌지 구분해서 공격 

//히어로는 체력 포션으로 100 체력 회복할 수 있고 체력 포션이 없으면 체력 회복이 안된다 
//외부의 적은 보스인지 아닌지 구별해서 공격 해야한다 
//보스이면 보호막을 가지고 있다 먼저 보호막을 다 뚫어야지만 직접 보스를 공격할 수 있다. 
//일반 적은 보호막 가지고 있지 않음 

public class Hero extends Unit {
	private int power;
	private int count; // 체력포션
	
	public Hero(int pos, int hp, int max, int count) {
		super(pos, hp, max);
		this.count = count;
	}

	private boolean drinkPotion() {
		if(count == 0) {
			return false;
		}
		this.setHp(this.getHp()+100);
		this.count -=1;
		return true;
	}
	
	public int getPower() {
		return power;
	}
	
	@Override
	void attack(Unit unit) {
		this.power = this.getRd().nextInt(this.getMax())+1;
		unit.setHp(unit.getHp()-power);
		damageInfo(unit);
	}

	private void damageInfo(Unit unit) {
		System.out.println("히어로가 %d의 공격력으로 좀비 공격 : 현재 좀비 hp : %d"
				.formatted(power, unit.getHp()));
	}
	
	public void plusHP() {
		if(!drinkPotion()) {
			System.out.println("모두 사용했습니다.");
			return;
		}
		System.out.println("체력 회복해서"+this.getHp()+"이 되었습니다");
	}
	
	// 보스 공격
	public void attack(Boss boss) {
		this.power = this.getRd().nextInt(this.getMax())+1;
		if(boss.getShield() > 0) {
			boss.setShield(boss.getShield()-power);
		} else {
			boss.setHp(boss.getHp()-power);
		}
		System.out.println("히어로가 %d의 공격력으로 보스 공격 : 현재 Boss hp : %d 현재 Boss Shield : %d"
				.formatted(power, boss.getHp() , boss.getShield()));
	}
}
