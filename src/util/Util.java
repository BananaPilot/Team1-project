package util;

import in.Input;

import java.lang.reflect.Field;
import java.util.ArrayList;

import classes.interfaces.Searchable;

public class Util {
    public static void printArrayList(ArrayList<?> arrayList) {
        for (Object element : arrayList) {
            System.out.println(element);
        }
    }
    
//    public static void notDeletedElements(ArrayList<?> arrayList) {
//    	for (Object object : arrayList) {
//			object.
//		}
//    }

    public static String capitalize(String stringToCapitalize) {
        String first = stringToCapitalize.substring(0, 1);
        String rest = stringToCapitalize.substring(1);
        return first.toUpperCase() + rest;
    }

    public static Object select(ArrayList<?> genericCollection, String description) {
        System.out.print(description);
        for (int i = 0; i < genericCollection.size(); i++) {
            System.out.println((i + 1) + ". " + genericCollection.get(i));
        }
        int index = Input.getInput();
        return genericCollection.get(index - 1);
    }
}
