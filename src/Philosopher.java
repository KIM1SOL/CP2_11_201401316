import java.util.Random;

public class Philosopher extends Thread {
	private int philosopher_num;
	private Fork fork;
	private Fork fork2;
	
	
	public Philosopher(int i, Fork forkk, Fork forkk2) {
		philosopher_num = i;
		fork = forkk;
		fork2 = forkk2;
	}
	public void eat() {
		fork.use(philosopher_num);
		fork2.use(philosopher_num);
		System.out.println("[" +philosopher_num+"] Ã¶ÇÐÀÚ ¸Ô´ÂÁß...");
	}
	public void think() {
		fork.EndUse(philosopher_num);
		fork2.EndUse(philosopher_num);
		
		int a = new Random().nextInt(100);
		try {
			System.out.println("[" +philosopher_num+"] Ã¶ÇÐÀÚ »ý°¢Áß...");
			Thread.sleep(a);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}	
	}
	
	public void run() {
		eat();
		think();
	}
}
