package classes.customer;

import classes.Contacts;
import classes.Operations;
import classes.Searchable;

import java.util.ArrayList;
import java.util.UUID;

public class Customer implements Searchable {
  private final String ID;
  private String name;
  private String surname;
  private String address;
  private Operations operations;
  private Contacts contacts;

  public Customer(String name, String surname, String address, String email, String phoneNumber) {
    this.ID = UUID.randomUUID().toString();
    this.name = name;
    this.surname = surname;
    this.address = address;
    this.contacts = new Contacts(email, phoneNumber);
    this.operations = new Operations(new ArrayList<>());
  }

  public String getID() {
    return ID;
  }

  public String getName() {
    return name;
  }

  public String getSurname() {
    return surname;
  }

  public String getAddress() {
    return address;
  }

  public Operations getOperations() {
    return operations;
  }

  public Contacts getContacts() {
    return contacts;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setSurname(String surname) {
    this.surname = surname;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public void setOperations(Operations operations) {
    this.operations = operations;
  }

  public void setContacts(Contacts contacts) {
    this.contacts = contacts;
  }

  @Override
  public String toString() {
    return "Customer{" +
            "ID='" + ID + '\'' +
            ", name='" + name + '\'' +
            ", surname='" + surname + '\'' +
            ", address='" + address + '\'' +
            ", operations=" + operations +
            ", contacts=" + contacts +
            '}';
  }
}
