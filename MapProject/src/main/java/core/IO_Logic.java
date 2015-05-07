/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

/**
 *
 * @author mhrcek
 */
public class IO_Logic {

    public static Image loadImage(String path) throws IOException {
        return ImageIO.read(new File(path));
    }

    public static Map loadMap(String path){
        FileInputStream inStream = null;
        ObjectInputStream objStream = null;
        
        try{
            
            inStream = new FileInputStream(path);
            objStream = new ObjectInputStream(inStream);
            
            return (Map) objStream.readObject();
            
        } catch (IOException e){
            e.printStackTrace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(IO_Logic.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            try{
                objStream.close();
                inStream.close();
            } catch(IOException e){
                e.printStackTrace();
            }
        }
        
        return null;
    }
    
    public static void saveMap(String path, Map map) {
        ObjectOutputStream objStream = null;
        FileOutputStream fileStream = null;
        try {
            fileStream = new FileOutputStream(path);
            objStream = new ObjectOutputStream(fileStream);
            objStream.writeObject(map);
        } catch (IOException ex) {
            Logger.getLogger(IO_Logic.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                objStream.close();
                fileStream.close();
            } catch (IOException ex) {
                Logger.getLogger(IO_Logic.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
