package interactions.supplier;

import CRUD.customer.CustomerCRUD;
import CRUD.supplier.SupplierCRUD;
import classes.supplier.Supplier;
import in.Input;
import prompts.supplier.SupplierPrompts;

import java.util.ArrayList;

public class SupplierInteractions {
  private static ArrayList<Supplier> suppliers;

  private SupplierInteractions(){}

  public static ArrayList<Supplier> getSuppliers() {
    if (suppliers == null){
      suppliers = new ArrayList<>();
    }
    return suppliers;
  }

  public static void supplierHandler(){
    int input;
    do {
      SupplierPrompts.supplierMainPrompt();
      input = Input.getInput();
      switch (input) {
        case 1 -> getSuppliers().add(SupplierCRUD.createSupplier());
        case 2 -> SupplierCRUD.listSuppliers();
        case 3 -> System.out.println(SupplierCRUD.getSupplier());
        case 4 -> SupplierCRUD.updateSupplier();
        case 5 -> getSuppliers().remove(SupplierCRUD.getSupplier());
      }
    } while (input != 0);
  }
}
