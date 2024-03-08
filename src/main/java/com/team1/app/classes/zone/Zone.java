package com.team1.app.classes.zone;

import com.team1.app.classes.position.Position;
import com.team1.app.classes.shared.Searchable;
import com.team1.app.classes.in.Input;
import com.team1.app.classes.util.Util;

import java.util.ArrayList;

public class Zone extends Searchable {
    private String sector;
    private final ArrayList<Position> positions = new ArrayList<>();

    public Zone(String sector) {
        this.sector = sector;
        buildZone(Input.getInstance().getInt("Total number of racks: "), Input.getInstance().getInt("With : "), Input.getInstance().getInt("Height: "));
    }

    public void buildZone(int totalNumberOfRacks, int widthOfRack, int heightOfRack) {
        for (int numberOfRacks = 0; numberOfRacks < totalNumberOfRacks; numberOfRacks++) {
            for (int height = 0; height < heightOfRack; height++) {
                for (int width = 0; width < widthOfRack; width++) {
                    positions.add(new Position(Position.getWid(), height));
                }
            }
        }
    }

    public ArrayList<Position> getPositions() {
        return positions;
    }

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

    @Override
    public String toString() {
        return  "-------------------------------" + '\n' +
                "### Zones " + '\n' +
                "-------------------------------" + '\n' +
                "Sector = '" + sector + '\''
                + Util.splitter(positions);
    }
}
