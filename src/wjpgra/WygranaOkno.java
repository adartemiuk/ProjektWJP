/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wjpgra;

import java.awt.Color;
import java.awt.Dialog;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author adamartemiuk
 */
public class WygranaOkno extends JDialog {
       public int gameWidth=1024;
   public int gameHeight=768;
    
    public int screenWidth=Toolkit.getDefaultToolkit().getScreenSize().width;
    public int screenHeight=Toolkit.getDefaultToolkit().getScreenSize().height;
    
    public int x=((screenWidth-gameWidth)/2)+212;
    public int y=((screenHeight-gameHeight)/2)+66;
    
    public int xCenter=(screenWidth-gameWidth)/2;
    public int yCenter=(screenHeight-gameHeight)/2;
    public WygranaOkno(){
    setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
    setSize(600,630);
    setLocation(x,y);
    setUndecorated(true);
    setResizable(false);

    JPanel panel = new JPanel();
   
    panel.setBackground(Color.CYAN);
    panel.setLayout(null);
    panel.setVisible(true);
    add(panel);
    
    JLabel napis = new JLabel("Wygrana !!!",JLabel.CENTER);
    napis.setFont(new Font("Noteworthy",Font.BOLD,50));
    napis.setBounds(0,0, 600, 90);
    napis.setForeground(Color.DARK_GRAY);
    
       JLabel punkty = new JLabel("Zdobyte punkty za poziom: "+GStatus.lvlpkt,JLabel.CENTER);
    punkty.setFont(new Font("Noteworthy",Font.BOLD,35));
    punkty.setBounds(0,90, 600, 90);
    punkty.setForeground(Color.DARK_GRAY);
    
     JLabel czas = new JLabel("Punkty za czas: "+GStatus.czaspkt,JLabel.CENTER);
    czas.setFont(new Font("Noteworthy",Font.BOLD,35));
    czas.setBounds(0,180, 600, 90);
    czas.setForeground(Color.DARK_GRAY);
    
    JLabel liczbaprob = new JLabel("Liczba powtórzeń: "+GStatus.liczbaprob,JLabel.CENTER);
    liczbaprob.setFont(new Font("Noteworthy",Font.BOLD,35));
    liczbaprob.setBounds(0,270, 600, 90);
    liczbaprob.setForeground(Color.DARK_GRAY);
    
     JLabel lustra = new JLabel("Punkty za pozostałe lustra: "+GStatus.lustrapkt,JLabel.CENTER);
    lustra.setFont(new Font("Noteworthy",Font.BOLD,35));
    lustra.setBounds(0,360, 600, 90);
    lustra.setForeground(Color.DARK_GRAY);
    
     JLabel podstawa = new JLabel("Suma: "+GStatus.points,JLabel.CENTER);
    podstawa.setFont(new Font("Noteworthy",Font.BOLD,35));
    podstawa.setBounds(0,450, 600, 90);
    podstawa.setForeground(Color.DARK_GRAY);
    
    JButton dalej = new JButton("Kolejny Poziom");
    dalej.setBounds(150,540,300,90);
    dalej.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
              PanelwGrze.czyrepaint=true;
               PanelGry.init=true;
              GStatus.ustawPoziom2();
              panel.setVisible(false);
              dispose();
              setVisible(false);
    
    
    
            } 
        });
    panel.add(liczbaprob);
    panel.add(lustra);
    panel.add(czas);
    panel.add(podstawa);
    panel.add(dalej);
    panel.add(punkty);
    panel.add(napis);
    
    
    
     
  
    
    }



  
}
