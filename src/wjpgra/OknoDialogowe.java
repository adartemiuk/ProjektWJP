
package wjpgra;

import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;

public class OknoDialogowe extends JDialog{
   public static JButton b3 = new JButton(new ImageIcon("/Users/adamartemiuk/Desktop/wroc.png"));
   public static JButton b1 = new JButton(new ImageIcon("/Users/adamartemiuk/Desktop/wznow.png"));
   public static JButton b2 = new JButton(new ImageIcon("/Users/adamartemiuk/Desktop/rest.png"));
   public int gameWidth=1024;
   public int gameHeight=768;
    
    public int screenWidth=Toolkit.getDefaultToolkit().getScreenSize().width;
    public int screenHeight=Toolkit.getDefaultToolkit().getScreenSize().height;
    
    public int x=((screenWidth-gameWidth)/2)+312;
    public int y=((screenHeight-gameHeight)/2)+84;
    
    public int xCenter=(screenWidth-gameWidth)/2;
    public int yCenter=(screenHeight-gameHeight)/2;
    
    public OknoDialogowe(){
        
    setModalityType(ModalityType.APPLICATION_MODAL);
    setSize(400,600);
    setLocation(x,y);
    setUndecorated(true);
    setResizable(false);
    setLayout(new GridLayout(3,1));
    dodajbatony();
    
    }
    
    public void dodajbatony(){
        
        
      
        
        b1.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                
               dispose();
               PanelGry.init=true;
            } 
        });
        
          b2.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                GStatus.resetujpoziom();
         
                  PanelwGrze.resetuj=true;
                PanelGry.init=true;
                dispose();
               
            } 
        });
          
            b3.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                PanelGry.time=GStatus.timelv1;
               
                PanelwGrze.resetuj=true;
               
                dispose();
            }
        });
        
        add(b1);
        add(b2);
        add(b3);
    }
}
