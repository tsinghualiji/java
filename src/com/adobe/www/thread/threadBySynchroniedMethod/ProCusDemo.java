package threadBySynchroniedMethod;

/**
 * 仓库
 */
class Person {
	private String name;
	private String sex;

	private boolean isEmpty = false;// 用来标记仓库是否是空的

	/**
	 * 生产 若仓库不为空,那么生产者应该等着消费者消费, 生产者生产完后, 要标记仓库的状态,唤醒消费者
	 * 
	 * @param name
	 * @param sex
	 */
	public synchronized void put(String name, String sex) {

		while (!isEmpty) {// 不空
			// 使用同步监听对象来调用 wait方法
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
		// 生产完
		isEmpty = false;
		this.notify();
	}

	/**
	 * 消费
	 */
	public synchronized void get() {
		while (isEmpty) {
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println(name + "----> " + sex);

		// 消费完
		isEmpty = true;
		this.notify();
	}

}

/**
 * 生产者
 */
class Pro implements Runnable {

	private Person p;

	public Pro(Person p) {
		this.p = p;
	}

	public void run() {
		for (int i = 0; i < 100; i++) {
			if (i % 2 == 0) {
				p.put("春哥哥", "男");
			} else {
				p.put("著姐", "女");
			}
		}
	}
}

/**
 * 消费者
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
