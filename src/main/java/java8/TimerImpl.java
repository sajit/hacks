package java8;

public class TimerImpl implements Timer {
	private int var;
	{
		var = 90;
	}
	@Override
	public int convert(String s) {
		return s.length();
	}

	@Override
	public int addAll(int... elements) {
		return 0+var;
	}
	static {
		TimerImpl timer = new TimerImpl();
		timer.addAll(new int[]{5,6});
	}
}
