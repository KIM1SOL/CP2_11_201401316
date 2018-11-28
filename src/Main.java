
public class Main {

	public static void main(String[] args) {
		int number = 5;
		NumberOfFork fork_num = new NumberOfFork(number);
		
		//포크 5개
		Fork[] fork = new Fork[number];
		for(int i = 0; i < number; i++) {
			fork[i] = new Fork(i, fork_num);
		}
		
		//철학자 5명
		Philosopher[] philosophers = new Philosopher[number];
		for(int i = 0; i < number; i++) {
			philosophers[i] = new Philosopher(i, fork[i], fork[(i+1)%number]);
		}
		
		//철학자 모두 식사 시작
		for(int i = 0; i < number; i++) {
			(new Thread(philosophers[i])).start();
		}
	}

}
