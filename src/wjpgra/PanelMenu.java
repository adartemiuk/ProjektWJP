
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
/**
 * Klasa menu glownego
 * Dziedziczy po JPanel
 * @author Adam Artemiuk
 */
public class PanelMenu extends JPanel implements ActionListener{
    /** JButton rozpoczecia nowej gry */
    public static  JButton start;
    /** JButton instrukcji do gry */
    JButton instr;
    /** JButton dinformacji o grze */
    JButton info;
    /** JButton wyjscia z gry */
    JButton wyjscie;
    /** Poczatkowa wspolrzedna x polozenia JButtona */
    int bx = 337;
    /** Poczatkowa wspolrzedna y polozenia JButtona */
    int by = 150;
    /** Szerokosc JButtona */
    int bszer = 350;
    /** Wysokosc JButtona */
    int bwys = 100;
     /**
     * Konstruktor - konfiguracja menu glownego
     */   
    public PanelMenu(){
        setLayout(null);
        wypelnijpanel();
    } 
    /**
     * metoda wypelniajaca menu glowne JLabelami i JButtonami
     */
    public void wypelnijpanel(){
        JLabel napis = new JLabel("WITAJ W GRZE \"ŚWIATŁEM DO CELU\"",JLabel.CENTER);
        napis.setFont(new Font("Noteworthy",Font.BOLD,45));
        napis.setForeground(Color.ORANGE);
        napis.setBounds(87,25,850,100);
        add(napis);
        
        start = new JButton(new ImageIcon("/Users/adamartemiuk/NetBeansProjects/git/images/rozp.png"));
        start.setBounds(bx, by, bszer, bwys);
        instr = new JButton(new ImageIcon("/Users/adamartemiuk/NetBeansProjects/git/images/instr.png"));
        instr.setBounds(bx, 2*by, bszer, bwys);
        info = new JButton(new ImageIcon("/Users/adamartemiuk/NetBeansProjects/git/images/info.png"));
        info.setBounds(bx, 3*by, bszer, bwys);
        wyjscie = new JButton(new ImageIcon("/Users/adamartemiuk/NetBeansProjects/git/images/koniec.png"));
        wyjscie.setBounds(bx, 4*by, bszer, bwys);
        wyjscie.addActionListener(this);
        
        add(start);
        add(instr);
        add(info);
        add(wyjscie);
    }
    /**
     * funkcja rysujaca elementy graficzne
     */
    protected void paintComponent(Graphics gs){
        Graphics2D g=(Graphics2D)gs;
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g.drawImage(Obrazy.tlomenu, 0, 0, null);
    }
    /**
     * Obsluga zdarzen do JButtona
     * Po wcisnieciu, gra jest wylaczana i wyswietla sie napis w konsoli
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Dziękuję za gre :)");
        System.exit(0);
    }   
}