package threadsynchBlock;

public class Test {
	public static void main(String[] args) {
		
		Account a = new Account(0);	
		new Thread(new SaveMoney(a, 1000),"¸¸Ç×").start();
		new Thread(new DrawMoney(a, 1000),"¶ù×Ó").start();
	}
}
