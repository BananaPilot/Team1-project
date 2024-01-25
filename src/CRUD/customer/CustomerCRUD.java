package CRUD.customer;

import classes.customer.Customer;
import classes.in.Input;

public class CustomerCRUD {
  public static Customer createCustomer(){
    return new Customer(Input.getString("Name: "), Input.getString("Surname: "), Input.getString("Address: "), Input.getString("E-Mail: "), Input.getString("Phone-number: "));
  }
}
