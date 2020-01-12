package design.patterns.strategy;

public class Driver {

	private DrivingStrategy strategy;

	public Driver(DrivingStrategy strategy) {
		this.strategy = strategy;
	}

	public void setStrategy(DrivingStrategy strategy) {
		this.strategy = strategy;
	}
	public double getTime(int distance,int limit) {
		return (double)distance/(double)strategy.speed(limit);
	}
}
