package design.patterns.observer;

/**
 * Created by sajit on 4/27/15.
 */
public class ObservableDemo {

    public  static  void  main(String[] args){
        Watchee subject = new Watchee();
        SquareObserver so = new SquareObserver(subject);
        CubeObserver co = new CubeObserver(subject);
        subject.attach(so);
        subject.attach(co);
        for(int i=1;i<5;i++){
            subject.setState(i);
            System.out.println(so.getValue());
            System.out.println(co.getValue());
            System.out.println("==========================");
        }

    }
}
