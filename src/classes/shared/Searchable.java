package classes.shared;

import util.Util;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public abstract class Searchable {
    public boolean contains(Object... values) {
        ArrayList<Object> objects = new ArrayList<>();
        for (Object value : values) {
            for (Method method : getAllMethods(getAllFields(this.getClass()))) {
                try {
                    Object object = method.invoke(this);
                    if (object == null) continue;
                    if (object.equals(value) && !objects.contains(this)) objects.add(this);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        }
        return !objects.isEmpty();
    }

    public ArrayList<Method> getAllMethods(List<String> fields) {
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

    public List<String> getAllFields(Class<? extends Searchable> myClass) {
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


    public static <T extends Searchable> T search(ArrayList<T> arrayList, Object... values) {
        for (T searchable : arrayList) {
            if (searchable.contains(values)) return searchable;
        }
        return null;
    }
}