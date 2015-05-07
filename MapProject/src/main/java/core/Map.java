/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core;

import core.MapLogic;
import java.awt.Image;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author mhrcek
 */
public class Map implements Serializable {

//    private Image mapImage;
    private MapLogic logic;
    private List<Coordinate> mapPoints;

    private static final long serialVersionUID = 6463760593940686409L;

    public Map() {
        logic = new MapLogic();
        logic.linkMap(this);

        mapPoints = new ArrayList<>();
    }

    public void addPoints(Coordinate... points) {
        for (Coordinate point : points) {
            Coordinate coord;

            if (point.getName() != null) {
                coord = new Coordinate(point.getX(), point.getY(), point.getName());
            } else {
                coord = new Coordinate(point.getX(), point.getY(), JOptionPane.showInputDialog("Location?"));
            }

            mapPoints.add(coord);
        }
    }

    public List<Coordinate> getMapPoints() {
        return mapPoints;
    }

//    public void addMapImage(Image mapImage) {
//        this.mapImage = mapImage;
//    }
//
//    public Image getMapImage() {
//        return mapImage;
//    }

    public MapLogic getMapLogic() {
        return logic;
    }

}
