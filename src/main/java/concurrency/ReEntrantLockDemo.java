package concurrency;

import java.util.concurrent.locks.ReentrantLock;

public class ReEntrantLockDemo {
	public static void main(String[] args) {
		CounterWithLock counter = new CounterWithLock();
		Thread t0 = new Thread(() -> {
			counter.inc();
			System.out.println("Count="+counter.getCount());
		});
		Thread t1 = new Thread(() -> {
			counter.inc();
			System.out.println("Count="+counter.getCount());
		});
		t1.start();
		//t1.start(); throws IllegalThreadStateException
		t0.start();
	}
}


class CounterWithLock {

	private final ReentrantLock lock = new ReentrantLock();
	private int count = 0;
	public void inc() {
		lock.lock();
		System.out.println(Thread.currentThread().getName()+" has lock");
		try {
			for (int i = Integer.MIN_VALUE; i < Integer.MAX_VALUE; i++) ;
			count++;
		}
		finally {
			lock.unlock();
		}


	}
	public int getCount() {
		return count;
	}
}
