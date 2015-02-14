package oop.elevator;

/**
 * Created by skunnumkal on 12/22/14.
 */
public abstract class ControlSystem {

    private Elevator elevator;
    private ButtonPanel panel;
    private MovePatternStrategy strategy;

    //called when receive input on button
    public void onInput(Object o){
        //calls panel.pressButton()
    }

    //this is called when the elevator is static and awaiting nextMove
    public void onNextMove(){
        //Integer nextFloor = strategy.getNextFloor(panel.getPressedButtons(),elevator.getCurrentFloor());
        //elevator.moveTo(nextFloor);
    }




}
