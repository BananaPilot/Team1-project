package classes;

public interface Searchable {
  default String getID(){
    return null;
  }

  default String getName(){
    return null;
  }

  default Contacts getContacts(){
    return null;
  }
}
