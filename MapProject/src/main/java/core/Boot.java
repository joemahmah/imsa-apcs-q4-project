package core;

public class Boot {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Map map = new Map();

        try {
            map.addMapImage(IO_Logic.loadImage("IMSAMap.png"));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.exit(404);
        }

        UI ui = new UI(800, 600, map);
    }
}
