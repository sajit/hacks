package concurrency;

/**
 * A demo to illustrate synchronized block. With this block of code, only one thread enters into the {@link Counter#inc()}
 * method. Hence the counter is incremented before second thread increments and output looks as follows
 * Thread-1 has lock
 * Thread-0 has lock
 * Count=1
 * Count=2
 *
 * Without the synchronized block , both threads run and don't wait and hence output is as follows
 * Thread-1 has lock
 * Thread-0 has lock
 * Count=1
 * Count=1
 */
public class SynchronizedDemo {
	public static void main(String[] args) {
		String count_prefix = "Count="; //count_prefix is in String pool (in heap)
		Counter counter = new Counter(); // "counter" is object refrence in stack pointing to the object in the heap
		Thread t0 = new Thread(() -> { //No. All threads share a common heap. t0 is an object in heap
			counter.inc();
			System.out.println("Count="+counter.getCount());
		});
		Thread t1 = new Thread(() -> {
			counter.inc();
			System.out.println("Count="+counter.getCount());
		});
		t1.start();
		t0.start();
	}

}

class Counter {

	private int count = 0;
	public void inc() {
		synchronized (this) {
			System.out.println(Thread.currentThread().getName()+" has lock");
			for(int i=Integer.MIN_VALUE;i<Integer.MAX_VALUE;i++); // i is a primitive variable in function stack
			this.count++; //instance variable
		}

	}
	public int getCount() {
		return count;
	}
}
