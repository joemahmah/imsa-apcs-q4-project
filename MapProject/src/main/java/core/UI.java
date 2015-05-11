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
    private List<Coordinate> snapCoordinates;
    private String mapLocation;

    public UI(int x, int y, Map map, String imageLocation) throws IOException {
        ralyCoordinates = new ArrayList<>();
        snapCoordinates = new ArrayList<>();

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
                Coordinate nearest = map.getMapLogic().getNearestRoom((int) getMousePosition().getX(), (int) getMousePosition().getY());
//                System.err.println(nearest.getX() + " " + nearest.getY());
                
                if(ralyCoordinates.size() > 1){
                    ralyCoordinates = new ArrayList<>();
                }
                
                ralyCoordinates.add(nearest);
                System.out.println(nearest.getName());
//                map.addPoints(new Coordinate((int) getMousePosition().getX(), (int) getMousePosition().getY()));
//                syncLocations();

                repaint();
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

            public double getX() {
                return getMousePosition().getX();
            }

            public double getY() {
                return getMousePosition().getY();
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

                if (ke.getKeyChar() == 'r') {

                    map.addPoints(new Coordinate((int) getMousePosition().getX(), (int) getMousePosition().getY()));
                    syncLocations();
                }

                if (ke.getKeyChar() == 'h') {

                    map.addTransferPoints(new Coordinate((int) getMousePosition().getX(), (int) getMousePosition().getY()));
                    syncLocations();
                }

                if (ke.getKeyChar() == 's') {
                    IO_Logic.saveMap(JOptionPane.showInputDialog("Save path:"), map);
                }

                if (ke.getKeyChar() == 'l') {
                    map = IO_Logic.loadMap(mapLocation = JOptionPane.showInputDialog("File location:"));
                    syncLocations();
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

    private void syncLocations() {
        for (Coordinate coord : map.getMapPoints()) {
            snapCoordinates.add(coord);
        }
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

        @Override
        public void paint(Graphics g) {
            g.drawImage(mapImage.getImage(), 0, 0, this);

            g.setColor(Color.BLUE);
            for (Coordinate coord : ralyCoordinates) {
                g.drawRect(coord.getX(), coord.getY() - 30, 4, 4);
                g.drawRect(coord.getX(), coord.getY() - 30, 2, 2);
            }

            g.setColor(Color.GREEN);
            for (int x = 0; x < ralyCoordinates.size() - 1; x++) {

                Coordinate start = ralyCoordinates.get(x);
                Coordinate end = ralyCoordinates.get(x + 1);

                Path path = map.getMapLogic().calcPath(start, end);

                for (int i = 0; i < path.getCoords().size() - 1; i++) {
                    g.drawLine(path.getCoords().get(i).getX(), path.getCoords().get(i).getY()-30, path.getCoords().get(i + 1).getX(), path.getCoords().get(i + 1).getY()-30);
                }
                
                map = IO_Logic.loadMap(mapLocation);
            }
            
//            g.setColor(Color.yellow);
//            for(Coordinate coord: map.getMapPoints()){
//                g.drawRect(coord.getX(), coord.getY() - 30, 4, 4);
//                g.drawRect(coord.getX(), coord.getY() - 30, 2, 2);
//            }
//            
//            g.setColor(Color.YELLOW);
//            for(Coordinate coord: map.getMapTransferPoints()){
//                g.drawRect(coord.getX(), coord.getY() - 30, 4, 4);
//                g.drawRect(coord.getX(), coord.getY() - 30, 2, 2);
//            }
        }
    }
    
    public void load(String location){
        map = IO_Logic.loadMap(mapLocation = location);
    }

}
