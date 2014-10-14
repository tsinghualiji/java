package com.adobe.www.collection;

import java.util.TreeSet;

public class TreeSetDemo {

	public class Person implements Comparable{
		
		int age;

		public Person(int age) {
			super();
			this.age = age;
		}

		@Override
		public int compareTo (Object o) {

			if(o instanceof Person){
				Person person =(Person)o;
				if (this.age > person.age){
					return 1;
				}else if(this.age < person.age){
					return -1;
				}	
			}
			return 0;
		}
	}
	
	public static void main(String[] args) {
		
		TreeSet treeSetDemo = new TreeSet();
	}

}
