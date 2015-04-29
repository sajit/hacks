package design.patterns.builder;

/**
 * Created by sajit on 4/28/15.
 */
public class BuilderDemo {

    public static void main(String[] args){

        PersonBuilder personBuilder = new PersonBuilder();
        Person ponnuz = personBuilder.withAge(20).withName("ponnu").withSex(false).build();

        System.out.println(ponnuz);
    }
}
