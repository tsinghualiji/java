package generic;

import java.util.Set;
import java.util.TreeSet;

class Person implements Comparable<Person>{
	
	private Integer age;

	public Person(Integer age) {
		super();
		this.age = age;
	}

	public int compareTo(Person o) {
		return this.age.compareTo(o.age);
	}
	
	/*public int compareTo(Object o) {
		//ǿתoΪPerson����
		
		Person p = (Person) o;
		return this.age.compareTo(p.age);
	}*/
	
	public String toString() {
		return age.toString();
	}



	
}
public class GenericDemo2 {
	public static void main(String[] args) {
		
		Set<Person> set = new TreeSet<Person>();
		
		set.add(new Person(6));
		set.add(new Person(-96));
		set.add(new Person(0));
		set.add(new Person(13));
		
		System.out.println(set);
		//Map
	}

	//Person<Object>  p = new Person<String>();
}
