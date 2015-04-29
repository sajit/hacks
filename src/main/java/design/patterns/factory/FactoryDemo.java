package design.patterns.factory;

import design.shapes.Circle;
import design.shapes.Shape;
import design.shapes.Square;

/**
 * Created by sajit on 4/28/15.
 */
public class FactoryDemo {

    public static void main(String[] args){
        ShapeFactory factory = ShapeFactory.getInstance();
        Shape shape1 = factory.getDefaultShapes(Circle.name);
        Square shape2 = (Square)factory.getDefaultShapes(Square.name);

        System.out.println("Area of shape 1 " + shape1.getArea());
        System.out.println("Area of shape 2 " + shape2.getArea());

    }
}
