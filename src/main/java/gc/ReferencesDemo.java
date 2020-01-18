package gc;

import java.lang.ref.WeakReference;

public class ReferencesDemo {


	public static void main(String[] args) {
		WeakReference<Foo> fooWR = new WeakReference<>(new Foo());
		System.out.println(fooWR.get());
		fooWR.clear();
		System.out.println(fooWR.get());

	}
}
class Foo {
	public String getType() {
		return "foo";
	}
}
