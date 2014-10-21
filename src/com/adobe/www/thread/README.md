![线程流程图](https://raw.githubusercontent.com/tsinghualiji/java/master/images/thread-life-cycle-in-java-flowchart.gif)
[线程基础](http://www.cnblogs.com/rollenholt/archive/2011/08/28/2156357.html)

##lock与synchronized的区别：

- ReentrantLock 拥有Synchronized相同的并发性和内存语义，此外还多了 锁投票，定时锁等候和中断锁等候
     线程A和B都要获取对象O的锁定，假设A获取了对象O锁，B将等待A释放对O的锁定，
     如果使用 synchronized ，如果A不释放，B将一直等下去，不能被中断
     如果 使用ReentrantLock，如果A不释放，可以使B在等待了足够长的时间以后，中断等待，而干别的事情
 
    ReentrantLock获取锁定与三种方式：
    1. a)  lock(), 如果获取了锁立即返回，如果别的线程持有锁，当前线程则一直处于休眠状态，直到获取锁
    2. b) tryLock(), 如果获取了锁立即返回true，如果别的线程正持有锁，立即返回false；
    3. c)tryLock(long timeout,TimeUnit unit)，   如果获取了锁定立即返回true，如果别的线程正持有锁，会等待参数给定的时间，在等待的过程中，如果获取了锁定，就返回true，如果等待超时，返回false；
    4. d) lockInterruptibly:如果获取了锁定立即返回，如果没有获取锁定，当前线程处于休眠状态，直到或者锁定，或者当前线程被别的线程中断
 
- synchronized是在JVM层面上实现的，不但可以通过一些监控工具监控synchronized的锁定，而且在代码执行时出现异常，JVM会自动释放锁定，但是使用Lock则不行，lock是通过代码实现的，要保证锁定一定会被释放，就必须将unLock()放到finally{}中
 
- 在资源竞争不是很激烈的情况下，Synchronized的性能要优于ReetrantLock，但是在资源竞争很激烈的情况下，Synchronized的性能会下降几十倍，但是ReetrantLock的性能能维持常态

	1. synchronized： 
在资源竞争不是很激烈的情况下，偶尔会有同步的情形下，synchronized是很合适的。原因在于，编译程序通常会尽可能的进行优化synchronize，另外可读性非常好，不管用没用过5.0多线程包的程序员都能理解。 

	2. ReentrantLock: 
ReentrantLock提供了多样化的同步，比如有时间限制的同步，可以被Interrupt的同步（synchronized的同步是不能Interrupt的）等。在资源竞争不激烈的情形下，性能稍微比synchronized差点点。但是当同步非常激烈的时候，synchronized的性能一下子能下降好几十倍。而ReentrantLock确还能维持常态。 

	3. Atomic: 
和上面的类似，不激烈情况下，性能比synchronized略逊，而激烈的时候，也能维持常态。激烈的时候，Atomic的性能会优于ReentrantLock一倍左右。但是其有一个缺点，就是只能同步一个值，一段代码中只能出现一个Atomic的变量，多于一个同步无效。因为他不能在多个Atomic之间同步

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



		



