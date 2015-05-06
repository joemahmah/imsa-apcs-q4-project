/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core;

/**
 *
 * @author mhrcek
 */
public class Coordinate {

    private int x;
    private int y;
    private String name;
    
    public Coordinate(int x, int y, String name){
        this.x = x;
        this.y = y;
        this.name=name;
    }
    
    public int getX(){
        return x;
    }
    
    public int getY(){
        return y;
    }
    
    public String getName(){
        return name;
    }
    
    public static Coordinate add(Coordinate... coordinates){
        Coordinate finalCoord = new Coordinate(0, 0,"0");
        
        for(Coordinate coord: coordinates){
            //finalCoord = new Coordinate(finalCoord.getX() + coord.getX(), finalCoord.getY() + coord.getY());
        }
        
        return finalCoord;
    }
    /**
     * Finds the distance between two points
     * @param the other corrdinate
     * @return the distance
     */
     public double distance(Coordinate c){
         int x2 = c.getX();
         int y2= c.getY();
         double distance = Math.sqrt(Math.pow((x-x2),2)+ Math.pow((y-y2),2));
         return distance;
    }
}
