package interactions.supplier.order;

import java.util.ArrayList;
import CRUD.supplier.order.SupplierOrderCRUD;
import classes.shared.OrderProduct;
import classes.supplier.SupplierOrder;
import prompts.supplier.order.SupplierOrderPrompts;

public class SuppllierOrderInteractions {
    private static ArrayList<SupplierOrder> supplierOrders;
    private static ArrayList<OrderProduct> products;

    public static ArrayList<SupplierOrder> getSupplierOrders(){
        if(supplierOrders == null){
            supplierOrders = new ArrayList<>();
        }
        return supplierOrders;
    }

    public static void SupplierOrderManager(){
        ArrayList<SupplierOrder> supplierOrders = new ArrayList<>();
        int input;

        do {
            SupplierOrderPrompts.supplierOrderMainPrompt();
            input = in.Input.getInput();

            switch (input) {
                case 1 -> getSupplierOrders().add(SupplierOrderCRUD.createSupplierOrder(products));
                case 2 -> SupplierOrderCRUD.listSupplierOrder(supplierOrders);
                case 3 -> System.out.println(SupplierOrderCRUD.search());
                case 4 -> SupplierOrderCRUD.updateSupplierOrder(supplierOrders);
                case 5 -> getSupplierOrders().remove(SupplierOrderCRUD.search());
            }
        } while (input != 0);
    }
}
