package classes.warehouse;


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
    //private ProdottoFantoccio productInPosition;

    // il costruttore che definirà le proprietà delle nostre posizioni

    public StockPosition(){
        this.staticBatchId++;

        this.isFull = true;
        //assegna l'elemento di tipo prodotto ad un istanza di StockPosition
        //this.productInPosition = product;

        this.batchId = staticBatchId;

        // prende l'id del tipo di prodotto e lo assegna
        //this.productRefId = product.idTipo;
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

    /*
       prende la posizione del prodotto usando l'id di posizione


    public ProdottoFantoccio getProductInPosition() {
        return productInPosition;
    }*/

    @Override
    public String toString() {
        return "Classes.Warehouse.Classes.Warehouse.StockPosition{" +
                "batchId=" + batchId +
                ", isFull=" + isFull +
                ", heigth=" + heigth +
                ", longness=" + longness +
                ", productRefId=" + productRefId;
    }
}
