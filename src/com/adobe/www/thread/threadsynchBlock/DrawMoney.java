package threadsynchBlock;

/**
 * ȡ����
 *
 */
public class DrawMoney implements Runnable {
	private Account a;//�����˻�
	private double money;

	public DrawMoney(Account a, double money) {
		super();
		this.a = a;
		this.money = money;
	}

	public void run() {
		for (int i = 0; i < 50; i++) {
			a.draw(money);
		}
	}

}
