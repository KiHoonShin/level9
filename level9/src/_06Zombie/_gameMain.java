package _06Zombie;

import java.util.*;

public class _gameMain {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		Random r = new Random();
		                         // max = 최대 공격력 범위 : 공격범위는 1~max 까진
                          // pos,hp,max,count
		Hero hero = new Hero(1, 200, 50, 2);
		Zombie zombie = new Zombie(5, 100, 10);
		
		                  // pos,hp,max,shield
		Boss boss = new Boss(9, 300, 20, 100);

		int pos = 1;
		//hero.setPos(pos);
		while (true) {
	
			if(hero.isDead()) {
				System.out.println("===== 사망 ===== ");
				break;
			}
			System.out.println("현재 위치 = " + pos);

			System.out.print("앞으로 이동하기(1),종료하기(2) ");

			int move = s.nextInt();
			
			if (move == 1) {
				hero.setPos(++pos);
				
				if (hero.getPos() == zombie.getPos()) {
					
				System.out.print("좀비를 만났습니다. 공격모드로 바뀝니다. ");

				while (true) {
					if (hero.isDead())
						break;
					System.out.print("공격하기(1),포션마시기(2): ");
					int sel = s.nextInt();
					if (sel == 1) {
						// 공격하기
						hero.attack(zombie);
						if (zombie.isDead()) {
							System.out.println("좀비를 죽였습니다. 이동할 수 있습니다.");
							break;
						}
						// 좀비턴
						int heroHitZombie = hero.getPower() / 2;
						zombie.attack(hero);
						zombie.damageInfo(hero , heroHitZombie);
						
					} else {
						// 포션마시기
						hero.plusHP();
					}
				}
			}
				if (hero.getPos() == boss.getPos()) {
					System.out.print("보스를 만났습니다. 공격모드로 바뀝니다. ");
					while (true) {
						if(hero.isDead()) break;
						System.out.print("공격하기(1),포션마시기(2): ");
						int d = s.nextInt();
						if(d == 1) {
							// 히어로 턴
							hero.attack(boss);
							if(boss.isDead()) {
								System.out.println("[보스를 이겼습니다. 이동할 수 있습니다.]");
								break;
							}
							// 보스 턴
							boss.attack(hero);
						} else {
							// 포션 마시기
							hero.plusHP();
						}
					}
				
			} 
				if (hero.getPos() == 10) {
					System.out.println("게임에서 승리했습니다. 종료합니다.");
					break;
				}
	} else if (move == 2) {
		break;
	}

  } //while
		
 }
}