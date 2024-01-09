package Warehouse;


import java.util.ArrayList;

public class Warehouse {

    /* il magazzino sarà un insieme di zone
       qui dichiaro una lista di zone,
       tipo di dato istanza di warehouse ( ancora da decidere )
     */
    public static ArrayList<Warehouse> warehouseZones = new ArrayList<>();

    //ho bisogno di un contesto statico per poter lavorare con le singole istanze separatamente

    //queste zone avranno un altezza ed una lunghezza
    private double heigth = 10;
    private Integer zoneLongness = 10;
    /* la zona sarà un insieme di posizioni,
       qui dichiaro una lista di posizioni,
       tipo di dato istanza di posizione
     */
    public ArrayList<StockPosition> positions = new ArrayList<StockPosition>();

    /* la zona poi avrà un nome per indicarne il settore,
       un id per poter essere identificata
     */
    public String zone;
    public int zoneHeigth;
    public int zoneId;
    private static int staticZoneId;

    /* l'idea è salvare ogni istanza di posizione in una lista
       per poi essere in gradi di poter attingere all'id della posizione
       tramite l'id deal prodotto
     */

     //costruttore per determinare le grandezze delle zone in posizioni tramite istanze di warehouse

    public Warehouse(String zoneName){
        this.zone = zoneName;
        this.staticZoneId++;
        this.zoneId = staticZoneId;
        positions.ensureCapacity(this.zoneLongness);

    }

    //serve un metodo per istanziare zone, assegnarvi le posizioni così usando come limite le grandezze fisiche

    public static void createZone(String zoneName){
        Warehouse newZone = new Warehouse(zoneName);
        warehouseZones.add(newZone);
    }


    // un metodo per istanziare una posizione ed assegnargli un prodotto
    public void productIsStocked(String nome, String brand, double price){
        ProdottoFantoccio prodotto = new ProdottoFantoccio(nome,brand,price);
        StockPosition newPosition = new StockPosition(prodotto);
        positions.add(newPosition);
        prodotto.posizione = positions.get(prodotto.id-1).getBatchId();
    }
    // un metodo per risalire all'id della posizione tramite id prodotto

    public int getPositionIdFromProduct(int productId){
        return positions.get(productId-1).getBatchId();
    }

    //risalire al prodotto tramite posizione
    public ProdottoFantoccio getProductFromPosition(int position){
        return positions.get(position-1).getProductInPosition();
    }

    //controllo tutte posizioni
    public void checkPositions(){
        for (int i=0; i< positions.size(); i++){
            System.out.println(positions.get(i));
        }
    }

    // metodo per trovare tutte le posizioni in base al nome
    public  ArrayList<Integer> checkProductByName(String name){
        ProdottoFantoccio risultato;
        ArrayList<Integer> myPositions = new ArrayList<>();
        for (int i=0; i< positions.size(); i++){
            if (positions.get(i).getProductInPosition().nome.equalsIgnoreCase(name)){
                risultato =  positions.get(i).getProductInPosition();
                myPositions.add(risultato.posizione);
            }
        }
        return myPositions;
    }

}
