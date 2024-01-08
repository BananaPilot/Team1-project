package Warehouse;

import java.util.ArrayList;
    public class Warehouse {

        /* il magazzino sarà un insieme di zone
           qui dichiaro una lista di zone,
           tipo di dato istanza di warehouse ( ancora da decidere )
         */
        public static ArrayList<Warehouse> warehouseZones = new ArrayList<>();
        /* la zona sarà un insieme di posizioni,
           qui dichiaro una lista di posizioni,
           tipo di dato istanza di posizione
         */
        public static ArrayList<StockPosition> positions = new ArrayList<StockPosition>();

        /* la zona poi avrà un nome per indicarne il settore,
           un id per poter essere identificata
         */
        public String zone;
        public int zoneId;

    /* l'idea è salvare ogni istanza di posizione in una lista
       per poi essere in gradi di poter attingere all'id della posizione
       tramite l'id deal prodotto
     */

        // un metodo per istanziare una posizione ed assegnargli un prodotto
        public static void productIsStocked(String nome, String brand, double price){
            /* serve classe prodotto
               ProdottoFantoccio prodotto = new ProdottoFantoccio(nome,brand,price);
               l'istanza di posizione ha bisogno di un prodotto come argomento sotto
            */
            StockPosition newPosition = new StockPosition(prodotto);
            positions.add(newPosition);
            // prodotto.posizione = positions.get(prodotto.id-1).getBatchId();
        }
    }

