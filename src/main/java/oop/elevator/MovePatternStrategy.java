package oop.elevator;

import java.util.List;

/**
 * Created by skunnumkal on 12/22/14.
 */
public interface MovePatternStrategy {

    Integer getNextFloor(List<Button> pressedButtons,Integer currentFloor);
}
