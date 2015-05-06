package main.java.core;

public class Boot {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Map map = new Map();

        try {
            map.addMapImage(IO_Logic.loadImage("/home/mhrcek/NetBeansProjects/APCS_Q4/imsa-apcs-q4-project/MapProject/src/main/resources/IMSAMap.PNG"));
        } catch (Exception e) {
            e.printStackTrace(System.err);
        } finally {
            System.exit(404);
        }

        UI ui = new UI(800, 600, map);
    }
}
