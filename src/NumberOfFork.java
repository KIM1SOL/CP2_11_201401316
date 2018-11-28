
public class NumberOfFork {
	//초기 테이블에 있는 포크의 수를 설정하기 위함
	//철학자가 포크를 하나 들면 decrement, 내려놓으면 increment
	int number;
	
	public NumberOfFork(int number) {
		this.number = number;
	}

	public void increment() {number ++;}
	
	public void decrement() {number --; }
	
	public void printCounter() {System.out.println(number);}
	
	public int getForkNum() {
		return number;
	}


}
