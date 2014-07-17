package oop;

/**
 * Created by sajit on 7/14/14.
 */
public class InheritanceUtils {

    public static void main(String[] args){
        Base b1 = new Base();
        b1.foo();
        b1.baz();
        b1.bar(new Base());
        b1.bar(new Derived1());
        System.out.println(b1.get());

        System.out.println("------------------------------------------");

        Derived1 d1 = new Derived1();
        d1.foo();
        d1.baz();
        d1.bar(new Base());
        d1.bar(new Derived1());
        System.out.println(d1.get());

        System.out.println("------------------------------------------");

        Base b2 = new Derived1();
        b2.foo();
        b2.baz();
        b2.bar(new Base());
        b2.bar(new Derived1());
        System.out.println(b2.get());

        //Base cannot be cast to Derived
        //Derived1 d2 = (Derived1)new Base();
        //d2.foo();


    }
}
