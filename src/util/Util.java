package util;

import classes.SearchBy;
import classes.Searchable;

import java.util.ArrayList;

public class Util {

  public static void printArray(ArrayList<?> arrayList){
    for (Object object: arrayList){
      System.out.println(object);
    }
  }
  public static Searchable search(ArrayList<Searchable> arrayList, SearchBy typeOfSearch, String valueToSearchBy) {
    for (Searchable element : arrayList) {
      switch (typeOfSearch) {
        case NAME -> {
          if (element.getName().equals(valueToSearchBy)) return element;
        }
        case ID -> {
          if (element.getID().equals(valueToSearchBy)) return element;
        }
        case EMAIL -> {
          if (element.getContacts().getEmail().equals(valueToSearchBy)) return element;
        }
      }
    }
    return null;
  }
}
