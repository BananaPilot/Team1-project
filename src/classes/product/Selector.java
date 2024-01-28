package classes.product;

import java.util.ArrayList;

import classes.in.Input;

public class Selector <T>{
	
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
