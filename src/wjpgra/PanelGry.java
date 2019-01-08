
package wjpgra;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;


 public class PanelGry extends JPanel{

     OknoDialogowe dialog = new OknoDialogowe();
    public JButton opcje;
    public  JLabel czas;
    public JPanel panel1;
    public JButton lustro90;
    public JButton lustro180;
    public JButton lustro45;
    public JButton lustro225;
    public JButton lustro60;
    public JButton lustro240;          
    public JLabel poziom;
    public JPanel panel3;
    public JLabel lustra;
    public JLabel punkty;
    GStatus g;
     public static int time;
     public static boolean init;
     public static boolean go;
    public PanelGry(){
      
        g = new GStatus();
        g.zerujpoziom();
        animationloop1(this);
         dodajpanelgry();
   
        setLayout(null);
       
      
       
    }
           public void animationloop1(PanelGry p){
        Timer t = new Timer();
        
        t.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
               if(init==true){
                PanelGry.time--;
               }
             
             revalidate();
              p.dodajpanelinfo(g,p);
              p.dodajpanelmenu();
                 
                if(PanelGry.time==0){
    PanelwGrze.uruchomWiazke();
                init=false;
               repaint();
                }
            }
        }, 1000, 1000);
    }
    public void dodajpanelinfo(GStatus g,PanelGry p){
      
        panel1 = new JPanel();
       panel1.setLayout(new FlowLayout(FlowLayout.LEADING,15,1));
        panel1.setBackground(Color.cyan);
        panel1.setBounds(0, 0, 1024, 60);
        add(panel1);
   
        lustro90= new JButton(new ImageIcon("/Users/adamartemiuk/Desktop/90.png"));
          lustro90.addActionListener(new ActionListener(){
           @Override
           public void actionPerformed(ActionEvent e) {
               PanelwGrze.l=1;
           }  
        });


        panel1.add(lustro90);
        
        
        lustro180= new JButton(new ImageIcon("/Users/adamartemiuk/Desktop/180.png"));
          lustro180.addActionListener(new ActionListener(){
           @Override
           public void actionPerformed(ActionEvent e) {
               PanelwGrze.l=2;
           }  
        });

        panel1.add(lustro180);
        
        
        lustro45= new JButton(new ImageIcon("/Users/adamartemiuk/Desktop/45.png"));
          lustro45.addActionListener(new ActionListener(){
           @Override
           public void actionPerformed(ActionEvent e) {
               PanelwGrze.l=3;
           }  
        });


        panel1.add(lustro45);
        
        
        lustro60= new JButton(new ImageIcon("/Users/adamartemiuk/Desktop/60.png"));
          lustro60.addActionListener(new ActionListener(){
           @Override
           public void actionPerformed(ActionEvent e) {
               PanelwGrze.l=4;
           }  
        });

        panel1.add(lustro60);
        
        
        lustro225= new JButton(new ImageIcon("/Users/adamartemiuk/Desktop/225.png"));
          lustro225.addActionListener(new ActionListener(){
           @Override
           public void actionPerformed(ActionEvent e) {
               PanelwGrze.l=5;
           }  
        });

        panel1.add(lustro225);
        
        
        lustro240= new JButton(new ImageIcon("/Users/adamartemiuk/Desktop/240.png"));
          lustro240.addActionListener(new ActionListener(){
           @Override
           public void actionPerformed(ActionEvent e) {
               PanelwGrze.l=6;
           }  
        });

        panel1.add(lustro240);
        
     
        czas = new JLabel("Pozostały czas: "+p.time+"/"+GStatus.timelvl);
        czas.setFont(new Font ("Noteworthy",Font.BOLD,30));
         czas.setBounds(410, 0, 300, 60);
        panel1.add(czas);
        
        poziom = new JLabel("Poziom: "+GStatus.lvl);
        poziom.setFont(new Font ("Noteworthy",Font.BOLD,30));
        poziom.setBounds(720, 0, 300, 60);
        panel1.add(poziom);
      }   
        
    
    public void dodajpanelgry(){

       PanelwGrze pwg = new PanelwGrze();
        pwg.setBounds(0, 60,1024,643);
        add(pwg);
        


        
    }
       
    
    public void dodajpanelmenu(){
        panel3 = new JPanel();
        panel3.setBackground(Color.cyan);
         panel3.setLayout(new FlowLayout(FlowLayout.LEADING,100,2));
        panel3.setBounds(0, 703, 1024, 65);
       
        lustra = new JLabel("Liczba luster: "+GStatus.lustr);
        lustra.setFont(new Font ("Noteworthy",Font.BOLD,30));
        lustra.setBounds(50,5,250,55);
        panel3.add(lustra);
        
        punkty = new JLabel("Punkty: "+GStatus.points);
        punkty.setFont(new Font ("Noteworthy",Font.BOLD,30));
        punkty.setBounds(300,5,150,55);
        panel3.add(punkty);

        opcje = new JButton(new ImageIcon("/Users/adamartemiuk/Desktop/menu.png"));
        
        
        opcje.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                init=false;
         
         dialog.setVisible(true);
             
            }
        });
           
       
        
      JButton rozpoczecie = new JButton(new ImageIcon("/Users/adamartemiuk/Desktop/start.png"));
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
        add(panel3);
    }    


  }   

