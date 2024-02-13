package CRUD.supplier;

import classes.database.DB;
import classes.interfaces.Searchable;
import classes.shared.Contacts;
import classes.supplier.Supplier;
import in.Input;
import interactions.supplier.SupplierInteractions;
import prompts.supplier.SupplierPrompts;
import util.Util;

import java.util.ArrayList;

public class SupplierCRUD {

    public Supplier createSupplier() {
        return new Supplier(Input.getString("Name: "), Input.getString("Address: "), Input.getInt("Supplier product type: "), Input.getString("VAT-number: "), Input.getString("E-mail: "), Input.getString("Phone-number: "));
    }

    public void listSuppliers(ArrayList<Supplier> suppliers) {
        Util.printArrayList(suppliers);
    }

    public Supplier getSupplier(ArrayList<Supplier> suppliers) {
        int input;
        SupplierPrompts.supplierSearchPrompt();
        input = Input.getInput();
        Object object = switch (input) {
            case 1 -> Searchable.search(suppliers, Input.getString("ID: "));
            case 2 -> Searchable.search(suppliers, Input.getString("VAT-number: "));
            case 3 -> Contacts.search(suppliers, Input.getString("E-mail: "));
            case 4 -> Searchable.search(suppliers, Input.getString("Company name: "));
            case 5 -> Searchable.search(suppliers, Input.getInt("Supplied product type: "));
            default -> null;
        };
        return (Supplier) object;
    }

    public void updateSupplier(ArrayList<Supplier> suppliers) {
        Supplier supplier = getSupplier(suppliers);
        if (supplier == null) {
            System.out.println("Something went wrong please try again");
            return;
        }
        int input;
        do {
            SupplierPrompts.supplierUpdatePrompt();
            input = Input.getInput();
            switch (input) {
                case 1 -> supplier.setCompanyName(Input.getString("New company name:"));
                case 2 -> supplier.setAddress(Input.getString("New address: "));
                case 3 -> supplier.getContacts().setEmail(Input.getString("New e-mail: "));
                case 4 -> supplier.getContacts().setPhoneNumber(Input.getString("New phone-number"));
            }
        } while (input != 0);
        System.out.println("Updated supplier: " + supplier);
    }
}
