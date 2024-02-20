package interactions.supplier;

import CRUD.supplier.SupplierCRUD;
import classes.database.DB;
import classes.supplier.Supplier;
import in.Input;
import interactions.order.OrderInteractions;
import prompts.supplier.SupplierPrompts;

import java.util.ArrayList;
import java.util.NoSuchElementException;

public class SupplierInteractions {
    private final SupplierCRUD supplierCRUD = new SupplierCRUD();
    private final ArrayList<Supplier> suppliers = DB.getInstance().getSuppliers();
    private final OrderInteractions orderInteractions = new OrderInteractions();

    public void supplierHandler() {
        int input;
        try {
            do {
                SupplierPrompts.supplierMainPrompt();
                input = Input.getInput();
                switch (input) {
                    case 1 -> {
                        Supplier supplier = supplierCRUD.createSupplier();
                        if (supplier != null) {
                            suppliers.add(supplier);
                        }
                    }
                    case 2 -> supplierCRUD.listSuppliers(suppliers);
                    case 3 -> {
                        Supplier supplier = supplierCRUD.getSupplier(suppliers);
                        if (supplier != null) {
                            System.out.println(supplier);
                        }
                    }
                    case 4 -> supplierCRUD.updateSupplier(suppliers);
                    case 5 -> {
                        Supplier supplier = supplierCRUD.getSupplier(suppliers);
                        if (supplier != null) {
                            suppliers.remove(supplier);
                        }
                    }
                    case 6 -> {
                        Supplier supplier = supplierCRUD.getSupplier(suppliers);
                        if (supplier != null) {
                            orderInteractions.orderHandler(supplier);
                        }
                    }
                }
            } while (input != 0);
        } catch (NoSuchElementException e) {
            System.out.println("Invalid input. Please enter a valid choice.");
        }
    }
}
