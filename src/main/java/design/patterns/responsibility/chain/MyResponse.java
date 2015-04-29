package design.patterns.responsibility.chain;

/**
 * Created by sajit on 4/29/15.
 */
public class MyResponse {

    final int code;
    final String message;

    public MyResponse(int code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public String toString(){
        return "{code:"+code+", message:"+message+"}";
    }
}
