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
    
    public Coordinate(int x, int y){
        this.x = x;
        this.y = y;
    }
    
    public int getX(){
        return x;
    }
    
    public int getY(){
        return y;
    }
    
    public static Coordinate add(Coordinate... coordinates){
        Coordinate finalCoord = new Coordinate(0, 0);
        
        for(Coordinate coord: coordinates){
            finalCoord = new Coordinate(finalCoord.getX() + coord.getX(), finalCoord.getY() + coord.getY());
        }
        
        return finalCoord;
    }
}
