package oop;

/**
 * Created by sajit on 7/14/14.
 */
public class Base {

    public void foo(){
        System.out.println(Base.class.getSimpleName()+ " foo");
    }

    public void bar(Base b){
        System.out.println("Bar in Base " + b.getClass().getSimpleName());
    }

    public void baz(){
        System.out.println("Baz  Base");
    }
}
