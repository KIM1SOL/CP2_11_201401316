
public class NumberOfFork {
	//�ʱ� ���̺� �ִ� ��ũ�� ���� �����ϱ� ����
	//ö���ڰ� ��ũ�� �ϳ� ��� decrement, ���������� increment
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
