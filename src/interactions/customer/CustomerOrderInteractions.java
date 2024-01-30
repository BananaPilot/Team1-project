package interactions.customer;
import CRUD.customer.CustomerOrderCRUD;
import classes.OrderProduct;
import classes.customer.CustomerOrder;
import prompts.customer.CustomerOrderPrompts;
import java.util.ArrayList;

public class CustomerOrderInteractions {
    private static ArrayList<CustomerOrder> customerOrder;
    private static ArrayList<OrderProduct> products;

    public static ArrayList<CustomerOrder> getCustomerOrder(){
        if (customerOrder == null){
            customerOrder = new ArrayList<>();
        }
        return customerOrder;
    }

    public static void CustomerOrderManager() {
        ArrayList<CustomerOrder> customerOrder = new ArrayList<>();
        int input;

        do {
            CustomerOrderPrompts.customerOrderMainPrompt();
            input = classes.in.Input.getInt();

            switch (input) {
                case 1 -> getCustomerOrder().add(CustomerOrderCRUD.createCustomerOrder(products));
                case 2 -> CustomerOrderCRUD.listCustomerOrders(customerOrder);
                case 3 -> System.out.println(CustomerOrderCRUD.getCustomerOrder(customerOrder));
                case 4 -> CustomerOrderCRUD.updateCustomerOrder(customerOrder);
                case 5 -> getCustomerOrder().remove(CustomerOrderCRUD.getCustomerOrder(customerOrder));
            }
        } while (input != 0);
    }
}