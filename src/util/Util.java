package util;

import classes.SearchBy;
import classes.Searchable;

import java.util.ArrayList;

public class Util {

  public static void stampaArray(ArrayList<?> arrayList){
    for (Object object: arrayList){
      System.out.println(object);
    }
  }
  public static Searchable search(ArrayList<Searchable> arrayList, SearchBy typeOfSearch, Object... valueToSearchBy) {
    for (Searchable element : arrayList) {
      switch (typeOfSearch) {
        case NAME -> {
          if (element.getName().equals(valueToSearchBy[0])) return element;
        }
        case SURNAME -> {
          if (element.getSurname().equals(valueToSearchBy[0])) return element;
        }
        case FULL_NAME -> {
          if (element.getName().equals(valueToSearchBy[0]) && element.getSurname().equals(valueToSearchBy[1])) return element;
        }
        case BRAND -> {
          if (element.getBrand().equals(valueToSearchBy[0])) return element;
        }
        case LOT -> {
          if (element.getLot().equals(valueToSearchBy[0])) return element;
        }
        case ID -> {
          if (element.getID().equals(valueToSearchBy[0])) return element;
        }
        case VAT -> {
          if (element.getVATNumber().equals(valueToSearchBy[0])) return element;
        }
        case EMAIL -> {
          if (element.getContacts().getEmail().equals(valueToSearchBy[0])) return element;
        }
      }
    }
    return null;
  }
}
