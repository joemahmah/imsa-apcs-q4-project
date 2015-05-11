/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core;

import java.io.Serializable;

/**
 *
 * @author mhrcek
 */
public class Coordinate implements Serializable{

    private int x;
    private int y;
    private String name;

    private static final long serialVersionUID = 6483760666640886409L;

    public Coordinate(int x, int y, String name) {
        this.x = x;
        this.y = y;
        this.name = name;
    }

    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public String getName() {
        return name;
    }

    public static Coordinate add(Coordinate... coordinates) {
        Coordinate finalCoord = new Coordinate(0, 0);

        for (Coordinate coord : coordinates) {
            finalCoord = new Coordinate(finalCoord.getX() + coord.getX(), finalCoord.getY() + coord.getY());
        }

        return finalCoord;
    }

    /**
     * Finds the distance between two points
     *
     * @param the other corrdinate
     * @return the distance
     */
    public double distance(Coordinate c) {
        int x2 = c.getX();
        int y2 = c.getY();
        double distance = Math.sqrt(Math.pow((x - x2), 2) + Math.pow((y - y2), 2));
        return distance;
    }
    
    public static double distance(Coordinate coord1, Coordinate coord2) {
        double distance = Math.sqrt(Math.pow((coord1.getX() - coord2.getX()), 2) + Math.pow((coord1.getY() - coord2.getY()), 2));
        return distance;
    }
}
