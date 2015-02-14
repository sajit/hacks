package design.furnitureworks;

/**
 * Created by skunnumkal on 1/26/15.
 */
public abstract class Furniture {
    protected int volume;

    public Furniture(){
        System.out.println("furniture:base class:constructor");
    }

    public int getVolume(){
        return volume;
    }

    public abstract Material getMaterial();

    @Override
    public String toString(){
        return "furniture:base class";
    }
}
