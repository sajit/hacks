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

