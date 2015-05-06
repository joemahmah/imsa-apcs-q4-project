/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.core;

import java.awt.Image;
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
    private List<Coordinate> badVertices;
    public MapLogic() {
        map = null;
        bounds = new ArrayList<>();
        badVertices=new ArrayList<>();
    }

    /**
     * Provides a pointer such that the map can be used.
     * @param map Map containing this instance of MapLogic.
     */
    public void linkMap(Map map) {
        this.map = map;
    }
    
    /**
     * Implements a scanner and scans a file to find the list of nodes
     * @param String name of the file
     */
    public void getBounds(String file)
    {
        
    }

    /**
     * Defines the bounds of the map via color id.
     */
    public void analyzeMap() {
        Image mapImage = map.getMapImage();

//        for (int x = 0; x < mapImage.getWidth(); x++) {
//            for (int y = 0; y < mapImage.getHeight(); y++) {
//                //Look for black on map && mark as bounds
//            }
//        }
    }
    
    /**
     * Finds the closest vertex
     * 
     */
    public Coordinate findClosest(Coordinate init)
    {
        Coordinite start = init;
        bounds.remove(init);
        double distance = 730.0;
        Coordinate end = new Coordinate(0,0,"0");
        for(Coordinate tryCoord: bounds)
        {
            if(!badVertices.contains(tryCoord))
            {
                double d = init.getDistance(tryCoord);
                if(d<distance)
                {
                    distance = d;
                    end = tryCoord;
                }
            }
        }
        bounds.add(init);
        //add in black line detector part?
        return end;
    }
    /**
     * Calculates the shortest route from start to finish.
     * @param start The user's starting position.
     * @param end The user's ending position.
     * @return 
     */
    public Path calcPath(Coordinate start, Coordinate end){
        return null;
    }
}
