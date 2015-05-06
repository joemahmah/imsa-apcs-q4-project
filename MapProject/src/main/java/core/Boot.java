package core;

public class Boot {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Map map = new Map();
        map.addMapImage(IO_Logic.loadImage("IMSAMap.png"));

        UI ui = new UI(800, 600, map);
    }
}
