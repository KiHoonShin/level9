package _06Zombie;

//좀비는 히어로 공격 가능하고 한턴이 지날때마다 방금 맞은 것에 50%를 회복하는 능력을 가지고 있다 
// ex : 히어로가 10을 때리면 +5 회복함 
public class Zombie extends Unit {
	private int power;
	
	public Zombie(int pos,int hp,int max) {
		super(pos,hp,max);
	}
	
	@Override
	void attack(Unit unit) {
		this.power = unit.getRd().nextInt(this.getMax())+1;
		unit.setHp(unit.getHp()-power);
		
	}

	public void damageInfo(Unit unit) {
		System.out.println("좀비가 %d의 공격력으로 히어로 공격했다! 현재 히어로 hp : %d, 좀비 체력 회복 %d"
				.formatted(power,unit.getHp(), this.getHp()));
	}
}
