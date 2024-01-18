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
        public static void createZone(String zoneName, int zoneLongness, int zoneHeigth){

            Warehouse newZone = new Warehouse(zoneName,zoneLongness,zoneHeigth);
            int zoneLength = newZone.zoneCapacity;
            ArrayList<StockPosition> myPositions = newZone.getPositions();
            for (int index = 0; index < zoneLength; index++){
                StockPosition newPosition = new StockPosition(zoneLongness);
                myPositions.add(newPosition);
            }
            StockPoisitionLogic.resetPosition();
            Warehouse.warehouseZones.add(newZone);
        }

    public int getZoneCapacity() {
        return zoneCapacity;
    }

    public static ArrayList<Warehouse> getWarehouseZones() {
        return warehouseZones;
    }

    public ArrayList<StockPosition> getPositions() {
            return positions;
        }
        public static void getAllPositions(int index){
            index--;
            for (StockPosition position :  warehouseZones.get(index).positions){
                System.out.println(position);
            }

        }
    }

