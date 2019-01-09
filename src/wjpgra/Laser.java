
package wjpgra;

import javafx.scene.shape.Line;
/**
 * Klasa odpowiadajaca za lasery, ktore beda odbijac sie od luster, dziedziczy po Line
 * @author Adam Artemiuk
 */
public class Laser extends Line {
    /** Poczatkowa wartosc wspolrzednej x */
    public double xs=0;
    /** Poczatkowa wartosc wspolrzednej y */
    public double ys=0;
    /** Koncowa wartosc wspolrzednej x */
    public double xk=0;
    /** Koncowa wartosc wspolrzednej y */
    public double yk=0;
    /** Wartosc wspolczynnika nachylenia prostej */
    public double a;
    /** Wartosc wspolczynnika b prostej */
    public double b;
    
}
