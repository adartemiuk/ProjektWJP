
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
       // GPars.loadInitialImages();
        JLabel napis = new JLabel("Informacje o grze",JLabel.CENTER);
        napis.setFont(new Font("Noteworthy",Font.BOLD,50));
        napis.setForeground(Color.ORANGE);
        napis.setBounds(0,65,500,100);
        add(napis);
        JLabel tekst = new JLabel("<html>Autor gry: Adam Artemiuk<br>" +
"Grafika: Adam Artemiuk<br>" +
"Rozmiar gry: 1024x768<br>" +
"Środowisko: Java Desktop<br>" +
"<br>" +
"Gra Światłem do celu powstała, aby nauczyć podstawowych <br>" +
"zjawisk z zakresu fizyki, takie jak pochłanianie, odbicie, rozczepienie, itp.</html>");
        tekst.setFont(new Font("Times New Roman" , Font.PLAIN,35));
        tekst.setForeground(Color.WHITE);
        tekst.setBounds(112, 134, 600, 500);
        add(tekst);
        powrot1 = new JButton(new ImageIcon("/Users/adamartemiuk/Desktop/powrot.png"));
        powrot1.setBounds(600,650,350,80);
        add(powrot1);
    }
    protected void paintComponent(Graphics gs){
        Graphics2D g=(Graphics2D)gs;
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g.drawImage(GPars.bgImage, 0, 0, null);
}
    }

