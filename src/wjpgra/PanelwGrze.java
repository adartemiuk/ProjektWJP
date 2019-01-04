
package wjpgra;


import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Line2D;
import javafx.scene.shape.Line;
import javax.swing.JPanel;

public class PanelwGrze extends JPanel implements MouseListener {
    boolean prawda;
    public int x,y;
    int i; 
    int k;
    GStatus status = new GStatus();
    Lustra[] lustra;
    Laser[] laser;
   public PanelwGrze(){
        lustra = new Lustra[6];
        for(int i=0;i<6;i++){
            lustra[i]=new Lustra();
        }
        laser = new Laser[7];
        for(int i=0;i<7;i++){
            laser[i]=new Laser();
        }
        laser[0].xs=60;
        laser[0].ys=520;
        laser[0].xk=1024;
        laser[0].yk=520;
       addMouseListener(this);    
    }
   
    @Override
    public void mouseClicked(MouseEvent e) {   
        if(e.getButton()==MouseEvent.BUTTON1){ 
           
            if(e.getY()<=640 && e.getX()<=5 || e.getX()>=1019 || e.getY()<=10 && e.getX()<=1024 || e.getY()>=630 ){
                if(i<6){
                    if(e.getClickCount()==1){ 
                        lustra[i].kat=90;
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
                }
            }
            if(i<=6){
                if(e.getClickCount()==2){ 
                    lustra[i-1].kat=180;
                    if(y<=10 && x<=1024 || y>=630){
                        lustra[i-1].xs=x-30;
                        lustra[i-1].ys=y; 
                        lustra[i-1].xk=x+30;
                        lustra[i-1].yk=y;
                    }
                    repaint();
                }    
            }   
        }
        else if(e.getButton()==MouseEvent.BUTTON3){ 
            if(e.getY()<=640 && e.getX()<=5 || e.getX()>=1019){
                if(i<6){
                    if(e.getClickCount()==1){
                        lustra[i].kat=45;
                        x=e.getX();
                        y=e.getY();
                        if(y<=640 && x<=5){
                            lustra[i].xs=x;
                            lustra[i].ys=y-20; 
                            lustra[i].xk=x+40;
                            lustra[i].yk=y+20; 
                        }else if(y<=640 && x>=1019){
                            lustra[i].xs=x;
                            lustra[i].ys=y-20; 
                            lustra[i].xk=x-40;
                            lustra[i].yk=y+20; 
                        }
                        repaint();
                        i++;   
                    }
                }
                if(i<=6){
                    if(e.getClickCount()==2){
                        lustra[i-1].kat=225;
                        if(y<=640 && x<=5){
                            lustra[i-1].xs=x;
                            lustra[i-1].ys=y+20; 
                            lustra[i-1].xk=x+40;
                            lustra[i-1].yk=y-20; 
                        }else if(y<=640 && x>=1019){
                            lustra[i-1].xs=x;
                            lustra[i-1].ys=y+20; 
                            lustra[i-1].xk=x-40;
                            lustra[i-1].yk=y-20; 
                        }
                        repaint();
                    }
                }
                if(i<=6){
                    if(e.getClickCount()==3){ 
                        lustra[i-1].kat=60;
                        if(y<=640 && x<=5){
                            lustra[i-1].xs=x;
                            lustra[i-1].ys=y-30; 
                            lustra[i-1].xk=x+35;
                            lustra[i-1].yk=y+30; 
                        }else if(y<=640 && x>=1019){
                            lustra[i-1].xs=x;
                            lustra[i-1].ys=y-30; 
                            lustra[i-1].xk=x-35;
                            lustra[i-1].yk=y+30; 
                        }
                        repaint();
                    }  
                }    
                if(i<=6){
                    if(e.getClickCount()==4){ 
                        lustra[i-1].kat=260;
                        if(y<=640 && x<=5){
                            lustra[i-1].xs=x;
                            lustra[i-1].ys=y+30; 
                            lustra[i-1].xk=x+35;
                            lustra[i-1].yk=y-30; 
                        }else if(y<=640 && x>=1019){
                            lustra[i-1].xs=x;
                            lustra[i-1].ys=y+30; 
                            lustra[i-1].xk=x-35;
                            lustra[i-1].yk=y-30; 
                        }
                        repaint();
                        if(i==6) i++;
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
        g.drawLine(laser[0].xs,laser[0].ys,laser[0].xk,laser[0].yk);
        for(int i=0;i<lustra.length;i++){
            g.setColor(Color.white);
            g.setStroke(new BasicStroke(5));
            if(lustra[i].kat==90){
                g.drawLine(lustra[i].xs,lustra[i].ys,lustra[i].xk,lustra[i].yk);  
            }
            if(lustra[i].kat==180){    
                g.drawLine(lustra[i].xs,lustra[i].ys,lustra[i].xk,lustra[i].yk); 
            }
            if(lustra[i].kat==60){
                g.drawLine(lustra[i].xs,lustra[i].ys,lustra[i].xk,lustra[i].yk); 
            }
            if(lustra[i].kat==45){
                g.drawLine(lustra[i].xs,lustra[i].ys,lustra[i].xk,lustra[i].yk); 
            }
            if(lustra[i].kat==225){
                g.drawLine(lustra[i].xs,lustra[i].ys,lustra[i].xk,lustra[i].yk); 
            }
            if(lustra[i].kat==260){
                g.drawLine(lustra[i].xs,lustra[i].ys,lustra[i].xk,lustra[i].yk); 
            }  
        }
        if(k<6){
            System.out.println(lustra[k].xs);
            if(Line2D.linesIntersect(laser[k].xs, laser[k].ys, laser[k].xk, laser[k].yk,
                    lustra[k].xs, lustra[k].ys, lustra[k].xk, lustra[k].yk)){
                System.out.println("przecina "+"j= "+k);
                liczA(lustra[k]);
                liczA(laser[k]);
                liczA(lustra[k]);
                liczA(laser[k]);
                Point p =new Point();
                p=liczPunktprzeciecia(lustra[k],laser[k]);
                System.out.println("x= "+p.x);
                System.out.println("y= "+p.y);
                g.drawLine(p.x, p.y, 10*k ,50*k );
                k++;
            }
             
        }
    }
    public static int liczA(Lustra lu){
     int a=0;
     if((lu.xk-lu.xs)!=0)
     a=(lu.yk-lu.ys)/(lu.xk-lu.xs);
     else 
         a=0;
     return a;
 }
     public static int liczB(Lustra lu){
     int b=0;
     if(lu.a!=0)
     b=lu.ys-lu.xs*((lu.yk-lu.ys)/(lu.xk-lu.xs));
     else 
         b=0; 
     return b;
 }
         public static int liczA(Laser la){
     int a=0;
     if((la.xk-la.xs)!=0)
     a=(la.yk-la.ys)/(la.xk-la.xs);
     else 
         a=0;
     return a;
 }
     public static int liczB(Laser la){
     int b=0;
     if(la.a!=0)
     b=la.ys-la.xs*((la.yk-la.ys)/(la.xk-la.xs));
     else 
         b=0; 
     return b;
 }
      public static Point liczPunktprzeciecia(Lustra lu,Laser la){
      Point p = new Point();
      if(lu.a!=0 && la.a!=0){
          p.x=(la.b-lu.b)/(lu.a-la.a);
          p.y=(lu.a*((la.b-lu.b)/(lu.a-la.a)))+lu.b;
      }
      else if (lu.a!=0 && (la.ys-la.yk==0)){
          p.x=(la.yk/lu.a)-lu.b;
          p.y=la.yk;
        
      }
      else if (la.a!=0 && (lu.ys-lu.yk==0)){
          p.x=(lu.yk/la.a)-la.b;
          p.y=lu.yk;
      }
       else if (lu.a!=0 && (la.xs-la.xk==0)){
          p.x=la.xs;
          p.y=(la.xk*lu.a)+lu.b;
      }
        else if (la.a!=0 && (lu.xs-lu.xk==0)){
          p.x=lu.xs;
          p.y=(lu.xk*la.a)+la.b;
      }
      else if ((lu.xk-lu.xs)==0 && (la.yk-la.ys==0)){
          p.x=lu.xk;
          p.y=la.yk;
      }
      else if ((lu.yk-lu.ys)==0 && (la.xk-la.xs==0)){
          p.x=la.xk;
          p.y=lu.yk;
      }
   
      return p;
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