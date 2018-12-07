
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


public class PanelInfo extends JPanel {
    JButton powrot1;
    public PanelInfo(){
        setLayout(null);
        GPars.loadInitialImages();
        JLabel napis = new JLabel("Informacje o Grze",JLabel.CENTER);
        napis.setFont(new Font("Noteworthy",Font.BOLD,50));
        napis.setForeground(Color.WHITE);
        napis.setBounds(5,25,700,100);
        add(napis);
        JLabel tekst = new JLabel("Tutaj będzie informacja o grze ");
        tekst.setFont(new Font("Times New Roman" , Font.PLAIN,35));
        tekst.setForeground(Color.WHITE);
        tekst.setBounds(212, 134, 600, 500);
        add(tekst);
        powrot1 = new JButton(new ImageIcon("/Users/adamartemiuk/Desktop/powrot.png"));
        powrot1.setBounds(700,650,200,100);
        add(powrot1);
    }
    protected void paintComponent(Graphics gs){
        Graphics2D g=(Graphics2D)gs;
        //Ustaw tryb lepszej jakości grafiki (wygładzanie/antyaliasing)
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        // Narysuj tło
        g.drawImage(GPars.bgImage, 0, 0, null);
}
    }

