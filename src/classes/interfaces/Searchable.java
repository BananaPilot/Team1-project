package classes.interfaces;

import classes.customer.Customer;
import classes.shared.Contacts;
import util.Util;

import java.lang.reflect.Field;
import java.util.ArrayList;

public interface Searchable {
  default boolean contains(Object... values) {
    Field[] fields = this.getClass().getDeclaredFields();
    ArrayList<Object> objects = new ArrayList<>();
    for (Field field: fields){
      if (field == null) continue;
      String capField = Util.capitalize(field.getName());
      for (Object value: values){
        try {
          Object object = this.getClass().getMethod("get" + capField).invoke(this);
          if (object == null) continue;
          if (object.equals(value)) if (!objects.contains(this)) objects.add(this);
        } catch (Exception e){
          e.printStackTrace();
        }
      }
    }
    return !objects.isEmpty();
  }

  static Searchable search(ArrayList<? extends Searchable> arrayList, Object... values){
    for (Searchable searchable: arrayList){
      if (searchable.contains(values)) return searchable;
    }
    return null;
  }
}
