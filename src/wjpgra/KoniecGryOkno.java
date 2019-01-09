
package wjpgra;

import java.awt.Color;
import java.awt.Dialog;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
/**
 * Klasa wyświetlająca okienko koncowe, dziedziczy po JDialog
 * @author Adam Artemiuk
 */
public class KoniecGryOkno extends JDialog {
 /** Wspolrzedna x polozenia JDialoga  */
    public int x=((WJPGra.screenWidth-WJPGra.gameWidth)/2)+312;
    /** Wspolrzedna y polozenia JDialoga  */
    public int y=((WJPGra.screenHeight-WJPGra.gameHeight)/2)+210;
    /** Przycisk konczacy gre */
    public static JButton reset;
    
    /**
     * Konstruktor - ustawienie parametrów obiektu
     */

    public KoniecGryOkno(){
        setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
        setSize(400,300);
        setLocation(x,y);
        setUndecorated(true);
        setResizable(false);
        generuj();
    }
        /**
     * Funkcja tworząca Panel, JLabel oraz JButton
     */
    public void generuj(){
        JPanel panel = new JPanel();
        panel.setBackground(Color.CYAN);
        panel.setLayout(null);
        panel.setVisible(true);
        add(panel);
    
        JLabel napis = new JLabel("Gratulacje !! Udało Ci się przejść wszystkie poziomy !!!",JLabel.CENTER);
        napis.setFont(new Font("Noteworthy",Font.BOLD,15));
        napis.setBounds(0,0, 400, 100);
        napis.setForeground(Color.DARK_GRAY);
    
        JLabel punkty = new JLabel("Zdobyte punkty: "+GStatus.points,JLabel.CENTER);
        punkty.setFont(new Font("Noteworthy",Font.BOLD,30));
        punkty.setBounds(0,100, 400, 100);
        punkty.setForeground(Color.DARK_GRAY);
    
        reset = new JButton("OK");
        reset.setBounds(100,200,200,50);
        // Dodaj obslugę zdarzen - wcisniecie JBUttona reset//
        reset.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                GStatus.zerujpoziomy(); // zresetuj poziom do poczatkowego poziomu
                PanelwGrze.czyrepaint=true; //odswiez panel i wyzeruj parametry
                PanelGry.init=true; // wlacz timer
                dispose(); // zamknij biezacy JDialog
            } 
        });  
        panel.add(reset);
        panel.add(napis);
        panel.add(punkty);
    }
}
