package design.patterns.builder;

/**
 * Created by sajit on 4/28/15.
 */
public class Person {

    private final String name;
    private final int age;
    private final boolean isMale;

//

    @Override
    public String toString(){
        return "I am " + name + " and am " + age + " yrs old";
    }
    public Person(String name, int age,boolean isMale){
        this.name = name;
        this.age = age;
        this.isMale = isMale;
    }

    public static PersonBuilder builder(){
        return new PersonBuilder();
    }
}
class PersonBuilder{
    private String name;
    private int age;
    private boolean isMale;
    public Person build(){
        return new Person(this.name,age,isMale);
    }

    public PersonBuilder withAge(int age){
        this.age = age;
        return this;

    }

    public PersonBuilder withName(String name){
        this.name = name;
        return this;
    }

    public PersonBuilder withSex(boolean isMale){
        this.isMale = isMale;
        return this;
    }
}

