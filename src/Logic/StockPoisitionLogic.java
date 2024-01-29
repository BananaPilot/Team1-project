package Logic;
import classes.product.Product;
import classes.warehouse.*;

public class StockPoisitionLogic {
    public static void resetPosition(){
        StockPosition.setStaticHeigth(0);;
        StockPosition.setStaticLongnessCounter(0);
    }

    public static void modifyQuantity(StockPosition pos, int newQuantity){
        pos.setQuantity(newQuantity);
    }
    public static void modifyProduct(StockPosition pos){
        //chiama metodo dentro product tramite pos : pos.getStockedProduct().
    }


}
