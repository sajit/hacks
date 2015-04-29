package design.shapes;

/**
 * Created by sajit on 4/28/15.
 */
public class Square implements Shape {
    private final double side;
    public static final String name = "SQUARE";

    public Square(double side){
        this.side = side;
    }
    @Override
    public double getArea() {
        return side*side;
    }

    @Override
    public double getPerimeter() {
        return 4*side;
    }
}
