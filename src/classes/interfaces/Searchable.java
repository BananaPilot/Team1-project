package classes.interfaces;

import util.Util;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public interface Searchable {
    default boolean contains(Object... values) {
        ArrayList<Object> objects = new ArrayList<>();
        for (Object value : values) {
            for (Method method : getAllMethods(getAllFields(this.getClass()))) {
                try {
                    Object object = method.invoke(this);
                    if (object == null) continue;
                    if (object.equals(value)) if (!objects.contains(this)) objects.add(this);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        }
        return !objects.isEmpty();
    }

    default ArrayList<Method> getAllMethods(List<String> fields) {
        ArrayList<Method> methods = new ArrayList<>();
        for (String string : fields) {
            if (string == null) continue;
            try {
                methods.add(this.getClass().getMethod("get" + Util.capitalize(string)));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return methods;
    }

    default List<String> getAllFields(Class<? extends Searchable> myClass) {
        ArrayList<String> strings = new ArrayList<>();
        Field[] fields = myClass.getDeclaredFields();
        if (myClass.getSuperclass() != null) {
            Field[] fields1 = myClass.getSuperclass().getDeclaredFields();
            for (Field field1 : fields1) {
                strings.add(field1.getName());
            }
        }
        for (Field field : fields) {
            strings.add(field.getName());
        }
        return strings;
    }


    static Searchable search(ArrayList<? extends Searchable> arrayList, Object... values) {
        for (Searchable searchable : arrayList) {
            if (searchable.contains(values)) return searchable;
        }
        return null;
    }
}