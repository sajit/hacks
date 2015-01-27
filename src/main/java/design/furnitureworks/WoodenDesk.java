package design.furnitureworks;

/**
 * Created by skunnumkal on 1/26/15.
 */
public class WoodenDesk extends Desk {

    public final Material material = Material.WOOD;
    public int getExpandedVolume(){
        return getVolume()*2;
    }

    @Override
    public Material getMaterial() {
        return material;
    }

    @Override
    public String toString(){
        return "wooden:desk";
    }

    public WoodenDesk(){
        System.out.println("wooden:desk:constructor");
    }
}
