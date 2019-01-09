
package wjpgra;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
/**
 * Klasa reprezentujaca okienko wyswietlane po przegranej
 * Dziedziczy po JDialog
 * @author Adam Artemiuk
 */
public class PrzegranaOkno extends JDialog {
    /** Wspolrzedna x polozenia JDialoga  */
   public int x=((WJPGra.screenWidth-WJPGra.gameWidth)/2)+312;
    /** Wspolrzedna y polozenia JDialoga  */
   public int y=((WJPGra.screenHeight-WJPGra.gameHeight)/2)+210;
    /** Panel dodany do JDialoga  */
    JPanel panel;
    /** napis z informacja o przegranej   */
    JLabel napis;
    /** Przycisk restartu poziomu  */
    JButton reset;
    /**
    * Konstruktor - konfiguracja JDialoga
    */ 
    public PrzegranaOkno(){
        setModalityType(ModalityType.APPLICATION_MODAL);
        setSize(400,300);
        setLocation(x,y);
        setUndecorated(true);
        setResizable(false);
        generuj();
    }
     /**
     * Metoda ktora dodaje panel z JButtonami i JLabelami do JDialoga;
     * dodanie obslugi zdarzen
     */ 
    public void generuj(){
        panel = new JPanel();
        panel.setBackground(Color.cyan);
        panel.setLayout(null);
        panel.setVisible(true);
        
        
        napis = new JLabel("Przegrana :(",JLabel.CENTER);
        napis.setFont(new Font("Noteworthy",Font.BOLD,50));
        napis.setBounds(0, 0, 400, 200);
        napis.setForeground(Color.black);
        
        reset = new JButton("Zagraj jeszcze raz");
        reset.setBounds(100,200,200,50);
        reset.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                // jesli poziom 1 to zrestartuj parametry poziomu 1
                if(GStatus.lvl==1)
                    GStatus.ustawPoziom1();
                //jesli poziom 2 to zrestartuj parametry poziomu 3
                if(GStatus.lvl==2)
                    GStatus.ustawPoziom2();
                //jesli poziom 3 to zrestartuj parametry poziomu 3
                if(GStatus.lvl==3)
                    GStatus.ustawPoziom3();
               //odswiez panel i wyzeruj wspolrzedne luster i laserow
                PanelwGrze.czyrepaint=true;
                // zwieksz liczbe podejsc
                GStatus.liczbaprob++;
                PanelGry.init=true;
                panel.setVisible(false);
                dispose();
                setVisible(false);  
            } 
        });
        panel.add(reset);
        panel.add(napis);
        add(panel);
    }
}
