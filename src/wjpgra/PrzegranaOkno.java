/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wjpgra;

import java.awt.Color;
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
public class PrzegranaOkno extends JDialog {
   public int gameWidth=1024;
   public int gameHeight=768;
    public int screenWidth=Toolkit.getDefaultToolkit().getScreenSize().width;
    public int screenHeight=Toolkit.getDefaultToolkit().getScreenSize().height;
   
    public int x=((screenWidth-gameWidth)/2)+312;
    public int y=((screenHeight-gameHeight)/2)+210;
    
    public int xCenter=(screenWidth-gameWidth)/2;
    public int yCenter=(screenHeight-gameHeight)/2;
    public PrzegranaOkno(){
    setModalityType(ModalityType.APPLICATION_MODAL);
    setSize(400,300);
    setLocation(x,y);
    setUndecorated(true);
    setResizable(false);
   

     JPanel panel = new JPanel();
   
    panel.setBackground(Color.CYAN);
    panel.setLayout(null);
    panel.setVisible(true);
    add(panel);
        JLabel napis = new JLabel("Przegrana :(",JLabel.CENTER);
    napis.setFont(new Font("Times New Roman",Font.BOLD,50));
    napis.setBounds(0, 0, 400, 200);

    napis.setForeground(Color.magenta);
   JButton reset = new JButton("Zagraj jeszcze raz");
    reset.setBounds(100,200,200,50);
    reset.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                if(GStatus.lvl==1)
                GStatus.zerujpoziom();
                else if(GStatus.lvl==2)
                GStatus.ustawPoziom2();
                PanelwGrze.czyrepaint=true;
                GStatus.liczbaprob++;
                PanelGry.init=true;

              panel.setVisible(false);
              dispose();
              setVisible(false);
             
               
            } 
        });
    panel.add(reset);
    panel.add(napis);
  
    }
}
