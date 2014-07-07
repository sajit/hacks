package oop;

/**
 * Created by sajit on 7/2/14.
 */
public class Square extends Shape implements Graphing<Square> {
    final int side;
    public Square(int length){
        super(4,"square");
        side = length;
    }

    @Override
    public double getArea() {
            return side*side;
    }



    public static void main(String[] args){
        Shape shape = new Square(5);

        System.out.println(shape.getArea());
        System.out.println(shape);
    }

    @Override
    public void paint(Square square) {
        System.out.println("Painting a square" + square);
    }
}
