package classes.warehouse;

import classes.WarehouseLogic.StockPoisitionLogic;
import classes.product.Product;

import java.util.ArrayList;
import java.util.UUID;

public class Warehouse {


        private static ArrayList<Warehouse> warehouseZones = new ArrayList<>();
        private final int zoneHeigth;
        private final int zoneLongness;
        private final int zoneCapacity;
        private int stockProductCounter;
        private String zoneName;
        private final String zoneId;
        private ArrayList<StockPosition> positions = new ArrayList<StockPosition>();


        public Warehouse(String zoneName, int zoneLongness, int zoneHeigth){

            this.zoneName = zoneName;
            this.zoneLongness = zoneLongness;
            this.zoneHeigth = zoneHeigth;
            this.zoneId = UUID.randomUUID().toString();
            this.zoneCapacity = zoneHeigth * zoneLongness;
        }

    public int getZoneCapacity() {
        return zoneCapacity;
    }

    public int getStockProductCounter() {
        return stockProductCounter;
    }

    public void incrementStockProductCounter() {
        this.stockProductCounter++;
    }

    public String getZoneName() {
        return zoneName;
    }

    public void resetStockProductCounter(){
            this.stockProductCounter = 0;
    }

    public static ArrayList<Warehouse> getWarehouseZones() {
        return warehouseZones;
    }

    public ArrayList<StockPosition> getPositions() {
            return positions;
        }
        public static void getAllPositions(int index){

            for (StockPosition position :  warehouseZones.get(index).positions){
                System.out.println(position);
            }

        }
    }

