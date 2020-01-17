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
		Counter counter = new Counter();
		Thread t0 = new Thread(() -> {
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
			for(int i=Integer.MIN_VALUE;i<Integer.MAX_VALUE;i++);
			count++;
		}

	}
	public int getCount() {
		return count;
	}
}
