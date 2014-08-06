package java8;

/**
 * Created by skunnumkal on 8/6/14.
 */
public class PlainJava {

    final static int x = 10;

    public static void main(String[] args){
        //x = 11; // Cannot re-assing a final variable

        try{
            Bar bar = new Bar();
            bar.testFinally();
        }catch(IllegalArgumentException iae){
            System.out.println(iae.getMessage());


        }



        for(int i=0;i<1000000;i++);
    }
}
final class Foo{
   public final void print(){ //Cannot override final method
       System.out.println("Final class Foo");
   }
}
class Bar{ //cannot inherit from Final class Foo} extends Foo{
  private int b = 0;
  public int testFinally(){
      try{
          b = 1/0;
          return b;
      }
      catch(Exception ex){
          System.out.println(ex.getMessage());
      }
      finally {
          System.out.println("Infinally");
          b = 8;
      }
      throw new IllegalArgumentException("d");
  }
  public int getB(){
      return  b;
  }

    /**
     * Called by the garbage collector on an object when garbage collection determines
     * that there are no more references to the object. But we cannot guarantee when it will be called
     * @throws Throwable
     */
  @Override
  public void finalize() throws Throwable {

    System.out.println("Goodbye cruel world..");
    super.finalize();
  }

}
