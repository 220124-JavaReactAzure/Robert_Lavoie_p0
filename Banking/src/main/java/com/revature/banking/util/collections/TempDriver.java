package com.revature.banking.util.collections;

public class TempDriver {

	public static void main(String[] args) {
		List<String> myStringList = new LinkedList<>();
		
		myStringList.add("Hello");
		myStringList.add("There");
		myStringList.add("Ahhh");
		myStringList.add("General");
		myStringList.add("Kenobi");
		
		System.out.println(myStringList.contains("Hello")); // true
		System.out.println(myStringList.contains("There")); // true
		System.out.println(myStringList.contains("AhHh"));  // false
		System.out.println(myStringList.contains("General")); // true
		System.out.println(myStringList.contains("Kenobi")); // true
		
		myStringList.remove("There");
		myStringList.contains("There");
		myStringList.add("There");		
		myStringList.contains("There");
		
		
		myStringList.get(1);
		myStringList.get(0);
	}

}
