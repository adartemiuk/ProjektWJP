
package wjpgra;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
/**
 * Klasa bedaca menu w grze
 * Dziedziczy po JDialog
 * @author Adam Artemiuk
 */
public class OknoDialogowe extends JDialog{
    /** JBUtton wznowienia gry */
    public static JButton b1;
    /** JBUtton restartu aktualnego poziomu */
    public static JButton b2;
    /** JBUtton wyjscia do menu glownego */
    public static JButton b3;
    /** Wspolrzedna x polozenia JDialoga  */
    public int x=((WJPGra.screenWidth-WJPGra.gameWidth)/2)+312;
    /** Wspolrzedna y polozenia JDialoga  */
    public int y=((WJPGra.screenHeight-WJPGra.gameHeight)/2)+84;
    /**
     * Konstruktor - ustawienie parametrów obiektu
     */
    public OknoDialogowe(){  
        setModalityType(ModalityType.APPLICATION_MODAL);
        setSize(400,600);
        setLocation(x,y);
        setUndecorated(true);
        setResizable(false);
        setLayout(new GridLayout(3,1));
        dodajbatony();
    }
    /**
     * Inicjowanie JButtonow, dodanie obslugi zdarzen
     */
    public void dodajbatony(){
        b1 = new JButton(new ImageIcon("/Users/adamartemiuk/NetBeansProjects/git/images/wznow.png"));
        b2 = new JButton(new ImageIcon("/Users/adamartemiuk/NetBeansProjects/git/images/rest.png"));
        b3 = new JButton(new ImageIcon("/Users/adamartemiuk/NetBeansProjects/git/images/wroc.png")); 
        // zamkniecie menu gry, wznowienie czasu gry
        b1.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
            PanelGry.init=true;
            dispose();
           
            }
        });
        //restart aktualnego poziomu, zamkniecie menu gry, wznowienie czasu gry 
        b2.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                PanelwGrze.rysujlaser=true;
                PanelGry.init=true;
                dispose();   
            } 
        });
        // powrot do menu glownego, reset gry do 1 poziomu 
        b3.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                PanelGry.time=GStatus.timelvl;
                PanelwGrze.rysujlaser=true;
                dispose();
            }
        });
        add(b1);
        add(b2);
        add(b3);
    }
}
