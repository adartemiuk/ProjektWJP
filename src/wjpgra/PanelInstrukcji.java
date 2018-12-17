
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

public class PanelInstrukcji extends JPanel {
   JButton powrot;
    public PanelInstrukcji(){
        setLayout(null);
        Obrazy.loadInitialImages();
        wypelnijpanel();
    }
    public void wypelnijpanel(){
        JLabel napis = new JLabel("Instrukcja",JLabel.CENTER);
        napis.setFont(new Font("Noteworthy",Font.BOLD,50));
        napis.setForeground(Color.ORANGE);
        napis.setBounds(0,25,400,100);
        add(napis);
        JLabel tekst = new JLabel("<html>Aby rozpocząć grę, kliknij przycisk \"Rozpocznij Grę\"<br>"
                +"Po rozpoczęciu gry, zaczyna się faza planowania, w której gracz musi w określonym czasie <br>"
                + "umieścić lustra na polu gry i naprowadzić wiązkę na cel. Gracz umieszcza lustra za pomocą Lewego Przycisku Myszki.<br>"
                + " Po wciśnięciu przycisku \"Start\" rozpoczyna się faza puszczenia wiązki.<br>"
                + " Jeśli graczowi uda się naprowadzić wiązkę na cel, otrzymuje punkty oraz przechodzi do nastepnego poziomu.<br>"
                + "Symbole używane w grze:</html>");
        tekst.setFont(new Font("Noteworthy",Font.BOLD,20));
        tekst.setForeground(Color.WHITE);
        tekst.setBounds(112, 84, 600, 400);
        add(tekst);
        powrot = new JButton(new ImageIcon("/Users/adamartemiuk/Desktop/powrot.png"));
        powrot.setBounds(600,650,350,80);
        add(powrot);
    }
    protected void paintComponent(Graphics gs){
        Graphics2D g=(Graphics2D)gs;

        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
  
        g.drawImage(Obrazy.bgImage, 0, 0, null);
    }
}