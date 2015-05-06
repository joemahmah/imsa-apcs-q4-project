/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.core;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author mhrcek
 */
public class UI extends JFrame {

    private ImagePanel mapPanel;
    private Map map;

    public UI(int x, int y, Map map) {
        setLayout(new GridLayout(2, 2));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBackground(Color.WHITE);
        setPreferredSize(new Dimension(x, y));
        setSize(new Dimension(x, y));
        setVisible(true);

        this.map = map;
        this.mapPanel = new ImagePanel(map);

        addComponents();
    }

    private void addComponents() {

        add(mapPanel);
    }

    private class ImagePanel extends JPanel {

        Image mapImage;

        private ImagePanel(Map map) {
            mapImage = map.getMapImage();
        }

        @Override
        public void paintComponent(Graphics g) {
            if (mapImage == null) {
                return;
            }

            int imageWidth = mapImage.getWidth(this);
            int imageHeight = mapImage.getHeight(this);

            g.drawImage(mapImage, 50, 50, this);

        }
    }

}
