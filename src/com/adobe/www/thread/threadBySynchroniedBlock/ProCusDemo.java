package threadBySynchroniedBlock;

/**
 * �ֿ�
 */
class Person {
	private String name;
	private String sex;
	private boolean isEmpty = false;// ������ǲֿ��Ƿ��ǿյ�

	/**
	 * ��� ���ֿⲻΪ��,��ô�����Ӧ�õ�����������, �����������, Ҫ��ǲֿ��״̬,���������
	 * 
	 * @param name
	 * @param sex
	 */
	public void put(String name, String sex) {

		synchronized (this) {
		//Ҫ��ʹ��Person.class��Ϊͬ���������Ļ�,����wait�� notify����Ҳ��ʹ�� Person.class������
		//synchronized (Person.class) {ERROR
			while (!isEmpty) {// ����
				// ʹ��ͬ��������������� wait����
				try {
					this.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			this.name = name;
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			this.sex = sex;
			// �����
			isEmpty = false;
			this.notify();
		}

	}

	/**
	 * ���
	 */
	public void get() {
		//synchronized (Person.class) {ERROR
		synchronized (this) {
			while (isEmpty) {
				try {
					this.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			System.out.println(name + "----> " + sex);

			// �����
			isEmpty = true;
			this.notify();
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
