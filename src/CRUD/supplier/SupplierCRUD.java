package CRUD.supplier;

import classes.shared.Searchable;
import classes.shared.Contacts;
import classes.supplier.Supplier;
import in.Input;
import prompts.supplier.SupplierPrompts;
import util.Util;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Optional;

public class SupplierCRUD {

    public Supplier createSupplier() {
        try {
            return new Supplier(
                    Input.getString("Company name: "),
                    Input.getString("Address: "),
                    Input.getInt("Supplied product type: "),
                    Input.getString("VAT-number: "),
                    Input.getString("E-mail: "),
                    Input.getString("Phone-number: ")
            );
        } catch (NoSuchElementException | NumberFormatException e) {
            System.out.println("Invalid input. Please enter valid values.");
            return null;
        }
    }

    public void listSuppliers(ArrayList<Supplier> suppliers) {
        Util.printArrayList(suppliers);
    }

    public Supplier getSupplier(ArrayList<Supplier> suppliers) {
        int input;
        SupplierPrompts.supplierSearchPrompt();

        while (true) {
            try {
                input = Input.getInput();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input format. Please enter a number.");
            }
        }

        try {
            return switch (input) {
                case 1 -> Searchable.search(suppliers, Input.getString("ID: "));
                case 2 -> Searchable.search(suppliers, Input.getString("VAT-number: "));
                case 3 -> (Supplier) Contacts.search(suppliers, Input.getString("E-mail: "));
                case 4 -> Searchable.search(suppliers, Input.getString("Address: "));
                case 5 -> Searchable.search(suppliers, Input.getString("Company name: "));
                case 6 -> Searchable.search(suppliers, Input.getInt("Supplied product type: "));
                default -> null;
            };
        } catch (NoSuchElementException | NumberFormatException e) {
            System.out.println("Invalid input. Please enter valid values.");
            return null;
        }
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
                case 1 -> supplier.setCompanyName(Optional.ofNullable(Input.getString("New company name:")).orElse(supplier.getCompanyName())); // Prevent null assignment
                case 2 -> supplier.setVATNumber(Optional.ofNullable(Input.getString("New VAT number:")).orElse(supplier.getVATNumber()));
                case 3 -> supplier.setAddress(Optional.ofNullable(Input.getString("New address: ")).orElse(supplier.getAddress()));
                case 4 -> {
                    Contacts contacts = supplier.getContacts();
                    if (contacts != null) {
                        contacts.setEmail(Optional.ofNullable(Input.getString("New e-mail: ")).orElse(contacts.getEmail()));
                    } else {
                        System.out.println("Error: e-mail is missing.");
                    }
                }
                case 5 -> {
                    Contacts contacts = supplier.getContacts();
                    if (contacts != null) {
                        contacts.setPhoneNumber(Optional.ofNullable(Input.getString("New phone-number")).orElse(contacts.getPhoneNumber()));
                    } else {
                        System.out.println("Error: phone number is missing.");
                    }
                }
            }
        } while (input != 0);
        System.out.println("Updated supplier: " + supplier);
    }
}
