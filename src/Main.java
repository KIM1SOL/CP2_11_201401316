
public class Main {

	public static void main(String[] args) {
		int number = 5;
		NumberOfFork fork_num = new NumberOfFork(number);
		
		//��ũ 5��
		Fork[] fork = new Fork[number];
		for(int i = 0; i < number; i++) {
			fork[i] = new Fork(i, fork_num);
		}
		
		//ö���� 5��
		Philosopher[] philosophers = new Philosopher[number];
		for(int i = 0; i < number; i++) {
			philosophers[i] = new Philosopher(i, fork[i], fork[(i+1)%number]);
		}
		
		//ö���� ��� �Ļ� ����
		for(int i = 0; i < number; i++) {
			(new Thread(philosophers[i])).start();
		}
	}

}
