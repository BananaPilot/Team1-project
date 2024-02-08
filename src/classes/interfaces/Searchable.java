package classes.interfaces;

import util.Util;

import java.lang.reflect.Field;
import java.util.ArrayList;

public interface Searchable {
  default boolean contains(Object... values) {
    Field[] fields = this.getClass().getDeclaredFields();
    for (Field field: fields){
      if (field == null) continue;
      return !checkAndPopulate(getMethodValue(Util.capitalize(field.getName())), values).isEmpty();
    }
    return false;
  }

  default Object getMethodValue(String filedName) {
    try {
      return this.getClass().getMethod("get" + filedName).invoke(this);
    } catch (Exception e){
      e.printStackTrace();
    }
    return null;
  }

  default ArrayList<Object> checkAndPopulate(Object res, Object... values) {
    ArrayList<Object> objects = new ArrayList<>();
    for (Object value: values){
      if (res == null) continue;
      if (res.equals(value)) if (!objects.contains(this)) objects.add(this);
    }
    return objects;
  }

  static Searchable search(ArrayList<? extends Searchable> arrayList, Object... values){
    for (Searchable searchable: arrayList){
      if (searchable.contains(values)) return searchable;
    }
    return null;
  }
}
