package design.furnitureworks;

/**
 * Created by skunnumkal on 1/26/15.
 */
public class MetalFurnitureTest implements FurnitureTest {
    @Override
    public boolean passesStrengthTest(Furniture furniture) {
        return false;
    }

    @Override
    public boolean passesHeatTest(Furniture furniture) {
        return false;
    }
}
