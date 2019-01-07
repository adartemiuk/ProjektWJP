
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
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;

import static wjpgra.GStatus.rysuj;

import static wjpgra.PanelGry.init;


public class PanelwGrze extends JPanel implements MouseListener,ActionListener {
    Timer time;
    int wspx1;
    int wspy1;
    boolean prawda;
    boolean wygrana;
    boolean przegrana;
 public int liczba=0;
 public int zwieksz=1;
   static boolean  licz=false;
  public static  boolean resetuj=true;
    public  int x,y;
    int i; 
    int k;
   int przesuniecie;
   public static int l;
    int numer;
    GStatus status = new GStatus();
    public static Lustra[] lustra;
    public static Laser[] laser;
   public PanelwGrze(){
       
       time= new Timer(300,this);
       resetuj();
       addMouseListener(this); 
                OknoDialogowe.b2.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                resetuj();
               repaint();
              
               
            } 
        });
          
            OknoDialogowe.b3.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                resetuj();
             repaint();
               
                
            }
        });
            PanelGry.rozpoczecie.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
             resetuj=false;
             repaint();  
                
             
            }
        });
    }
   
    @Override
    public void mouseClicked(MouseEvent e) {  
        
        if(e.getButton()==MouseEvent.BUTTON1){ 
            GStatus.rysuj=true;
            if(e.getY()<=640 && e.getX()<=5 || e.getX()>=1019 || e.getY()<=10 && e.getX()<=1024 || e.getY()>=630 ){
                if(i<6){
                    if(l==1){ 
                        prawda=true;
                        lustra[i].kat=90;
                        numer=i;
                        x=e.getX();
                        y=e.getY();
                        if(y<=640 && x<=5 || x>=1019){
                        lustra[i].xs=x;
                        lustra[i].ys=y-30; 
                        lustra[i].xk=x;
                        lustra[i].yk=y+30; 
                        }
                        repaint();
                        i++;
                     } 
                    if(l==2){ 
                    prawda=true;
                    lustra[i].kat=180;
                    numer=i;
                    x=e.getX();
                    y=e.getY();
                    if(y<=10 && x<=1024 || y>=630){
                        lustra[i].xs=x-30;
                        lustra[i].ys=y; 
                        lustra[i].xk=x+30;
                        lustra[i].yk=y;
                    }
                    repaint();
                    i++;
                }   
                    if(l==3){
                        prawda=true;
                        lustra[i].kat=45;
                        numer=i;
                        x=e.getX();
                        y=e.getY();
                        if(y<=640 && x<=5){
                            lustra[i].strona=true;
                            lustra[i].xs=x;
                            lustra[i].ys=y-20; 
                            lustra[i].xk=x+40;
                            lustra[i].yk=y+20; 
                        }else if(y<=640 && x>=1019){
                            lustra[i].strona=false;
                            lustra[i].xs=x;
                            lustra[i].ys=y-20; 
                            lustra[i].xk=x-40;
                            lustra[i].yk=y+20; 
                        }
                        repaint();
                        i++;   
                    }    
                    if(l==5){
                        prawda=true;
                        numer=i;
                        lustra[i].kat=225;
                        x=e.getX();
                        y=e.getY();
                        if(y<=640 && x<=5){
                            lustra[i].strona=true;
                            lustra[i].xs=x;
                            lustra[i].ys=y+20; 
                            lustra[i].xk=x+40;
                            lustra[i].yk=y-20; 
                        }else if(y<=640 && x>=1019){
                            lustra[i].strona=false;
                            lustra[i].xs=x;
                            lustra[i].ys=y+20; 
                            lustra[i].xk=x-40;
                            lustra[i].yk=y-20; 
                        }
                        repaint();
                        i++;
                    }
                    if(l==4){
                        prawda=true;
                        numer=i;
                        lustra[i].kat=60;
                        x=e.getX();
                        y=e.getY();
                        if(y<=640 && x<=5){
                            lustra[i].strona=true;
                            lustra[i].xs=x;
                            lustra[i].ys=y-20; 
                            lustra[i].xk=x+20;
                            lustra[i].yk=y+20; 
                        }else if(y<=640 && x>=1019){
                            lustra[i].strona=false;
                            lustra[i].xs=x;
                            lustra[i].ys=y-20; 
                            lustra[i].xk=x-20;
                            lustra[i].yk=y+20; 
                        }
                        repaint();
                        i++;
                    }  
                   
                    if(l==6){
                        prawda=true;
                        numer=i;
                        lustra[i].kat=240;
                        x=e.getX();
                        y=e.getY();
                        if(y<=640 && x<=5){
                            lustra[i].strona=true;
                            lustra[i].xs=x;
                            lustra[i].ys=y+20; 
                            lustra[i].xk=x+20;
                            lustra[i].yk=y-20; 
                        }else if(y<=640 && x>=1019){
                            lustra[i].strona=false;
                            lustra[i].xs=x;
                            lustra[i].ys=y+20; 
                            lustra[i].xk=x-20;
                            lustra[i].yk=y-20; 
                        }
                        repaint();
                        i++;
                    } 
                }  
            } 
        }
                if(prawda){
            if(k<7){
                if(Line2D.linesIntersect(laser[k].xs, laser[k].ys, laser[k].xk, laser[k].yk,
                lustra[numer].xs, lustra[numer].ys, lustra[numer].xk, lustra[numer].yk)){  
                    if(lustra[numer].kat==90){
                        if(laser[k].xs>laser[k].xk && laser[k].ys<laser[k].yk ){
                           
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
                            laser[k].yk=(p.y+przesuniecie)+643;
                           
                            
                            
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
                    }  if(lustra[numer].kat==180){
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

                        }else if(laser[k].xs>laser[k].xk && laser[k].ys>laser[k].yk ){
                            
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

                        } else if(laser[k].xs<laser[k].xk && laser[k].ys<laser[k].yk ){
                            
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

                        }   else if(laser[k].xs>laser[k].xk && laser[k].ys<laser[k].yk ){
                            
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

                                }else if(laser[k].ys-laser[k].yk==0){
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
                            }else if(!lustra[numer].strona){
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

                                }else if(laser[k].ys-laser[k].yk==0){
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

                                } else if(laser[k].ys-laser[k].yk==0){
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
                            } else if(!lustra[numer].strona){
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

                                }else if(laser[k].ys-laser[k].yk==0){
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

                                }else if(laser[k].ys-laser[k].yk==0){
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
                            } else if(!lustra[numer].strona){
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

                                }else if(laser[k].ys-laser[k].yk==0){
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


                                }else if(laser[k].ys-laser[k].yk==0){
                                    
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
                            } else if(!lustra[numer].strona){
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

                                }else if(laser[k].ys-laser[k].yk==0){
                                    
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
    

    protected void paintComponent(Graphics gs){
        
        Graphics2D g=(Graphics2D)gs;
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g.drawImage(Obrazy.bgImage1, 0, 0, null);
        g.drawImage(Obrazy.bgImage2,900,0,50,50,null);
        g.drawImage(Obrazy.bgImage3,650,0,80,240,null);
        g.drawImage(Obrazy.bgImage4,0,500,60,50,null);
        g.setColor(Color.red);
        if(GStatus.rysuj){
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
            if(resetuj)
            g.drawLine((int)laser[0].xs,(int)laser[0].ys, (int)laser[0].xk ,(int)laser[0].yk);
            if(GStatus.rysuj && resetuj){
            for(int i=0;i<7;i++)
                g.drawLine((int)laser[i].xs,(int)laser[i].ys, (int)laser[i].xk ,(int)laser[i].yk);
            
            }
            
            if(resetuj==false){
                time.restart();
            g.setColor(Color.yellow);
            g.drawLine((int)laser[liczba].xs,(int)laser[liczba].ys,(int)laser[liczba].xk,(int)laser[liczba].yk);
                            
                            if(sprawdzCzyWygrana()) System.out.println("wygrales"); 
                            if(sprawdzCzyPrzegrana()) System.out.println("przegrales");
               time.start();
               if(liczba==6) time.stop();
            }
    }
    public static double liczA(Lustra lu){
     double a=0;
     if((lu.xk-lu.xs)!=0)
     a=(lu.yk-lu.ys)/(lu.xk-lu.xs);
     else 
         a=0;
     return a;
 }
     public static double liczB(Lustra lu){
     double b=0;
     if(lu.a!=0)
     b=lu.ys-lu.xs*((lu.yk-lu.ys)/(lu.xk-lu.xs));
     else 
         b=0; 
     return b;
 }
         public static double liczA(Laser la){
     double a=0;
     if((la.xk-la.xs)!=0)
     a=(la.yk-la.ys)/(la.xk-la.xs);
     else 
         a=0;
     return a;
 }
     public static double liczB(Laser la){
     double b=0;
     if(la.a!=0)
     b=la.ys-la.xs*((la.yk-la.ys)/(la.xk-la.xs));
     else 
         b=0; 
     return b;
 }
      public static Point liczPunktprzeciecia(Lustra lu,Laser la){
      Point p = new Point();
      if(lu.a!=0 && la.a!=0){
          p.x=(int)((la.b-lu.b)/(lu.a-la.a));
          p.y=(int)((lu.a*((la.b-lu.b)/(lu.a-la.a)))+lu.b);
      }
      else if (lu.a!=0 && (la.ys-la.yk==0)){
          p.x=(int)((la.yk-lu.b)/lu.a);
          p.y=(int)la.yk;
        
      }
      else if (la.a!=0 && (lu.ys-lu.yk==0)){
          p.x=(int)((lu.yk-la.b)/la.a);
          p.y=(int)lu.yk;
      }
       else if (lu.a!=0 && (la.xs-la.xk==0)){
          p.x=(int)la.xs;
          p.y=(int)((la.xk*lu.a)+lu.b);
      }
        else if (la.a!=0 && (lu.xs-lu.xk==0)){
          p.x=(int)lu.xs;
          p.y=(int)((lu.xk*la.a)+la.b);
      }
      else if ((lu.xk-lu.xs)==0 && (la.yk-la.ys==0)){
          p.x=(int)lu.xk;
          p.y=(int)la.yk;
      }
      else if ((lu.yk-lu.ys)==0 && (la.xk-la.xs==0)){
          p.x=(int)la.xk;
          p.y=(int)lu.yk;
      }
   
      return p;
  }
    public  void resetuj(){
             lustra = new Lustra[6];
        for(int i=0;i<6;i++){
            lustra[i]=new Lustra();
        }
     laser = new Laser[7];
        for(int i=0;i<7;i++){
            laser[i]=new Laser();
        }
        laser[0].xs=60;
        laser[0].ys=525;
        laser[0].xk=1024;
        laser[0].yk=525;
    rysuj=false;
     i=0;
     k=0;
     liczba=0;
     resetuj=true;


    }
    public boolean sprawdzCzyWygrana(){
        boolean wygrana;
        Rectangle cel = new Rectangle(900,0,50,50);
        if(cel.intersectsLine(laser[liczba].xs,laser[liczba].ys,laser[liczba].xk,laser[liczba].yk))
       wygrana=true;
        else wygrana=false;
        return wygrana;
    }
    
        public boolean sprawdzCzyPrzegrana(){
        boolean przegrana;
        Rectangle przeszkoda1 = new Rectangle(650,0,80,240);
        if(przeszkoda1.intersectsLine(laser[liczba].xs,laser[liczba].ys,laser[liczba].xk,laser[liczba].yk))
        przegrana=true;
        else przegrana=false;
        return przegrana;
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

    @Override
    public void actionPerformed(ActionEvent e) {
       
 if(resetuj==false){
   
    if(liczba<6)
    liczba=liczba+zwieksz;  

 repaint();
 } 
       
   

     
    }


}