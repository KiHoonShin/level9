package _05인터페이스;

import java.util.Random;

// damage() 메소드를 가진
// Interface Damageable 을 정의하고
// 최하위 유닛들 (모든) 에게 Damageable 상속
// main에서 각각의 유닛들을 손상시킨 후 -> repair() 돌려보기


// 마크 인터페이스 : 안에 구현부는 없고 클래스를 구분하기 위해서 사용하는 인터페이스
interface Repairable{}

interface Damageable{}

// 모든 유닛의 최고 조상클래스
class Unit{
	protected final int MAX_HP;
	protected int hp;
	protected String name;
	public Unit(int hp) {
		MAX_HP = hp;
		this.hp = hp;
	}
	@Override
	public String toString() {
		return "%s [%d / %d]".formatted(name,hp,MAX_HP);
	}
	
	public void damage(Damageable damageUnit) {
		Random rd = new Random();
		Unit unit = (Unit) damageUnit;
		int damage = rd.nextInt(30) + 1;
		unit.hp -= damage;
		if (unit.hp < 0) {
			unit.hp = 0;
			System.out.println("죽음");
		}
		System.out.printf("%s 가 %s -%d 데미지 공격 %n", this, unit, damage);
	}
}

abstract class GroundUnit extends Unit{
	public GroundUnit(int hp) {
		super(hp);
	}
}

abstract class AirUnit extends Unit{
	public AirUnit(int hp) {
		super(hp);
	}
}

class Tank extends GroundUnit implements Repairable , Damageable{
	
	public Tank() {
		super(150);
		name = "Tank";
		System.out.println(this);
	}
}

class Marine extends GroundUnit implements Damageable{
	
	public Marine() {
		super(70);
		name = "Marine";
		System.out.println(this);
	}
}

class DropShip extends AirUnit implements Repairable , Damageable{
	public DropShip() {
		super(120);
		name = "DropShip";
		System.out.println(this);
	}
}

class SCV extends GroundUnit implements Repairable , Damageable {
	public SCV() {
		super(100);
		name = "SCV";
		System.out.println(this);
	}
	public void repair(Repairable repairUnit) {
		Unit unit = (Unit) repairUnit;
		unit.hp += 30;
		if(unit.hp > unit.MAX_HP) {
			unit.hp = unit.MAX_HP;
		}
		System.out.println(unit + "수리 완료");
	}
	
}


public class _05인터페이스_실습2 {

	public static void main(String[] args) {
		//Random rd = new Random();
		Tank tank = new Tank();
		Marine marine = new Marine();
		SCV scv = new SCV();
		DropShip dropShip = new DropShip();
		System.out.println("----------------------");
		//scv.repair(dropShip);
		// scv.repair(marine); implements Repairable 없어서 불가능
		scv.damage(dropShip);
		dropShip.damage(scv);
		tank.damage(dropShip);
		marine.damage(tank);
		scv.repair(dropShip);
		System.out.println("-----------------------");
		System.out.println(tank);
		System.out.println(marine);
		System.out.println(scv);
		System.out.println(dropShip);
		
	}

}
