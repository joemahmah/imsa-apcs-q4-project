/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core;

import java.io.Serializable;
import javax.swing.ImageIcon;

/**
 *
 * @author mhrcek
 */
public class Map implements Serializable {

    ImageIcon mapImage;
    MapLogic logic;

    public Map() {
        logic = new MapLogic();
        logic.linkMap(this);
    }
    
    public ImageIcon getMapImage(){
        return mapImage;
    }
    
    public MapLogic getMapLogic(){
        return logic;
    }

}
