
package wjpgra;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Dialog;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class GamePanel extends JPanel{
    JButton opcje;
    JButton rozpoczecie;
    int p;
    float t;
    int pkt;
    int lus;
    public GamePanel(){
        setLayout(null);
        dodajpanelwynikow();
        dodajpanelgry();
        dodajpanelmenu();
    }
    public void dodajpanelwynikow(){
        JPanel panel1 = new JPanel();
        panel1.setLayout(new FlowLayout(FlowLayout.LEADING,100,5));
        panel1.setBackground(Color.cyan);
        panel1.setBounds(0, 0, 1024, 60);
        add(panel1);
        JLabel podpis = new JLabel("Gra Światłem do Celu®");
        podpis.setFont(new Font ("Noteworthy",Font.BOLD,30));
        panel1.add(podpis);
        JLabel czas = new JLabel("Pozostały czas: "+t);
        czas.setFont(new Font ("Noteworthy",Font.BOLD,30));
        panel1.add(czas);
        JLabel poziom = new JLabel("Poziom: "+p);
        poziom.setFont(new Font ("Noteworthy",Font.BOLD,30));
        panel1.add(poziom);
        
    }
    public void dodajpanelgry(){
       PanelwGrze pwg = new PanelwGrze();
        pwg.setBounds(0, 60,1024,643);
        pwg.setBackground(Color.LIGHT_GRAY);
        add(pwg);
       
        

    }
    public void dodajpanelmenu(){
        JPanel panel3 = new JPanel();
        panel3.setBackground(Color.cyan);
        panel3.setLayout(null);
        panel3.setBounds(0, 703, 1024, 65);
        JLabel lustra = new JLabel("Liczba luster: "+lus);
        lustra.setFont(new Font ("Noteworthy",Font.BOLD,30));
        lustra.setBounds(50,5,200,55);
        panel3.add(lustra);
        JLabel punkty = new JLabel("Punkty: "+pkt);
        punkty.setFont(new Font ("Noteworthy",Font.BOLD,30));
        punkty.setBounds(300,5,150,55);
        panel3.add(punkty);

         opcje = new JButton(new ImageIcon("/Users/adamartemiuk/Desktop/menu.png"));
        opcje.setBounds(800,10,185,45);
        
        opcje.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
         OknoDialogowe dialog = new OknoDialogowe();
         dialog.setVisible(true);
            }
    
        });
           
        
        panel3.add(opcje);
         rozpoczecie = new JButton(new ImageIcon("/Users/adamartemiuk/Desktop/start.png"));
        rozpoczecie.setBounds(600,10,185,45);
        panel3.add(rozpoczecie);
        add(panel3);
    }
    
   
}
