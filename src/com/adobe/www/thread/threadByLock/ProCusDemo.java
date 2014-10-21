package threadByLock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * �ֿ�
 */
class Person {
	private String name;
	private String sex;
	private final ReentrantLock lock = new ReentrantLock();
	private Condition con = lock.newCondition();
	private boolean isEmpty = false;// ������ǲֿ��Ƿ��ǿյ�

	/**
	 * ��� ���ֿⲻΪ��,��ô�����Ӧ�õ�����������, �����������, Ҫ��ǲֿ��״̬,���������
	 * 
	 * @param name
	 * @param sex
	 */
	public void put(String name, String sex) {
		lock.lock();
		try {
			while (!isEmpty) {
				con.await();
			}
			this.name = name;
			Thread.sleep(1);
			this.sex = sex;
			isEmpty = false;
			con.signal();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}

	/**
	 * ���
	 */
	public void get() {
		lock.lock();
		try {
			while(isEmpty){
				con.await();
			}
			System.out.println(name + "----> " + sex);
			isEmpty = true;
			con.signal();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}

}

/**
 * �����
 */
class Pro implements Runnable {

	private Person p;
	public Pro(Person p) {
		this.p = p;
	}
	public void run() {
		for (int i = 0; i < 100; i++) {
			if (i % 2 == 0) {
				p.put("�����", "��");
			} else {
				p.put("���", "Ů");
			}
		}
	}
}

/**
 * �����
 */
class Cus implements Runnable {
	private Person p;
	public Cus(Person p) {
		this.p = p;
	}
	public void run() {
		for (int i = 0; i < 100; i++) {
			p.get();
		}
	}
}

class ProCusDemo {
	public static void main(String[] args) {
		Person p = new Person();
		new Thread(new Pro(p)).start();
		new Thread(new Cus(p)).start();
	}
}
