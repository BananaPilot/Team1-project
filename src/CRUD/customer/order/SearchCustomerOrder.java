package CRUD.customer.order;
import classes.customer.CustomerOrder;
import interactions.customer.order.CustomerOrderInteractions;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class SearchCustomerOrder {
    private final static ArrayList<CustomerOrder> customerOrders = CustomerOrderInteractions.getCustomerOrder();

    //IMPLEMENTARE QUI 1. RICERCA PER NOME E COGNOME DI CLIENTE

    public static CustomerOrder getCustomerOrderByID(String id) {
        for (CustomerOrder customerOrder : customerOrders) {
            if (customerOrder.getID().equals(id)) return customerOrder;
        }
        return null;
    }
    public static CustomerOrder getCustomerOrderByDate() {
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate date = LocalDate.parse(in.Input.getString("Date in format DD-MM-YYYY"), dateFormat);
        for (CustomerOrder customerOrder : customerOrders) {
            if (customerOrder.getDate().equals(date)) return customerOrder;
        }
        return null;
    }




}
