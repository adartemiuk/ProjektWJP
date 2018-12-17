
package wjpgra;


import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.JPanel;

public class PanelwGrze extends JPanel implements MouseListener {
      public int x,y;
      int i;
      GStatus status = new GStatus();
      ArrayList<Point> points = new ArrayList<Point>();
   public PanelwGrze(){
       Obrazy.loadInitialImages();
       addMouseListener(this);
       
   }
 
   protected void paintComponent(Graphics gs){
        Graphics2D g=(Graphics2D)gs;
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g.drawImage(Obrazy.bgImage1, 0, 0, null);
          g.drawImage(Obrazy.bgImage2,900,0,50,50,null);
          g.drawImage(Obrazy.bgImage3,650,0,80,240,null);
          g.drawImage(Obrazy.bgImage4,0,500,80,80,null);
          
            for(Point p:points){
                x=(int)p.getX();
                y=(int)p.getY();
               
               g.drawLine(x, y, x, y+150);
                
            }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        
          i++; 
          if(i<=status.lustr) {
         status.points++;
          x=e.getX();
          y=e.getY();
          points.add(new Point(x, y));
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