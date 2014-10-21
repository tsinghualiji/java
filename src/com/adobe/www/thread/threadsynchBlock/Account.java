package threadsynchBlock;

/**
 * 账户
 */
public class Account {

	private double balance;
	private boolean isEmpty = true;// 账户是否有余额

	/**
	 * 存储操作
	 * @param money
	 * 表示存储的毛主席
	 */
	public void save(double money) {
		synchronized (this) {
			while (!isEmpty) {
				try {
					this.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}// 监听对象调用
			}
			setBalance(balance + money);// 修改余额
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out
					.println(Thread.currentThread().getName() + ",存了" + money);

			// 存完钱,
			isEmpty = false;
			this.notify();// 唤醒她儿子取钱
		}
	}

	/**
	 * 取款操作
	 * 
	 * @param money
	 */
	public void draw(double money) {
		synchronized (this) {
			while (isEmpty) {
				try {
					this.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}// 等着他老爹打钱
			}
			if (balance >= money) {
				setBalance(balance - money);// 修改余额
				try {
					Thread.sleep(1);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("-->" + Thread.currentThread().getName()
						+ ",取走" + money);
			} else {
				System.out.println(Thread.currentThread().getName() + ",余额不足,"
						+ balance);
			}
			// 去完前
			isEmpty = true;
			this.notify();// 唤醒他老爹存钱
		}
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public Account(double balance) {
		super();
		this.balance = balance;
	}

}
