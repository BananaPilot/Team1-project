package classes;

public interface Searchable {
  default String getID(){
    return null;
  }

  default String getName(){
    return null;
  }

  default String getSurname(){
    return null;
  }

  default String getBrand(){
    return null;
  }

  default String getLot(){
    return null;
  }

  default String getVATNumber() {
    return null;
  }

  default Contacts getContacts(){
    return null;
  }
}
