
package wjpgra;

import java.awt.Image;
import javax.swing.ImageIcon;

public class Obrazy {
   public static Image bgImage;
   public static Image bgImage1;
    public static Image bgImage2;
    public static Image bgImage3;
     public static Image bgImage4;
     public static Image pion;
     public static Image poziom;
    public static void loadInitialImages() {
    bgImage = loadImage("/Users/adamartemiuk/Desktop/bckgnd.png");
    bgImage1 = loadImage("/Users/adamartemiuk/Desktop/tlo4.png");
    bgImage2 = loadImage("/Users/adamartemiuk/Desktop/punkt.png");
    bgImage3 = loadImage("/Users/adamartemiuk/Desktop/absorbujacy.png");
    bgImage4 = loadImage("/Users/adamartemiuk/Desktop/zrodlo.png");
    pion = loadImage("/Users/adamartemiuk/Desktop/pion.png");
    poziom = loadImage("/Users/adamartemiuk/Desktop/poziom.png");
    }
    public static Image loadImage(String fileName) {
        return new ImageIcon(fileName).getImage();
    }
}
