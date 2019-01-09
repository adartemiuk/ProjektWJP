
package wjpgra;

import javafx.scene.shape.Line;
/**
 * Klasa odpowiadajaca za lustra, ktore beda stawiane, dziedziczy po Line
 * @author Adam Artemiuk
 */
public class Lustra extends Line{
    /** Poczatkowa wartosc wspolrzednej x */
    public  double xs=-10;
    /** Koncowa wartosc wspolrzednej x */
    public  double xk=-10;
    /** Poczatkowa wartosc wspolrzednej y */
    public double ys=-11;
    /** Koncowa wartosc wspolrzednej y */
    public double yk=-11;
    /** Wartosc kata nachylenia lustra */
    public  int kat;
    /** Wartosc wspolczynnika nachylenia prostej */
    public double a;
    /** Wartosc wspolczynnika b prostej */
    public double b;
    /** Zmienna okreslajaca po ktorej stronie znajduje sie lustro (true=lewo;false=prawo) */
    public boolean strona;
    
 
}
