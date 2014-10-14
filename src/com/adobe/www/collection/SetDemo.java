package com.adobe.www.collection;

import java.util.Collection;
import java.util.Collections;

public class SetDemo {

	public class Emp implements Comparable{
		
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + age;
			result = prime * result + (int) (name ^ (name >>> 32));
			return result;
		}
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Emp other = (Emp) obj;
			if (age != other.age)
				return false;
			if (name != other.name)
				return false;
			return true;
		}

		long name;
		int age;

		@Override
		public int compareTo(Object o) {
			
			
			
			return 0;
			
		}
	}

	public static void main(String[] args) {

		
		
		
	}
}
