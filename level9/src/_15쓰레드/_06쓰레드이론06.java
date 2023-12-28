package _15쓰레드;

public class _06쓰레드이론06 {
// volatile : 변수값이 변경될때마다 메모리를 업데이트
	static volatile boolean stop = false;
	public static void main(String[] args) {
		
		new Thread(() -> {
			int i = 0;
			while (!stop) {
				i++;
	//			System.out.println(i);
			}

			System.out.println("--- 쓰레드 종료 ---");
		}).start();
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		stop = true;
	}

}
