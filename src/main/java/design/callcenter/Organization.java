package design.callcenter;


import java.util.Random;
import java.util.UUID;

/**
 * Created by skunnumkal on 10/30/14.
 */
public class Organization {

    Fresher[] freshers;
    TeamLead tl;
    public Organization(){
        freshers = new Fresher[3];
        for(int i=0;i<freshers.length;i++){
            freshers[i] = new Fresher(i);
        }
        tl = TeamLead.getInstance();
    }

    public boolean handleCall(long duration){
       for(Fresher fresher : freshers){
           if(!fresher.isBusy()){
               new Thread(new Call(duration,fresher)).start();
               return true;
           }
       }
       if(!tl.isBusy()){
           new Thread(new Call(duration,tl)).start();
           return true;
       }
       else{
           return false;
       }
    }

    public static void main(String[] args) throws InterruptedException {
        Organization org = new Organization();
        Random rand = new Random();
        for(int i=0;i<10;i++){
            long duration = rand.nextInt(20000);
            System.out.println("Next call duration " + duration);
            org.handleCall(duration);
            //Thread.sleep(3000);
        }

    }
}
class Call implements Runnable{

    private final long duration;
    private final Employee employee;
    private final String key;
    @Override
    public void run() {
        int empId = -1;
        if(this.employee instanceof Fresher){
            empId = ((Fresher)this.employee).id;
        }

        System.out.println("Starting call of duration " + duration+ " with key " + key + " for Employee " + empId);
        for(long i=0;i<duration;i++);
        this.employee.setBusy(false);
        System.out.println("Finishing call " + duration+ " with key "+ key + " for Employee " + empId);
    }
    public Call(long duration,Employee employee){
        this.duration = duration;
        this.employee = employee;
        this.employee.setBusy(true);
        this.key = UUID.randomUUID().toString();
    }
}

