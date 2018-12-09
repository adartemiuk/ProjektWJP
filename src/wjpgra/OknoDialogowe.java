
package wjpgra;


import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;


public class OknoDialogowe extends JDialog{
   
     int gameWidth=1024;
    int gameHeight=768;
    
    int screenWidth=Toolkit.getDefaultToolkit().getScreenSize().width;
    int screenHeight=Toolkit.getDefaultToolkit().getScreenSize().height;
    
    int x=((screenWidth-gameWidth)/2)+312;
    int y=((screenHeight-gameHeight)/2)+84;
    
    int xCenter=(screenWidth-gameWidth)/2;
    int yCenter=(screenHeight-gameHeight)/2;
    
    public OknoDialogowe(){
        setModalityType(ModalityType.APPLICATION_MODAL);
    setSize(400,600);
    setLocation(x,y);
    setUndecorated(true);
    setResizable(false);
    setLayout(new GridLayout(3,1));
    JButton b1 = new JButton(new ImageIcon("/Users/adamartemiuk/Desktop/wznow.png"));
        JButton b2 = new JButton(new ImageIcon("/Users/adamartemiuk/Desktop/rest.png"));
        JButton b3 = new JButton(new ImageIcon("/Users/adamartemiuk/Desktop/wroc.png"));
      
        b1.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
               dispose();
            }
            
        });
        
          b2.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
               dispose();
            }
            
        });
          
            b3.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                
                Menu m = new Menu(gameWidth,gameHeight,xCenter,yCenter);
                dispose();
            }
            
        });
        
        add(b1);
        add(b2);
        add(b3);
}
}
