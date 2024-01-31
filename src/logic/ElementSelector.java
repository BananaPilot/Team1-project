package logic;

import java.util.ArrayList;

import classes.in.Input;

public class ElementSelector <T>{
	
	
	/**
	 * 
	 * Let's the user decide which element to select from an array list and returns it
	 * 
	 * @param genericType <T>: type of the array list's elements 
	 * @param genericCollection arrayList of generic type <T>
	 * @param description description of the user input
	 * 
	 * @return an @element of the array list taken in input based on the @index specified by the user
	 * @since 0.1
	 */
	public static <T> T selectAsset(ArrayList<T> genericCollection, String description){
		System.out.println(description);
		int index = 1;
		for(T collection : genericCollection) {
			System.out.println(index + ". " + collection);
			index++;
		}
		index = Input.getInt();
		return genericCollection.get(index-1);
	}
}
