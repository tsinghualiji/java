package threadsynchBlock;

/**
 * �˻�
 */
public class Account {

	private double balance;
	private boolean isEmpty = true;// �˻��Ƿ������

	/**
	 * �洢����
	 * @param money
	 * ��ʾ�洢��ë��ϯ
	 */
	public void save(double money) {
		synchronized (this) {
			while (!isEmpty) {
				try {
					this.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}// �����������
			}
			setBalance(balance + money);// �޸����
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out
					.println(Thread.currentThread().getName() + ",����" + money);

			// ����Ǯ,
			isEmpty = false;
			this.notify();// ����������ȡǮ
		}
	}

	/**
	 * ȡ�����
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
				}// �������ϵ���Ǯ
			}
			if (balance >= money) {
				setBalance(balance - money);// �޸����
				try {
					Thread.sleep(1);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("-->" + Thread.currentThread().getName()
						+ ",ȡ��" + money);
			} else {
				System.out.println(Thread.currentThread().getName() + ",����,"
						+ balance);
			}
			// ȥ��ǰ
			isEmpty = true;
			this.notify();// �������ϵ���Ǯ
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
