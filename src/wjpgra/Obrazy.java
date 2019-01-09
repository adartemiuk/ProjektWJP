
package wjpgra;

import java.awt.Image;
import javax.swing.ImageIcon;
/**
 * Klasa przechowujaca obrazy uzyte w grze
 * @author Adam Artemiuk
 */
public class Obrazy {
    /** Obrazek dla tla menu glownego */
    public static Image tlomenu;
    /** Obrazek dla tla panelu gry */
    public static Image tlogry;
    /** Obrazek celu na ktory bedzie nakierowany laser*/
    public static Image cel;
    /** Obrazek przeszkody poziomej */
    public static Image przeszkoda1;
    /** Obrazek przeszkody poziomej */
    public static Image przeszkoda2;
    /** Obrazek zrodla lasera */
    public static Image zrodlo;
    /** Panel menu glownego */
    /**
     * Metoda ładowania obrazow
     */

    public static void loadInitialImages() {
        tlomenu = loadImage("/Users/adamartemiuk/NetBeansProjects/git/images/bckgnd.png");
        tlogry = loadImage("/Users/adamartemiuk/NetBeansProjects/git/images/tlo.jpeg");
        cel = loadImage("/Users/adamartemiuk/NetBeansProjects/git/images/punkt.png");
        przeszkoda1 = loadImage("/Users/adamartemiuk/NetBeansProjects/git/images/absorbujacy180.png");
        przeszkoda2 = loadImage("/Users/adamartemiuk/NetBeansProjects/git/images/absorbujacy90.png");
        zrodlo = loadImage("/Users/adamartemiuk/NetBeansProjects/git/images/zrodlo.png");
    }
     /**
     * Metoda pobierania obiektu klasy Image na podstawie ścieżki
     * dostepu podanej jako String
     */
    public static Image loadImage(String fileName) {
        return new ImageIcon(fileName).getImage();
    }
}
