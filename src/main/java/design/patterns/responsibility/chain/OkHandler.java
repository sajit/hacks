package design.patterns.responsibility.chain;

/**
 * Created by sajit on 4/29/15.
 */
public class OkHandler extends AbstractHandler {
    @Override
    public void handleResponse(MyResponse response) {
        if(response.code == 200){
            System.out.println("Being handled by Ok Handler " + response);
        }
        else{
            this.successor.handleResponse(response);
        }
    }
}
