package design.furnitureworks;

/**
 * Created by skunnumkal on 1/26/15.
 */
public class TestingFactory {


    private static FurnitureTest woodTests = new WoodFurnitureTest();
    private static FurnitureTest metalTests = new MetalFurnitureTest();
    public static FurnitureTest getFurnitureTest(Material material){
        if(material.equals(Material.METAL)){
            return metalTests;
        }
        else{
            return woodTests;
        }

    }

    public static void main(String[] args){
        Furniture furniture = new WoodenDesk();
        System.out.println(furniture); //should print wooden desk
        System.out.println(TestingFactory.getFurnitureTest(Material.WOOD).passesStrengthTest(furniture));
    }
}
