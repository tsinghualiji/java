package threadsynchBolckByClass;

/**
 * �˻�
 */
public class Account {

	private double balance;
	private boolean isEmpty = true;// �˻��Ƿ������
	/**
	 * �洢����
	 * 
	 * @param money
	 *            ��ʾ�洢��ë��ϯ
	 */
	public void save(double money) {
		synchronized (Account.class) {
			while (!isEmpty) {
				try {
					Account.class.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}// ����������
			}
			setBalance(balance + money);// �޸����
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out
					.println(Thread.currentThread().getName() + ",����" + money);

			// ����ǰ,
			isEmpty = false;
			Account.class.notify();// ���������ȡǮ
		}
	}

	/**
	 * ȡ�����
	 * 
	 * @param money
	 */
	public void draw(double money) {
		synchronized (Account.class) {
			while (isEmpty) {
				try {
					Account.class.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}// �������ϵ��Ǯ
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
			Account.class.notify();// �������ϵ��Ǯ
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
