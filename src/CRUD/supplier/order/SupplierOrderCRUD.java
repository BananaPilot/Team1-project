package CRUD.supplier.order;

import java.util.ArrayList;
import interactions.supplier.order.*;
import classes.shared.OrderProduct;
import classes.supplier.SupplierOrder;
import prompts.supplier.order.*;
import util.*;

public class SupplierOrderCRUD {

    public static SupplierOrder createSupplierOrder(ArrayList<OrderProduct> products){
        return new SupplierOrder(products);
    }

    public static void listSupplierOrder(ArrayList<SupplierOrder> supplierOrders){
        Util.printArrayList(supplierOrders);
    }

    public static SupplierOrder search(Object... values){
    for (SupplierOrder supplierOrder: SuppllierOrderInteractions.getSupplierOrders()){
      if (supplierOrder.contains(values)) return supplierOrder;
    }
    return null;
  }

    public static void updateSupplierOrder(ArrayList<SupplierOrder> supplierOrders){
        SupplierOrderPrompts.supplierOrderUpdatePrompt();
    }

    public static void deleteCustomerOrder(ArrayList<SupplierOrder> supplierOrders){
        SupplierOrderPrompts.supplierOrderDeletePrompt();
    }
}
