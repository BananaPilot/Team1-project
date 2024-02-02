package CRUD.customer.order;
import classes.shared.OrderProduct;
import classes.customer.CustomerOrder;
import in.Input;
import interactions.customer.order.CustomerOrderInteractions;
import prompts.customer.order.CustomerOrderPrompts;
import java.util.ArrayList;


public class CustomerOrderCRUD {

        //3.CREATE
        public static CustomerOrder createCustomerOrder(ArrayList<OrderProduct> products) {
        return new CustomerOrder(products);
    }


        //2. LIST
        public static void listCustomerOrders(ArrayList<CustomerOrder> customerOrders){
            for(CustomerOrder customerOrder : CustomerOrderInteractions.getCustomerOrder()){
                System.out.println(customerOrders);
            }
        }

        //3. SEARCH
        public static CustomerOrder getCustomerOrder(ArrayList<CustomerOrder> customerOrders) {
            int input;
            CustomerOrderPrompts.customerOrderSearchPrompt();
            input = Input.getInt();
            return switch (input) {
                case 1 -> SearchCustomerOrder.getCustomerOrderByID(Input.getString("ID: "));
                case 2 -> SearchCustomerOrder.getCustomerOrderByDate();
                default -> null;
            };
        }

        //4. UPDATE
        //IMPLEMENTARE MODIFICA
        public static void updateCustomerOrder(ArrayList<CustomerOrder> customerOrders) {
            CustomerOrderPrompts.customerOrderUpdatePrompt();
        }

        //5.DELETE
        //IMPLEMENTARE DELETE
        public static void deleteCustomerOrder(ArrayList<CustomerOrder> customerOrders) {
            CustomerOrderPrompts.customerOrderDeletePrompt();
        }

}
