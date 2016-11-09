package design;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.*;

/**
 * In this version the main thread that accepts input from System.in is not blocked by elevator motion
 * Every message received is enqueued and after elevator finishes moving the message
 * is dequed and processed
 * Created by skunnumkal on 7/26/14.
 */
public class AsyncControlSystem {

    public static void main(String[] args) throws IOException {
        Elevator elevator = new Elevator(Integer.valueOf(0));
        ExecutorService executor = Executors.newFixedThreadPool(5);
        Queue<Message> queue = new LinkedList<Message>();


        while(true){
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            System.out.println("Enter Destination Floor: (Or a non integer to exit)");
            String s = br.readLine();

            try {
                int i = Integer.parseInt(s);
                queue.add(Message.of(null,Integer.valueOf(i)));
                ElevatorCallable asyncElevator = new ElevatorCallable(elevator,Integer.valueOf(i));
                FutureTask<ElevatorCallable> moveElevatorTask = new FutureTask<ElevatorCallable>(asyncElevator);

                executor.execute(moveElevatorTask);

                if(moveElevatorTask.isDone() && !queue.isEmpty()){
                    Message nextMessage = queue.poll();
                    System.out.println("Getting next floor" + nextMessage.dest);

                    asyncElevator = new ElevatorCallable(elevator,nextMessage.dest);
                    moveElevatorTask = new FutureTask(asyncElevator);
                    executor.execute(moveElevatorTask);
                }

            }
            catch(NumberFormatException nfe){
                System.out.println("Exiting");
                System.exit(0);
            }


        }
    }
}
