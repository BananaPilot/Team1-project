package interactions.supplier;

import java.util.ArrayList;

import CRUD.supplier.SupplierOrderCRUD;
import classes.in.Input;
import classes.product.Product;


public class SupplierOrderInt {
    
    public static void SupplierOrderCRUDInterface(){
        ArrayList<Product> products = new ArrayList<>();
        int input;
        do{
            prompts.supplierOrder.SupplierOrder.mainPrompt();
            input = Input.getInt();
            switch (input) {
                case 1: SupplierOrderCRUD.createSupplierOrder(products, input, null);
                case 2: SupplierOrderCRUD.readSupplierOrder(products);
                case 3: SupplierOrderCRUD.modifyOrder();
                case 4: SupplierOrderCRUD.deleteOrder(products, input);
            }


        }
        while(input != 0);
    }
}
