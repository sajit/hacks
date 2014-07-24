package design;

/**
 * Created by skunnumkal on 7/24/14.
 */
public class Elevator {
    
    Integer currentFloor,targetFloor;
    private boolean moving = false;

    public void setTargetFloor(Integer floor){
        this.targetFloor = floor;
    }
    
    public void setCurrentFloor(Integer floor){
        this.currentFloor = floor;
    }
    
    public void move() throws InterruptedException {
        if(currentFloor.intValue() != targetFloor.intValue()){
            moving = true;
            Thread.sleep(Math.abs(targetFloor.intValue()-currentFloor.intValue())*5000);
            moving = false;
        }

    }
    
    public boolean isMoving(){
        return moving;
    }

    public void printStatus(){
        if(moving){
           System.out.println("In motion..");
        }
        else{
            System.out.println("Current floor " + currentFloor);
        }

    }
    
    
}
