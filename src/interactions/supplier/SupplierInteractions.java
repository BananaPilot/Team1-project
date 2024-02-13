package interactions.supplier;

import CRUD.supplier.SupplierCRUD;
import classes.database.DB;
import classes.supplier.Supplier;
import in.Input;
import prompts.supplier.SupplierPrompts;

import java.util.ArrayList;

public class SupplierInteractions {
    private final SupplierCRUD supplierCRUD = new SupplierCRUD();
    private final ArrayList<Supplier> suppliers = DB.getInstance().getSuppliers();

    public void supplierHandler() {
        int input;
        do {
            SupplierPrompts.supplierMainPrompt();
            input = Input.getInput();
            switch (input) {
                case 1 -> suppliers.add(supplierCRUD.createSupplier());
                case 2 -> supplierCRUD.listSuppliers(suppliers);
                case 3 -> System.out.println(supplierCRUD.getSupplier(suppliers));
                case 4 -> supplierCRUD.updateSupplier(suppliers);
                case 5 -> suppliers.remove(supplierCRUD.getSupplier(suppliers));
            }
        } while (input != 0);
    }
}
