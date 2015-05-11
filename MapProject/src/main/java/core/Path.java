/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author mhrcek
 */
public class Path {
    
    private List<Coordinate> coords;
    
    public Path(Coordinate... coords){
        
        this.coords = new ArrayList<>();
        
        addCoordinate(coords);
    }
    
    public void addCoordinate(Coordinate... coords){
        for(Coordinate coord: coords){
            this.coords.add(coord);
            System.err.println(coord.getName());
        }
    }
    
    public List<Coordinate> getCoords(){
        return coords;
    }
    
    public Coordinate[] getCoordsAsArray(){
        
        Coordinate[] coords = new Coordinate[this.coords.size()];
        
        for(int i=0; i<coords.length; i++){
            coords[i] = this.coords.get(i);
        }
        
        return coords;
    }
    
    public boolean contains(Coordinate coordinate){
        for(Coordinate coord: coords){
            if(coord == coordinate){
                return true;
            }
        }
        
        return false;
    }
    
}
