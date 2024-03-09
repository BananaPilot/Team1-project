package com.team1.app.classes.util;

import com.team1.app.classes.in.In;

import java.util.List;

public class Util {

    private Util() {}
    public static void printArrayList(List<?> arrayList) {
        for (Object element : arrayList) {
            System.out.println(element);
        }
    }

    public static String capitalize(String stringToCapitalize) {
        String first = stringToCapitalize.substring(0, 1);
        String rest = stringToCapitalize.substring(1);
        return first.toUpperCase() + rest;
    }

    public static <T> T select(List<T> genericCollection, String description) throws IllegalArgumentException{
        System.out.println(description);
        if(genericCollection.isEmpty()) {
            throw new IllegalArgumentException("This list is empty!");
        }
        for (int i = 0; i < genericCollection.size(); i++) {
            System.out.println((i + 1) + ". " + genericCollection.get(i));
        }
        int index = -1;
        boolean outOfBoundIndex = false;
        do{
            index = In.getInstance().getInput();
            if(genericCollection.size() < index) {
                System.out.println("The number you selected is not into the list." +
                        "Please select again or press 0 to skip the selection.");
                outOfBoundIndex = true;
            }
        }while(outOfBoundIndex && index != 0);
        if(index == 0){
           throw new IllegalArgumentException("You skipped the current selection.");
        }
        return genericCollection.get(index - 1);
    }

    public static String splitter(List<?> arrayList) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Object o: arrayList){
            stringBuilder.append("\n").append(o);
        }
        return stringBuilder.toString();
    }
}
