
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
 * Klasa reprezentujaca okienko wyswietlane po przejsciu danego poziomu - wygrana
 * Dziedziczy po JDialog
 * @author Adam Artemiuk
 */
public class WygranaOkno extends JDialog {
    
    /** Wspolrzedna x polozenia JDialoga  */
    public int x=((WJPGra.screenWidth-WJPGra.gameWidth)/2)+212;
    /** Wspolrzedna y polozenia JDialoga  */
    public int y=((WJPGra.screenHeight-WJPGra.gameHeight)/2)+66;
    /** JDialog do okna koncowego  */
    public KoniecGryOkno koniec ;
    /** JLabel z informacja o wygranej */
    JLabel napis;
    /** Panel dolaczony do JDialoga */
    JPanel panel;
    /** Wyswietla informacje o lacznej liczbie pkt */
    JLabel punkty;
    /** Wyswietla informacje o punktach za pozostaly czas */
    JLabel czas;
    /** Wyswietla informacje o karnych punktach za liczbe podejsc do poziomu */
    JLabel liczbaprob;
    /** Wyswietla informacje o punktach za pozostale lustra */
    JLabel lustra;
    /** Wyswietla informacje o punktach za przejscie danego poziomu */
    JLabel podstawa;
    /** JButton przejscia do nastepnego poziomu (o ile jeszcze jest) */
    JButton dalej;
    /**
    * Konstruktor - konfiguracja JDialoga
    */ 
    public WygranaOkno(){
        setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
        setSize(600,630);
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
        
    
        napis = new JLabel("Wygrana !!!",JLabel.CENTER);
        napis.setFont(new Font("Noteworthy",Font.BOLD,50));
        napis.setBounds(0,0, 600, 90);
        napis.setForeground(Color.black);
    
        punkty = new JLabel("Zdobyte punkty za poziom: "+GStatus.lvlpkt,JLabel.CENTER);
        punkty.setFont(new Font("Noteworthy",Font.BOLD,35));
        punkty.setBounds(0,90, 600, 90);
        punkty.setForeground(Color.black);
    
        czas = new JLabel("Punkty za czas: "+GStatus.czaspkt,JLabel.CENTER);
        czas.setFont(new Font("Noteworthy",Font.BOLD,35));
        czas.setBounds(0,180, 600, 90);
        czas.setForeground(Color.black);
    
        liczbaprob = new JLabel("Liczba powtórzeń: "+GStatus.liczbaprob,JLabel.CENTER);
        liczbaprob.setFont(new Font("Noteworthy",Font.BOLD,35));
        liczbaprob.setBounds(0,270, 600, 90);
        liczbaprob.setForeground(Color.black);
    
        lustra = new JLabel("Punkty za pozostałe lustra: "+GStatus.lustrapkt,JLabel.CENTER);
        lustra.setFont(new Font("Noteworthy",Font.BOLD,35));
        lustra.setBounds(0,360, 600, 90);
        lustra.setForeground(Color.black);
    
        podstawa = new JLabel("Suma: "+GStatus.points,JLabel.CENTER);
        podstawa.setFont(new Font("Noteworthy",Font.BOLD,35));
        podstawa.setBounds(0,450, 600, 90);
        podstawa.setForeground(Color.black);
    
        dalej = new JButton("Kolejny Poziom");
        dalej.setBounds(150,540,300,90);
        dalej.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                // jesli poziom 1 to zresetuj i przejdz do poziomu 2
                if(GStatus.lvl==1) {
                    GStatus.ustawPoziom2();
                    //odswiez panel i wyzeruj wspolrzedne luster i laserow
                    PanelwGrze.czyrepaint=true;
                    PanelGry.init=true;
                    panel.setVisible(false);
                    setVisible(false);
                    dispose();  
                } // jesli poziom 2 to zresetuj i przejdz do poziomu 3
                else if (GStatus.lvl==2){
                    GStatus.ustawPoziom3();
                    PanelwGrze.czyrepaint=true;
                    PanelGry.init=true;
                    panel.setVisible(false);
                     setVisible(false);
                    dispose();
                   
                } // jesli poziom 3 (ostatni) wyswietl JDialog z informacja o zakonczonej grze i pkt
                else if(GStatus.lvl==3){
                    panel.setVisible(false);
                    setVisible(false);
                    dispose();
                    koniec = new KoniecGryOkno();
                    koniec.setVisible(true);
                }    
            } 
        });
        panel.add(liczbaprob);
        panel.add(lustra);
        panel.add(czas);
        panel.add(podstawa);
        panel.add(dalej);
        panel.add(punkty);
        panel.add(napis);
        add(panel);
    } 
}
