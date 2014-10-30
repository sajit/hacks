package design.callcenter;

/**
 * Created by skunnumkal on 10/30/14.
 */
public class TeamLead extends  Employee{

    private TeamLead(){

    }
    private static TeamLead tl;

    public static TeamLead getInstance(){
        if(tl == null){
            tl = new TeamLead();
        }
        return tl;
    }
}
