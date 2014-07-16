package oop;

/**
 * Created by sajit on 7/14/14.
 */
public class Derived1 extends Base {

    public void foo(){
        System.out.println(Derived1.class.getSimpleName() + " foo");
    }

    
    public void bar(Derived1 d){
        System.out.println("Bar in Derived " + d.getClass().getSimpleName());
    }

    @Override
    public void baz(){
        System.out.println("Derived1 baz");
    }
}
