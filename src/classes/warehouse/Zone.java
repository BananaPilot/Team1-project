package classes.warehouse;

import java.util.ArrayList;
import java.util.UUID;

public class Zone {

        private final int zoneHeigth;
        private int warehouseIndex = 1;
        private static int staticWarehouseIndex = 1;
        private final int zoneLongness;
        private final int zoneCapacity;
        private int stockProductCounter;
        private String sector;
        private final String zoneId;
        private ArrayList<Position> positions = new ArrayList<Position>();


        public Zone(String sector, int zoneLongness, int zoneHeigth){

            this.sector = sector;
            this.zoneLongness = zoneLongness;
            this.zoneHeigth = zoneHeigth;
            this.zoneId = UUID.randomUUID().toString();
            this.zoneCapacity = zoneHeigth * zoneLongness;
            this.warehouseIndex = staticWarehouseIndex;
            staticWarehouseIndex++;
        }

    public int getWarehouseIndex() {
        return warehouseIndex;
    }
    public int getZoneCapacity() {
        return zoneCapacity;
    }
    public static ArrayList<Zone> getWarehouseZones(){
            return Warehouse.getWarehouseZones();
    }
    public int getStockProductCounter() {
        return stockProductCounter;
    }
    public void incrementStockProductCounter() {
        this.stockProductCounter++;
    }

    public String getSector() {
        return sector;
    }

    public void resetStockProductCounter(){
            this.stockProductCounter = 0;
    }

    public ArrayList<Position> getPositions() {
            return positions;
        }
    public static void getAllPositions(int index) {
        index--;
        for (Position position : Warehouse.getWarehouseZones().get(index).positions) {
            System.out.println(position);
        }
    }

    @Override
    public String toString() {
        return "Sector: " +
                " Index: " + this.warehouseIndex +
                " zoneHeigth: " + zoneHeigth +
                " zoneLongness: " + zoneLongness +
                " zoneCapacity: " + zoneCapacity +
                " zoneName: " + sector + '\'' +
                " zoneId: " + zoneId + '\''
                ;
    }
}

