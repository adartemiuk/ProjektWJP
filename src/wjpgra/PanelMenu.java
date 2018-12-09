
package wjpgra;


import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class PanelMenu extends JPanel implements ActionListener{
        JButton start;
        JButton instr;
        JButton info;
        JButton wyjscie;
       
    public PanelMenu(){
         //GPars.loadInitialImages();
        setLayout(null);
        JLabel napis = new JLabel("WITAJ W GRZE \"ŚWIATŁEM DO CELU\"",JLabel.CENTER);
        napis.setFont(new Font("Noteworthy",Font.BOLD,45));
        napis.setForeground(Color.ORANGE);
        napis.setBounds(87,25,850,100);
        add(napis);
        
         start = new JButton(new ImageIcon("/Users/adamartemiuk/Desktop/rozp.png"));
        start.setBounds(337, 150, 350, 100);
         instr = new JButton(new ImageIcon("/Users/adamartemiuk/Desktop/instr.png"));
        instr.setBounds(337, 300, 350, 100);
          info = new JButton(new ImageIcon("/Users/adamartemiuk/Desktop/info.png"));
        info.setBounds(337, 450, 350, 100);
         wyjscie = new JButton(new ImageIcon("/Users/adamartemiuk/Desktop/koniec.png"));
        wyjscie.setBounds(337, 600, 350, 100);
       wyjscie.addActionListener(this);
    
        add(start);
        add(instr);
        add(info);
        add(wyjscie);
      
        
    }
        protected void paintComponent(Graphics gs){
        Graphics2D g=(Graphics2D)gs;
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g.drawImage(GPars.bgImage, 0, 0, null);
        }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Dziękuję za gre :)");
        System.exit(0);
    }
   
}