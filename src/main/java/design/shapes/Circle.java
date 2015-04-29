package design.shapes;

/**
 * Created by sajit on 4/28/15.
 */
public class Circle implements Shape {
    private final double radius;
    public final static String name = "CIRCLE";

    public Circle(double radius){
        this.radius = radius;
    }
    @Override
    public double getArea() {
        return Math.PI * radius*radius;
    }

    @Override
    public double getPerimeter() {
        return 2*Math.PI*radius;
    }
}
