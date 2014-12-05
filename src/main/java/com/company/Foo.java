package com.company;

/**
 * Created by skunnumkal on 11/4/14.
 */
public class Foo {

    private class Bar{
        public String name = "Bar";
    }
    private static class Baz{
        public String name = "Baz";
    }

    public Foo(){
        Bar bar1 = new Bar();
    }
}
