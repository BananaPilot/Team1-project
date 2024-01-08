package Warehouse;


public class StockPosition {
    /* ogni posizione avrà,
       un id per il lotto,
       un booleano per determinare se è disponibile,
       un altezza che verrà determinata in seguito,
       quindi anche una lunghezza,
       ed i numeri identificativi dei prodotti al loro interno ( per adesso )
     */
    private int batchId = 0;
    private static int staticBatchId = 0;
    private boolean isFull = false;
    private double heigth;
    private double longness;
    private int productRefId = 0;

    // un istanza di posizione conterrà un elemento prodotto
    private ProdottoFantoccio productInPosition;

    // il costruttore che definirà le proprietà delle nostre posizioni

    public StockPosition(ProdottoFantoccio product){
        this.staticBatchId++;

        this.isFull = true;
        this.productInPosition = product;

        this.batchId = staticBatchId;
        this.productRefId = product.idTipo;
    }

    // avremo bisogno dei getter per poter attingere alle nostre proprietà

    public int getBatchId(){
        return batchId;
    }
    public int productRefId(){
        return batchId;
    }
    public boolean isPositionEmpty(){
        return this.isFull;
    }
    public double getPositionHeigth(){
        return this.heigth;
    }
    public double getPositionLongness(){
        return this.longness;
    }

    public ProdottoFantoccio getProductInPosition() {
        return productInPosition;
    }

    @Override
    public String toString() {
        return "Warehouse.Warehouse.StockPosition{" +
                "batchId=" + batchId +
                ", isFull=" + isFull +
                ", heigth=" + heigth +
                ", longness=" + longness +
                ", productRefId=" + productRefId +
                ", productInPosition=" + productInPosition +
                '}';
    }
}
