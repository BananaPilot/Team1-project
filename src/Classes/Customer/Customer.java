package Classes.Customer;

import java.util.UUID;

public class Customer {
   private final String ID;
   private String name;
   private String surname;
   private String address;

   //TODO operations

   //TODO Contacts

   public Customer(int ID, String name, String surname, String address) {
      this.ID = UUID.randomUUID().toString();
      this.name = name;
      this.surname = surname;
      this.address = address;
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

   public void setName(String name) {
      this.name = name;
   }

   public void setSurname(String surname) {
      this.surname = surname;
   }

   public void setAddress(String address) {
      this.address = address;
   }
}
