package design;

/**
 * Created by skunnumkal on 7/24/14.
 */
public class Message {
    public Integer src,dest;

    public Message(Integer src,Integer dest){
        this.src = src;
        this.dest = dest;

    }

    @Override
    public String toString(){
        String srcString = "NULL",destString = "NULL";
        if(src != null){
            srcString = src.toString();

        }
        if(dest != null){
            destString = dest.toString();
        }
        return srcString+ " : " + destString;
    }


}
