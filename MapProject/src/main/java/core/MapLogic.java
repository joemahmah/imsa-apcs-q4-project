/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core;

import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;

/**
 *
 * @author mhrcek
 */
public class MapLogic {

    private Map map;
    private List<Coordinate> bounds;

    public MapLogic() {
        map = null;
        bounds = new ArrayList<>();
    }

    /**
     * Provides a pointer such that the map can be used.
     * @param map Map containing this instance of MapLogic.
     */
    public void linkMap(Map map) {
        this.map = map;
    }

    /**
     * Defines the bounds of the map via color id.
     */
    public void analyzeMap() {
        ImageIcon mapImage = map.getMapImage();

        for (int x = 0; x < mapImage.getIconWidth(); x++) {
            for (int y = 0; y < mapImage.getIconHeight(); y++) {
                //Look for black on map && mark as bounds
            }
        }
    }
    
    /**
     * Calculates the shortest route from start to finish.
     * @param start The user's starting position.
     * @param end The user's ending position.
     * @return 
     */
    public Path calcPath(Coordinate start, Coordinate end){
        
    }
}
