
package wjpgra;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class Menu extends JFrame  {
     PanelMenu pm;
     PanelInstrukcji ip ;
     PanelInfo inf ;
     PanelGry gp ;
     public CardLayout cl;
     public JPanel cards ;
    GStatus g = new GStatus();
   
    public Menu(int width, int height, int x, int y){
    super();
    
    setSize(width,height);
    setLocation(x,y);
    setResizable(false);
    setUndecorated(true);
 
    initGUI();
    setVisible(true);
    
 
    }
/*
             private void animationloop(PanelGry p){
       GStatus.czaspocz=System.currentTimeMillis();
       long currTime=GStatus.czaspocz;
       while(currTime-GStatus.czaspocz<GStatus.MAXTIME){
           long elapsedTime=(System.currentTimeMillis()-currTime)/1000;
           PanelGry.time=elapsedTime;
           System.out.println(PanelGry.time);
         
           try{
               Thread.sleep(1000);
           }catch(InterruptedException ex){
               System.out.println(ex);
           }
           }
       }
    */
     
    public void initGUI(){
        
      cards=new JPanel(new CardLayout());
         gp= new PanelGry();
      pm = new PanelMenu();
      ip = new PanelInstrukcji();
      inf = new PanelInfo();
      getContentPane().add(cards);
      cards.add(pm,"1");
      cards.add(ip,"2");
      cards.add(inf,"3");
      cards.add(gp,"4");
      
      cl = (CardLayout) cards.getLayout();
      cl.show(cards,"1");
      
        pm.instr.addActionListener(new ActionListener(){
           @Override
           public void actionPerformed(ActionEvent e) {
               cl.show(cards,"2");
           }  
        });
        
        ip.powrot.addActionListener(new ActionListener(){
           @Override
           public void actionPerformed(ActionEvent e) {
               cl.show(cards,"1");
           }
        });
     
        pm.info.addActionListener(new ActionListener(){
           @Override
           public void actionPerformed(ActionEvent e) {
               cl.show(cards,"3");
           }  
        });
   
        inf.powrot1.addActionListener(new ActionListener(){
           @Override
           public void actionPerformed(ActionEvent e) {
               cl.show(cards,"1");
           }
        });
        OknoDialogowe.b3.addActionListener(new ActionListener(){
           @Override
           public void actionPerformed(ActionEvent e) {
               cl.show(cards,"1");
           }
        });
        
        PanelMenu.start.addActionListener(new ActionListener(){
           @Override
           public void actionPerformed(ActionEvent e) {
               
                PanelGry.init=true;
               cl.show(cards,"4");  
               
             
        }
    }); 
}
}