package util;

import in.Input;

import java.util.ArrayList;

public class Util {
    public static void printArrayList(ArrayList<?> arrayList) {
        for (Object element : arrayList) {
            System.out.println(element);
        }
    }

    public static String capitalize(String stringToCapitalize) {
        String first = stringToCapitalize.substring(0, 1);
        String rest = stringToCapitalize.substring(1);
        return first.toUpperCase() + rest;
    }

    public static <T> T select(ArrayList<T> genericCollection, String description) throws IllegalArgumentException{
        System.out.print(description);
        if(genericCollection.isEmpty()) {
            throw new IllegalArgumentException("This list is empty!");
        }
        for (int i = 0; i < genericCollection.size(); i++) {
            System.out.println((i + 1) + ". " + genericCollection.get(i));
        }
        int index;
        index = Input.getInput();
        if(genericCollection.size() < index) {
            throw new IllegalArgumentException("The selected value is not in the list.");
        }
        return genericCollection.get(index - 1);
    }
}
