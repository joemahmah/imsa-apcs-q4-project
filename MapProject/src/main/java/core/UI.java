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
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author mhrcek
 */
public class UI extends JFrame {

    private ImagePanel mapPanel;
    private Map map;
    private MouseListener listener;
    private List<Coordinate> ralyCoordinates;

    public UI(int x, int y, Map map, String imageLocation) throws IOException {
        ralyCoordinates = new ArrayList<>();

        setLayout(new FlowLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBackground(Color.WHITE);
        setPreferredSize(new Dimension(x, y));
        setSize(new Dimension(x, y));
        setResizable(false);

        this.map = map;
        this.mapPanel = new ImagePanel(imageLocation);

        addComponents();
        addListeners();

        setVisible(true);
    }

    private void addListeners() {
        listener = new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent me) {
//                ralyCoordinates.add(new Coordinate((int) getMousePosition().getX(),(int) getMousePosition().getY() - 30));
                map.addPoints(new Coordinate((int) getMousePosition().getX(), (int) getMousePosition().getY()));
            }

            @Override
            public void mousePressed(MouseEvent me) {

            }

            @Override
            public void mouseReleased(MouseEvent me) {

            }

            @Override
            public void mouseEntered(MouseEvent me) {

            }

            @Override
            public void mouseExited(MouseEvent me) {

            }
        };

        KeyListener keyListen = new KeyListener() {

            @Override
            public void keyTyped(KeyEvent ke) {
                if (ke.getKeyChar() == 'p') {

                    List<Coordinate> coords = map.getMapPoints();
                    for (Coordinate coord : coords) {
                        System.out.println(coord.getName() + ": " + coord.getX() + "," + coord.getY());
                    }
                }
                
                if(ke.getKeyChar() == 's'){
                    IO_Logic.saveMap(JOptionPane.showInputDialog("Save path:"), map);
                }
                
                if(ke.getKeyChar() == 'l'){
                    map = IO_Logic.loadMap(JOptionPane.showInputDialog("File location:"));
                }
            }

            @Override
            public void keyPressed(KeyEvent ke) {
                
            }

            @Override
            public void keyReleased(KeyEvent ke) {
                
            }
        };

        addMouseListener(listener);
        addKeyListener(keyListen);
    }

    private void addComponents() {

        add(mapPanel);
    }

    private class ImagePanel extends JLabel {

        ImageIcon mapImage;

        private ImagePanel(String imageLocation) throws IOException {
            mapImage = new ImageIcon(IO_Logic.loadImage(imageLocation));
            setIcon(mapImage);
        }
    }

}
