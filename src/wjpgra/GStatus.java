
package wjpgra;


public class GStatus {
    
    public static int lustrapkt;
    public static int liczbaprob;
    public static int lvlpkt;
    public static int czaspkt;
    public static boolean rysuj;
    public static boolean resetuj;
    public static int points;
    public static int timelvl;
    public static int ujemnepkt;
    public  static int lvl=1;
    public static int lustr = 6;
    public final static int LPOZIOMOW=5;

public static void zerujpoziom(){
    timelvl=180;
   lustr=6;
    lvl=1;
    PanelGry.time=timelvl;
   
}
public static void ustawPoziom2(){
    timelvl=150;
    lvl=2;
    PanelGry.time=timelvl;
    lustr=4;
}
}       
    
    
   

