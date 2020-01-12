package design.patterns.strategy;

public class RecklessDrivingStrategy implements DrivingStrategy {
	@Override
	public int speed(int limit) {
		return limit+15;
	}
}
