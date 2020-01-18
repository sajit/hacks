package gc;

public class DeadlockDemo {

	static boolean goB = false;
	public static void main(String[] args) {
		A a = new A();
		B b = new B();
		a.setB(b);
		b.setA(a);
		Thread tA = new Thread(() -> {
			a.computeA();
		});
		Thread tB = new Thread(() -> {
			b.computeB();
		});
		tA.start();
		tB.start();
	}
}
class A {
	private B b;

	public void setB(B b){
		this.b = b;
	}

	public void computeA() {
		System.out.println("Computing A" + Thread.currentThread().getName());

		synchronized (this) {
			DeadlockDemo.goB = true;
			b.computeB();
		}
	}
}
class B {
	private A a;

	public void setA(A a){
		this.a = a;
	}

	public synchronized void computeB() {
		while(!DeadlockDemo.goB ){}
		System.out.println("Computing B" + Thread.currentThread().getName());


	}
}
