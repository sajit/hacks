package java8;

public interface Timer {

	int convert(String s);

	default int convert(double d){
		return (int)d;
	}

	int addAll(int... elements);
}
