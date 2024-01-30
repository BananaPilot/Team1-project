package classes.supplier;

import classes.Contacts;
import classes.Operations;
import classes.Searchable;

import java.util.UUID;

public class Supplier implements Searchable {
  private final String ID;
  private String name;
  private String address;
  private int suppliedProductType;
  private String VATNumber;
  private Operations operations;
  private Contacts contacts;

  public Supplier(String companyName, String address, int suppliedProductType, String VATNumber, String email, String phoneNumber) {
    this.ID = UUID.randomUUID().toString();
    this.name = companyName;
    this.address = address;
    this.suppliedProductType = suppliedProductType;
    this.VATNumber = VATNumber;
    this.contacts = new Contacts(email, phoneNumber);
  }

  public String getID() {
    return ID;
  }

  public String getName() {
    return name;
  }

  public String getAddress() {
    return address;
  }

  public int getSuppliedProductType() {
    return suppliedProductType;
  }

  public String getVATNumber() {
    return VATNumber;
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

  public void setAddress(String address) {
    this.address = address;
  }

  public void setSuppliedProductType(int suppliedProductType) {
    this.suppliedProductType = suppliedProductType;
  }

  public void setVATNumber(String VATNumber) {
    this.VATNumber = VATNumber;
  }

  public void setOperations(Operations operations) {
    this.operations = operations;
  }

  public void setContacts(Contacts contacts) {
    this.contacts = contacts;
  }

  @Override
  public String toString() {
    return "Supplier{" +
            ", ID=" + ID +
            ", companyName='" + name + '\'' +
            ", address='" + address + '\'' +
            ", suppliedProductType=" + suppliedProductType +
            ", VATNumber='" + VATNumber + '\'' +
            ", operations=" + operations +
            ", contacts=" + contacts +
            '}';
  }
}
