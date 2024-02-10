package interactions.supplier;

import CRUD.supplier.SupplierCRUD;
import classes.database.DB;
import in.Input;
import prompts.supplier.SupplierPrompts;

public class SupplierInteractions {
    SupplierCRUD supplierCRUD = new SupplierCRUD();

    public void supplierHandler() {
        int input;
        do {
            SupplierPrompts.supplierMainPrompt();
            input = Input.getInput();
            switch (input) {
                case 1 -> DB.getSuppliers().add(supplierCRUD.createSupplier());
                case 2 -> supplierCRUD.listSuppliers();
                case 3 -> System.out.println(supplierCRUD.getSupplier());
                case 4 -> supplierCRUD.updateSupplier();
                case 5 -> DB.getSuppliers().remove(supplierCRUD.getSupplier());
            }
        } while (input != 0);
    }
}
