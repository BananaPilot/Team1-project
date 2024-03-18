package com.team1.app.classes.supplier.interactions;

import com.team1.app.classes.database.DB;
import com.team1.app.classes.shared.Searchable;
import com.team1.app.classes.shared.Contacts;
import com.team1.app.classes.supplier.Supplier;
import com.team1.app.classes.in.In;
import com.team1.app.classes.util.Util;

import java.util.List;

public class SupplierCRUD {

    public Supplier createSupplier() {
        return new Supplier(In.getInstance().getString("Name: "), In.getInstance().getString("Address: "), Util.select(DB.getInstance().getProductTypes(), "Select product type supplied: "), In.getInstance().getString("VAT-number: "), In.getInstance().getString("E-mail: "), In.getInstance().getString("Phone-number: "));
    }

    public void listSuppliers(List<Supplier> suppliers) {
        Util.printArrayList(suppliers);
    }

    public Supplier getSupplier(List<Supplier> suppliers) {
        int input;
        SupplierPrompts.supplierSearchPrompt();
        input = In.getInstance().getInput();
        return switch (input) {
            case 1 -> Searchable.search(suppliers, In.getInstance().getString("ID: "));
            case 2 -> Searchable.search(suppliers, In.getInstance().getString("VAT-number: "));
            case 3 -> (Supplier) Contacts.searchByContacts(suppliers, In.getInstance().getString("E-mail: "));
            case 4 -> Searchable.search(suppliers, In.getInstance().getString("Address: "));
            case 5 -> Searchable.search(suppliers, In.getInstance().getString("Company name: "));
            case 6 -> Searchable.search(suppliers, In.getInstance().getInt("Supplied product type: "));
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
            input = In.getInstance().getInput();
            switch (input) {
                case 1 -> supplier.setCompanyName(In.getInstance().getString("New company name:"));
                case 2 -> supplier.setAddress(In.getInstance().getString("New address: "));
                case 3 -> supplier.getContacts().setEmail(In.getInstance().getString("New e-mail: "));
                case 4 -> supplier.getContacts().setPhoneNumber(In.getInstance().getString("New phone-number"));
                case 0 -> System.out.println("Going back");
                default -> throw new IllegalStateException("Unexpected value: " + input);
            }
        } while (input != 0);
        System.out.println("Updated supplier: " + supplier);
    }
}