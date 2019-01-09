
package wjpgra;


import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Line2D;
import javax.swing.Timer;
import javax.swing.JPanel;
/**
 * Klasa dziedziczaca po JPanel
 * Glowna klasa rysujaca
 * @author Adam Artemiuk
 */
public class PanelwGrze extends JPanel implements MouseListener,ActionListener {
    /** Timer do animacji */
    Timer time;
    /** Zmienna sluzaca jako indeks tabeli  */
    public int z;
    /** Zmienna zliczajaca liczbe luster  */
    public int licznik;
    /** zmienna sluzaca jako indeks tabeli  */
    public int index; 
    /** zmienna sluzaca jako indeks tabeli  */
    public int k;
    /** zmienna inicjujaca rysowanie luster  */
    public boolean rysujlustra;
    /** zmienna okreslajaca wygrana  */
    public static boolean wygrana;
    /** zmienna inicjujaca odswiezanie panelu i resetowanie zmiennych  */
    public static boolean czyrepaint;
    /** zmienna okreslajaca czy przegrana  */
    public boolean przegrana;
    /** zmienna sluzaca jako indeks tabeli  */
    public int liczba;
    /** zmienna inicjujaca resetowanie  */
    public static boolean rysujlaser=true;
    /** Wspolrzedne, ktore przechowuja wspolrzedne klikniecia myszka  */
    public  int x,y;
    /** Wartosc przesuniecia potrzebna do liczenia odbica lasera  */
    public int przesuniecie;
    /** Zmienna okreslajaca rodzaj lustra  */
    public static int typ;
    /** indeks tabeli  */
    public int numer;
    /** Tablica obiektow typu lustra  */
    public static Lustra[] lustra;
    /** Tablica obiektow typu laser  */
    public static Laser[] laser;
     /**
     * Konstruktor - inicjacja timera, dodanie obslugi zdarzen
     */   
    public PanelwGrze(){
       
        time= new Timer(400,this);
        resetuj();
        addMouseListener(this); 
        
        OknoDialogowe.b2.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                if(GStatus.lvl==1) GStatus.ustawPoziom1();
                if(GStatus.lvl==2) GStatus.ustawPoziom2();
                if(GStatus.lvl==3) GStatus.ustawPoziom3();
                GStatus.liczbaprob++;
                resetuj();
                repaint();
            } 
        });
          
        OknoDialogowe.b3.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                GStatus.zerujpoziomy();
                resetuj();
                repaint();    
            }
        });
    }
     
     /* obsluga zdarzen - klikniecie myszka */
    @Override
    public void mouseClicked(MouseEvent e) {  
        // jesli kliknieto LPM
        if(e.getButton()==MouseEvent.BUTTON1){ 
            GStatus.rysujlustra=true;
            // jesli miejsce klikniecia jest na krawedziach okna gry
            if(e.getY()<=640 && e.getX()<=10 || e.getX()>=1014 || e.getY()<=10 && e.getX()<=1024 || e.getY()>=630 ){
                // jesli liczba dostepnych luster nie zostala przekroczona
                if(index<lustra.length){
                    //jesli kliknieto lustro 90 
                    if(typ==1){ 
                        GStatus.lustr--;
                        licznik++;
                        rysujlustra=true;
                        lustra[index].kat=90;
                        numer=index;
                        x=e.getX();
                        y=e.getY();
                        
                        if(y<=640 && x<=5 || x>=1019){
                        lustra[index].xs=x;
                        lustra[index].ys=y-30; 
                        lustra[index].xk=x;
                        lustra[index].yk=y+30; 
                        }
                        repaint();
                        index++;
                     } 
                    //jesli kliknieto lustro 180 
                    if(typ==2){ 
                        GStatus.lustr--;
                        licznik++;
                    rysujlustra=true;
                    lustra[index].kat=180;
                    numer=index;
                    x=e.getX();
                    y=e.getY();
                    if(y<=10 && x<=1024 || y>=630){
                        lustra[index].xs=x-30;
                        lustra[index].ys=y; 
                        lustra[index].xk=x+30;
                        lustra[index].yk=y;
                    }
                    repaint();
                    index++;
                }   //jesli kliknieto lustro 45
                    if(typ==3){
                        GStatus.lustr--;
                        licznik++;
                        rysujlustra=true;
                        lustra[index].kat=45;
                        numer=index;
                        x=e.getX();
                        y=e.getY();
                        //lewa strona
                        if(y<=640 && x<=5){
                            lustra[index].strona=true;
                            lustra[index].xs=x;
                            lustra[index].ys=y-20; 
                            lustra[index].xk=x+40;
                            lustra[index].yk=y+20; 
                            //prawa strona
                        }else if(y<=640 && x>=1019){
                            lustra[index].strona=false;
                            lustra[index].xs=x;
                            lustra[index].ys=y-20; 
                            lustra[index].xk=x-40;
                            lustra[index].yk=y+20; 
                        }
                        repaint();
                        index++;   
                    }////jesli kliknieto lustro 225    
                    if(typ==5){
                        GStatus.lustr--;
                        licznik++;
                        rysujlustra=true;
                        numer=index;
                        lustra[index].kat=225;
                        x=e.getX();
                        y=e.getY();
                        if(y<=640 && x<=5){
                            lustra[index].strona=true;
                            lustra[index].xs=x;
                            lustra[index].ys=y+20; 
                            lustra[index].xk=x+40;
                            lustra[index].yk=y-20; 
                        }else if(y<=640 && x>=1019){
                            lustra[index].strona=false;
                            lustra[index].xs=x;
                            lustra[index].ys=y+20; 
                            lustra[index].xk=x-40;
                            lustra[index].yk=y-20; 
                        }
                        repaint();
                        index++;
                    }//jesli kliknieto lustro 60
                    if(typ==4){
                        GStatus.lustr--;
                        licznik++;
                        rysujlustra=true;
                        numer=index;
                        lustra[index].kat=60;
                        x=e.getX();
                        y=e.getY();
                        if(y<=640 && x<=5){
                            lustra[index].strona=true;
                            lustra[index].xs=x;
                            lustra[index].ys=y-20; 
                            lustra[index].xk=x+20;
                            lustra[index].yk=y+20; 
                        }else if(y<=640 && x>=1019){
                            lustra[index].strona=false;
                            lustra[index].xs=x;
                            lustra[index].ys=y-20; 
                            lustra[index].xk=x-20;
                            lustra[index].yk=y+20; 
                        }
                        repaint();
                        index++;
                    }  
                   //jesli kliknieto lustro 240
                    if(typ==6){
                        GStatus.lustr--;
                        licznik++;
                        rysujlustra=true;
                        numer=index;
                        lustra[index].kat=240;
                        x=e.getX();
                        y=e.getY();
                        if(y<=640 && x<=5){
                            lustra[index].strona=true;
                            lustra[index].xs=x;
                            lustra[index].ys=y+20; 
                            lustra[index].xk=x+20;
                            lustra[index].yk=y-20; 
                        }else if(y<=640 && x>=1019){
                            lustra[index].strona=false;
                            lustra[index].xs=x;
                            lustra[index].ys=y+20; 
                            lustra[index].xk=x-20;
                            lustra[index].yk=y-20; 
                        }
                        repaint();
                        index++;
                    } 
                }  
            } 
        }//jesli kliknieto na krawedz okna gry
        if(rysujlustra){
            //jesli nie przekroczono liczby dostepnych laserow
            if(k<laser.length){
                // jesli linia lasera przecina sie z linia lustra
                if(Line2D.linesIntersect(laser[k].xs, laser[k].ys, laser[k].xk, laser[k].yk,
                lustra[numer].xs, lustra[numer].ys, lustra[numer].xk, lustra[numer].yk)){  
                    //jesli lustro 90
                    if(lustra[numer].kat==90){
                        //sprawdzenie z ktorej strony laser pada na lustro
                        if(laser[k].xs>laser[k].xk && laser[k].ys<laser[k].yk ){
                            lustra[numer].a=liczA(lustra[numer]);
                            laser[k].a=liczA(laser[k]);
                            lustra[numer].b=liczB(lustra[numer]);
                            laser[k].b=liczB(laser[k]);
                            // licz punkt przeciecia i przesuniecie
                            Point p=new Point();
                            p=liczPunktprzeciecia(lustra[numer],laser[k]);
                            przesuniecie=p.y-(int)laser[k].ys;
                            k++;
                            // rysuj nowy laser i zmien wspolrzedne koncowe poprzedniego lasera
                            laser[k-1].xk=p.x;
                            laser[k-1].yk=p.y;
                            laser[k].xs=p.x;
                            laser[k].ys=p.y;
                            laser[k].xk=laser[k-1].xs+1024;
                            laser[k].yk=(p.y+przesuniecie)+643;
                            // tak samo dla kolejnych luster
                            
                        } else if(laser[k].xs>laser[k].xk && laser[k].ys>laser[k].yk ){
                            lustra[numer].a=liczA(lustra[numer]);
                            laser[k].a=liczA(laser[k]);
                            lustra[numer].b=liczB(lustra[numer]);
                            laser[k].b=liczB(laser[k]);
                            Point p=new Point();
                            p=liczPunktprzeciecia(lustra[numer],laser[k]);
                            przesuniecie=p.y-(int)laser[k].ys;
                            k++;
                            laser[k-1].xk=p.x;
                            laser[k-1].yk=p.y;
                            laser[k].xs=p.x;
                            laser[k].ys=p.y;
                            laser[k].xk=laser[k-1].xs+1024;
                            laser[k].yk=(p.y+przesuniecie)-643;
                        }
                        else if(laser[k].xs<laser[k].xk && laser[k].ys<laser[k].yk ){
                            lustra[numer].a=liczA(lustra[numer]);
                            laser[k].a=liczA(laser[k]);
                            lustra[numer].b=liczB(lustra[numer]);
                            laser[k].b=liczB(laser[k]);
                            Point p=new Point();
                            p=liczPunktprzeciecia(lustra[numer],laser[k]);
                            przesuniecie=p.y-(int)laser[k].ys;
                            k++;
                            laser[k-1].xk=p.x;
                            laser[k-1].yk=p.y;
                            laser[k].xs=p.x;
                            laser[k].ys=p.y;
                            laser[k].xk=laser[k-1].xs-1024;
                            laser[k].yk=(p.y+przesuniecie)+643;
                        } else if(laser[k].xs<laser[k].xk && laser[k].ys>laser[k].yk ){
                            lustra[numer].a=liczA(lustra[numer]);
                            laser[k].a=liczA(laser[k]);
                            lustra[numer].b=liczB(lustra[numer]);
                            laser[k].b=liczB(laser[k]);
                            Point p=new Point();
                            p=liczPunktprzeciecia(lustra[numer],laser[k]);
                            przesuniecie=p.y-(int)laser[k].ys;
                            k++;
                            laser[k-1].xk=p.x;
                            laser[k-1].yk=p.y;
                            laser[k].xs=p.x;
                            laser[k].ys=p.y;
                            laser[k].xk=laser[k-1].xs-1024;
                            laser[k].yk=(p.y+przesuniecie)-643;
                        }
                    }  
                    if(lustra[numer].kat==180){
                        if(laser[k].xs<laser[k].xk && laser[k].ys>laser[k].yk  ){
                            lustra[numer].a=liczA(lustra[numer]);
                            laser[k].a=liczA(laser[k]);
                            lustra[numer].b=liczB(lustra[numer]);
                            laser[k].b=liczB(laser[k]);
                            Point p=new Point();
                            p=liczPunktprzeciecia(lustra[numer],laser[k]);
                            przesuniecie=p.x-(int)laser[k].xs;
                            k++;
                            laser[k-1].xk=p.x;
                            laser[k-1].yk=p.y;
                            laser[k].xs=p.x;
                            laser[k].ys=p.y;
                            laser[k].xk=(p.x+przesuniecie)+1024;
                            laser[k].yk=laser[k-1].ys+643;
                        }
                        else if(laser[k].xs>laser[k].xk && laser[k].ys>laser[k].yk ){
                            lustra[numer].a=liczA(lustra[numer]);
                            laser[k].a=liczA(laser[k]);
                            lustra[numer].b=liczB(lustra[numer]);
                            laser[k].b=liczB(laser[k]);
                            Point p=new Point();
                            p=liczPunktprzeciecia(lustra[numer],laser[k]);
                            przesuniecie=p.x-(int)laser[k].xs;
                            k++;
                            laser[k-1].xk=p.x;
                            laser[k-1].yk=p.y;
                            laser[k].xs=p.x;
                            laser[k].ys=p.y;
                            laser[k].xk=(p.x+przesuniecie)-1024;
                            laser[k].yk=laser[k-1].ys+643;
                        } 
                        else if(laser[k].xs<laser[k].xk && laser[k].ys<laser[k].yk ){
                            lustra[numer].a=liczA(lustra[numer]);
                            laser[k].a=liczA(laser[k]);
                            lustra[numer].b=liczB(lustra[numer]);
                            laser[k].b=liczB(laser[k]);
                            Point p=new Point();
                            p=liczPunktprzeciecia(lustra[numer],laser[k]);
                            przesuniecie=p.x-(int)laser[k].xs;
                            k++;
                            laser[k-1].xk=p.x;
                            laser[k-1].yk=p.y;
                            laser[k].xs=p.x;
                            laser[k].ys=p.y;
                            laser[k].xk=(p.x+przesuniecie)+1024;
                            laser[k].yk=laser[k-1].ys-643;
                        }
                        else if(laser[k].xs>laser[k].xk && laser[k].ys<laser[k].yk ){
                            lustra[numer].a=liczA(lustra[numer]);
                            laser[k].a=liczA(laser[k]);
                            lustra[numer].b=liczB(lustra[numer]);
                            laser[k].b=liczB(laser[k]);
                            Point p=new Point();
                            p=liczPunktprzeciecia(lustra[numer],laser[k]);
                            przesuniecie=p.x-(int)laser[k].xs;
                            k++;
                            laser[k-1].xk=p.x;
                            laser[k-1].yk=p.y;
                            laser[k].xs=p.x;
                            laser[k].ys=p.y;
                            laser[k].xk=(p.x+przesuniecie)-1024;
                            laser[k].yk=laser[k-1].ys-643;
                        }  
                    }
                    if(lustra[numer].kat==45){
                        if(lustra[numer].strona){
                            if(laser[k].xs-laser[k].xk==0){
                                lustra[numer].a=liczA(lustra[numer]);
                                laser[k].a=liczA(laser[k]);
                                lustra[numer].b=liczB(lustra[numer]);
                                laser[k].b=liczB(laser[k]);
                                Point p=new Point();
                                p=liczPunktprzeciecia(lustra[numer],laser[k]);
                                k++;    
                                laser[k-1].xk=p.x;
                                laser[k-1].yk=p.y;
                                laser[k].xs=p.x;
                                laser[k].ys=p.y;
                                laser[k].xk=1024;
                                laser[k].yk=p.y;
                            }
                            else if(laser[k].ys-laser[k].yk==0){
                                lustra[numer].a=liczA(lustra[numer]);
                                laser[k].a=liczA(laser[k]);
                                lustra[numer].b=liczB(lustra[numer]);
                                laser[k].b=liczB(laser[k]);
                                Point p=new Point();
                                p=liczPunktprzeciecia(lustra[numer],laser[k]);
                                k++;
                                laser[k-1].xk=p.x;
                                laser[k-1].yk=p.y;
                                laser[k].xs=p.x;
                                laser[k].ys=p.y;
                                laser[k].xk=p.x;
                                laser[k].yk=0;
                            }
                        }
                        else if(!lustra[numer].strona){
                            if(laser[k].xs-laser[k].xk==0){
                                lustra[numer].a=liczA(lustra[numer]);
                                laser[k].a=liczA(laser[k]);
                                lustra[numer].b=liczB(lustra[numer]);
                                laser[k].b=liczB(laser[k]);
                                Point p=new Point();
                                p=liczPunktprzeciecia(lustra[numer],laser[k]);
                                k++;                                    
                                laser[k-1].xk=p.x;
                                laser[k-1].yk=p.y;            
                                laser[k].xs=p.x;
                                laser[k].ys=p.y;
                                laser[k].xk=0;
                                laser[k].yk=p.y;
                            }
                            else if(laser[k].ys-laser[k].yk==0){
                                lustra[numer].a=liczA(lustra[numer]);
                                laser[k].a=liczA(laser[k]);
                                lustra[numer].b=liczB(lustra[numer]);
                                laser[k].b=liczB(laser[k]);
                                Point p=new Point();
                                p=liczPunktprzeciecia(lustra[numer],laser[k]);
                                k++;                                
                                laser[k-1].xk=p.x;
                                laser[k-1].yk=p.y;
                                laser[k].xs=p.x;
                                laser[k].ys=p.y;
                                laser[k].xk=p.x;
                                laser[k].yk=0;
                            }  
                        }
                    }
                    if(lustra[numer].kat==225){
                        if(lustra[numer].strona){
                            if(laser[k].xs-laser[k].xk==0){
                                lustra[numer].a=liczA(lustra[numer]);
                                laser[k].a=liczA(laser[k]);
                                lustra[numer].b=liczB(lustra[numer]);
                                laser[k].b=liczB(laser[k]);
                                Point p=new Point();
                                p=liczPunktprzeciecia(lustra[numer],laser[k]);
                                k++;                            
                                laser[k-1].xk=p.x;
                                laser[k-1].yk=p.y;        
                                laser[k].xs=p.x;
                                laser[k].ys=p.y;
                                laser[k].xk=1024;
                                laser[k].yk=p.y;
                            }
                            else if(laser[k].ys-laser[k].yk==0){
                                lustra[numer].a=liczA(lustra[numer]);
                                laser[k].a=liczA(laser[k]);
                                lustra[numer].b=liczB(lustra[numer]);
                                laser[k].b=liczB(laser[k]);
                                Point p=new Point();
                                p=liczPunktprzeciecia(lustra[numer],laser[k]);
                                k++;
                                laser[k-1].xk=p.x;
                                laser[k-1].yk=p.y;
                                laser[k].xs=p.x;
                                laser[k].ys=p.y;
                                laser[k].xk=p.x;
                                laser[k].yk=800;
                            }
                        }
                        else if(!lustra[numer].strona){
                            if(laser[k].xs-laser[k].xk==0){
                                lustra[numer].a=liczA(lustra[numer]);
                                laser[k].a=liczA(laser[k]);
                                lustra[numer].b=liczB(lustra[numer]);
                                laser[k].b=liczB(laser[k]);
                                Point p=new Point();
                                p=liczPunktprzeciecia(lustra[numer],laser[k]);
                                k++;                            
                                laser[k-1].xk=p.x;
                                laser[k-1].yk=p.y;            
                                laser[k].xs=p.x;
                                laser[k].ys=p.y;
                                laser[k].xk=0;
                                laser[k].yk=p.y;
                            }
                            else if(laser[k].ys-laser[k].yk==0){
                                lustra[numer].a=liczA(lustra[numer]);
                                laser[k].a=liczA(laser[k]);
                                lustra[numer].b=liczB(lustra[numer]);
                                laser[k].b=liczB(laser[k]);
                                Point p=new Point();
                                p=liczPunktprzeciecia(lustra[numer],laser[k]);
                                k++;                            
                                laser[k-1].xk=p.x;
                                laser[k-1].yk=p.y;        
                                laser[k].xs=p.x;
                                laser[k].ys=p.y;
                                laser[k].xk=p.x;
                                laser[k].yk=800;
                            }  
                        }
                    }
                    if(lustra[numer].kat==240){
                        if(lustra[numer].strona){
                            if(laser[k].xs>laser[k].xk && laser[k].ys>laser[k].yk ){
                                lustra[numer].a=liczA(lustra[numer]);
                                laser[k].a=liczA(laser[k]);
                                lustra[numer].b=liczB(lustra[numer]);
                                laser[k].b=liczB(laser[k]);
                                Point p=new Point();
                                p=liczPunktprzeciecia(lustra[numer],laser[k]);
                                k++;
                                laser[k-1].xk=p.x;
                                laser[k-1].yk=p.y;        
                                laser[k].xs=p.x;
                                laser[k].ys=p.y;
                                laser[k].xk=1024;
                                laser[k].yk=p.y;
                            }
                            else if(laser[k].ys-laser[k].yk==0){
                                lustra[numer].a=liczA(lustra[numer]);
                                laser[k].a=liczA(laser[k]);
                                lustra[numer].b=liczB(lustra[numer]);
                                laser[k].b=liczB(laser[k]);
                                Point p=new Point();
                                p=liczPunktprzeciecia(lustra[numer],laser[k]);
                                k++;                                
                                laser[k-1].xk=p.x;
                                laser[k-1].yk=p.y;  
                                laser[k].xs=p.x;
                                laser[k].ys=p.y;
                                laser[k].xk=1024;
                                laser[k].yk=p.y+896;
                            }
                        }
                        else if(!lustra[numer].strona){
                            if(laser[k].xs<laser[k].xk && laser[k].ys>laser[k].yk  ){
                                lustra[numer].a=liczA(lustra[numer]);
                                laser[k].a=liczA(laser[k]);
                                lustra[numer].b=liczB(lustra[numer]);
                                laser[k].b=liczB(laser[k]);
                                Point p=new Point();
                                p=liczPunktprzeciecia(lustra[numer],laser[k]);
                                k++;                            
                                laser[k-1].xk=p.x;
                                laser[k-1].yk=p.y;        
                                laser[k].xs=p.x;
                                laser[k].ys=p.y;
                                laser[k].xk=0;
                                laser[k].yk=p.y;
                            }
                            else if(laser[k].ys-laser[k].yk==0){
                                lustra[numer].a=liczA(lustra[numer]);
                                laser[k].a=liczA(laser[k]);
                                lustra[numer].b=liczB(lustra[numer]);
                                laser[k].b=liczB(laser[k]);
                                Point p=new Point();
                                p=liczPunktprzeciecia(lustra[numer],laser[k]);
                                k++;
                                laser[k-1].xk=p.x;
                                laser[k-1].yk=p.y;             
                                laser[k].xs=p.x;
                                laser[k].ys=p.y;
                                laser[k].xk=0;
                                laser[k].yk=p.y+896;
                            }  
                        }
                    }
                    if(lustra[numer].kat==60){
                        if(lustra[numer].strona){
                            if(laser[k].xs>laser[k].xk && laser[k].ys<laser[k].yk ){
                                lustra[numer].a=liczA(lustra[numer]);
                                laser[k].a=liczA(laser[k]);
                                lustra[numer].b=liczB(lustra[numer]);
                                laser[k].b=liczB(laser[k]);
                                Point p=new Point();
                                p=liczPunktprzeciecia(lustra[numer],laser[k]);
                                k++;   
                                laser[k-1].xk=p.x;
                                laser[k-1].yk=p.y;        
                                laser[k].xs=p.x;
                                laser[k].ys=p.y;
                                laser[k].xk=1024;
                                laser[k].yk=p.y;
                            }
                            else if(laser[k].ys-laser[k].yk==0){
                                lustra[numer].a=liczA(lustra[numer]);
                                laser[k].a=liczA(laser[k]);
                                lustra[numer].b=liczB(lustra[numer]);
                                laser[k].b=liczB(laser[k]);
                                Point p=new Point();
                                p=liczPunktprzeciecia(lustra[numer],laser[k]);                            
                                k++;    
                                laser[k-1].xk=p.x;
                                laser[k-1].yk=p.y;        
                                laser[k].xs=p.x;
                                laser[k].ys=p.y;
                                laser[k].xk=1024;
                                laser[k].yk=p.y-896;
                            }
                        }
                        else if(!lustra[numer].strona){
                            if(laser[k].xs<laser[k].xk && laser[k].ys<laser[k].yk ){
                                lustra[numer].a=liczA(lustra[numer]);
                                laser[k].a=liczA(laser[k]);
                                lustra[numer].b=liczB(lustra[numer]);
                                laser[k].b=liczB(laser[k]);
                                Point p=new Point();
                                p=liczPunktprzeciecia(lustra[numer],laser[k]);
                                k++;                            
                                laser[k-1].xk=p.x;
                                laser[k-1].yk=p.y;
                                laser[k].xs=p.x;
                                laser[k].ys=p.y;
                                laser[k].xk=0;
                                laser[k].yk=p.y;
                            }
                            else if(laser[k].ys-laser[k].yk==0){
                                lustra[numer].a=liczA(lustra[numer]);
                                laser[k].a=liczA(laser[k]);
                                lustra[numer].b=liczB(lustra[numer]);
                                laser[k].b=liczB(laser[k]);
                                Point p=new Point();
                                p=liczPunktprzeciecia(lustra[numer],laser[k]);
                                k++;                            
                                laser[k-1].xk=p.x;
                                laser[k-1].yk=p.y;
                                laser[k].xs=p.x;
                                laser[k].ys=p.y;
                                laser[k].xk=0;
                                laser[k].yk=p.y-896;
                            }  
                        }
                    }
                }
            }
        }
    }
     /**
     * metoda rysujaca elementy graficzne
     */
    protected void paintComponent(Graphics gs){
        Graphics2D g=(Graphics2D)gs;
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g.drawImage(Obrazy.tlogry, 0, 0, null); 
        // jesli poziom 1 rysuj odpowiednie przeszkody
        if(GStatus.lvl==1){
            g.drawImage(Obrazy.cel,660,140,50,50,null);
            g.drawImage(Obrazy.przeszkoda1,600,200,450,40,null);
            g.drawImage(Obrazy.przeszkoda2,600,200,40,-65,null);
        }//jesli poziom 2
        if(GStatus.lvl==2){
            g.drawImage(Obrazy.cel,550,50,50,50,null);
            g.drawImage(Obrazy.przeszkoda1,450,0,200,50,null);
            g.drawImage(Obrazy.przeszkoda2,650,0,50,150,null);
            g.drawImage(Obrazy.przeszkoda1,450,100,200,50,null);
        }//jesli poziom 3
        if(GStatus.lvl==3){
            g.drawImage(Obrazy.cel,640,300,50,50,null);
            g.drawImage(Obrazy.przeszkoda2,260,100,20,280,null);
            g.drawImage(Obrazy.przeszkoda1,280,100,100,20,null);
            g.drawImage(Obrazy.przeszkoda1,280,230,100,20,null);
            g.drawImage(Obrazy.przeszkoda1,280,360,100,20,null);
            g.drawImage(Obrazy.przeszkoda1,450,100,150,20,null);
            g.drawImage(Obrazy.przeszkoda2,515,120,20,260,null);
            g.drawImage(Obrazy.przeszkoda2,700,120,20,260,null);
        }
        g.drawImage(Obrazy.zrodlo,0,500,60,50,null);
        g.setColor(Color.red);
        //jesli kliknieto to rysuj lustra
        if(GStatus.rysujlustra){
            // dla wszsystkich luster z tabeli rysuj w zaleznosci od typu lustra
            for(int i=0;i<lustra.length;i++){
                g.setColor(Color.white);
                g.setStroke(new BasicStroke(5));
                if(lustra[i].kat==90){
                    g.drawLine((int)lustra[i].xs,(int)lustra[i].ys,(int)lustra[i].xk,(int)lustra[i].yk);  
                }
                if(lustra[i].kat==180){    
                    g.drawLine((int)lustra[i].xs,(int)lustra[i].ys,(int)lustra[i].xk,(int)lustra[i].yk); 
                }
                if(lustra[i].kat==60){
                    g.drawLine((int)lustra[i].xs,(int)lustra[i].ys,(int)lustra[i].xk,(int)lustra[i].yk); 
                }
                if(lustra[i].kat==45){
                    g.drawLine((int)lustra[i].xs,(int)lustra[i].ys,(int)lustra[i].xk,(int)lustra[i].yk); 
                }
                if(lustra[i].kat==225){
                    g.drawLine((int)lustra[i].xs,(int)lustra[i].ys,(int)lustra[i].xk,(int)lustra[i].yk); 
                }
                if(lustra[i].kat==240){
                    g.drawLine((int)lustra[i].xs,(int)lustra[i].ys,(int)lustra[i].xk,(int)lustra[i].yk); 
                }  
            }
        }   
        g.setColor(Color.red);
        g.setStroke(new BasicStroke(1));
        // jesli rysujlaser= prawda to rysuj wszystkie lasery
        if(rysujlaser)
            g.drawLine((int)laser[0].xs,(int)laser[0].ys, (int)laser[0].xk ,(int)laser[0].yk);
                if(GStatus.rysujlustra && rysujlaser){
                    for(int i=0;i<laser.length;i++)
                        g.drawLine((int)laser[i].xs,(int)laser[i].ys, (int)laser[i].xk ,(int)laser[i].yk);
                }
                // przejscie do stanu puszczenia wiazki
                if(rysujlaser==false){
                    time.restart();
                    switch (GStatus.lvl) {
                        case 1:
                            g.setColor(Color.yellow);
                            break;
                        case 2:
                            g.setColor(Color.green);
                            break;
                        case 3:
                            g.setColor(Color.BLUE);
                            break;
                        default:
                            break;
            }
                    g.drawLine((int)laser[liczba].xs,(int)laser[liczba].ys,(int)laser[liczba].xk,(int)laser[liczba].yk);
                    time.start();
                    wygrana=sprawdzCzyWygrana();
                    przegrana=sprawdzCzyPrzegrana();
                    
                    if(wygrana){
                        time.stop();
                        liczPunkty();
                        WygranaOkno wo = new WygranaOkno();
                        wo.setVisible(true);
                    }
                    if(przegrana){
                        time.stop();
                        PrzegranaOkno po = new PrzegranaOkno();
                        po.setVisible(true);               
                    }
                }
                
                if(czyrepaint){
                    resetuj();   
                }
    }
        /**
     * licz wspolczynnik nachylenia prostej a 
     * @param lu obiekt klasy Lustra
     */
    public static double liczA(Lustra lu){
        double a=0;
        if((lu.xk-lu.xs)!=0)
            a=(lu.yk-lu.ys)/(lu.xk-lu.xs);
        else 
            a=0;
        return a;
    }
        /**
     * Licz wspolczynnik b prostej
     * @param lu obiekt klasy Lustra
     */
    public static double liczB(Lustra lu){
        double b=0;
        if(lu.a!=0)
            b=lu.ys-lu.xs*((lu.yk-lu.ys)/(lu.xk-lu.xs));
        else 
            b=0; 
        return b;
    }
      /**
     * licz wspolczynnik nachylenia prostej a 
     * @param la obiekt klasy Laser
     */
    public static double liczA(Laser la){
        double a=0;
        if((la.xk-la.xs)!=0)
            a=(la.yk-la.ys)/(la.xk-la.xs);
        else 
            a=0;
        return a;
    }
            /**
     * Licz wspolczynnik b prostej
     * @param la obiekt klasy Laser
     */
    public static double liczB(Laser la){
        double b=0;
        if(la.a!=0)
            b=la.ys-la.xs*((la.yk-la.ys)/(la.xk-la.xs));
        else 
            b=0; 
        return b;
    }
            /**
     * Metoda liczy punkt przeciecia miedzy dwiema liniami na podstawie ich wspolrzednych
     * @param lu obiekt klasy Lustra
     * @param la obiekt klasy Laser
     */
    public static Point liczPunktprzeciecia(Lustra lu,Laser la){
        Point p = new Point();
        // jesli y1=a1x1+b1 i y2=a2x2+b2
        if(lu.a!=0 && la.a!=0){
            p.x=(int)((la.b-lu.b)/(lu.a-la.a));
            p.y=(int)((lu.a*((la.b-lu.b)/(lu.a-la.a)))+lu.b);
        }// jesli y1=a1x1+b1 i y2=stala
        else if (lu.a!=0 && (la.ys-la.yk==0)){
            p.x=(int)((la.yk-lu.b)/lu.a);
            p.y=(int)la.yk;
        }// jesli y2=a2x2+b2 i y1=stala
        else if (la.a!=0 && (lu.ys-lu.yk==0)){
            p.x=(int)((lu.yk-la.b)/la.a);
            p.y=(int)lu.yk;
        }// jesli y1=a1x1+b1 i x2=stala
        else if (lu.a!=0 && (la.xs-la.xk==0)){
            p.x=(int)la.xs;
            p.y=(int)((la.xk*lu.a)+lu.b);
        }// jesli y2=a2x2+b2 i x1=stala
        else if (la.a!=0 && (lu.xs-lu.xk==0)){
            p.x=(int)lu.xs;
            p.y=(int)((lu.xk*la.a)+la.b);
        }// jesli x1=stala i y2=stala
        else if ((lu.xk-lu.xs)==0 && (la.yk-la.ys==0)){
            p.x=(int)lu.xk;
            p.y=(int)la.yk;
        }// jesli x2=stala i y1=stala
        else if ((lu.yk-lu.ys)==0 && (la.xk-la.xs==0)){
            p.x=(int)la.xk;
            p.y=(int)lu.yk;
        }
        return p;
    }
       /**
     * metoda tworzy nowe tablice dla luster, zeruje indeksy i zmienne
     *
     */
    public void resetuj(){
        lustra = new Lustra[GStatus.lustr];
        for(int i=0;i<lustra.length;i++){
            lustra[i]=new Lustra();
        }
        laser = new Laser[GStatus.lustr+1];
        for(int i=0;i<laser.length;i++){
            laser[i]=new Laser();
        }
        laser[0].xs=60;
        laser[0].ys=525;
        laser[0].xk=1024;
        laser[0].yk=525;
        index=0;
        k=0;
        z=0;
        licznik=0;
        liczba=0;
        rysujlaser=true;
        czyrepaint=false;
        GStatus.rysujlustra=false;
         repaint();
        
    }
       /**
     * metoda sprawdzajaca czy graczowi udalo sie nakierowac wiazke
     * 
     */
    public boolean sprawdzCzyWygrana(){
        boolean wygrana=false;
        if(GStatus.lvl==1){
            // tworzy kwadrat o wspolrzednych celu
            Rectangle cel = new Rectangle(660,140,50,50);
            if(przegrana==false){
                if(z!=0){
                    // jesli cel i laser sie przecinaja to wygrana
                 if(cel.intersectsLine(laser[z-1].xs,laser[z-1].ys,laser[z-1].xk,laser[z-1].yk)){
                    if(laser[z-1].xs>=900 || laser[z-1].ys<=140 ){
                        wygrana=true;
                    }
                 }
            }   }
        }
        if(GStatus.lvl==2){
            Rectangle cel = new Rectangle(550,50,50,50);
            if(przegrana==false){
                if(z!=0){
                 if(cel.intersectsLine(laser[z-1].xs,laser[z-1].ys,laser[z-1].xk,laser[z-1].yk)){
                    if(laser[z-1].xs<=550){
                        wygrana=true;
                    }
                 }
            }}
        }
        if(GStatus.lvl==3){
            Rectangle cel = new Rectangle(640,300,50,50);
            if(przegrana==false){
                if(z!=0){
                 if(cel.intersectsLine(laser[z-1].xs,laser[z-1].ys,laser[z-1].xk,laser[z-1].yk)){
                    if(laser[z-1].xs<=640){
                        wygrana=true;
                    }
                 }
            }}
        }
        return wygrana;
    }
           /**
     * metoda powodujaca puszczenie wiazki
     * 
     */
    public static void uruchomWiazke(){
        rysujlaser=false;
    }
           /**
     * metoda sprawdzajaca czy gracz nakierowal wiazke na przeszkode 
     * 
     */
    public boolean sprawdzCzyPrzegrana(){
        boolean przegrana=false;
        if(GStatus.lvl==1){
            // tworzy kwadrat o wspolrzednych przeszkody
            Rectangle przeszkoda1 = new Rectangle(600,200,450,40);
            Rectangle przeszkoda2 = new Rectangle(600,200,40,-65);
            if(wygrana==false){
                if(z!=0){
                    // jesli przeszkoda i laser sie przecinaja to przegrana
                    if(przeszkoda1.intersectsLine(laser[z-1].xs,laser[z-1].ys,laser[z-1].xk,laser[z-1].yk)){
                        przegrana=true;
                    } else if(przeszkoda2.intersectsLine(laser[z-1].xs,laser[z-1].ys,laser[z-1].xk,laser[z-1].yk)){
                        przegrana=true;
                    }    
                }   
            }
        }
        if(GStatus.lvl==2){
            Rectangle przeszkoda1 = new Rectangle(450,0,200,50);
            Rectangle przeszkoda2 = new Rectangle(650,0,50,150);
            Rectangle przeszkoda3 = new Rectangle(450,100,200,50);
            if(wygrana==false){
                if(z!=0){
                    if(przeszkoda1.intersectsLine(laser[z-1].xs,laser[z-1].ys,laser[z-1].xk,laser[z-1].yk)){
                        przegrana=true;
                    } 
                    else if(przeszkoda2.intersectsLine(laser[z-1].xs,laser[z-1].ys,laser[z-1].xk,laser[z-1].yk)){
                        przegrana=true;
                    }
                    else if(przeszkoda3.intersectsLine(laser[z-1].xs,laser[z-1].ys,laser[z-1].xk,laser[z-1].yk)){
                        przegrana=true;
                    }
                }           
            }  
        }  
        if(GStatus.lvl==3){
           
            Rectangle przeszkoda1 = new Rectangle(260,100,20,280);
            Rectangle przeszkoda2 = new Rectangle(280,100,100,20);
            Rectangle przeszkoda3 = new Rectangle(280,230,100,20);
            Rectangle przeszkoda4 = new Rectangle(280,360,100,20);
            Rectangle przeszkoda5 = new Rectangle(450,100,150,20);
            Rectangle przeszkoda6 = new Rectangle(515,120,20,260);
            Rectangle przeszkoda7 = new Rectangle(700,120,20,260);
            if(wygrana==false){
                if(z!=0){
                    if(przeszkoda1.intersectsLine(laser[z-1].xs,laser[z-1].ys,laser[z-1].xk,laser[z-1].yk)){
                        przegrana=true;
                    } 
                    else if(przeszkoda2.intersectsLine(laser[z-1].xs,laser[z-1].ys,laser[z-1].xk,laser[z-1].yk)){
                        przegrana=true;
                    }
                    else if(przeszkoda3.intersectsLine(laser[z-1].xs,laser[z-1].ys,laser[z-1].xk,laser[z-1].yk)){
                        przegrana=true;
                    }
                    else if(przeszkoda4.intersectsLine(laser[z-1].xs,laser[z-1].ys,laser[z-1].xk,laser[z-1].yk)){
                        przegrana=true;
                    }
                    else if(przeszkoda5.intersectsLine(laser[z-1].xs,laser[z-1].ys,laser[z-1].xk,laser[z-1].yk)){
                        przegrana=true;
                    }
                    else if(przeszkoda6.intersectsLine(laser[z-1].xs,laser[z-1].ys,laser[z-1].xk,laser[z-1].yk)){
                        przegrana=true;
                    }
                    else if(przeszkoda7.intersectsLine(laser[z-1].xs,laser[z-1].ys,laser[z-1].xk,laser[z-1].yk)){
                        przegrana=true;
                    }  
                }       
            }
        } 
        return przegrana;
    }
              /**
     * metoda przyznajaca punkty za przejscie poziomu
     * 
     */
    public void liczPunkty(){
        if(GStatus.lustr>0) 
            GStatus.lustrapkt=GStatus.lustr*20;
        if(PanelGry.time>0)
            GStatus.czaspkt=PanelGry.time*2;
        if(GStatus.lvl==1)
            GStatus.lvlpkt=100;
        if(GStatus.lvl==2)
            GStatus.lvlpkt=200;
        GStatus.ujemnepkt=-(20*GStatus.liczbaprob);
        GStatus.points+=GStatus.lvlpkt+GStatus.czaspkt+GStatus.lustrapkt+GStatus.ujemnepkt;
    }
              /**
     * obsluga zdarzenia dla timera, co 400 ms zmienia wartosc indeksu
     * ktory nastepnie jest rysowany
     * 
     */
    @Override
    public void actionPerformed(ActionEvent e) {
 
        if(rysujlaser==false){
            if(liczba<=laser.length-1)
                liczba++; 
                z=liczba;
            if(liczba==laser.length)
                liczba--; 
     
        repaint();
        }
    }
    @Override
    public void mousePressed(MouseEvent e) {
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {  
    }

    @Override
    public void mouseEntered(MouseEvent e) {   
    }

    @Override
    public void mouseExited(MouseEvent e) {  
    }      
}