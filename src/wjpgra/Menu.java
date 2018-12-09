
package wjpgra;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class Menu extends JFrame {
     PanelMenu pm = new PanelMenu();
     InstrPanel ip = new InstrPanel();
     PanelInfo inf = new PanelInfo();
     GamePanel gp = new GamePanel();

     
     CardLayout cl;
    JPanel cards ;
    
    public Menu(int width, int height, int x, int y){
    super();
    setSize(width,height);
    setLocation(x,y);
    setResizable(false);
    setUndecorated(true);
    initGUI();
    setVisible(true);
    }
    public void initGUI(){
        
       cards=new JPanel(new CardLayout());
       
      getContentPane().add(cards);
      cards.add(pm,"1");
      cards.add(ip,"2");
      cards.add(inf,"3");
      cards.add(gp,"4");
      
       cl = (CardLayout) cards.getLayout();
      cl.show(cards,"1");
      pm.instr.addActionListener(new Action());
     ip.powrot.addActionListener(new Action1());
     pm.info.addActionListener(new Action2());
     inf.powrot1.addActionListener(new Action3());
     
    
         
   
     
     pm.start.addActionListener(new ActionListener(){
           @Override
           public void actionPerformed(ActionEvent e) {
               cl.show(cards,"4");
           }
         
     });
    
    }
class Action1 implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            cl.show(cards,"1");
        }
    
}
   class Action implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            cl.show(cards,"2");
        }
    
}
      class Action2 implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            cl.show(cards,"3");
        }
    
}
         class Action3 implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            cl.show(cards,"1");
        }
    
}
  
    
}
