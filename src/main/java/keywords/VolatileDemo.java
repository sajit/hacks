package keywords;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Without volatile you will see output such as this
 * Incremented in Thread=pool-1-thread-1 current Count=15
 * Thread=pool-1-thread-2 count = 14
 * thread-1 incremented the value of count but thread-2 still reads old value
 *
 * However with volatile we see that thread-2 gets incremented
 * Thread=pool-1-thread-2 count = 13
 * Thread=pool-1-thread-2 count = 14
 *
 * You can use Volatile variable if you want to read and write long and double variable atomically. long and double both are 64 bit data type
 * and by default writing of long and double is not atomic and platform dependence. Many platform perform write in
 * long and double variable 2 step, writing 32 bit in each step,
 * due to this its possible for a Thread to see 32 bit from two different write.
 * You can avoid this issue by making long and double variable volatile in Java.
 *
 * Read more: https://javarevisited.blogspot.com/2011/06/volatile-keyword-java-example-tutorial.html#ixzz6BQK3ZiE5
 *
 * with volatile variable, it's guaranteed that all reader thread will see updated value of the volatile variable once write operation completed, without volatile keyword different reader thread may see different values.
 *
 * Read more: https://javarevisited.blogspot.com/2011/06/volatile-keyword-java-example-tutorial.html#ixzz6BQKLkncu
 * volatile variable can be used to inform the compiler that a particular field is subject to be accessed by multiple threads, which will prevent the compiler from doing any reordering or any kind of optimization which is not desirable in a multi-threaded environment
 *
 * Read more: https://javarevisited.blogspot.com/2011/06/volatile-keyword-java-example-tutorial.html#ixzz6BQKTMkOb
 *
 */
class SharedObject {
	private volatile int count;
	public void increment(String threadName) {
		count++;
		System.out.println("Incremented in Thread="+threadName+" current Count="+count);
	}
	public int getCount() {
		return count;
	}
}
public class VolatileDemo {



	public static void main(String[] args)  {

		ExecutorService executor = Executors.newFixedThreadPool(10);
		SharedObject sharedObject = new SharedObject();
		executor.submit(new CountIncrementer(sharedObject));
		executor.submit(new CountReader(sharedObject));


		executor.shutdown();



	}

	class Foo {

	}

}
class CountIncrementer implements Runnable {
	private final SharedObject sharedObject;
	public CountIncrementer(SharedObject sharedObject){
		this.sharedObject = sharedObject;
	}

	@Override
	public void run() {
		for(int i=0;i<200;i++){
			sharedObject.increment(Thread.currentThread().getName());

		}

	}
}
class CountReader implements Runnable {
	private final SharedObject sharedObject;

	public CountReader(SharedObject sharedObject) {
		this.sharedObject = sharedObject;
	}

	@Override
	public void run() {
		for(int i=0;i<200;i++) {
			System.out.println("Thread="+Thread.currentThread().getName() + " count = " + sharedObject.getCount());

		}

	}
}

