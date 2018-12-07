
package wjpgra;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class InstrPanel extends JPanel {
   JButton powrot;
    public InstrPanel(){
        setLayout(null);
        GPars.loadInitialImages();
        JLabel napis = new JLabel("Instrukcja",JLabel.CENTER);
        napis.setFont(new Font("Noteworthy",Font.BOLD,50));
        napis.setForeground(Color.YELLOW);
        napis.setBounds(5,25,700,100);
        add(napis);
        JLabel tekst = new JLabel("Tutaj będzie tekst instrukcji ");
        tekst.setFont(new Font("Times New Roman" , Font.PLAIN,35));
        tekst.setForeground(Color.WHITE);
        tekst.setBounds(212, 134, 600, 500);
        add(tekst);
        powrot = new JButton(new ImageIcon("/Users/adamartemiuk/Desktop/powrot.png"));
        powrot.setBounds(700,650,200,100);
        add(powrot);
    }
    protected void paintComponent(Graphics gs){
        Graphics2D g=(Graphics2D)gs;
        //Ustaw tryb lepszej jakości grafiki (wygładzanie/antyaliasing)
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        // Narysuj tło
        g.drawImage(GPars.bgImage, 0, 0, null);
}
}