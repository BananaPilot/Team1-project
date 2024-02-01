package CRUD.supplier;

import java.util.ArrayList;

import classes.Order;
import classes.in.Input;
import classes.product.Product;
import classes.supplier.Supplier;
import prompts.supplierOrder.*;
import classes.supplier.SupplierOrder;

public class SupplierOrderCRUD {

    public static ArrayList<Product> createSupplierOrder(ArrayList<Product> products, int index, Product element) {
        products.add(index, element);
        return products ;
    }

    public static void readSupplierOrder(ArrayList<Product> products){
        if(products.isEmpty()){
            System.out.println("List is empty");
        }
        else{
            for(Product product : products){
                System.out.println(product);
            }
        }
    }

    public static void deleteOrder(ArrayList<Product> products, int index){
       products.remove(index);
       System.out.println("The product has been deleted.");
    }

    public static void modifyOrder(){
        SupplierOrder supplyOrder = SupplierOrder(null).getProducts();
        
        if(supplyOrder.equals(null)){
            System.out.println("Something went wrong");
            return;
        }

        int input;
        do {
            prompts.supplierOrder.SupplierOrder.orderModifyPrompt();
            input = Input.getInt();
            switch (input) {
                case 1: supplyOrder.setProducts(null);//modify product
                case 2: //modify date?
                case 3: //modify quantity
            }
        }while (input != 0);
        System.out.println("Updated Supplier order: " + supplyOrder);
        
    }    
}
