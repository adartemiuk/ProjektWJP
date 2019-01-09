
package wjpgra;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
/**
 * Klasa stanowiaca glowny panel gry na ktorym znajduja sie 3 panele
 * Dziedziczy po JPanel
 * @author Adam Artemiuk
 */
public class PanelGry extends JPanel{
    /** Odliczany czas */
    public static int time;
    /** Zmienna inicjacji timera */
    public static boolean init;
    /** Menu gry */
    OknoDialogowe dialog;
    /** JBUtton menu gry */
    public JButton opcje;
    /** Wyswietlanie wartosci timera */
    public  JLabel czas;
    /** Panel informacji */
    public JPanel panel1;
    /** Przycisk ustawiana lustra pionowego */
    public JButton lustro90;
    /** Przycisk ustawiana lustra poziomego */
    public JButton lustro180;
    /** Przycisk ustawiana lustra 45 stopni */
    public JButton lustro45;
    /** JPrzycisk ustawiana lustra 225 stopni */
    public JButton lustro225;
    /** Przycisk ustawiana lustra 60 stopni */
    public JButton lustro60;
    /** Przycisk ustawiana lustra 240 stopni */
    public JButton lustro240;
    /** Przycisk przejscia do stanu aktywacji wiazki */
    public JButton rozpoczecie;
    /** Wyswietla informacje o aktualnym poziomie gry */
    public JLabel poziom;
    /** Psnel menu */
    public JPanel panel3;
    /** Wyswietla informacje o liczbie dostepnych luster */
    public JLabel lustra;
    /** Wyswietla informacje o punktach */
    public JLabel punkty;
    /**
     * Konstruktor - wprowadzenie timera, dodanie 3 paneli
     */
    public PanelGry(){
        dialog = new OknoDialogowe();
        GStatus.zerujpoziomy();
        animationloop1(this);
        dodajpanelgry();
        setLayout(null);   
    }
    /**
     * Inicjacja timera, co sekunde zmniejsza wartosc o jeden
     */
    public void animationloop1(PanelGry p){
        Timer t = new Timer();
        t.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                //jesli true to odliczaj
                if(init==true){
                    PanelGry.time--;
                }
                revalidate();
                p.dodajpanelinfo(p);
                p.dodajpanelmenu();
                // gdy skonczy sie czas
                if(PanelGry.time==0){
                    PanelwGrze.uruchomWiazke();
                    init=false;
                    repaint();
                }
            }
        }, 1000, 1000);
    }
    /**
     * Panel informacji,skonfigurowanie, dodanie JLabeli JButtonow i 
     * obslugi zdarzen do umieszczania luster
     */
    public void dodajpanelinfo(PanelGry p){
        panel1 = new JPanel();
        panel1.setLayout(new FlowLayout(FlowLayout.LEADING,15,1));
        panel1.setBackground(Color.cyan);
        panel1.setBounds(0, 0, 1024, 60);
        add(panel1);
        // po wcisnieciu ustaw wartosc zmiennej statycznej na odpowiadajaca danemu rodzajowi lustra
        lustro90= new JButton(new ImageIcon("/Users/adamartemiuk/NetBeansProjects/git/images/90.png"));
        lustro90.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                PanelwGrze.typ=1;
            }  
        });
        lustro180= new JButton(new ImageIcon("/Users/adamartemiuk/NetBeansProjects/git/images/180.png"));
        lustro180.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                PanelwGrze.typ=2;
            }  
        });
        lustro45= new JButton(new ImageIcon("/Users/adamartemiuk/NetBeansProjects/git/images/45.png"));
        lustro45.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                PanelwGrze.typ=3;
            }  
        });
        lustro60= new JButton(new ImageIcon("/Users/adamartemiuk/NetBeansProjects/git/images/60.png"));
        lustro60.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
               PanelwGrze.typ=4;
            }  
        });
        lustro225= new JButton(new ImageIcon("/Users/adamartemiuk/NetBeansProjects/git/images/225.png"));
        lustro225.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
               PanelwGrze.typ=5;
            }  
        });
        lustro240= new JButton(new ImageIcon("/Users/adamartemiuk/NetBeansProjects/git/images/240.png"));
        lustro240.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
               PanelwGrze.typ=6;
            }  
        });
        czas = new JLabel("Pozostały czas: "+p.time+"/"+GStatus.timelvl);
        czas.setFont(new Font ("Noteworthy",Font.BOLD,30));
        czas.setBounds(410, 0, 300, 60);
        
        poziom = new JLabel("Poziom: "+GStatus.lvl);
        poziom.setFont(new Font ("Noteworthy",Font.BOLD,30));
        poziom.setBounds(720, 0, 300, 60);
        
        
        panel1.add(lustro90);
        panel1.add(lustro180);
        panel1.add(lustro45);
        panel1.add(lustro60);
        panel1.add(lustro225);
        panel1.add(lustro240);
        panel1.add(czas);
        panel1.add(poziom);
    }   
    /**
     * Metoda tworzaca obiekt glowenego panelu gry, na ktorym beda rysowane lustra, lasery, itp
     * 
     */    
    public void dodajpanelgry(){
        PanelwGrze pwg = new PanelwGrze();
        pwg.setBounds(0, 60,1024,643);
        add(pwg);
    }
    /**
     * Panel menu, skonfigurowanie, dodanie JLabeli JButtonow i 
     * obslugi zdarzen do przejscia etapu uruchomienia wiazki, oraz wyswietlenia menu gry
     */
    public void dodajpanelmenu(){
        if(PanelwGrze.czyrepaint==true)
            repaint();
        panel3 = new JPanel();
        panel3.setBackground(Color.cyan);
        panel3.setLayout(new FlowLayout(FlowLayout.LEADING,70,0));
        panel3.setBounds(0, 703, 1024, 65);
       
        lustra = new JLabel("Liczba luster: "+GStatus.lustr);
        lustra.setFont(new Font ("Noteworthy",Font.BOLD,30));
        lustra.setBounds(50,5,250,55);
        
        punkty = new JLabel("Punkty: "+GStatus.points);
        punkty.setFont(new Font ("Noteworthy",Font.BOLD,30));
        punkty.setBounds(300,5,150,55);
        
        opcje = new JButton(new ImageIcon("/Users/adamartemiuk/NetBeansProjects/git/images/menu.png"));
        //klikniecie powoduje zatrzymanie czasu i wyswietlenie menu gry
        opcje.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                init=false;
                dialog.setVisible(true);
            }
        });
        rozpoczecie = new JButton(new ImageIcon("/Users/adamartemiuk/NetBeansProjects/git/images/start.png"));
        //zatrzymanie czasu, i uruchomienie wiazki
        rozpoczecie.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                PanelwGrze.uruchomWiazke();
                init=false;
                repaint(); 
            }
        });
        panel3.add(rozpoczecie);
        panel3.add(opcje);
        panel3.add(punkty);
        panel3.add(lustra);
        add(panel3);
    }    


}   

