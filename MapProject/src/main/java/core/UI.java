/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Panel;
import javax.swing.JFrame;

/**
 *
 * @author mhrcek
 */
public class UI extends JFrame {

    private Panel mapPanel;

    public UI(int x, int y) {
        setLayout(new GridLayout(2, 2));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBackground(Color.WHITE);
        setPreferredSize(new Dimension(x, y));
        setSize(new Dimension(x, y));
        setVisible(true);

        mapPanel = new Panel();

        addComponents();
    }

    private void addComponents() {

        add(mapPanel);
    }

}
