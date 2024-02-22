package classes.shared;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class Searchable {
    public boolean contains(Object... values) {
        ArrayList<Object> objects = new ArrayList<>();
        for (Object value : values) {
            for (Method method : getAllMethods(this.getClass())) {
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

    public List<Method> getAllMethods(Class<? extends Searchable> myClass) {
        List<Method> methods = Arrays.asList(myClass.getDeclaredMethods());
        methods.removeIf(method -> method.getName().contains("set") || method.getName().contains("to"));
        return methods;
    }

    public static <T extends Searchable> T search(List<T> arrayList, Object... values) {
        for (T searchable : arrayList) {
            if (searchable.contains(values)) return searchable;
        }
        return null;
    }
}