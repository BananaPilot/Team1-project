package Logic;
import classes.warehouse.*;

public class StockPoisitionLogic {
    public static void resetPosition(){
        StockPosition.setStaticHeigth(0);;
        StockPosition.setStaticLongnessCounter(0);
    }

}
