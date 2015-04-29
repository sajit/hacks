package design.patterns.factory;

import design.shapes.Circle;
import design.shapes.Shape;
import design.shapes.Square;

/**
 * Created by sajit on 4/28/15.
 */
public class ShapeFactory {

    private static ShapeFactory factory;
    private ShapeFactory(){
    }

    /**
     * This also illustrates the singleton design pattern
     * @return
     */
    public static ShapeFactory getInstance(){
        if(factory == null){
            factory = new ShapeFactory();
        }
        return factory;

    }

    public Shape getDefaultShapes(String name){
        Shape shape;
        switch (name){
            case Square.name : {shape = new Square(1.0); break;}
            case Circle.name: {shape = new Circle(1.0); break;}
            default:throw new RuntimeException("not found");

        }
        return shape;
    }
}
