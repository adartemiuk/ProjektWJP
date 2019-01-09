
package wjpgra;

/**
 * Klasa odpowiadajaca za poziomy gry
 * @author Adam Artemiuk
 */
public class GStatus {
    /** Liczba punktow zdobytych za uzyte lustra */
    public static int lustrapkt;
    /** Liczba podejsc do danego poziomu */
    public static int liczbaprob;
    /** Liczba punktow zdobytych za przejscie danego poziomu  */
    public static int lvlpkt;
    /** Liczba punktow zdobytych za czas */
    public static int czaspkt;
    /** Zmienna umozliwiajaca rysowanie luster */
    public static boolean rysujlustra;
    /** Calkowita liczba punktow */
    public static int points;
    /** Czas na przejscie poziomu */
    public static int timelvl;
    /** Liczba karnych punktow za powtorzenie poziomu */
    public static int ujemnepkt;
    /** Aktualny poziom */
    public  static int lvl;
    /** Liczba luster na dany poziom */
    public static int lustr;
    /**
     * Resetowanie poziomu
     */
    public static void zerujpoziomy(){
        lustrapkt=0;
        liczbaprob=0;
        lvlpkt=0;
        czaspkt=0;
        ujemnepkt=0;
        points=0;
        ustawPoziom1();
    }
    /**
     * Ustawienie 1 poziomu
     */
    public static void ustawPoziom1(){
        timelvl=180;
        lvl=1;
        PanelGry.time=timelvl;
        lustr=6;
    }
        /**
     * Ustawienie 2 poziomu
     */
    public static void ustawPoziom2(){
        timelvl=150;
        lvl=2;
        PanelGry.time=timelvl;
        lustr=4;
    }
        /**
     * Ustawienie 3 poziomu
     */
    public static void ustawPoziom3(){
        timelvl=120;
        lvl=3;
        PanelGry.time=timelvl;
        lustr=7;
    }
}       
    
    
   

