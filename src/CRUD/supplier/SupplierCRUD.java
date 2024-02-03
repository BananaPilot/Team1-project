package CRUD.supplier;

import classes.shared.Contacts;
import classes.supplier.Supplier;
import in.Input;
import interactions.supplier.SupplierInteractions;
import prompts.supplier.SupplierPrompts;
import util.Util;

public class SupplierCRUD {
  public static Supplier createSupplier(){
    return new Supplier(Input.getString("Name: "), Input.getString("Address: "), Input.getInt("Supplier product type: "), Input.getString("VAT-number: "), Input.getString("E-mail: "), Input.getString("Phone-number: "));
  }

  public static void listSuppliers(){
    Util.printArrayList(SupplierInteractions.getSuppliers());
  }

  public static Supplier getSupplier(){
    int input;
    SupplierPrompts.supplierSearchPrompt();
    input = Input.getInput();
    Object object = switch (input){
      case 1 -> search(Input.getString("ID: "));
      case 2 -> search(Input.getString("VAT-number: "));
      case 3 -> Contacts.search(SupplierInteractions.getSuppliers(), Input.getString("E-mail: "));
      case 4 -> search(Input.getString("Company name: "));
      case 5 -> search(Input.getInt("Supplied product type: "));
      default -> null;
    };
    return (Supplier) object;
  }

  public static void updateSupplier(){
    Supplier supplier = getSupplier();
    if (supplier == null){
      System.out.println("Something went wrong please try again");
      return;
    }
    int input;
    do {
      SupplierPrompts.supplierUpdatePrompt();
      input = Input.getInput();
      switch (input){
        case 1 -> supplier.setCompanyName(Input.getString("New company name:"));
        case 2 -> supplier.setAddress(Input.getString("New address: "));
        case 3 -> supplier.getContacts().setEmail(Input.getString("New e-mail: "));
        case 4 -> supplier.getContacts().setPhoneNumber(Input.getString("New phone-number"));
      }
    } while (input != 0);
    System.out.println("Updated supplier: " + supplier);
  }

  public static Supplier search(Object... values){
    for (Supplier supplier: SupplierInteractions.getSuppliers()){
      if (supplier.contains(values)) return supplier;
    }
    return null;
  }
}
