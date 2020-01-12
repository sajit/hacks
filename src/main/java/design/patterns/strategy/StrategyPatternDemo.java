package design.patterns.strategy;

public class StrategyPatternDemo {

	public static void main(String[] args) {
		Driver driver = new Driver(new NormalDrivingStrategy());
		System.out.println("Time taken to cover distance 60 mi" + driver.getTime(60,40));
		Driver procastinator = new Driver(new RecklessDrivingStrategy());
		System.out.println("Time taken to cover distance 60 mi" + procastinator.getTime(60,40));

	}
}
