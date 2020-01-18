package generics;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import com.google.common.collect.ImmutableList;
import org.apache.commons.lang.ObjectUtils;
import org.junit.Test;

public class GenericsTests {

	@Test
	public void testEquality() {
		List<Integer> intList = ImmutableList.of(0);
		List<?> wildCardList = ImmutableList.of(0);
		assertEquals(intList,wildCardList);


	}

	@Test
	public void readFromWildcardGenericList() {
		Adult adult1 = new Adult();
		adult1.setName("Bob");
		Adult adult2 = new Adult();
		adult2.setName("Alice");
		List<Adult> adults = ImmutableList.of(adult1,adult2);
		List<? extends Person> persons = adults;
		Person p1 = adults.get(0);
		assertTrue(( p1 instanceof Adult));
		assertTrue(( p1 instanceof Person));
		assertTrue(((Adult)p1).canWalk());
//		Infant boy = new Infant();
//		boy.setName("Sam");
//		//persons.add(boy); //not possible
//		Person boy2 = new Person();
//		boy2.setName("Julio");
//		//persons.add(boy2); //not possible
	}

	@Test(expected = NullPointerException.class)
	public void nullsInList() {
		List<Integer> ints = ImmutableList.of(1,null,4,null);
		for(Integer x : ints){
			System.out.println(x);
		}
	}

	@Test(expected = NullPointerException.class)
	public void nullist() {
		List<Integer> ints = null;
		for(Integer x : ints){
			System.out.println(x);
		}
	}

	@Test(expected = ClassCastException.class)
	public void additionToGenericList() {
		List<Person> persons = new ArrayList<>();
		Infant boy = new Infant();
		boy.setName("Sam");
		persons.add(boy);
		Person boy2 = new Person();
		boy2.setName("Julio");
		persons.add(boy2);
		assertEquals(2,persons.size());
		Infant boyFromList = (Infant)persons.get(0);
		assertFalse(boyFromList.canWalk());
		Infant boy2FromList = (Infant)persons.get(1);

	}

	@Test
	public void writeToGenericList() {
		Adult adult1 = new Adult();
		adult1.setName("Bob");

		List<? super Adult> adults = new ArrayList<>();
		adults.add(adult1);

		Person boy1 = new Adult();
		boy1.setName("robin");
		//adults.add(boy1); //not possible

	}


}
class Person {
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
class Infant extends Person {
	public boolean canWalk() {
		return  false;
	}
}
class Adult extends Person {
	public boolean canWalk() {
		return  true;
	}
}
