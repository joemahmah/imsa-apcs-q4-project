/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core;

import java.awt.Image;
import java.io.Serializable;
import javax.swing.ImageIcon;

/**
 *
 * @author mhrcek
 */
public class Map implements Serializable {

    private Image mapImage;
    private MapLogic logic;

    public Map() {
        logic = new MapLogic();
        logic.linkMap(this);
    }
    
    public void addMapImage(Image mapImage){
        this.mapImage = mapImage;
    }
    
    public Image getMapImage(){
        return mapImage;
    }
    
    public MapLogic getMapLogic(){
        return logic;
    }

}
