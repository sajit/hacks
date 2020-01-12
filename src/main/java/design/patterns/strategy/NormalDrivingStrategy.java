package design.patterns.strategy;

public class NormalDrivingStrategy implements DrivingStrategy {
	@Override
	public int speed(int limit) {
		return limit;
	}
}
