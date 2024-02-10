package CRUD.supplier.order;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import CRUD.supplier.SupplierCRUD;
import classes.customer.CustomerOrder;
import classes.interfaces.Order;
import classes.interfaces.Searchable;
import in.Input;
import interactions.supplier.order.*;
import classes.shared.OrderProduct;
import classes.supplier.SupplierOrder;
import prompts.supplier.order.*;
import util.*;

public class SupplierOrderCRUD {
    SupplierCRUD supplierCRUD = new SupplierCRUD();

    public static SupplierOrder createSupplierOrder(ArrayList<OrderProduct> products) {
        return new SupplierOrder(products);
    }

    public static void listSupplierOrder(ArrayList<SupplierOrder> supplierOrders) {
        Util.printArrayList(supplierOrders);
    }

    public Order getSupplierOrder() {
        SupplierOrderPrompts.supplierOrderSearchPrompt();
        int input = Input.getInput();
        switch (input) {
        }
    }

    public static void updateSupplierOrder(ArrayList<SupplierOrder> supplierOrders) {
        SupplierOrderPrompts.supplierOrderUpdatePrompt();
    }

    public static void deleteCustomerOrder(ArrayList<SupplierOrder> supplierOrders) {
        SupplierOrderPrompts.supplierOrderDeletePrompt();
    }

    public static SupplierOrder getSupplierOrderByDate(ArrayList<SupplierOrder> supplierOrders) {
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate date = LocalDate.parse(in.Input.getString("Date in format DD-MM-YYYY: "), dateFormat);
        for (SupplierOrder supplierOrder : supplierOrders) {
            if (supplierOrder.getDate().equals(date)) return supplierOrder;
        }
        return null;
    }
}
