package CRUD.customer;

import classes.customer.Customer;
import interactions.customer.CustomerInteractions;

import java.util.ArrayList;

public class SearchCustomer {
  private final static ArrayList<Customer> customers = CustomerInteractions.getCustomers();

  public static Customer getCustomerByID(String id) {
    for (Customer customer: customers){
      if (customer.getID().equals(id)) return customer;
    }
    return null;
  }
  public static Customer getCustomerByEmail(String email) {
    for (Customer customer: customers) {
      if (customer.getContacts().getEmail().equals(email)) return customer;
    }
    return null;
  }

  public static Customer getCustomerByNameSurname(String name, String surname) {
    for (Customer customer: customers) {
      if (customer.getName().equals(name) && customer.getSurname().equals(surname)) return customer;
    }
    return null;
  }
}