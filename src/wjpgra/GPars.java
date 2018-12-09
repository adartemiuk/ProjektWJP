
package wjpgra;

import java.awt.Image;
import javax.swing.ImageIcon;

public class GPars {
   public static Image bgImage;
   public static Image bgImage1;
    public static void loadInitialImages() {
    bgImage = loadImage("/Users/adamartemiuk/Desktop/bckgnd.png");
    bgImage1 = loadImage("/Users/adamartemiuk/Desktop/tlo4.png");
    }
    public static Image loadImage(String fileName) {
        return new ImageIcon(fileName).getImage();
    }//koniec loadImage(); 
}
