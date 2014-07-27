package design;

/**
 * Created by skunnumkal on 7/24/14.
 */
public class Elevator {
    
    Integer currentFloor;
    private boolean moving = false;

    public Elevator(Integer currentFloor){
        this.currentFloor = currentFloor;
    }

    

    
    public void move(Integer targetFloor) throws InterruptedException {
        synchronized (this){
            if(currentFloor.intValue() != targetFloor.intValue()){
                moving = true;
                printStatus();
                Thread.sleep(Math.abs(targetFloor.intValue()-currentFloor.intValue())*3000);

                this.currentFloor = targetFloor;
                moving = false;
            }
        }
        printStatus();

    }
    
    public boolean isMoving(){
        return moving;
    }

    public void printStatus(){
        if(moving){
           System.out.println("In motion.. start from " + currentFloor );
        }
        else{
            System.out.println("Current floor " + currentFloor);
        }

    }
    
    
}
