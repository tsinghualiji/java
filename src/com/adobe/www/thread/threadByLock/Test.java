package threadByLock;

public class Test {
	public static void main(String[] args) {
		
		Account a = new Account(0);
		new Thread(new SaveMoney(a, 1000),"����").start();
		new Thread(new DrawMoney(a, 1000),"����").start();
	
	}
}
