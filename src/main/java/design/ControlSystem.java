package design;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by skunnumkal on 7/24/14.
 */
public class ControlSystem {

    private Queue<Message> queue = new LinkedList<Message>();

    private Elevator elevator = new Elevator(Integer.valueOf(0));

    public void enQueue(Message message){
        queue.add(message);
    }

    public Message getMessageIfAvailable()
    {
        Message message = null;
        if(!queue.isEmpty()){
            message = queue.poll();
        }
        return message;
    }


    /**
     * In this basic model, everything is synchronized, while the elevator is in motion, no new
     * requests are accepted
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        ControlSystem controlSystem = new ControlSystem();

        while(true){
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            System.out.println("Enter Destination Floor: (Or a non integer to exit)");
            String s = br.readLine();

            try {
                int i = Integer.parseInt(s);
                controlSystem.moveElevator(Integer.valueOf(i));
                //controlSystem.enQueue(Message.of(null, Integer.valueOf(i)));
            }
            catch(NumberFormatException nfe){
                System.out.println("Exiting");
                System.exit(0);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            controlSystem.printStatus();

        }
    }


    public void moveElevator(Integer dest) throws InterruptedException {
        this.elevator.move(dest);
    }

    public void printStatus() {
        elevator.printStatus();
    }
}
