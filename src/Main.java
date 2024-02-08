import classes.interfaces.Searchable;
import in.Input;
import interactions.customer.CustomerInteractions;

public class Main {
  public static void main(String[] args) {
    Searchable.search(CustomerInteractions.getCustomers(), "peppino", "giuseppino", "327045046")
    Input.getScanner().close();
  }
}

