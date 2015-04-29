package design.patterns.responsibility.chain;

/**
 * Created by sajit on 4/29/15.
 */
public abstract class AbstractHandler {
    protected AbstractHandler successor;

    public void setSuccessor(AbstractHandler successor)
    {
        this.successor = successor;
    }

    public abstract void handleResponse(MyResponse response);
}
