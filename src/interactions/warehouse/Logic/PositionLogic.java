package interactions.warehouse.Logic;
import classes.warehouse.*;

public class PositionLogic {
    public static void resetPosition(){
        Position.setStaticLevel(0);;
        Position.setStaticLongnessCounter(0);
    }
    public static void modifyQuantity(Position pos, int newQuantity){
        pos.setQuantity(newQuantity);
    }
    public static void modifyProduct(Position pos){
        //chiama metodo dentro product tramite pos : pos.getStockedProduct().
    }


}
