package util;

import java.util.ArrayList;

public class Util {
  public static void printArrayList(ArrayList<?> arrayList){
    for (Object element: arrayList){
      System.out.println(element);
    }
  }

  public static String capitalize(String stringToCapitalize){
    String first = stringToCapitalize.substring(0, 1);
    String rest = stringToCapitalize.substring(1);
    return first.toUpperCase() + rest;
  }
}
