package classes.warehouse;
import classes.product.Product;


public class StockPosition {
    private int positionId = 0;
    private static int staticpositionId = 0;
    private int heigth = 0;
    private static int staticHeigth = 0;
    private boolean isFull = false;
    private int productRefId = 0;
    private StringBuilder lot = new StringBuilder(" ");
    private Product stockedProduct;
    private static int staticLongnessCounter = 0;

    public StockPosition(int zoneLongness){

        if (staticLongnessCounter == zoneLongness ){
            staticLongnessCounter = 0;
            staticHeigth++;
        }

        this.staticpositionId++;
        this.positionId = staticpositionId;
        this.heigth = staticHeigth;
        this.lot.append(positionId + "L" + this.heigth);
        staticLongnessCounter++;
    }

    public static void resetPosition(){
        staticHeigth = 0;
        staticLongnessCounter = 0;
    }
    public int getPositionId(){
        return this.positionId;
    }
    //public int productRefId(){return ID;}
    public boolean isPositionEmpty(){
        return this.isFull;
    }

    public StringBuilder getLot() {
        return lot;
    }


    @Override
    public String toString() {
        return "Classes.Warehouse.Classes.Warehouse.StockPosition{" +
                "positionId=" + positionId +
                " lot=" + lot +
                ", isFull=" + isFull +
                ", productRefId=" + productRefId;
    }
}
