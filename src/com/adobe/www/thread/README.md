[线程基础](http://www.cnblogs.com/rollenholt/archive/2011/08/28/2156357.html)

##线程的生命周期:

				阻      塞
				|		^
				v		|
	新建---> 就绪 <---->运行 --->死亡

	新建:创建了线程对象
		线程start之后,就不能再start了
	就绪(runnable):  线程对象.start();
	运行:获得CPU资源
	阻塞: sleep(),IO阻塞
	死亡:线程运行完,Exception或Error
		线程死了之后,就不能再start了;

常量:
- static int MAX_PRIORITY  线程可以具有的最高优先级。 
- static int MIN_PRIORITY  线程可以具有的最低优先级。 
- static int NORM_PRIORITY 分配给线程的默认优先级。 

常用方法:
- static Thread currentThread()
		返回对当前正在执行的线程对象的引用。 
- String getName() 
		返回该线程的名称。 
- int getPriority() 
		返回线程的优先级。 
- boolean isAlive() 
		测试线程是否处于活动状态。
		就绪,运行,阻塞
- boolean isDaemon() 测试该线程是否为后台线程
- void join() 等待该线程终止。 
		启动线程: start方法,永远不会去调用run方法
- protected  void finalize() 不需要我们来调用,系统自动调用;
        当垃圾回收器确定不存在对该对象的更多引用时，由对象的垃圾回收器调用此方法。 
		强制回收垃圾:  System.gc();//Runtime.getRuntime().gc();
- void setDaemon(boolean on) 设置成后台线程
		必须先设置,再启动;
- void setName(String name) 
		改变线程名称 
- void setPriority(int newPriority)
		更改线程的优先级。 
		无论什么时候都可以设置其优先级
		线程的优先级: 表示优先级高的线程执行机会的次数更多;
		设置线程的优先级,尽量使用三个常量;
- static void sleep(long millis) 
		线程休眠,进入阻塞状态,不会失去同步监听对象
- void start() 
		使该线程开始执行 
- static void yield()  线程礼让,调用yield之后,进入就绪状态,
		思考题 1:  final,finally, finalize 的区别?
	
##线程同步:
- 1.同步代码块:
	synchronized(同步监听对象)
	{
		//需要同步的代码
	}
	同步监听对象:保持不变的一个对象,
		取值通常有:
				1. 同一份资源;
				2. this,此时只能使用实现方法,继承时不能使用this
				3. 同步代码块所在类的字节码,  OOXX.class(JVM中相同的字节码,只有一份)
		
- 2. 同步方法:  
		非静态方法默认使用的是this作为同步监听对象;
		静态方法默认是使用的是方法所在类的字节码对象;
			1.直接在run方法前 使用 synchronized:
					但是,此时只能用实现方式,
			2.一般情况下,我们单独写一个方法,并使用同步,在run方法里,调用;

- 3. 使用可重入锁:
			java.util.concurrent.locks.Lock 接口:
			java.util.concurrent.locks.ReentrantLock类:
			
		写法格式:
			1.创建ReentrantLock 对象;
			2.在需要同步的方法里,
				(1). 进入方法后,获取锁
				(2). 把需要同步的代码,放在 try 块里;
				(3). 在 finally 块里,手动解锁;		
			语法格式:
			private final ReentrantLock lock  = new ReentrantLock();
			public void m(){
				lock.lock();//获取锁
				
				try{
					//需要同步的代码
				}finally{
					lock.unlock();//手动解锁
				}
			}
				
	思考题2:  synchronized 和  java.util.concurrent.locks.Lock 的区别:
	
- 单例模式:
		
		class Singleton{
			private static  Singleton instance = null;
			
			//双重判断
			public static Singleton getInstance(){
				
				if(instance == null)
				{	
					synchronized(Singleton.class){
						if(instance == null)
						{	
							instance = new Singleton();
						}
					}
				}
				return instance;
			}
			
			private Singleton(){}
		}
	
- Spring : 
		DI(IoC)
		AOP: 动态代理(反射)
		<bean id="ooxx" class="Singleton的权限定名" scope="singleton"/>
		//这就能搞一个Singleton的权限定名的一个单例对象,因为<bean/>默认创建的就是作用域就是 singleton
		
- 死锁:
		多个线程同时锁住同一个监听对象,
		开发中要避免死锁;
	
- 生产者和消费者:
		1.  妖的问题
		2.	存钱和取钱问题

- Object:
		必须使用同步监听对象调用,而且必须写在同步代码块里去;
		wait();  表示当前线程进人等待,要失去同步监听对象,自己不能唤醒自己
		notify():	表示唤醒在等待的线程对象;
		notifyAll(): 表示唤醒多个
		
		若使用的是同步代码块:
		
			那么wait().notify()就得使用自己写的同步监听对象调用
			synchronized(OOXX)
			{
				OOXX.wait();
			}
		
	java.util.concurrent.locks.Condition:
	
	private final ReentrantLock lock = new ReentrantLock();
		Condition con = lock.newCondition();

 	void await()   等价于 Object的wait()
          造成当前线程在接到信号或被中断之前一直处于等待状态。 
 	void signal()  等价于Object的notify();
          唤醒一个等待线程。 
 	void signalAll() 	等价于Object的 notifyAll();
          唤醒所有等待线程。 



		



