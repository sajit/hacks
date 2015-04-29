package design.patterns.responsibility.chain;

import org.apache.commons.lang.math.RandomUtils;

/**
 * Created by sajit on 4/29/15.
 */
public class RCDemo {

    public static void main(String[] args){
        AbstractHandler headHandler = createChain();
        for(int i=0; i<5;i++){
            MyResponse aResponse = (RandomUtils.nextBoolean())? new MyResponse(200,"good") : new MyResponse(400,"bad");
            System.out.println(aResponse);
            headHandler.handleResponse(aResponse);
        }
    }

    private static AbstractHandler createChain() {
        AbstractHandler firstHandler =  new OkHandler();
        AbstractHandler failHandler = new ErrorHandler();
        firstHandler.setSuccessor(failHandler);
        return firstHandler;
    }
}
