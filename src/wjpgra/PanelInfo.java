
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
/**
 * Klasa reprezentujaca panel z informacjami o grze
 * Dziedziczy po JPanel
 * @author Adam Artemiuk
 */
public class PanelInfo extends JPanel {
   /** JButton do powrotu do menu glowengo */
    JButton powrot1;
    /**
     * Konstruktor - konfiguracja panelu
     */
    public PanelInfo(){
        setLayout(null);
        Obrazy.loadInitialImages();
        wypelnijpanel();
    }
    /**
     * dodanie do panela informacji JLabela z tekstem oraz z JButtona z obsluga zdarzen, 
     * ktory umozliwia powrot do menu glowengo 
     */
    public void wypelnijpanel(){
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
        powrot1 = new JButton(new ImageIcon("/Users/adamartemiuk/NetBeansProjects/git/images/powrot.png"));
        powrot1.setBounds(600,650,350,80);
        add(powrot1);
    }
    /**
     * funkcja rysujaca elementy graficzne
     */
    protected void paintComponent(Graphics gs){
        Graphics2D g=(Graphics2D)gs;
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g.drawImage(Obrazy.tlomenu, 0, 0, null);
    }
}

