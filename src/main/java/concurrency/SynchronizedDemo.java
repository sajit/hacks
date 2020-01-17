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
		CounterIncrementer t1 = new CounterIncrementer(counter);
		CounterIncrementer t2 = new CounterIncrementer(counter);
		t2.start();
		t1.start();
	}
}
class CounterIncrementer extends Thread {
	private final Counter counter;
	public CounterIncrementer(Counter counter){
		this.counter = counter;
	}

	@Override
	public void run() {
		counter.inc();
		System.out.println("Count="+counter.getCount());
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
