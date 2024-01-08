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

}
