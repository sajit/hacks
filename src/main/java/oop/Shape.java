package oop;

/**
 * Created by sajit on 7/2/14.
 */
public abstract class Shape {

    final int sides;
    final String name;
    public Shape(int sides,String name){
        this.sides = sides;
        this.name = name;

    }

    public int getNumberOfSides(){
        return this.sides;
    }

    public abstract double getArea();



    @Override
    public String toString(){
        return name;
    }


}
