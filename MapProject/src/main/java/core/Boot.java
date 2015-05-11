package core;

public class Boot {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Map map = new Map();

        try {
//            map.addMapImage(IO_Logic.loadImage("/home/mhrcek/NetBeansProjects/APCS_Q4_2/imsa-apcs-q4-project/IMSAMap.PNG"));
        } catch (Exception e) {
            e.printStackTrace(System.err);
            System.exit(404);
        }

        try {
            UI ui = new UI(640, 480, map,"/home/mhrcek/Desktop/map.png");
        } catch (Exception e) {
            e.printStackTrace(System.err);
        }
    }
}
