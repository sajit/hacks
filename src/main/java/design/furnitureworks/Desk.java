package design.furnitureworks;

/**
 * Created by skunnumkal on 1/26/15.
 */
public abstract class Desk extends Furniture {

    @Override
    public String toString(){
        return "desk:abstract";
    }

    public Desk(){
        System.out.println("desk:constructor");
    }
}
