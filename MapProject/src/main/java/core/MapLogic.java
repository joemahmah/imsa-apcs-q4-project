/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core;

import java.awt.Image;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.swing.ImageIcon;

/**
 *
 * @author mhrcek
 */
public class MapLogic implements Serializable {

    private Map map;
    private List<Coordinate> bounds;
    private List<Coordinate> badVertices;

    private static final long serialVersionUID = 5483769666940726409L;

    public MapLogic() {
        map = null;
        bounds = new ArrayList<>();
        badVertices = new ArrayList<>();
    }

    /**
     * Provides a pointer such that the map can be used.
     *
     * @param map Map containing this instance of MapLogic.
     */
    public void linkMap(Map map) {
        this.map = map;
    }

    /**
     * Implements a scanner and scans a file to find the list of nodes
     *
     * @param String name of the file
     */
    public void getBounds(String file) {

    }

    /**
     * Defines the bounds of the map via color id.
     */
    public void analyzeMap() {
//        Image mapImage = map.getMapImage();

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
//    public Coordinate findClosest(Coordinate init)
//    {
//        Coordinite start = init;
//        bounds.remove(init);
//        double distance = 730.0;
//        Coordinate end = new Coordinate(0,0,"0");
//        for(Coordinate tryCoord: bounds)
//        {
//            if(!badVertices.contains(tryCoord))
//            {
//                double d = init.getDistance(tryCoord);
//                if(d<distance)
//                {
//                    distance = d;
//                    end = tryCoord;
//                }
//            }
//        }
//        bounds.add(init);
//        //add in black line detector part?
//        return end;
//    }
    /**
     * Calculates the shortest route from start to finish.
     *
     * @param start The user's starting position.
     * @param end The user's ending position.
     * @return
     */
    public Path calcPath(Coordinate start, Coordinate end) {

        List<Path> paths = new ArrayList<>();

        for (int i = 0; i < 100; i++) {
            paths.add(new Path(start));
        }

        for (Path path : paths) {
            while (!path.contains(end)) {
                path.addCoordinate(getRandom(end, path, path.getCoordsAsArray()));
            }
            System.out.print("/");
        }
        System.out.println("");

        Path shortest = paths.get(0);
        for (Path path : paths) {
            if (path.getTotalLength() < shortest.getTotalLength()) {
                shortest = path;
            }
        }

        return shortest;

    }

    Coordinate getNearestRoom(int x, int y) {
        List<Coordinate> rooms = map.getMapPoints();

        if (rooms.size() < 1) {
            return null;
        }

        Coordinate nearest = rooms.get(0);
        for (Coordinate location : rooms) {
            double distNear = Coordinate.distance(nearest, new Coordinate(x, y));
            double distCoord = Coordinate.distance(location, new Coordinate(x, y));

            if (distCoord < distNear) {
                nearest = location;
            }
        }

        return nearest;
    }

    Coordinate getNearest(Coordinate... exclude) {
        List<Coordinate> rooms = map.getMapPoints();
        rooms.addAll(map.getMapTransferPoints());

        List<Coordinate> ignoreList = new ArrayList<>();
        for (Coordinate coord : exclude) {
            ignoreList.add(coord);
        }

        Coordinate lastNode = ignoreList.get(ignoreList.size() - 1);

        rooms.removeAll(ignoreList);

        if (rooms.size() < 1) {
            return null;
        }

        Coordinate nearest = rooms.get(0);
        for (Coordinate location : rooms) {
            double distNear = Coordinate.distance(nearest, lastNode);
            double distCoord = Coordinate.distance(location, lastNode);

            if (distCoord < distNear) {
                nearest = location;
            }
        }

        return nearest;
    }

    Coordinate getRandom(Coordinate endCoord, Path path, Coordinate... exclude) {
        List<Coordinate> rooms = map.getMapPoints();
        rooms.addAll(map.getMapTransferPoints());

        List<Coordinate> ignoreList = new ArrayList<>();
        for (Coordinate coord : exclude) {
            ignoreList.add(coord);
        }

        Coordinate lastNode = ignoreList.get(ignoreList.size() - 1);

        rooms.removeAll(ignoreList);

        if (rooms.size() < 1) {
            return null;
        }
        
        if(Coordinate.distance(endCoord, lastNode) < 40){
            return endCoord;
        }

//        for(Coordinate coord: rooms){
//            System.err.println(Coordinate.distance(coord, lastNode));
//        }
//        System.err.println("\n\n");
        Random rand = new Random();
        Coordinate nearest;
        do {

            System.err.print(""); //No clue why it's needed but it is...
            if (rooms.size() == 0) {
                path.addCoordinate(new Coordinate(90000, 90000));
                return endCoord;
            }

            nearest = rooms.get(rand.nextInt(rooms.size()));

            if (Coordinate.distance(nearest, lastNode) > 40) {
                rooms.remove(nearest);
            }
//            System.err.println(Coordinate.distance(nearest, lastNode));
        } while (Coordinate.distance(nearest, lastNode) > 40);

        return nearest;
    }
}
