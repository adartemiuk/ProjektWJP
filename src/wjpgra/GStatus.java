
package wjpgra;


public class GStatus {
    public static long czaspocz;
    public static boolean rysuj;
    public int points;
public static int timelv1=180;
    public  int lvl;
    public static int lustr = 6;
    public final static int LPOZIOMOW=5;
    public final static long MAXTIME=Long.MAX_VALUE;
public void resetujpoziom(){
    rysuj=false;
    points=0;
    lvl=1;
    PanelGry.time=timelv1;
}
public void nastepnypoziom(){
    lvl++;
}
}       
    
    
   

