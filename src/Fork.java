
public class Fork {
	//���̺� ��ũ�� ���ٸ� �������� �� ����� �������´� -> ����� �ذ�� 
	
	private NumberOfFork num_of_fork;
	private boolean isUse = false;
	private int forkNumber;
	
	public Fork(int i, NumberOfFork fork_num) {
		this.num_of_fork = fork_num;
		forkNumber = i;
	}
	
	public synchronized void use(int num) {
		while(isUse) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		isUse = true;
		if(num_of_fork.getForkNum() == 1) {
			System.out.println("["+num+"] ö���ڰ� ["+forkNumber+"] ��ũ�� ������ϴ�.");
			EndUse(num);
		}
		else {
			num_of_fork.decrement();
			System.out.println("["+num+"] ö���ڰ� ["+forkNumber+"] ��ũ�� ������ϴ�.");
		}
		notifyAll();
		
	}
	
	public synchronized void EndUse(int num) {
		while(!isUse) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		isUse = false;
		num_of_fork.increment();
		System.out.println("["+ num+"] ö���ڰ� [" +forkNumber+"] ��ũ�� ���ҽ��ϴ�." );
		notifyAll();
		
	}

}
