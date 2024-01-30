import classes.customer.Customer;
import classes.in.Input;
import interactions.customer.CustomerInteractions;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

public class Main {
  public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
    CustomerInteractions.CustomerHandler();
    Input.getScanner().close();
  }
}

