package com.team1.app.classes.supplier.interactions;

import com.team1.app.classes.database.DB;
import com.team1.app.classes.shared.Searchable;
import com.team1.app.classes.shared.Contacts;
import com.team1.app.classes.supplier.Supplier;
import com.team1.app.classes.in.Input;
import com.team1.app.classes.util.Util;

import java.util.List;

public class SupplierCRUD {

    public Supplier createSupplier() {
        return new Supplier(Input.getInstance().getString("Name: "), Input.getInstance().getString("Address: "), Util.select(DB.getInstance().getProductTypes(), "Select product type supplied: "), Input.getInstance().getString("VAT-number: "), Input.getInstance().getString("E-mail: "), Input.getInstance().getString("Phone-number: "));
    }

    public void listSuppliers(List<Supplier> suppliers) {
        Util.printArrayList(suppliers);
    }

    public Supplier getSupplier(List<Supplier> suppliers) {
        int input;
        SupplierPrompts.supplierSearchPrompt();
        input = Input.getInstance().getInput();
        return switch (input) {
            case 1 -> Searchable.search(suppliers, Input.getInstance().getString("ID: "));
            case 2 -> Searchable.search(suppliers, Input.getInstance().getString("VAT-number: "));
            case 3 -> Contacts.search(suppliers, Input.getInstance().getString("E-mail: "));
            case 4 -> Searchable.search(suppliers, Input.getInstance().getString("Company name: "));
            case 5 -> Searchable.search(suppliers, Input.getInstance().getInt("Supplied product type: "));
            default -> throw new IllegalStateException("Unexpected value: " + input);
        };
    }

    public void updateSupplier(List<Supplier> suppliers) {
        Supplier supplier = getSupplier(suppliers);
        if (supplier == null) {
            System.out.println("Something went wrong please try again");
            return;
        }
        int input;
        do {
            SupplierPrompts.supplierUpdatePrompt();
            input = Input.getInstance().getInput();
            switch (input) {
                case 1 -> supplier.setCompanyName(Input.getInstance().getString("New company name:"));
                case 2 -> supplier.setAddress(Input.getInstance().getString("New address: "));
                case 3 -> supplier.getContacts().setEmail(Input.getInstance().getString("New e-mail: "));
                case 4 -> supplier.getContacts().setPhoneNumber(Input.getInstance().getString("New phone-number"));
                default -> throw new IllegalStateException("Unexpected value: " + input);
            }
        } while (input > 0);
        System.out.println("Updated supplier: " + supplier);
    }
}