package design.patterns.responsibility.chain;

/**
 * Created by sajit on 4/29/15.
 */
public class ErrorHandler extends AbstractHandler {
    @Override
    public void handleResponse(MyResponse response) {
        System.out.println("Handled by Error Handler " + response);
    }
}
