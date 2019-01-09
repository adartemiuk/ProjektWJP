
package wjpgra;

import java.awt.Toolkit;

/**
 * Klasa main, gra Swiatlem do celu
 * @author Adam Artemiuk
 */
public class WJPGra {
    public static int gameWidth=1024;
    public static int gameHeight=768;
   
    public static int screenWidth=Toolkit.getDefaultToolkit().getScreenSize().width;
    public static int screenHeight=Toolkit.getDefaultToolkit().getScreenSize().height;
    /**
     * Metoda uruchamia grę. Najpierw pobierane są parametry ekranu
     * i po ustaleniu rozmiaru gry (1024/768) obliczany jest punkt (x,y)
     * górnego, lewego narożnika panelu gry tak, aby pole gry było wyśrodkowane
     * na ekranie.
     */
    
    public static void main(String[] args) {
        
    
    int xCenter=(screenWidth-gameWidth)/2;
    int yCenter=(screenHeight-gameHeight)/2;
    // Stworzenie obiektu klasy Menu, uruchomienie menu glownego gry
    Menu m = new Menu(gameWidth,gameHeight,xCenter,yCenter);

    }   
}
