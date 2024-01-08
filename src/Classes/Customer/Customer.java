package Classes.Customer;

public class Customer {
   private int counter = 1;
   private final int ID;
   private String name;
   private String surname;
   private String address;

   //TODO operations

   //TODO Contacts

   public Customer(int ID, String name, String surname, String address) {
      this.ID = incrementAndGet();
      this.name = name;
      this.surname = surname;
      this.address = address;
   }

   public int getID() {
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

   private int incrementAndGet() {
      return counter++;
   }
}
