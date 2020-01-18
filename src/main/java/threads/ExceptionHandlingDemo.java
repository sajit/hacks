package threads;

public class ExceptionHandlingDemo {

	/**
	 * Exceptions thrown in thread is not caught in main thread. To handle those exceptions define a
	 * {@link Thread.UncaughtExceptionHandler}
	 * @param args
	 */
	public static void main(String[] args) {
		Thread.UncaughtExceptionHandler handler = (th, ex) -> System.out.println("Uncaught exception: " + ex);
		Thread t0 = new Thread(() -> {
			throw new RuntimeException("die");
		});
		t0.setUncaughtExceptionHandler(handler);

		t0.start();
		System.out.println("Normally exiting main thread");
	}
}

