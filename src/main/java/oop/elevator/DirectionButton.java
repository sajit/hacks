package oop.elevator;

/**
 * Created by skunnumkal on 12/22/14.
 */
public class DirectionButton extends Button {
    private final Direction direction;
    private Integer floorNum;
    public DirectionButton(Direction direction){
        this.direction = direction;
    }
}
enum Direction{
    UP,DOWN
}