/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import main.java.core.Map;

/**
 *
 * @author mhrcek
 */
public class UI extends JFrame {

    private ImagePanel mapPanel;
    private Map map;

    public UI(int x, int y, Map map) {
        setLayout(new FlowLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBackground(Color.WHITE);
        setPreferredSize(new Dimension(x, y));
        setSize(new Dimension(x, y));

        this.map = map;
        this.mapPanel = new ImagePanel(map);

        addComponents();
        setVisible(true);
    }

    private void addComponents() {

        add(mapPanel);
    }

    private class ImagePanel extends JLabel {

        ImageIcon mapImage;

        private ImagePanel(Map map) {
            mapImage = new ImageIcon(map.getMapImage());
            setIcon(mapImage);
        }
    }

}
