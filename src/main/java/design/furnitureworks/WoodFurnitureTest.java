package design.furnitureworks;

/**
 * Created by skunnumkal on 1/26/15.
 */
public class WoodFurnitureTest implements FurnitureTest {
    @Override
    public boolean passesStrengthTest(Furniture furniture) {
        if(furniture.getMaterial() != Material.WOOD){
            return false;
        }
        //doLogic
        return true;
    }

    @Override
    public boolean passesHeatTest(Furniture furniture) {
        return false;
    }
}
