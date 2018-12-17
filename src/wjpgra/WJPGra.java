
package wjpgra;

import java.awt.Toolkit;


public class WJPGra {

    public static void main(String[] args) {
    int gameWidth=1024;
    int gameHeight=768;
    
    int screenWidth=Toolkit.getDefaultToolkit().getScreenSize().width;
    int screenHeight=Toolkit.getDefaultToolkit().getScreenSize().height;
    
    int xCenter=(screenWidth-gameWidth)/2;
    int yCenter=(screenHeight-gameHeight)/2;
    
    Menu m = new Menu(gameWidth,gameHeight,xCenter,yCenter);

    }   
}
