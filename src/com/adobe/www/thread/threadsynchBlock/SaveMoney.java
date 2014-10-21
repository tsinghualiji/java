package threadsynchBlock;

/**
 * ´æ¿îÕß
 */
public class SaveMoney implements Runnable {

	private Account a;//ÒÀÀµÕË»§
	private double money;
	
	public SaveMoney(Account a, double money) {
		super();
		this.a = a;
		this.money = money;
	}

	public void run() {
		for (int i = 0; i < 50; i++) {
			a.save(money);
		}
	}

}
