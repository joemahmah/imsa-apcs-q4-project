package core;

import main.java.core.Map;

public class Boot {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Map map = new Map();

        try {
            map.addMapImage(IO_Logic.loadImage("/home/mhrcek/NetBeansProjects/APCS_Q4_2/imsa-apcs-q4-project/IMSAMap.PNG"));
        } catch (Exception e) {
            e.printStackTrace(System.err);
            System.exit(404);
        }

        try {
            UI ui = new UI(490, 580, map);
        } catch (Exception e) {
            e.printStackTrace(System.err);
        }
    }
}
