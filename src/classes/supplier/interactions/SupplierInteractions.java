package classes.supplier.interactions;

import classes.database.DB;
import classes.order.interactions.OrderInteractions;
import classes.supplier.Supplier;
import in.Input;

import java.util.ArrayList;
import java.util.List;

public class SupplierInteractions {
    private final SupplierCRUD supplierCRUD = new SupplierCRUD();
    private final List<Supplier> suppliers = DB.getInstance().getSuppliers();
    private final OrderInteractions orderInteractions = new OrderInteractions();

    public void supplierHandler() {
        int input;
        do {
            SupplierPrompts.supplierMainPrompt();
            input = Input.getInstance().getInput();
            switch (input) {
                case 1 -> suppliers.add(supplierCRUD.createSupplier());
                case 2 -> supplierCRUD.listSuppliers(suppliers);
                case 3 -> System.out.println(supplierCRUD.getSupplier(suppliers));
                case 4 -> supplierCRUD.updateSupplier(suppliers);
                case 5 -> suppliers.remove(supplierCRUD.getSupplier(suppliers));
                case 6 -> orderInteractions.orderHandler(supplierCRUD.getSupplier(suppliers));
                default -> throw new IllegalStateException("Unexpected value: " + input);
            }
        } while (input > 0);
    }
}