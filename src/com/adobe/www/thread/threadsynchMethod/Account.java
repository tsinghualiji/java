package threadsynchMethod;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * �˻�
 */
public class Account {

	private double balance;
	private final Lock lock = new ReentrantLock();
	private final Condition con = lock.newCondition();
	private boolean isEmpty = true;// �˻��Ƿ������
	public double getBalance() {
		return balance;
	}

	/**
	 * �洢����
	 * 
	 * @param money
	 *            ��ʾ�洢��ë��ϯ
	 */
	public void save(double money) {
		lock.lock();
		try {
			while (!isEmpty) {
				con.await();
			}
			setBalance(balance + money);// �޸����
			Thread.sleep(1);
			System.out.println(Thread.currentThread().getName() + ",����" + money);
			// ����ǰ,
			isEmpty = false;
			con.signal();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}

	/**
	 * ȡ�����
	 * 
	 * @param money
	 */
	public void draw(double money) {
		lock.lock();
		try {
			while (isEmpty) {
				con.await();
			}
			if (balance >= money) {
				setBalance(balance - money);// �޸����
				Thread.sleep(1);
				System.out.println("-->" + Thread.currentThread().getName()
						+ ",ȡ��" + money);
			} else {
				System.out.println(Thread.currentThread().getName() + ",����,"
						+ balance);
			}
			// ȥ��ǰ

			isEmpty = true;
			con.signal();
		} catch (Exception e) {
		} finally {
			lock.unlock();
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
