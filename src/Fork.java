
public class Fork {
	//테이블에 포크가 없다면 마지막에 든 사람이 내려놓는다 -> 데드락 해결법 
	
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
			System.out.println("["+num+"] 철학자가 ["+forkNumber+"] 포크를 들었습니다.");
			EndUse(num);
		}
		else {
			num_of_fork.decrement();
			System.out.println("["+num+"] 철학자가 ["+forkNumber+"] 포크를 들었습니다.");
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
		System.out.println("["+ num+"] 철학자가 [" +forkNumber+"] 포크를 놓았습니다." );
		notifyAll();
		
	}

}
