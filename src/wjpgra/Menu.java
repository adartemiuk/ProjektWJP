
package wjpgra;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
/**
 * Klasa bedaca menu glownym gry, przechowuje panele,dziedziczy po JFrame
 * @author Adam Artemiuk
 */
public class Menu extends JFrame  {
    /** Panel menu glownego */
    PanelMenu pm;
    /** Panel instrukcji */
    PanelInstrukcji ip ;
    /** Panel informacji o grze */
    PanelInfo inf ;
    /** Panel gry */
    PanelGry gp ;
    /** Klasa przechowuje panele  */
    public CardLayout cl;
    /** Panel na CardLayout */
    public JPanel cards ;
    
 /**
     * Konstruktor klasy menu glownego gry.
     * Ustawienia początkowe oraz wczytywanie elementow menu
     * Dodanie oblsugi zdarzen
     * @param width Szerokość pola graficznego gry
     * @param height Wysokość pola graficznego gry
     * @param x Wspolrzedna x polozenia JFrama
     * @param y Wspolrzedna y polozenia JFrama
     */
    public Menu(int width, int height, int x, int y){
        super();
        setSize(width,height);
        setLocation(x,y);
        setResizable(false);
        setUndecorated(true);
        initGUI();
        setVisible(true);
    }
   /**
     * Inicjowanie interfejsu graficznego 
     */
    public void initGUI(){   
        cards=new JPanel(new CardLayout());
        gp= new PanelGry();
        pm = new PanelMenu();
        ip = new PanelInstrukcji();
        inf = new PanelInfo();
        getContentPane().add(cards);
        cards.add(pm,"1");
        cards.add(ip,"2");
        cards.add(inf,"3");
        cards.add(gp,"4");
        cl = (CardLayout) cards.getLayout();
        cl.show(cards,"1");
      
        //doadanie obslugi zdarzen dla JBUttona - wyswietlenie panelu z CardLayout
        pm.instr.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
               cl.show(cards,"2");
            }  
        });
         //doadanie obslugi zdarzen dla JBUttona - wyswietlenie panelu z CardLayout
        ip.powrot.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
               cl.show(cards,"1");
            }
        });
         //doadanie obslugi zdarzen dla JBUttona - wyswietlenie panelu z CardLayout
        pm.info.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                cl.show(cards,"3");
           }  
        });
        //doadanie obslugi zdarzen dla JBUttona - wyswietlenie panelu z CardLayout
        inf.powrot1.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
               cl.show(cards,"1");
            }
        });
        //doadanie obslugi zdarzen dla JBUttona - wyswietlenie panelu z CardLayout
        OknoDialogowe.b3.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
               cl.show(cards,"1");
            }
        });
         //doadanie obslugi zdarzen dla JBUttona - wyswietlenie panelu z CardLayout
        PanelMenu.start.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
               PanelGry.init=true;
               cl.show(cards,"4");      
            }
        });   
    }
}